package vg.jesus.huaripaucar.hackathon.service;

import java.util.Optional;

import java.util.List;


import vg.jesus.huaripaucar.hackathon.model.Departamento;

public interface DepartamentoService {
    List<Departamento> findAll();
    Optional<Departamento> findById(Integer id);
    Departamento save(Departamento departamento);
    Departamento update(Departamento departamento);
}