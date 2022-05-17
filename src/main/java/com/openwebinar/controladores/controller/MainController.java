/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.openwebinar.controladores.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rostro
 */

@Controller
public class MainController {
  
    @GetMapping("/")
    public String welcome(Model modelo) {
        modelo.addAttribute("mesaje", "Envio de mensaje");
        return "index";
    }
    
      @GetMapping("/saludo")
    public String saludar(@RequestParam("saludo") String saludo, Model modelo) {
        modelo.addAttribute("mesaje", "Envio de mensaje SALUDO");
        modelo.addAttribute("saludo", saludo);
        return "saludo";
    }
    
    
    @GetMapping("/opcional")
    public String opcion(@RequestParam("opcion") Optional<String> op, Model modelo) {
        modelo.addAttribute("mesaje", "Con Optional y el emtodo de Spring orElse(mensaje) \n No dará un 400 en caso de no enviar parametro ");
        modelo.addAttribute("opcion", op.orElse("No se envio OP"));
        return "opcional";
    }
    
    @GetMapping("/parametro/{ruta}")
    public String rataParametro(@PathVariable String ruta, Model model) {
        model.addAttribute("urlP", "Envio de parametros en la url /url/parametro        : " + ruta);
        model.addAttribute("recordatorio", "Se ha de llamar igual el {name} que el @PathVariable String name");
        return "urlParametro";
    }
    
    @GetMapping("/dos")
    public String dosParametros(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        return "dosParam";
    }
    
    @GetMapping ("/dos/{puesto}/{sueldo}")
    public String dosEnUrl(@PathVariable String puesto, @PathVariable String sueldo, Model model) {
        model.addAttribute("puesto", puesto);
        model.addAttribute("sueldo", sueldo);
        return "dosParamUrl";
    }
}
