package pe.edu.pe.mspracticas.domain;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashSet;
    import java.util.Set;

@Getter
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Table(name = "Practicas")
    public class Practicas {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPracticas;
        @Column(name = "idEstudiante")
private Integer idEstudiante;

@Column(name = "nombreEstudiante")
private String nombreEstudiante;

@Column(name = "fechaInicio")
private LocalDate fechaInicio;

@Column(name = "fechaFin")
private LocalDate fechaFin;

@Column(name = "estado")
private String estado;

@Column(name = "fechaSolicitud")
private LocalDateTime fechaSolicitud;

@Column(name = "fechaAprobacionCoordinador")
private LocalDateTime fechaAprobacionCoordinador;

@Column(name = "fechaAprobacionSecretaria")
private LocalDateTime fechaAprobacionSecretaria;

@Column(name = "comentariosSecretaria")
private String comentariosSecretaria;


        @ManyToMany
        @JoinTable(
                name = "empresa_practicas",
                joinColumns = @JoinColumn(name = "practicas_id"),
                inverseJoinColumns = @JoinColumn(name = "empresa_id")
        )
        private Set<Empresa> empresas = new HashSet<>();

        @ManyToMany
        @JoinTable(
                name = "tutor_practicas",
                joinColumns = @JoinColumn(name = "practicas_id"),
                inverseJoinColumns = @JoinColumn(name = "tutor_id")
        )
        private Set<Tutor> tutores = new HashSet<>();

        @OneToMany(mappedBy = "practicas", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Pasos> pasos = new HashSet<>();

    }