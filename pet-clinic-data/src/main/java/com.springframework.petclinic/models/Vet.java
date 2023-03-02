package com.springframework.petclinic.models;

import java.util.Set;

public class Vet extends Person{
    private Set<Specialty> specialties;

    public Vet(){}

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
