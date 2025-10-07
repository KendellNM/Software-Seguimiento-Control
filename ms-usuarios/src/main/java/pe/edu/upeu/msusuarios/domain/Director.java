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
    @Table(name = "Director")
    public class Director {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idDirector;@Column(name = "codigo")
private String codigo;

@Column(name = "estado")
private String estado;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Persona director;
    }