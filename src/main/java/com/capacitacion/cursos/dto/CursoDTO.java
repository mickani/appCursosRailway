package com.capacitacion.cursos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CursoDTO {
 
    @NotBlank
    private String institucion;
    @NotBlank
    private String titulo;
    @NotBlank
    private boolean finalizado;
    @NotBlank
    private String fecha;
}
