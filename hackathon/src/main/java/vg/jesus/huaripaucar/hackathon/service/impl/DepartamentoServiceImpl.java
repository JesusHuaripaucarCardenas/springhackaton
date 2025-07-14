package vg.jesus.huaripaucar.hackathon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import vg.jesus.huaripaucar.hackathon.model.Departamento;
import vg.jesus.huaripaucar.hackathon.repository.DepartamentoRepository;
import vg.jesus.huaripaucar.hackathon.service.DepartamentoService;

@Slf4j
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository repo;

    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Departamento> findAll() {
        log.info("Listando departamentos");
        return repo.findAll();
    }

    @Override
    public Optional<Departamento> findById(Integer id) {
        log.info("Buscando departamento ID={}" , id);
        return repo.findById(id);
    }

    @Override
    public Departamento save(Departamento departamento) {
        log.info("Guardando departamento: {}" , departamento);
        return repo.save(departamento);
    }

    @Override
    public Departamento update(Departamento departamento) {
        log.info("Actualizando departamento: {}" , departamento);
        return repo.save(departamento);
    }
}
