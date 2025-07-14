package vg.jesus.huaripaucar.hackathon.rest;

import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vg.jesus.huaripaucar.hackathon.model.Estudiante;
import vg.jesus.huaripaucar.hackathon.service.EstudianteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/estudiante")
public class EstudianteRest {

    private final EstudianteService service;

    @Autowired
    public EstudianteRest(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estudiante> findAll() {
        return service.findAll();
    }

    @GetMapping("/estado/{estado}")
    public List<Estudiante> findByEstado(@PathVariable String estado) {
        return service.findByEstado(estado);
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/save")
    public Estudiante save(@RequestBody Estudiante estudiante) {
        return service.save(estudiante);
    }

    @PutMapping("/update")
    public Estudiante update(@RequestBody Estudiante estudiante) {
        return service.update(estudiante);
    }

    @PatchMapping("/delete/{id}")
    public Estudiante delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PatchMapping("/restore/{id}")
    public Estudiante restore(@PathVariable Long id) {
        return service.restore(id);
    }

@GetMapping("/pdf/{id}")
public ResponseEntity<byte[]> generateReport(@PathVariable Long id) {
    try {
        byte[] pdf = service.generateJasperPdfReport(id);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=reporte_estudiante_" + id + ".pdf")
            .contentType(MediaType.APPLICATION_PDF)
            .body(pdf);
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.internalServerError().build();
    }
}

}
