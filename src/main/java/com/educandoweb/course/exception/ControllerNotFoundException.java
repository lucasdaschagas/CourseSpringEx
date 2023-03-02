package com.educandoweb.course.exception;

import java.io.Serial;

public class ControllerNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public ControllerNotFoundException(Object id){
        super("Para de mandar visu unica filhos da puta do caralho" + id);
    }
}
