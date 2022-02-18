package com.neosoft.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neosoft.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

	List<Reservation> findByFirstNameOrLastNameOrMobileNoOrEmailId(String firstName, String lastName, String mobileNo,
			String emailId);

	@Query("from Reservation r where e.id=?1")
	Reservation findById1(Long id);

}
