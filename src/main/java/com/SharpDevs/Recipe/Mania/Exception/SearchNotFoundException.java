package com.SharpDevs.Recipe.Mania.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SearchNotFoundException extends RuntimeException {

    public SearchNotFoundException(String message){

        super(message);
    }
}
