package com.poddubchak.myproject.chatmsgservice.excption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by @author Vladimir Poddubchak @date 16.10.2019.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MsgNotFoundException extends RuntimeException{
    public MsgNotFoundException(String message){
        super(message);
    }
}
