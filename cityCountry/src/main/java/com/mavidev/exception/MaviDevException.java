package com.mavidev.exception;

import lombok.Getter;

@Getter
public class MaviDevException extends RuntimeException{
    private final ErrorType errorType;
    public MaviDevException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public MaviDevException(ErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }
}
