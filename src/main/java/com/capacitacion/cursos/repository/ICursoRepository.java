package com.capacitacion.cursos.repository;

import com.capacitacion.cursos.entity.Curso;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long> {

    public Optional<Curso>findByTitulo(String titulo);

    public boolean existsBytitulo(String titulo);

}
