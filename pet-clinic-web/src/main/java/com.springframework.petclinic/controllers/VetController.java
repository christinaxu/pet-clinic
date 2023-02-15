package com.springframework.petclinic.controllers;

import com.springframework.petclinic.services.map.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vets","index","index.html","/"})
    public String vetList(Model model){

        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
