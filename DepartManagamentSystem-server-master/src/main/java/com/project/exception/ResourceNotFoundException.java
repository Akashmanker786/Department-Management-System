package com.project.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ResourceNotFoundException extends RuntimeException {
    private String message;
    private Long resourceId;

    public ResourceNotFoundException(String message ,  Long fieldValue) {

        super(String.format("%s not found with  : %s " , message, fieldValue));


    }
}
