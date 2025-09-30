package pe.edu.pe.msempresa.domain;

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

    @Column(name = "razonSocial")
    private String razonSocial;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "anio")
    private String anio;

    @Column(name = "estado")
    private String estado;

    @ManyToMany
    @JoinTable(
            name = "empresa_representante",
            joinColumns = @JoinColumn(name = "empresa_id", referencedColumnName = "idEmpresa"),
            inverseJoinColumns = @JoinColumn(name = "representante_id", referencedColumnName = "idRepresentante")
    )
    private Set<Representante> representantes = new HashSet<>();

}