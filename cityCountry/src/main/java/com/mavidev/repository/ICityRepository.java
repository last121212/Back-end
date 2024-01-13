package com.mavidev.repository;

import com.mavidev.repository.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICityRepository extends JpaRepository<City,Integer> {

    Optional<City> findByName(String name);
}
