package vg.jesus.huaripaucar.hackathon.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import vg.jesus.huaripaucar.hackathon.model.ProgramasAcademico;
import vg.jesus.huaripaucar.hackathon.service.ProgramasAcademicoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/programas_academico")
public class ProgramasAcademicoRest {

    private final ProgramasAcademicoService service;

    @Autowired
    public ProgramasAcademicoRest(ProgramasAcademicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProgramasAcademico> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProgramasAcademico> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public ProgramasAcademico save(@RequestBody ProgramasAcademico pa) {
        return service.save(pa);
    }

    @PutMapping("/update")
    public ProgramasAcademico update(@RequestBody ProgramasAcademico pa) {
        return service.update(pa);
    }
}
