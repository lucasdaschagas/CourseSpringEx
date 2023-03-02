package com.educandoweb.course.ControllerException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1l;
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String trace;
    private String path;


}
