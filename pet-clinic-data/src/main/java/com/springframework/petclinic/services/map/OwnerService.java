package com.springframework.petclinic.services.map;

import com.springframework.petclinic.models.Owner;
import com.springframework.petclinic.models.Pet;
import org.springframework.stereotype.Service;

@Service
public class OwnerService extends AbstractServiceMap<Owner, Long> {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object){
        if(object!=null){
            if(object.getPets()!=null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required!");
                    }
                    if(pet.getId()==null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }
}
