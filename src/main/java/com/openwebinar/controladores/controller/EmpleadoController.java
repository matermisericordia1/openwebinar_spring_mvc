/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.openwebinar.controladores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.openwebinar.controladores.servicios.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.openwebinar.controladores.modelo.Empleado;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author rostro
 */

@Controller
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleados;
    
    @GetMapping("/empleados/list")
    public String listado(Model modelo) {
        modelo.addAttribute("lista", empleados.findAll());
        return "empleado/list";
    }
    
    @GetMapping("/empleados/crear")
    public String crear(Model model){
        model.addAttribute("empleadoForm", new Empleado());
        return "empleado/crear";
    }
    
    @PostMapping("/empleados/crear/save")
    public String guardar(@ModelAttribute("empleadoForm") Empleado nuevoEmpleado) {
        empleados.add(nuevoEmpleado);
        return "redirect:/empleados/list";
    }
}
