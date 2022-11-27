package com.capacitacion.cursos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cursos")
@Getter @Setter
@NoArgsConstructor

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String institucion;
    
    @Column
    private String titulo;
    
    @Column
    private boolean finalizado;
    
    @Column
    private String fecha;


    public Curso(String institucion, String titulo, boolean finalizado, String fecha) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.finalizado = finalizado;
        this.fecha = fecha;
    }
    
    
}
