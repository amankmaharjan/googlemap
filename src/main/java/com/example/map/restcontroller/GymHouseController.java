package com.example.map.restcontroller;

import com.example.map.dto.GymHouseDTO;
import com.example.map.services.GymHouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GymHouseController {
    @Autowired
    GymHouseServices gymHouseServices;

    @RequestMapping(value = "/track/", method = RequestMethod.POST)
    public ResponseEntity<?> greetingPOST(HttpServletRequest request) {

        System.out.println(request.getRemoteUser());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemotePort());

        return new ResponseEntity<String>("hello theme tracker", HttpStatus.OK);
    }

    @RequestMapping(value = "/gymhouse/", method = RequestMethod.GET)
    public ResponseEntity<?> getGymHousesGet(HttpServletRequest request) {
        List<GymHouseDTO> gymHouseDTOList = gymHouseServices.getAllGymHouses();
        return new ResponseEntity<>(gymHouseDTOList, HttpStatus.OK);
    }

    @RequestMapping(value = "/gymhouse/", method = RequestMethod.POST)
    public ResponseEntity<?> addGymHousesPost(@RequestBody GymHouseDTO gymHouseDTO) {
        gymHouseServices.insertGymHouse(gymHouseDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/gymhouse/{nearestLocationName}", method = RequestMethod.GET)
    public ResponseEntity<?> getGymHouseNearestLocation(@PathVariable("nearestLocationName")String nearestLocationName) {
        List<GymHouseDTO> gymHouseDTOList =gymHouseServices.getAllGymHousesByNearestLocation(nearestLocationName);


        return new ResponseEntity<>(gymHouseDTOList,HttpStatus.OK);
    }
}
