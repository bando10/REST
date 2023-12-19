package com.example.controllers;

import com.example.agence.InOff;
import com.example.agence.InRes;
import com.example.exceptions.AgenceNotFoundException;
import com.example.exceptions.BadAgenceException;
import com.example.exceptions.HotelNotFoundException;
import com.example.models.*;
import com.example.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

	/* ATTRIBUTES */
	private HotelRepository hotelRepository;
	private AgenceRepository agenceRepository;
	private ReservationRepository reservationRepository;
	private ClientRepository clientRepository;
	private OffreRepository offreRepository;
	private static final String uri = "hotelservice/1/api";

	/* METHODS */
		
	@GetMapping(uri + "/reservations")
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	@GetMapping(uri + "/hotel/{id}")
	public Hotel getHotelById(@PathVariable long id) throws HotelNotFoundException {
		return hotelRepository.findById(id)
				.orElseThrow(() -> new HotelNotFoundException(
						"Error : Could not find hotel with id : " + id));
	}


	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/offres")
	public List<Offre> getOffres(@RequestBody InOff input) throws AgenceNotFoundException {
		if(agenceRepository.findByLoginAndPassword(input.getLogin(), input.getPassword()).isEmpty())
			throw new AgenceNotFoundException("Agence non reconnu");
		Agence connected = agenceRepository.findByLoginAndPassword(input.getLogin(), input.getPassword()).get();
		List<Chambre> availableChambres = reservationRepository.findByDebFinNbPersonnes(input.getDeb(), input.getFin(), input.getNbPersonnes());
		Hotel h = hotelRepository.findById(1L).get();
		List<Offre> offres = new ArrayList<>();
		for(Chambre c : availableChambres) {
			Offre o = new Offre(input.getDeb(), input.getFin(), connected.getRemise(), h, connected, c);
			offres.add(o);
			offreRepository.save(o);
		}
		return offres;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/reservation")
	public long setReservation(@RequestBody InRes input) throws AgenceNotFoundException, BadAgenceException {
		if(agenceRepository.findByLoginAndPassword(input.getLogin(), input.getPassword()).isEmpty())
			throw new AgenceNotFoundException("Agence non reconnu");
		Agence connected = agenceRepository.findByLoginAndPassword(input.getLogin(), input.getPassword()).get();
		Offre o = offreRepository.findById(input.getIdOffre()).get();
		if(connected != o.getAgence())
			throw new BadAgenceException("Agence ne corresponds pas avec l'offre");
		Client c = new Client(input.getPrenom(), input.getNom(), input.getCarte(), input.getExp(), input.getCvv());
		clientRepository.save(c);
		Reservation b = new Reservation(c, connected, o.getChambre(), o.getDeb(), o.getFin());
		reservationRepository.save(b);
		return b.getId();
	}
	
	@PutMapping(uri + "/hotel")
	public Hotel updateHotel(@RequestBody Hotel newHotel, @PathVariable long id) {
		return hotelRepository.findById(1L).map(hotel -> {
			hotel.setNom(newHotel.getNom());
			hotel.setAdresse(newHotel.getAdresse());
			hotel.setVille(newHotel.getVille());
			hotel.setPays(newHotel.getPays());
			hotel.setEtoiles(newHotel.getEtoiles());
			hotelRepository.save(hotel);
			return hotel;
		}).orElseGet(() -> {
			newHotel.setId(id);
			hotelRepository.save(newHotel);
			return newHotel;
		});
	}

}
