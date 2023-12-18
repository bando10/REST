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
    public CommandLineRunner InitDatabase(HotelRepo hotelRepo, AgenceRepo agenceRepo, ReservationRepo reservationRepo, ClientRepo clientRepo,
                                          ChambreRepo chambreRepo) {
        /*Hotel h1 = new Hotel("", "", "", "", 5);
        hotelRepo.save(h1);

        Agence a1 = new Agence("", "", "", 0.3);
        Agence a2 = new Agence("  ", "", "", 0.12);
        agenceRepo.save(a1);
        agenceRepo.save(a2);

        Client c1 = new Client("", "", "","" ,"");
        Client c2 = new Client("", "", "","" ,"");
        clientRepo.save(c1);
        clientRepo.save(c2);

        Chambre r1 = new Chambre(3, 3000, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/409940770.jpg?k=76b6a62e229eea3cd9ed279e1f23a6cd8d7a6e76849fd59b5eef406a95706f78&o=&hp=1");
        Chambre r2 = new Chambre(5, 9000, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/206967994.jpg?k=e90201be923b9965459323e977530f066fcaed85f7f89e9d1f7f8b66a2b756a4&o=&hp=1");
        Chambre r3 = new Chambre(6, 10000, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/366419089.jpg?k=39a1c650c952795135ac0866cb97ed3096e08837e6e576682a2874bc3a45f201&o=&hp=1");
        Chambre r4 = new Chambre(8, 8000, "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/156333415.jpg?k=77dcf931d3673448a39e9ce378f57c4d056f1639645759bc46661c038271f63e&o=&hp=1");
        chambreRepo.save(r1);
        chambreRepo.save(r2);
        chambreRepo.save(r3);
        chambreRepo.save(r4);

        LocalDate deb = LocalDate.of(2022, 12, 15);
        LocalDate fin = LocalDate.of(2022, 12, 20);

        Reservation b1 = new Reservation(c1 ,a1, r3, deb, fin);
        Reservation b2 = new Reservation(c2 ,a1, r4, deb, fin);
        reservationRepo.save(b1);
        reservationRepo.save(b2);*/
        return args -> logger.info("Preloading database");
    }
}
