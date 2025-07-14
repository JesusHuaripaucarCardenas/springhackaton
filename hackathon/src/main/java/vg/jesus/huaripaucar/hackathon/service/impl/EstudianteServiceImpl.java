package vg.jesus.huaripaucar.hackathon.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import vg.jesus.huaripaucar.hackathon.model.Estudiante;
import vg.jesus.huaripaucar.hackathon.repository.EstudianteRepository;
import vg.jesus.huaripaucar.hackathon.service.EstudianteService;

@Slf4j
@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repo;
    private final DataSource dataSource;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository repo, DataSource dataSource) {
        this.repo = repo;
        this.dataSource = dataSource;
    }

    @Override
    public List<Estudiante> findAll() {
        log.info("Listando todos los estudiantes");
        return repo.findAll();
    }

    @Override
    public List<Estudiante> findByEstado(String estado) {
        log.info("Listando estudiantes por estado: {}", estado);
        return repo.findByEstado(estado);
    }

    @Override
    public Optional<Estudiante> findById(Long id) {
        log.info("Buscando estudiante por ID: {}", id);
        return repo.findById(id);
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        log.info("Guardando estudiante: {}", estudiante);
        // prePersist ya pone fechaInscripcion y estado
        return repo.save(estudiante);
    }

    @Override
    public Estudiante update(Estudiante estudiante) {
        log.info("Actualizando estudiante: {}", estudiante);
        estudiante.setEstado("A");
        return repo.save(estudiante);
    }

    @Override
    public Estudiante delete(Long id) {
        log.info("Eliminando (soft) estudiante con ID: {}", id);
        Estudiante e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        e.setEstado("I");
        return repo.save(e);
    }

    @Override
    public Estudiante restore(Long id) {
        log.info("Restaurando estudiante con ID: {}", id);
        Estudiante e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        e.setEstado("A");
        return repo.save(e);
    }

@Override
public byte[] generateJasperPdfReport(Long id) throws Exception {
    InputStream jasperStream = new ClassPathResource("reports/report_estudiante.jasper").getInputStream();
    HashMap<String, Object> params = new HashMap<>();
    if (id != null) {
        params.put("ESTUDIANTE_ID", id);
    }
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, params, dataSource.getConnection());
    return JasperExportManager.exportReportToPdf(jasperPrint);
}

}