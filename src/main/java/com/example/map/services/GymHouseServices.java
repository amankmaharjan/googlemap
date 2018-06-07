package com.example.map.services;

import com.example.map.dto.GymHouseDTO;
import com.example.map.model.GymHouse;
import com.example.map.model.NearestLocation;
import com.example.map.repository.GymHouseRepository;
import com.example.map.repository.LocationRepository;
import com.example.map.repository.NearestLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GymHouseServices {
    @Autowired
    GymHouseRepository gymHouseRepository;
    @Autowired
    NearestLocationRepository nearestLocationRepository;
    @Autowired
    LocationRepository locationRepository;
    @PersistenceContext
    EntityManager entityManager;


    public List<GymHouseDTO> getAllGymHouses() {
        List<GymHouseDTO> gymHousesHouseDTOList = new ArrayList<>();
        for (GymHouse gymHouse : gymHouseRepository.findAll()
                ) {
            GymHouseDTO gymHouseDTO = new GymHouseDTO(gymHouse);
            gymHousesHouseDTOList.add(gymHouseDTO);

        }
        return gymHousesHouseDTOList;
    }

    public void insertGymHouse(GymHouseDTO gymHouseDTO) {
        GymHouse gymHouse = new GymHouse();
        gymHouse.setLocation(gymHouseDTO.getLocation());
        gymHouse.setName(gymHouseDTO.getName());

        List<NearestLocation> nearestLocationList = gymHouseDTO.getNearestLocationList();
        for (NearestLocation nearestLocation : nearestLocationList
                ) {
            nearestLocation = nearestLocationRepository.getOne(nearestLocation.getId());
        }

        gymHouse.setNearestLocationList(nearestLocationList);
        gymHouseRepository.save(gymHouse);
    }

    public List<GymHouseDTO> getAllGymHousesByNearestLocation(String nearestGymHouseLocation) {
        NearestLocation nearestLocation = nearestLocationRepository.findByName(nearestGymHouseLocation);
        if (nearestLocation == null) {
            System.out.println("not found");
            return null;
        }
        List<GymHouseDTO> gymHouseDTOList = new ArrayList<>();
        String sql = "SELECT   gh.id, gh.name, gh.`location`,  gh.`extra`, ghnl.`nearest_location_list`  FROM   `gym_house_nearest_location_list` ghnl   JOIN nearest_location nl ON( ghnl.`nearest_location_list` = nl.`id`   AND nl.`name` like  CONCAT('%',:nearestLocatonName,'%')  )JOIN `gym_house` gh     ON (gh.id = ghnl.`gym_house_id`) ";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nearestLocatonName", nearestGymHouseLocation);
        List<Object[]> rows = query.getResultList();
        for (Object[] row : rows) {

            List<NearestLocation> nearestLocationList = new ArrayList<>();
            nearestLocationList.add(nearestLocationRepository.findById((Integer) row[4]).orElse(null));


            GymHouseDTO gymHouseDTO = new GymHouseDTO();
            gymHouseDTO.setId(Integer.parseInt(row[0].toString()));
            gymHouseDTO.setName(row[1].toString());
            gymHouseDTO.setLocation(locationRepository.findById((Integer) row[2]).orElse(null));
            if (row[3] == null) {
                gymHouseDTO.setExtra(null);
            } else {
                gymHouseDTO.setExtra(row[3].toString());
            }

            gymHouseDTO.setNearestLocationList(nearestLocationList);
            gymHouseDTOList.add(gymHouseDTO);

        }

        return gymHouseDTOList;
    }
}
