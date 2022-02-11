package com.example.mail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "message"})
public class Res<T> {
    @JsonProperty("isSuccess")
    private boolean isSuccess;
    private T message;
}