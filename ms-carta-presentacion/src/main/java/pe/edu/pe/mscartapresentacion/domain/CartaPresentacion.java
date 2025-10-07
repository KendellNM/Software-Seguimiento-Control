package pe.edu.pe.mscartapresentacion.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carta_presentacion")
public class CartaPresentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carta")
    private Long idCarta;

    private String destinatarioNombre;

    private String destinatarioCargo;

    private String empresaNombre;

    private String ciudadFecha;

    private String cuerpo;

    private String despedida;

    private String postulanteNombre;

    private String postulanteDocumento;

    private String estado;
}
