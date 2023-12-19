package com.example.data;

import com.example.models.*;
import com.example.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Data {

    private Logger logger = LoggerFactory.getLogger(Data.class);

    @Bean
    public CommandLineRunner InitDatabase(HotelRepository hotelRepository, AgenceRepository agenceRepository, ReservationRepository reservationRepository, ClientRepository clientRepository,
                                          ChambreRepository chambreRepository) {
        Hotel h1 = new Hotel("Hotel1", "1 rue des Uns", "Paris", "France", 5);
        hotelRepository.save(h1);

        Agence a1 = new Agence("Agence n1", "1", "1", 0.3);
        agenceRepository.save(a1);

        Client c1 = new Client("Tony", "NG", "2134","01/26" ,"123");
        clientRepository.save(c1);

        Chambre r1 = new Chambre(3, 3000, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.masdepeint.com%2Ffr%2Fsp%2Fhotel-5-etoiles-arles&psig=AOvVaw2H6u_y3J2XYoIXJT9-of95&ust=1703001745094000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIjxxYSumYMDFQAAAAAdAAAAABAH");
        chambreRepository.save(r1);

        LocalDate deb = LocalDate.of(2023, 12, 10);
        LocalDate fin = LocalDate.of(2023, 12, 17);


        Reservation b1 = new Reservation(c1 ,a1, r1, deb, fin);
        reservationRepository.save(b1);
        /*



        Agence a2 = new Agence("  ", "", "", 0.12);
        agenceRepository.save(a2);

        Client c2 = new Client("", "", "","" ,"");
        clientRepository.save(c2);


        Chambre r2 = new Chambre(5, 9000, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/206967994.jpg?k=e90201be923b9965459323e977530f066fcaed85f7f89e9d1f7f8b66a2b756a4&o=&hp=1");
        Chambre r3 = new Chambre(6, 10000, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/366419089.jpg?k=39a1c650c952795135ac0866cb97ed3096e08837e6e576682a2874bc3a45f201&o=&hp=1");
        Chambre r4 = new Chambre(8, 8000, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/156333415.jpg?k=77dcf931d3673448a39e9ce378f57c4d056f1639645759bc46661c038271f63e&o=&hp=1");

        chambreRepository.save(r2);
        chambreRepository.save(r3);
        chambreRepository.save(r4);




        Reservation b2 = new Reservation(c2 ,a1, r4, deb, fin);

        reservationRepository.save(b2);*/
        return args -> logger.info("Preloading database");
    }
}
