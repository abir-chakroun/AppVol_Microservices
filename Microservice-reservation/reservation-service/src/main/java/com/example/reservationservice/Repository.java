package com.example.reservationservice;

import org.springframework.data.repository.CrudRepository;
import  com.example.reservationservice.ReservationItem;

interface ReservationRepository extends CrudRepository<ReservationItem, Long>{

}