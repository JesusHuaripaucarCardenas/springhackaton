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


import vg.jesus.huaripaucar.hackathon.model.Provincia;
import vg.jesus.huaripaucar.hackathon.service.ProvinciaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/provincia")
public class ProvinciaRest {

    private final ProvinciaService service;

    @Autowired
    public ProvinciaRest(ProvinciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Provincia> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Provincia> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public Provincia save(@RequestBody Provincia prov) {
        return service.save(prov);
    }

    @PutMapping("/update")
    public Provincia update(@RequestBody Provincia prov) {
        return service.update(prov);
    }
}