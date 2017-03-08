package com.sky.services;


import com.sky.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebLocationController {


    @Autowired
    protected WebLocationService webLocationService;

    public WebLocationController(WebLocationService webLocationService){
        this.webLocationService =webLocationService;
    }


    @RequestMapping("/customer/{customerId}")
    public String getCustomerLocation(Model model, @PathVariable("customerId") String customerId){

        Location location = webLocationService.getLocationForCustomer(customerId);
        model.addAttribute("location",location);
        return "location";

    }

}
