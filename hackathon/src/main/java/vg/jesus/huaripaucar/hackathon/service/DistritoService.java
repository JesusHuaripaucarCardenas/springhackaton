package vg.jesus.huaripaucar.hackathon.service;

import java.util.Optional;

import java.util.List;


import vg.jesus.huaripaucar.hackathon.model.Distrito;

public interface DistritoService {
    List<Distrito> findAll();
    Optional<Distrito> findById(Integer id);
    Distrito save(Distrito distrito);
    Distrito update(Distrito distrito);
}