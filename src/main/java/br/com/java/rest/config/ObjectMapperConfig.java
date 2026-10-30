package br.com.java.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.databind.ser.std.SimpleBeanPropertyFilter;
import tools.jackson.databind.ser.std.SimpleFilterProvider;


@Configuration
public class ObjectMapperConfig {

    @Bean
    public  ObjectWriter objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleFilterProvider filters = new SimpleFilterProvider()
                .addFilter("PersonFilter",
                        SimpleBeanPropertyFilter.serializeAllExcept("lastName", "password"));

        return mapper.writer(filters);
    }
}
