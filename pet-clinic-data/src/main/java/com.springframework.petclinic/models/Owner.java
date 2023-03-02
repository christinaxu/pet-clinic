package com.springframework.petclinic.models;

import java.util.Set;

public class Owner extends Person{
    public Owner(){}

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
