package com.anuragroy.cryptonotifier.service.impl;

import com.anuragroy.cryptonotifier.service.CryptoService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

import java.io.IOException;

@Service
public class CryptoServiceImpl implements CryptoService {

    @Autowired
    private WebClient webClient;

    Logger log = LoggerFactory.getLogger(CryptoServiceImpl.class);

    @Override
    public String getDogeCoinPrice() {
        try {
            String url = "https://coinswitch.co/coins/dogecoin/dogecoin-to-inr";
            HtmlPage htmlPage = webClient.getPage(url);
            Node node = null;
            DomNodeList<DomNode> nodes = htmlPage.querySelectorAll(".assets__card");
            for (DomNode link : nodes) {
                node = link.getAttributes().getNamedItem("data-asset");
                if (node != null && node.getNodeValue().equals("Dogecoin")) {
                        return "Live Dogecoin Price on CoinSwitch: " + link.querySelectorAll(".assets__price").get(0).getTextContent();
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            return e.getMessage();
        }
        return "Something went wrong!";
    }
}
