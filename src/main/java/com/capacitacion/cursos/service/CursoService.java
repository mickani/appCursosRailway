package com.capacitacion.cursos.service;

import com.capacitacion.cursos.entity.Curso;
import com.capacitacion.cursos.repository.ICursoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CursoService {
    
    @Autowired
    ICursoRepository cursoRepo;
    
    //Crear
    public void crear(Curso curso){
        cursoRepo.save(curso);
    }
    
    //Read
    public List<Curso> list(){
       return cursoRepo.findAll();
    }
    
    public Optional<Curso> getById(Long id){
        return cursoRepo.findById(id);
    }
    
    public Optional<Curso> getByTitulo(String titulo){
        return cursoRepo.findByTitulo(titulo);
    }
    
    //Delete
    public void delete(Long id){
        cursoRepo.deleteById(id);
    }
    
    //Validar
    public boolean existsById(Long id){
        return cursoRepo.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return cursoRepo.existsBytitulo(titulo);
    }
}
