package com.springframework.petclinic.services;

import com.springframework.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByName(String name);


}
