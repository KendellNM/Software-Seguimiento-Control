package pe.edu.pe.mspracticas.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

public class PracticaCreateDTO {

    @NotNull(message = "El id del estudiante es obligatorio")
    private Long idEstudiante;

    private String nombreEstudiante;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Set<Long> empresaId;

    private Set<Long> tutorId;


}
