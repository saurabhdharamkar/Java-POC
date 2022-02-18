package com.neosoft;

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
		Assert.notNull(reservationRepository.findById((long)1));
	}
	
	@Test
	void findAllReservations() {
		Assert.notNull(reservationRepository.findAll());
	}
	
	@Test
	void addReservation() {
		
		Reservation reservation = new Reservation((long)1,"Saurabh","Dharamkar","9878987678","sd@gmail.com","Akola","Maharashtra","2022-12-08");
		Assert.notNull(reservationRepository.save(reservation));
	}
	
	@Test
	void updateReservation() {
	
		Reservation reservation = new Reservation((long)1,"Saurabh","Dharamkar","9878987678","sd@gmail.com","Akola","Maharashtra","2022-12-08");
		Assert.notNull(reservationRepository.save(reservation));
	}
	
	
	@Test
	void deleteReservationById() {
		reservationRepository.deleteById((long)3);
		assertThat(reservationRepository.existsById((long)3)).isFalse();
	}
	
	@Test
	void findByFirstName() {
		Assert.notNull(reservationRepository.findByFirstNameLike("Saurabh"));
	}
}
