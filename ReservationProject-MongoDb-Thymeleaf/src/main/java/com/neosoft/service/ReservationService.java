package com.neosoft.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Reservation;
import com.neosoft.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	
	public ReservationService(ReservationRepository reservationRepository) {
	
		this.reservationRepository = reservationRepository;
	}


	public Iterable<Reservation> reservationList() {
		
		return reservationRepository.findAll();
	}


	public Optional<Reservation> getReservById(Long id) {
		return reservationRepository.findById(id);
	}


	public Reservation addReservation(@Valid Reservation reservation) {
		
		return reservationRepository.save(reservation);
		
	}


	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
		
	}


	public List<Reservation> findByFirstNameOrLastNameOrMobileNoOrEmailId(String firstName, String lastName, String mobileNo,
			String emailId) {
		
		return reservationRepository.findByFirstNameOrLastNameOrMobileNoOrEmailId( firstName,  lastName,  mobileNo,
				 emailId);
	}


	public Optional<Reservation> findById(Long id) {
		return reservationRepository.findById(id);
	}

}
