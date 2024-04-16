package com.martinez.webappempleados.persistence.dao;

import com.martinez.webappempleados.persistence.entity.EmpleadoEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface EmpleadoPagSort extends ListPagingAndSortingRepository<EmpleadoEntity, Integer> {
}
