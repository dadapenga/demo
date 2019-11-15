package com.example.demo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class DemoProperties {

    @Value("${com.demo.title}")
    private String title;

    @Value("@{com.demo.description}")
    private String description;

}
