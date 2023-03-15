package com.example.signature2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Getter
@Setter
public class ResponseField {
    @JsonProperty("Generated Signature")
    private String Signature;
}