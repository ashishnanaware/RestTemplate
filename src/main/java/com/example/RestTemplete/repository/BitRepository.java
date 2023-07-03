package com.example.RestTemplete.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.RestTemplete.BO.BitRate;
@EnableJpaRepositories
@Repository
public interface BitRepository extends JpaRepository<BitRate, Integer> {

	
	@Query(value = "select p from BitRate p")
	public List<BitRate> allData();
	
	

}
