package com.springframework.petclinic.controllers;

import com.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/vets")
@Controller
public class VetController {
    private final VetServiceMap vetService;

    public VetController(VetServiceMap vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index","/vets/index.html","/vets/","/vets.html"})
    public String vetList(Model model){

        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
