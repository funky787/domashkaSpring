package org.sadovodBase.config;

import org.sadovodBase.service.CounterService;
import org.sadovodBase.service.PrinterService;
import org.sadovodBase.service.SessionData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {


    @Bean
    public CounterService counterService() {
        return new CounterService();
    }


    @Bean
    @Scope("prototype")
    public SessionData sessionData() {
        return new SessionData();
    }


    @Bean
    public String appName() {
        return "Library Application";
    }


    @Bean
    public PrinterService printerService() {
        return new PrinterService();
    }
}