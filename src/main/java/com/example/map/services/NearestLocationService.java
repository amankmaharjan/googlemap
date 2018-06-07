package com.example.map.services;

import com.example.map.dto.NearestLocationDTO;
import com.example.map.model.NearestLocation;
import com.example.map.repository.NearestLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NearestLocationService {
    @Autowired
    NearestLocationRepository nearestLocationRepository;


    public List<NearestLocationDTO> getAllNearestLocations() {
        List<NearestLocationDTO> nearestLocationsHouseDTOList = new ArrayList<>();
        for (NearestLocation NearestLocation : nearestLocationRepository.findAll()
                ) {
            NearestLocationDTO NearestLocationDTO = new NearestLocationDTO(NearestLocation);
            nearestLocationsHouseDTOList.add(NearestLocationDTO);


        }
        return nearestLocationsHouseDTOList;
    }

    public void insertNearestLocation(NearestLocationDTO nearestLocationDTO) {
        NearestLocation nearestLocation = new NearestLocation();
        nearestLocation.setName(nearestLocationDTO.getName());
        nearestLocationRepository.save(nearestLocation);
    }
}
