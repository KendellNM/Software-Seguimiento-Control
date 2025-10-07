package pe.edu.upeu.msusuarios.domain;

import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Getter
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Table(name = "Estudiante")
    public class Estudiante {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idEstudiante;@Column(name = "codigo")
private String codigo;

@Column(name = "estado")
private String estado;

@Column(name = "ciclo")
private String ciclo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Persona persona;
    }