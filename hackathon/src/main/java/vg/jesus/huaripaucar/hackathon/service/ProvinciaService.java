package vg.jesus.huaripaucar.hackathon.service;

import java.util.Optional;

import java.util.List;


import vg.jesus.huaripaucar.hackathon.model.Provincia;

public interface ProvinciaService {
    List<Provincia> findAll();
    Optional<Provincia> findById(Integer id);
    Provincia save(Provincia provincia);
    Provincia update(Provincia provincia);
}
