package com.capacitacion.cursos.controller;

import com.capacitacion.cursos.dto.CursoDTO;
import com.capacitacion.cursos.entity.Curso;
import com.capacitacion.cursos.service.CursoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
//@CrossOrigin("http://localhost:4200")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    //Traer todo
    @GetMapping("/list")
    public ResponseEntity<List<Curso>> list() {
        List<Curso> cursos = cursoService.list();
        return ResponseEntity.status(HttpStatus.OK).body(cursos);
    }

    //Traer curso por id
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Curso> getById(@PathVariable("id") Long id) {
        if (!cursoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Curso curso = cursoService.getById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    //Borrar curso
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!cursoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        cursoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    //Crear Curso
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CursoDTO cursoDTO){
        if (StringUtils.isAllBlank(cursoDTO.getInstitucion()) || StringUtils.isAllBlank(cursoDTO.getTitulo())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        Curso curso=new Curso(cursoDTO.getInstitucion(), cursoDTO.getTitulo(), cursoDTO.isFinalizado(), cursoDTO.getFecha());
        cursoService.crear(curso);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    //Editar Curso
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") Long id, @RequestBody CursoDTO cursoDTO){
        
        if (!cursoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        }
        if (StringUtils.isAllBlank(cursoDTO.getInstitucion()) || StringUtils.isAllBlank(cursoDTO.getTitulo())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        
        Curso curso=cursoService.getById(id).get();
        
        curso.setInstitucion(cursoDTO.getInstitucion());
        curso.setTitulo(cursoDTO.getTitulo());
        curso.setFinalizado(cursoDTO.isFinalizado());
        curso.setFecha(cursoDTO.getFecha());
        
        cursoService.crear(curso);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
