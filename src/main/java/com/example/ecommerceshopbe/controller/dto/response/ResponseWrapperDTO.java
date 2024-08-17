package com.example.ecommerceshopbe.controller.dto.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class ResponseWrapperDTO<T> {
    private T data;
    private String errorMessage;
}
