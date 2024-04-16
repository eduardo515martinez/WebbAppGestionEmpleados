package com.martinez.webappempleados.persistence.dao;

import com.martinez.webappempleados.persistence.entity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoDao extends CrudRepository<EmpleadoEntity, Integer> {

}
