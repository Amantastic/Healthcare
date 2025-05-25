package com.medislot.appointment.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.api_key}")
    private String apiKey;

    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        );
        return new Cloudinary(config);
    }

}


//@Bean
//public Cloudinary cloudinary() {
//    return new Cloudinary(ObjectUtils.asMap(
//            "cloud_name", "dqrhdgrl6jw8",
//            "api_key", "111736239997dg355",
//            "api_secret", "p16DjgjhsHdgdrmsfGJS7VOdEvfWLqs",
//            "secure", true
//    ));
//}

//cloudinary.cloud_name=your_cloud_name_here
//cloudinary.api_key=your_api_key_here
//cloudinary.api_secret=your_api_secret_here