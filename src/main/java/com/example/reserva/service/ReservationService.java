package com.example.reserva.service;

import com.example.reserva.domain.entities.Customer;
import com.example.reserva.domain.entities.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private List<Reservation> reservations = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public Reservation createReservation(Reservation reservation){
        Customer customer = customers.stream()
                .filter(c->c.getId().equals(reservation.getCustomer().getId()))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Customer no found"));

        reservation.setCustomer(customer);
        reservation.setId((long) (reservations.size()+1));
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations(){
        return reservations;
    }
}
