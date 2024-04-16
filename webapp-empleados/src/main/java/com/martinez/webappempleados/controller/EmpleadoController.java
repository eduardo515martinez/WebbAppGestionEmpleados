package com.martinez.webappempleados.controller;

import com.martinez.webappempleados.persistence.entity.EmpleadoEntity;
import com.martinez.webappempleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public Page<EmpleadoEntity> listaEmpleados(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int elements){
        return empleadoService.findAll(page, elements);
    }

    @GetMapping("/empleados/{id}")
    public EmpleadoEntity mostrarEmpleadoPorId(@PathVariable Integer id){
        return empleadoService.findById(id);
    }

    @PostMapping("/empleados")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoEntity agregarEmpleado(@RequestBody EmpleadoEntity empleado){
        return empleadoService.save(empleado);
    }

    @PutMapping("/empleados/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoEntity actualizarEmpleado(@RequestBody EmpleadoEntity empleado, @PathVariable Integer id){
        EmpleadoEntity empleadoActual = empleadoService.findById(id);

        empleadoActual.setNombre(empleado.getNombre());
        empleadoActual.setApellido(empleado.getApellido());
        empleadoActual.setDireccion(empleado.getDireccion());
        empleadoActual.setSalario(empleado.getSalario());
        empleadoActual.setDepartamento(empleado.getDepartamento());

        return empleadoService.save(empleadoActual);
    }

    @DeleteMapping("/empleados/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarEmpleado(@PathVariable Integer id){
        empleadoService.delete(id);
    }
}
