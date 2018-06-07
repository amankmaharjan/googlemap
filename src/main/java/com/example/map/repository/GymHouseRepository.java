package com.example.map.repository;

import com.example.map.model.GymHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface  GymHouseRepository  extends JpaRepository<GymHouse,Integer>{
}
