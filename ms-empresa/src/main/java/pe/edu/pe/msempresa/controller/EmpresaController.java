package pe.edu.pe.msempresa.controller;

import jakarta.validation.Valid;
import pe.edu.pe.msempresa.domain.Empresa;
import pe.edu.pe.msempresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> readAll() {
        try {
            List<Empresa> empresas = empresaService.readAll();
            if (empresas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(empresas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Empresa empresa) {
        try {
            Empresa empresaCreated = empresaService.create(empresa);
            return new ResponseEntity<>(empresaCreated, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable("id") Long id) {
        try {
            Empresa empresa = empresaService.read(id).get();
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> delete(@PathVariable("id") Long id) {
        try {
            empresaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Empresa empresa) {
        try {
            Optional<Empresa> empresaOptional = empresaService.read(id);
            if (empresaOptional.isPresent()) {
                empresa.setIdEmpresa(id);
                return new ResponseEntity<>(empresaService.update(empresa), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/activas")
    public ResponseEntity<List<Empresa>> readAllActivas() {
        List<Empresa> empresas = empresaService.readAllActivas();
        return empresas.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Empresa>> search(
            @RequestParam("nombre") String nombre,
            @RequestParam(value = "estado", required = false) String estado) {
        try {
            List<Empresa> empresas = (estado == null || estado.isBlank())
                    ? empresaService.searchByNombre(nombre)
                    : empresaService.searchByNombreAndEstado(nombre, estado);
            return empresas.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                    : new ResponseEntity<>(empresas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}