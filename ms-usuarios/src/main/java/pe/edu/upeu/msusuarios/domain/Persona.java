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
    @Table(name = "Persona")
    public class Persona {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPersona;@Column(name = "nombre")
private String nombre;

@Column(name = "apellido")
private String apellido;

@Column(name = "dni")
private String dni;

@Column(name = "edad")
private Integer edad;

@Column(name = "direccion")
private String direccion;

@Column(name = "telefono")
private String telefono;

@Column(name = "correo")
private String correo;

@Column(name = "fechaNacimiento")
private String fechaNacimiento;

@Column(name = "genero")
private String genero;

@Column(name = "estado")
private String estado;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Estudiante persona;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinador_id")
    private Coordinador coordinador;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secretaria_id")
    private Secretaria secretaria;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Director director;
    }