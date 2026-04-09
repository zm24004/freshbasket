package com.freshbasket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freshbasket.dto.ResponseDTO;
import com.freshbasket.service.SuperMarketService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("api/v1")
public class FreshmarketController {
    private final SuperMarketService supermarketService;

    public FreshmarketController(SuperMarketService superMarketService) {
        this.supermarketService = superMarketService;
    } 

    @GetMapping("/test")
    public ResponseDTO testEndPoint(){
        ResponseDTO response = new ResponseDTO();
        response.setMessage(SuperMarketService.getWelcomeMessage());
        response.setStatus(status: "Activo");
        return response;
    
    }
    

}
