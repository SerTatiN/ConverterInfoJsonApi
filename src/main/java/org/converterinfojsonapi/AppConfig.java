package org.converterinfojsonapi;

import org.converterinfojsonapi.logic.ConvertorImpl;
import org.converterinfojsonapi.logic.IConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Bean
    IConverter converter(){
        return new ConvertorImpl();
    }
}
