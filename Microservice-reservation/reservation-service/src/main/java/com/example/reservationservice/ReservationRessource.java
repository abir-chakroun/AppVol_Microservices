package com.example.reservationservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
@RequestMapping(path = "Service-Reservation")
@RestController

public class ReservationRessource {

    @RequestMapping(path = "Service-Reservation")
    @RestController
    public class ReservationController {

        ReservationRepository repository;

        @GetMapping("/Reservartions")
        public List<ReservationItem> getAllReservations() {
            System.out.println("Get all Reservations");

            return (List<ReservationItem>) (repository.findAll());
               }

        @PostMapping(value = "/Reservations/create")
        public ReservationItem post (@Valid @RequestBody ReservationItem ReservationItem) {

           System.out.println("new ReservationItem");
            ReservationItem r = this.repository
                    .findById(ReservationItem.getVolNum())
                    .orElseThrow(() -> new IllegalStateException("The reservation does not exist!"));
            ReservationItem _Instrument = repository.save(ReservationItem);
            return _Instrument;
        };

        @DeleteMapping("/Reservations/{num}")
        public ResponseEntity<String> deleteReservationItem(@PathVariable("id") Long num) {
            System.out.println("Delete ReservationItem with Code = " + num );
            repository.deleteById(num);
            return new ResponseEntity<String>("ReservationItem has been deleted!", HttpStatus.OK);
        }

        @DeleteMapping("/Reservations/delete")
        public ResponseEntity<String> deleteAllReservations() {
            System.out.println("Delete All Reservations");
            repository.deleteAll();
            return new ResponseEntity<String>("All Reservations have been deleted!", HttpStatus.OK);
        }

        @PutMapping("/Reservations/{num}")
        public ResponseEntity<ReservationItem> updateReservationItem(@PathVariable("num") Long num, @RequestBody ReservationItem reservationitem) {

            System.out.println("Update ReservationItem");

            ReservationItem Data = repository.findById(num).orElse(null);
            if (Data!= null ) {

                ReservationItem v = Data;
                v.setClientId(reservationitem.getClientId());
                v.setVolNum(reservationitem.getVolNum());

                return new ResponseEntity<ReservationItem>(repository.save(v), HttpStatus.OK);
            } else {
                return new ResponseEntity<ReservationItem>(HttpStatus.NOT_FOUND);
            }
        }

    }


}
//





//
