package com.springframework.petclinic.model;

public class Pet extends BaseEntity{
    private PetType petType;
    private Owner owner;
    public Pet(){}

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
