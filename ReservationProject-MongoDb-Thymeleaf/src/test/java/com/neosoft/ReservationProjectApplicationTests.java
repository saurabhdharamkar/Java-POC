package com.neosoft;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import static org.assertj.core.api.Assertions.assertThat;

import com.neosoft.model.Reservation;
import com.neosoft.repository.ReservationRepository;

@SpringBootTest
class ReservationProjectApplicationTests {

	@Autowired
	private ReservationRepository reservationRepository;
	
	

	@Test
	void findReservationById() {
		Assert.notNull(reservationRepository.findById((long) 1));
	}
	
	@Test
	void findAllReservations() {
		Assert.notNull(reservationRepository.findAll());
	}
	
	@Test
	void addUser() {

		Reservation reservation = new Reservation((long)1,"Saurabh","Dharamkar","8830134731","sd@gmail.com","Akola","Maharashtra","2022-02-12");
		Assert.notNull(reservationRepository.save(reservation));
	}
	
	@Test
	void updateUser() {
		
		Reservation reservation = new Reservation((long)1,"Saurabh","Dharamkar","8830134731","sd@gmail.com","Akola","Maharashtra","2022-02-12");
		Assert.notNull(reservationRepository.save(reservation));
	}
	
	
	
	@Test
	void deleteReservationById() {
		reservationRepository.deleteById((long)3);
		assertThat(reservationRepository.existsById((long)3)).isFalse();
	}
	



}
