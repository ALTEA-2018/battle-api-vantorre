package com.miage.altea.tp.pokemon_battle_api.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Come back latter")
public class NotYourTurnException extends Exception {
    public NotYourTurnException(String message){
        super(message);
    }
}
