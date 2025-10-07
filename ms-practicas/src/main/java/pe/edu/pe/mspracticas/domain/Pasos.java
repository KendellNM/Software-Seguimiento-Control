package pe.edu.pe.mspracticas.domain;

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
    @Table(name = "Pasos")
    public class Pasos {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPasos;@Column(name = "nombre")
private String nombre;

@Column(name = "idPasosExterno")
private Integer idPasosExterno;

@Column(name = "estado")
private String estado;


    @ManyToOne
    @JoinColumn(name = "practicas_id")
    private Practicas practicas;
    }