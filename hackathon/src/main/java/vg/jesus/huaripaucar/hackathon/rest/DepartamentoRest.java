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


import vg.jesus.huaripaucar.hackathon.model.Departamento;
import vg.jesus.huaripaucar.hackathon.service.DepartamentoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/departamento")
public class DepartamentoRest {

    private final DepartamentoService service;

    @Autowired
    public DepartamentoRest(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Departamento> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Departamento> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public Departamento save(@RequestBody Departamento dept) {
        return service.save(dept);
    }

    @PutMapping("/update")
    public Departamento update(@RequestBody Departamento dept) {
        return service.update(dept);
    }
}