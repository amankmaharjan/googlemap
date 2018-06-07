package com.example.map.restcontroller;

import com.example.map.dto.GymHouseDTO;
import com.example.map.dto.NearestLocationDTO;
import com.example.map.model.NearestLocation;
import com.example.map.services.NearestLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class NearestLocationController {
    @Autowired
    NearestLocationService nearestLocationService;

    @RequestMapping(value = "/nearestlocation/", method = RequestMethod.GET)
    public ResponseEntity<?> getNearestLocationGet(HttpServletRequest request) {
        List<NearestLocationDTO> nearestLocationDTOS = nearestLocationService.getAllNearestLocations();
        return new ResponseEntity<>(nearestLocationDTOS, HttpStatus.OK);
    }


    @RequestMapping(value = "/nearestlocation/", method = RequestMethod.POST)
    public ResponseEntity<?> createNearestLocatonPost(@RequestBody NearestLocationDTO nearestLocationDTO) {

        nearestLocationService.insertNearestLocation(nearestLocationDTO);

        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
}
