package com.latamsol.latamsol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadosController {
    @GetMapping("/empleados")
    public String empleados(){
        return "empleados";
    }
}
