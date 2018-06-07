package com.example.map.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GymHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String extra;
    @OneToOne(cascade = CascadeType.ALL)
    Location location;
    @ManyToMany
    List<NearestLocation> nearestLocationList;
}

