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
    @Table(name = "Coordinador")
    public class Coordinador {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idCoordinador;@Column(name = "codigo")
private String codigo;

@Column(name = "estado")
private String estado;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinador_id")
    private Persona coordinador;
    }