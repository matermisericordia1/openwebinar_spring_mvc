/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.openwebinar.controladores.servicios;

import com.openwebinar.controladores.modelo.Empleado;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 *
 * @author rostro
 */
@Service
public class EmpleadoService {

    private List<Empleado> repositorio = new ArrayList<>();

    public Empleado add(Empleado e) {
        repositorio.add(e);
        return e;
    }

    public List<Empleado> findAll() {
        return repositorio;
    }

    @PostConstruct
    public void init() {
        repositorio.addAll(
                Arrays.asList(
                        new Empleado(1, "Juan Marcos", "antonio@nimen.com", "765432"),
                        new Empleado(2, "Pedro Orduñez", "pedro@nimen.com", "5576232"),
                        new Empleado(3, "Ana Garcia", "ana@nimen.com", "127654")
                )
        );
    }

    public Empleado findById(long id) {
        Empleado result = null;
        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < repositorio.size()) {
            if (repositorio.get(i).getId() == id) {
                encontrado = true;
                result = repositorio.get(i);
            } else {
                i++;
            }
        }
        return result;
    }

    public Empleado edit(Empleado e) {

        boolean encontrado = false;

        int i = 0;

        while (!encontrado && i < repositorio.size()) {
            if (repositorio.get(i).getId() == e.getId()) {
                encontrado = true;
                repositorio.remove(i);
                repositorio.add(i, e);
            } else {
                i++;
            }

        }

        if (!encontrado) {
            repositorio.add(e);
        }
        return e;
    }

}
