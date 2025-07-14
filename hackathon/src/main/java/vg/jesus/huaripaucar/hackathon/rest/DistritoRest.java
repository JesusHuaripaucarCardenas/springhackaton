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


import vg.jesus.huaripaucar.hackathon.model.Distrito;
import vg.jesus.huaripaucar.hackathon.service.DistritoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/distrito")
public class DistritoRest {

    private final DistritoService service;

    @Autowired
    public DistritoRest(DistritoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Distrito> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Distrito> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public Distrito save(@RequestBody Distrito dist) {
        return service.save(dist);
    }

    @PutMapping("/update")
    public Distrito update(@RequestBody Distrito dist) {
        return service.update(dist);
    }
}