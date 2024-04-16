package com.martinez.webappempleados.service;

import com.martinez.webappempleados.persistence.dao.EmpleadoDao;
import com.martinez.webappempleados.persistence.dao.EmpleadoPagSort;
import com.martinez.webappempleados.persistence.entity.EmpleadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoDao empleadoDao;

    @Autowired
    private EmpleadoPagSort empleadoPagSort;
    @Override
    @Transactional(readOnly = true)
    public Page<EmpleadoEntity> findAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return empleadoPagSort.findAll(pageRequest);
    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoEntity findById(Integer id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public EmpleadoEntity save(EmpleadoEntity empleado) {
        return empleadoDao.save(empleado);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        empleadoDao.deleteById(id);
    }
}
