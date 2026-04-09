package com.freshbasket.service;

import org.springframework.stereotype.Service;

@Service
public class SuperMarketService {
    public String getWelcomeMessage(){
        return "Bienvenidos a la App de FreshMarket";
    }

}
