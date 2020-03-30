package com.example.codeclan.pirateservice.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="raids")
public class Raids {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="location")
    private String location;

    @Column(name="loot")
    private int loot;

    @JsonIgnoreProperties(value = "raids")
    @ManyToMany
    @JoinTable(
            name = "raids_pirates",
            joinColumns = { @JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "pirate_id",
                    nullable = false,
                    updatable = false)
            })
    private List<Pirate> pirates;


    public Raids(String location, int loot){
        this.location = location;
        this.loot = loot;
        this.pirates = new ArrayList<>();
    }

    public Raids(){

    }

    public void addPirateToRaid(Pirate pirates){
        this.pirates.add(pirates);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }
}
