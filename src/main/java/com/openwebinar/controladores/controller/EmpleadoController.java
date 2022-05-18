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
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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
        return "empleado/editar";
    }
    
    @PostMapping("/empleados/crear/save")
    public String guardar(@Valid @ModelAttribute("empleadoForm") Empleado nuevoEmpleado, 
            BindingResult bindingResult) {
        System.out.println(bindingResult.toString());
        
        if(bindingResult.hasErrors()) {
            return "empleado/editar";
        } else {
            empleados.add(nuevoEmpleado);
            return "redirect:/empleados/list";
        }
        
        
    }
    
     @GetMapping("/empleados/editar/{id}")
    public String editar(@PathVariable long id, Model model){
        
        Empleado empleado = empleados.findById(id);
        
        if (empleado!=null) {
            model.addAttribute("empleadoForm", empleado);
            return "empleado/editar";
        } else {
            return "redirect:empleado/crear";
        }
        
        
    }
    
    @PostMapping("/empleados/editar/save")
    public String editarEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado editadoEmpleado,
            BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "empleado/editar";
        } else {
            
        empleados.edit(editadoEmpleado);
        return "redirect:/empleados/list";
        }
        
    }
}
