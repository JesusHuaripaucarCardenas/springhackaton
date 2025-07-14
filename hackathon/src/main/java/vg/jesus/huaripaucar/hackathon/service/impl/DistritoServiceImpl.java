package vg.jesus.huaripaucar.hackathon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import vg.jesus.huaripaucar.hackathon.model.Distrito;
import vg.jesus.huaripaucar.hackathon.repository.DistritoRepository;
import vg.jesus.huaripaucar.hackathon.service.DistritoService;

@Slf4j
@Service
public class DistritoServiceImpl implements DistritoService {
    private final DistritoRepository repo;

    @Autowired
    public DistritoServiceImpl(DistritoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Distrito> findAll() {
        log.info("Listando distritos");
        return repo.findAll();
    }

    @Override
    public Optional<Distrito> findById(Integer id) {
        log.info("Buscando distrito ID={}" , id);
        return repo.findById(id);
    }

    @Override
    public Distrito save(Distrito distrito) {
        log.info("Guardando distrito: {}" , distrito);
        return repo.save(distrito);
    }

    @Override
    public Distrito update(Distrito distrito) {
        log.info("Actualizando distrito: {}" , distrito);
        return repo.save(distrito);
    }
}