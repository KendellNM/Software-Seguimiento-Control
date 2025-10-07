package  pe.edu.pe.mspracticas.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;
    @Column(name = "ruc")
    private String ruc;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "representante")
    private String representante;

    @Column(name = "estado")
    private String estado;

    @Column(name = "email")
    private String email;


    @ManyToMany(mappedBy = "empresas")
    @JsonIgnore
    private Set<Practicas> practicas = new HashSet<>();
}