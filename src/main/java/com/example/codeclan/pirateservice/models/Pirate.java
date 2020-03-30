package com.example.codeclan.pirateservice.models;

//POJO Plain Old Java Object
// All attributes to be saved to the db should be private and have getters and setters
// Need a DEFAULT constructor
// Need a LONG id.

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pirates")
public class Pirate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; //the ID that the db assigns to our object
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name = "age")
    private int age;


    @JsonIgnoreProperties(value = "pirates")
    @ManyToMany
    @Column(name = "pirates_raids_id")
    @JoinTable(
            name = "pirates_raids",
            joinColumns = { @JoinColumn(
                    name = "pirate_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false)
            }
    )
    private List<Raids> raids;

    @JsonIgnoreProperties("pirates")
    @ManyToOne
    @JoinColumn(name="ship_id",  nullable=false)
    private Ship ship;

    public Pirate(String firstName, String lastName, int age, Ship ship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ship = ship;
        this.raids = new ArrayList<> ();
//        this.raids = raids;
    }

    ////////DEFAULT CONSTRUCTOR!!
    public Pirate(){
    }

    public void addRaidToPirate(Raids raid){
        this.raids.add(raid);
    }

    public List<Raids> getRaids() {
        return this.raids;
    }

    public void setRaids(List<Raids> raids) {
        this.raids = raids;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
