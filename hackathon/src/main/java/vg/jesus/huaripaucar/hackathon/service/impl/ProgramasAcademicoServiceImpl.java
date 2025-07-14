package vg.jesus.huaripaucar.hackathon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import vg.jesus.huaripaucar.hackathon.model.ProgramasAcademico;
import vg.jesus.huaripaucar.hackathon.repository.ProgramasAcademicoRepository;
import vg.jesus.huaripaucar.hackathon.service.ProgramasAcademicoService;

@Slf4j
@Service
public class ProgramasAcademicoServiceImpl implements ProgramasAcademicoService {
    private final ProgramasAcademicoRepository repo;

    @Autowired
    public ProgramasAcademicoServiceImpl(ProgramasAcademicoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ProgramasAcademico> findAll() {
        log.info("Listando programas académicos");
        return repo.findAll();
    }

    @Override
    public Optional<ProgramasAcademico> findById(Integer id) {
        log.info("Buscando programa ID={}" , id);
        return repo.findById(id);
    }

    @Override
    public ProgramasAcademico save(ProgramasAcademico pa) {
        log.info("Guardando programa académico: {}" , pa);
        return repo.save(pa);
    }

    @Override
    public ProgramasAcademico update(ProgramasAcademico pa) {
        log.info("Actualizando programa académico: {}" , pa);
        return repo.save(pa);
    }
}