package com.mavidev.repository;

import com.mavidev.repository.entity.Location;
import com.mavidev.repository.view.VwFindAllLocationJoinCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByCounty(String county);

    @Query(value = "SELECT new com.mavidev.repository.view.VwFindAllLocationJoinCity(c.name,l.county) FROM Location l INNER JOIN City c ON l.cityId = c.id")
    List<VwFindAllLocationJoinCity> findAllLocationJoinCity();
}
