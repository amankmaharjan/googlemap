package com.example.map.repository;

import com.example.map.model.NearestLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NearestLocationRepository extends JpaRepository<NearestLocation, Integer> {
    NearestLocation findByName(String name);
}
