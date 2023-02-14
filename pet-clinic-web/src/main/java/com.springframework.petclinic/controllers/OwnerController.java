package com.springframework.petclinic.controllers;

import com.springframework.petclinic.services.map.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","index.html","index","/"})
    public String listOwners(Model model){
        System.out.println("List All Owners");
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";

    }



//    @RequestMapping({"","index.html","index","/"})
//    public String petIndex(){
//        System.out.println("test");
//        return "test";
//    }
}
