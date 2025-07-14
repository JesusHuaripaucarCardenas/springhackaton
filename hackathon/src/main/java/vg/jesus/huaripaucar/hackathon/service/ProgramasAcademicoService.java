package vg.jesus.huaripaucar.hackathon.service;

import java.util.Optional;

import java.util.List;


import vg.jesus.huaripaucar.hackathon.model.ProgramasAcademico;

public interface ProgramasAcademicoService {
    List<ProgramasAcademico> findAll();
    Optional<ProgramasAcademico> findById(Integer id);
    ProgramasAcademico save(ProgramasAcademico pa);
    ProgramasAcademico update(ProgramasAcademico pa);
}