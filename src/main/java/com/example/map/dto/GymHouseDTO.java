package com.example.map.dto;

import com.example.map.model.GymHouse;
import com.example.map.model.Location;
import com.example.map.model.NearestLocation;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GymHouseDTO {

    int id;
    String name;
    Location location;
    String extra;
    List<NearestLocation> nearestLocationList;
    public GymHouseDTO(GymHouse gymHouse) {
        id=gymHouse.getId();
        name=gymHouse.getName();
        location=gymHouse.getLocation();
        nearestLocationList=gymHouse.getNearestLocationList();
        extra=gymHouse.getExtra();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public List<NearestLocation> getNearestLocationList() {
        return nearestLocationList;
    }

    public void setNearestLocationList(List<NearestLocation> nearestLocationList) {
        this.nearestLocationList = nearestLocationList;
    }
}
