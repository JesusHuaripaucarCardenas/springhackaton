package vg.jesus.huaripaucar.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vg.jesus.huaripaucar.hackathon.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByEstado(String estado);
}
