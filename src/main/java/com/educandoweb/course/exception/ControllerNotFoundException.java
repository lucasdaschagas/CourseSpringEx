package com.educandoweb.course.exception;

import java.io.Serial;

public class ControllerNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public ControllerNotFoundException(Object id){
        super("Id " + id + " do not exists, please insert a valid id");
    }
}
