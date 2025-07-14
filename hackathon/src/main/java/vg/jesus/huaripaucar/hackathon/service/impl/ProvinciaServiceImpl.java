package vg.jesus.huaripaucar.hackathon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import vg.jesus.huaripaucar.hackathon.model.Provincia;
import vg.jesus.huaripaucar.hackathon.repository.ProvinciaRepository;
import vg.jesus.huaripaucar.hackathon.service.ProvinciaService;

@Slf4j
@Service
public class ProvinciaServiceImpl implements ProvinciaService {
    private final ProvinciaRepository repo;

    @Autowired
    public ProvinciaServiceImpl(ProvinciaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Provincia> findAll() {
        log.info("Listando provincias");
        return repo.findAll();
    }

    @Override
    public Optional<Provincia> findById(Integer id) {
        log.info("Buscando provincia ID={}" , id);
        return repo.findById(id);
    }

    @Override
    public Provincia save(Provincia provincia) {
        log.info("Guardando provincia: {}" , provincia);
        return repo.save(provincia);
    }

    @Override
    public Provincia update(Provincia provincia) {
        log.info("Actualizando provincia: {}" , provincia);
        return repo.save(provincia);
    }
}