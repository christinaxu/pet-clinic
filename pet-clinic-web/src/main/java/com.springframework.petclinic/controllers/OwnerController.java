package com.springframework.petclinic.controllers;

import com.springframework.petclinic.models.Owner;
import com.springframework.petclinic.services.map.OwnerServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerServiceMap ownerService;

    public OwnerController(OwnerServiceMap ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","index.html","index","/"})
    public String listOwners(Model model){
        System.out.println("List All Owners");
        Set<Owner> owners = ownerService.findAll();
        for(Owner o : owners){
            System.out.println(o.getId() + "   " + o.getFirstName() + "   " + o.getLastName());
        }
        model.addAttribute("owners",owners);
        return "owners/index";

    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notimpelemented";
    }

}
