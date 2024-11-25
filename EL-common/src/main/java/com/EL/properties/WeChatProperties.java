package com.EL.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "el.wechat")
@Data
public class WeChatProperties {

    private String appid;
    private String secret;
    private String privateKeyFilePath;
    private String apiV3Key;

}
