package com.example.signature2.controller;

import com.example.signature2.model.RequestFields;
import com.example.signature2.model.ResponseField;
import com.example.signature2.service.SignService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

@RequestMapping(path="/signature")
@RestController
public class MainController
{
    static final String HMAC = "HmacSHA256";
    @PostMapping("/post")
    public @ResponseBody
    ResponseField signature(@RequestBody RequestFields s)
            throws UnsupportedEncodingException, InvalidKeyException, JsonProcessingException, NoSuchAlgorithmException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {

        String secretKey=s.getSecretKey();
        ObjectMapper objectMapper = new ObjectMapper();
        String json=objectMapper.writeValueAsString(s);
        HashMap<String,String> map= objectMapper.readValue(json, HashMap.class);
        String data= SignService.build(map);
        String signature=SignService.sign(data,secretKey,HMAC);

        Gson gson = new Gson();
        ResponseField r= gson.fromJson("{\"Signature\":\""+signature+"\"}", ResponseField.class);
        return r;

    }

}
