package com.javacodegeeks.example.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebMultiplicationService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    protected Logger logger = Logger.getLogger(WebMultiplicationService.class
            .getName());

    public WebMultiplicationService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }

    public String multi(String addend1, String addend2) {
        return restTemplate.getForObject(serviceUrl + "/multi?addend1={addend1}&addend2={addend2}", String.class, addend1, addend2);
    }
}