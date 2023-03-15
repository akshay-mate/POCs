package com.example.jwt.configuration;

import com.example.jwt.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.ZoneId;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Component
public class TotalUsersInfoContributor implements InfoContributor {


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("project.name", String.valueOf("jwt-token"));
        builder.withDetail("groupId", String.valueOf("com.example.jwt"));
        builder.withDetail("artifactId", String.valueOf("jwt-token"));
        builder.withDetail("version", String.valueOf("2.6.1"));
    }


//
//    @Override
//    public void contribute(Info.Builder builder) {
//        builder.withDetail("jwt-token",
//                Collections.singletonMap("project name ", "jwt-token")); }
//

}
