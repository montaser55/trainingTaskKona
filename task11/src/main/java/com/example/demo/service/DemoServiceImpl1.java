package com.example.demo.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "demo.service.imple.id", havingValue = "1" , matchIfMissing = true)
public class DemoServiceImpl1 implements DemoService{
    @Override
    public String getDemo() {
        return "Impl1";
    }
}
