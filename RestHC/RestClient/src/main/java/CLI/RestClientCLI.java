package CLI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import models.Agence;
import models.Reservation;
import models.InRes;
import models.InOff;
import models.Offre;

@Component
public class RestClientCLI extends AbstractMain implements CommandLineRunner {

	/* ATTRIBUTES */
	@Autowired
	private RestTemplate proxy;
	private IntegerInputProcessor inputProcessor;
	private static String URI_AGENCIES;

	@Override
	public void run(String... args) throws Exception {

		BufferedReader inputReader;
		String userInput = "";

		String status = null;

		try {

			while (true) {
				inputReader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Choisissez ce que vous voulez faire : ");
				System.out.println("\n1. Se connecter à une agence");
				System.out.println("\n2. Utiliser le Comparateur");
				String choice = inputReader.readLine();
				System.out.println();

				if (choice.equals("1")) {
					setTestServiceUrl(inputReader);

					URI_AGENCIES = SERVICE_AGENCE_URL + "/api";

					do {
						menu();
						userInput = inputReader.readLine();
						processUserInput(inputReader, userInput, proxy);
						Thread.sleep(3000);
					} while (!userInput.equals(QUIT));
				}

				if (choice.equals("2")) {

					do {
						int port = 8081;

						InOff search = userInOff(inputReader, "comparator");
						List<Offre> listOffre = new ArrayList<Offre>();
						List<String> agenciesName = List.of("tour", "smart", "travel");
						List<Integer> nbOffresByAgence = new ArrayList<Integer>();

						for (String a : agenciesName) {
							URI_AGENCIES = "http://localhost:";
							URI_AGENCIES += Integer.toString(port) + "/agenceservice/" + a + "/api";
							Offre[] offres = proxy.postForObject(URI_AGENCIES + "/sendSearch", search, Offre[].class);
							Agence agency = proxy.getForObject(URI_AGENCIES + "/agency", Agence.class);

							if (nbOffresByAgence.isEmpty())
								nbOffresByAgence.add(offres.length);
							else
								nbOffresByAgence.add(offres.length + nbOffresByAgence.get(nbOffresByAgence.size() - 1));

							for (Offre o : offres)
								o.setAgence(agency);

							listOffre.addAll(Arrays.asList(offres));

							port += 2;
						}

						port = 8081;

						System.out.println(nbOffresByAgence.get(0));
						System.out.println(nbOffresByAgence.get(1));
						System.out.println(nbOffresByAgence.get(2));

						System.out.println("Résultat de la recherche :");
						if (!listOffre.isEmpty()) {

							offresMenu(listOffre);
							System.out.println("Souhaitez-vous réserver une offre ? (y/N)");
							status = inputReader.readLine();
							System.out.println();

							if (status.equals("y")) {
								System.out.println("Vous souhaitez reserver quelle offre ?");
								int userChoice = Integer.parseInt(inputReader.readLine());
								System.out.println();

								Offre choosenOffre = listOffre.get(userChoice - 1);

								InRes inputReservation = userInRes(inputReader, choosenOffre);

								boolean found = false;
								int j = 0;
								while (j < agenciesName.size() && !found) {
									if (userChoice <= nbOffresByAgence.get(j)) {
										URI_AGENCIES = "http://localhost:";
										URI_AGENCIES += Integer.toString(port) + "/agenceservice/" + agenciesName.get(j)
												+ "/api/sendChoice";
										found = true;
									}
									j++;
									port += 2;
								}

								Reservation reservation = proxy.postForObject(URI_AGENCIES, inputReservation, Reservation.class);

								System.out.println(reservation.toString());
							}
						} else {
							System.out.println("Aucun résultat trouvé pour votre recherche.");
						}

						System.out.println("Voulez-vous quitter le comparateur ? (y/N)");
						if (inputReader.readLine().equals("y")) {
							status = "done";
						}

					} while (!status.equals("done"));
				}
			}
		} catch (IOException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void menu() {

		StringBuilder builder = new StringBuilder();
		builder.append(QUIT + ". Quit.");
		builder.append("\n1. Recherche.");
		System.out.println(builder);

	}

	protected void offresMenu(List<Offre> offres) {
		StringBuilder builder = new StringBuilder();
		int i = 1;
		for (Offre o : offres) {
			builder.append("\n" + i + o.toString());
			i++;
		}
		System.out.println(builder);
	}

	protected InOff userInOff(BufferedReader reader, String caller) {
		try {
			System.out.println("Veuillez entrer le pays de reservation :");
			String pays = reader.readLine();
			System.out.println();

			System.out.println("Veuillez entrer la ville de reservation :");
			String ville = reader.readLine();
			System.out.println();

			System.out.println("Veuillez entrer la date d'arrivée (YYYY-MM-JJ):");
			LocalDate deb = LocalDate.parse(reader.readLine());
			System.out.println();

			System.out.println("Veuillez entrez la date de départ (YYYY-MM-JJ):");
			LocalDate fin = LocalDate.parse(reader.readLine());
			System.out.println();

			int prixMax;
			if (caller.equals("agence")) {
				System.out.println("Veuillez entrez le prix maximum:");
				prixMax = (int) Double.parseDouble(reader.readLine());
				System.out.println();
			}

			else {
				prixMax = 0;
			}

			System.out.println("Veuillez entrez le nombre de personne :");
			int nbPersonnes = Integer.parseInt(reader.readLine());
			System.out.println();

			System.out.println("Veuillez entrez le nombre d'étoile souhaite:");
			int etoiles = Integer.parseInt(reader.readLine());
			System.out.println();

			return new InOff(ville, pays, deb, fin, nbPersonnes, etoiles, prixMax);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected InRes userInRes(BufferedReader reader, Offre choosenOffre) {
		try {
			System.out.println("Indiquez votre nom: ");
			String name = reader.readLine();
			System.out.println();

			System.out.println("Indiquez votre prenom: ");
			String surname = reader.readLine();
			System.out.println();

			System.out.println("Indiquez votre numéro de carte bancaire: ");
			String card = reader.readLine();
			System.out.println();

			System.out.println("Indiquez le cvv de votre carte: ");
			String cvv = reader.readLine();
			System.out.println();

			System.out.println("Indiquez la date d'expiration de votre carte: ");
			String exp = reader.readLine();
			System.out.println();

			return new InRes(choosenOffre.getId(), name, surname, card, cvv, exp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void processUserInput(BufferedReader reader, String userInput, RestTemplate proxy) {

		try {
			switch (userInput) {
			case "1":

				InOff search = userInOff(reader, "agence");

				double gaps = Math.abs(ChronoUnit.DAYS.between(search.getDeb(), search.getFin()));

				Offre[] offres = proxy.postForObject(URI_AGENCIES + "/sendSearch", search, Offre[].class);
				List<Offre> listOffre = new ArrayList<Offre>();

				for (Offre o : offres) {
					double totalPrice = o.getChambre().getPrix() * gaps * (1 - o.getRemise());
					System.out.println(search.getPrixM() >= totalPrice);
					if (search.getPrixM() >= totalPrice) {
						listOffre.add(o);
					}
				}
				if (!listOffre.isEmpty()) {
					offresMenu(listOffre);
					System.out.println("Vous souhaitez reserver quelle offre ? ");
					String userChoice = reader.readLine();

					Offre choosenOffre = listOffre.get(Integer.parseInt(userChoice) - 1);

					InRes inputReservation = userInRes(reader, choosenOffre);

					Reservation reservation = proxy.postForObject(URI_AGENCIES + "/sendChoice", inputReservation, Reservation.class);

					System.out.println("Réservation confirmée : " + reservation.toString());
				} else {
					System.out.println("Aucun résultat trouvé pour votre recherche.");
				}
				break;

			case QUIT:
				System.out.println("Bye Bye");
				return;
			default:
				System.err.println("Désolé mauvais input");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected boolean validServiceUrl() {
		// TODO Auto-generated method stub
		return false;
	}
}
