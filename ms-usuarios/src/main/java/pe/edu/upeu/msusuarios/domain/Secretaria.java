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
    @Table(name = "Secretaria")
    public class Secretaria {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idSecretaria;@Column(name = "codigo")
private String codigo;

@Column(name = "estado")
private String estado;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secretaria_id")
    private Persona secretaria;
    }