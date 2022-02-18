package com.neosoft.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.neosoft.exception.ResourceNotFoundException;
import com.neosoft.model.Reservation;
import com.neosoft.service.ReservationService;
import com.neosoft.service.SequenceGeneratorService;

@Controller

public class ReservationController {
	
	private static final Logger log=LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired 
	private ReservationService reservationService;
	
	@Autowired 
	private SequenceGeneratorService sequenceGeneratorService;

	public ReservationController(ReservationService reservationService) {
		
		this.reservationService = reservationService;
	}
	
	   @GetMapping("/reservations")
	    public Iterable<Reservation> getAllReservations() {
	        return reservationService.reservationList();
	    }
	
	@GetMapping("/reservationList")
	public String reservationList(Model model) {
		log.info("GET:/reservationList-->called");
		model.addAttribute("reservations",reservationService.reservationList());
		return "reservations";
	}
	
	@GetMapping("/reservation/{id}")
	public String reservationList(Model model,@PathVariable("id")Long id) {
		model.addAttribute(reservationService.getReservById(id));
		return "reservations";
	}
	
	 @GetMapping(value = {"/add-form"})
	    public String addReservation( Model model,@ModelAttribute("reservation")Reservation reservation) {
	        log.info("Get:/add-form---->Called");
	        model.addAttribute("reservation", reservation);
	        return "add-edit";
	    }
	 
	 @PostMapping("/save-reservation")
	    public String editReservation(@ModelAttribute("reservation") @Valid Reservation reservation) {
		 reservation.setId(sequenceGeneratorService.generateSequence(Reservation.SEQUENCE_NAME));
		 log.info("POST:/save-reservation/{"+reservation.getId()+"}-->called");
	        reservationService.addReservation(reservation);
	        return "redirect:reservationList";
	    }
	 @PostMapping("/save-reservation1")
	    public String editReservation1(@ModelAttribute("reservation") @Valid Reservation reservation) {
		// reservation.setId(sequenceGeneratorService.generateSequence(Reservation.SEQUENCE_NAME));
		 log.info("POST:/save-reservation/{"+reservation.getId()+"}-->called");
	        reservationService.addReservation(reservation);
	        return "redirect:reservationList";
	    }
	 
	 @GetMapping(value = {"/edit-form/{id}", "/edit-form"})
	    public String editReservation(@PathVariable("id") Optional<Long> id, Model model) {
		 log.info("Get:/edit-form/{"+id+"}---->Called");
	        Reservation reservation = id.isPresent() ?
	                reservationService.findById(id.get()).get() : new Reservation();
	        model.addAttribute("reservation", reservation);
	        return "edit";
	    }

	@PutMapping("/edit-add-reservation/{id}")
	public String updateReservation(@Valid @ModelAttribute("reservation") Reservation reservation,@PathVariable("id")Long id) 
			throws ResourceNotFoundException{
		log.info("Put:/edit-add-reservation/{"+reservation.getId()+"}---->Called");
		Reservation reservation1=reservationService.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Reservation Not Found for Id"+id));
		reservation.setId(id);
		reservationService.addReservation(reservation);
		return "redirct:add-edit";
	}
	
	@GetMapping("/delete-reservation/{id}")
	public String deleteReservation(@PathVariable("id")Long id,Model model) throws ResourceNotFoundException {
		log.info("GetMapping:/delete-reservation{"+id+"}--->called");
		Reservation reservation1=reservationService.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Reservation Not Found for Id"+id));
		reservationService.deleteReservation(id);
		model.addAttribute("reservations",reservationService.reservationList());
		return "reservations";
		
	}
	
	@GetMapping("/search/{firstName}")
		
		public String findByFirstOrLastOrMobileOrEmail(@PathVariable("firstName") String firstName,@PathVariable("lastName")String lastName,@PathVariable("mobileNo")String mobileNo,@PathVariable("emailId")String emailId,Model model) {
		System.out.println("hello");
		model.addAttribute("reservations",reservationService.findByFirstNameOrLastNameOrMobileNoOrEmailId(firstName,lastName,mobileNo,emailId));
	     return "reservations";
	}
	
	
	
	
	

}
