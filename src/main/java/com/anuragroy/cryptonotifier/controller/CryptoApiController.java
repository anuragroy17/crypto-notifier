package com.anuragroy.cryptonotifier.controller;

import com.anuragroy.cryptonotifier.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/crypto")
public class CryptoApiController {


    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/doge")
    public String getDogeCoinPrice() {
          return cryptoService.getDogeCoinPrice();
    }
}
