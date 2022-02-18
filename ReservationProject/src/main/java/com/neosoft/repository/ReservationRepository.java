package com.neosoft.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neosoft.model.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

	List<Reservation> findByFirstNameLike(String firstName);

	@Query("from Reservation r where e.id=?1")
	Reservation findById1(Long id);
	
	@Query("FROM Reservation r WHERE r.firstName LIKE %?1% OR r.lastName LIKE %?1% OR r.mobileNo LIKE %?1% OR r.emailId %?1% OR r.city %?1% OR r.state %?1%")
	List<Reservation> performSearch(String keyWord);

}
