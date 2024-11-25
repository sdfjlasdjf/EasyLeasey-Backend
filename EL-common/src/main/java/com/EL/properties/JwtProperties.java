package com.EL.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "el.jwt")
@Data
public class JwtProperties {


    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;


    private String userSecretKey;
    private long userTtl;
    private String userTokenName;

}