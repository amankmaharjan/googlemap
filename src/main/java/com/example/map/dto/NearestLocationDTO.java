package com.example.map.dto;

import com.example.map.model.NearestLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NearestLocationDTO {
    int id;
    String name;

    public NearestLocationDTO(NearestLocation nearestLocation) {
        id=nearestLocation.getId();
        name=nearestLocation.getName();
    }
}
