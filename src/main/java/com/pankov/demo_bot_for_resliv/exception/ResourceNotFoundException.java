package com.pankov.demo_bot_for_resliv.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    private String messageError;

    public ResourceNotFoundException(String messageError) {
        super(messageError);
        this.messageError = messageError;
    }
}
