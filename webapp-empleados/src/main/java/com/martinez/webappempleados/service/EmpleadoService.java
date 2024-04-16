package com.martinez.webappempleados.service;

import com.martinez.webappempleados.persistence.entity.EmpleadoEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmpleadoService {

    //public List<EmpleadoEntity> findAll();
    public Page<EmpleadoEntity> findAll(int page, int elements);
    public EmpleadoEntity findById(Integer id);
    public EmpleadoEntity save(EmpleadoEntity empleado);
    public void delete(Integer id);

}
