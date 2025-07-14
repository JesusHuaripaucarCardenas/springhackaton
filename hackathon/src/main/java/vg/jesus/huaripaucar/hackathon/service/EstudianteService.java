package vg.jesus.huaripaucar.hackathon.service;

import java.util.List;
import java.util.Optional;

import vg.jesus.huaripaucar.hackathon.model.Estudiante;

public interface EstudianteService {

    List<Estudiante> findAll();

    List<Estudiante> findByEstado(String estado);

    Optional<Estudiante> findById(Long id);

    Estudiante save(Estudiante estudiante);

    Estudiante update(Estudiante estudiante);

    Estudiante delete(Long id);

    Estudiante restore(Long id);

    byte[] generateJasperPdfReport(Long id) throws Exception;

}
