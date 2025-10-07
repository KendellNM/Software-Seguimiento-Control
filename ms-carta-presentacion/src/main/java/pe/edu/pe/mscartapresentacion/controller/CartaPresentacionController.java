package pe.edu.pe.mscartapresentacion.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import pe.edu.pe.mscartapresentacion.service.CartaPresentacionService;
import pe.edu.pe.mscartapresentacion.domain.CartaPresentacion;

@RestController
@ConditionalOnProperty(value = "legacy.carta.enabled", havingValue = "true")
@RequestMapping("api/carta-presentacion")
public class CartaPresentacionController {

    @Autowired
    private CartaPresentacionService service;

    @GetMapping
    public ResponseEntity<List<CartaPresentacion>> readAll() {
        try {
            List<CartaPresentacion> items = service.readAll();
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CartaPresentacion carta) {
        try {
            CartaPresentacion created = service.create(carta);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaPresentacion> getById(@PathVariable("id") Long id) {
        try {
            Optional<CartaPresentacion> opt = service.read(id);
            return opt.map(carta -> new ResponseEntity<>(carta, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody CartaPresentacion carta) {
        try {
            Optional<CartaPresentacion> opt = service.read(id);
            if (opt.isPresent()) {
                carta.setIdCarta(id);
                return new ResponseEntity<>(service.update(carta), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Logic-only endpoint to prepare template data for PDF (no PDF generation yet)
    @GetMapping("/render/{id}")
    public ResponseEntity<?> renderTemplateData(@PathVariable("id") Long id) {
        try {
            Optional<CartaPresentacion> opt = service.read(id);
            if (opt.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            CartaPresentacion c = opt.get();
            Map<String, Object> data = new HashMap<>();
            data.put("destinatarioNombre", c.getDestinatarioNombre());
            data.put("destinatarioCargo", c.getDestinatarioCargo());
            data.put("empresaNombre", c.getEmpresaNombre());
            data.put("ciudadFecha", c.getCiudadFecha());
            data.put("cuerpo", c.getCuerpo());
            data.put("despedida", c.getDespedida());
            data.put("postulanteNombre", c.getPostulanteNombre());
            data.put("postulanteDocumento", c.getPostulanteDocumento());
            data.put("estado", c.getEstado());
            // Placeholder of a basic template string to be used later for PDF generation
            String plantilla = "{ciudadFecha}\n\n" +
                    "Sr./Sra. {destinatarioNombre} - {destinatarioCargo}\n" +
                    "{empresaNombre}\n\n" +
                    "{cuerpo}\n\n" +
                    "{despedida}\n\n" +
                    "Atte,\n{postulanteNombre}\nDNI: {postulanteDocumento}";
            Map<String, Object> resp = new HashMap<>();
            resp.put("plantilla", plantilla);
            resp.put("datos", data);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
