package com.dev_dady.park_api.config;

import jakarta.annotation.PostConstruct;

import java.util.TimeZone;

public class SpringTimeZoneConfig {
    @PostConstruct
    public void timezoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
