package com.anuragroy.cryptonotifier.controller;

import com.anuragroy.cryptonotifier.service.CryptoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/crypto")
public class CryptoApiController {

    Logger log = LoggerFactory.getLogger(CryptoApiController.class);

    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/doge")
    public String getDogeCoinPrice() {
          return cryptoService.getDogeCoinPrice();
    }

    @Scheduled(fixedDelay = 60000, initialDelay = 5000)
    public void sendNotification() {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                new com.twilio.type.PhoneNumber("whatsapp:+917276585354"),
//                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
//                cryptoService.getDogeCoinPrice())
//                .create();

        log.debug("Notified Whatsapp");
    }
}
