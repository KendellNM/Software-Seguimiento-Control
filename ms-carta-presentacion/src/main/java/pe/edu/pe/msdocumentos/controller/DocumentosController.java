package pe.edu.pe.msdocumentos.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.msdocumentos.service.DocumentoService;
import pe.edu.pe.msdocumentos.service.DocumentoService.CartaData;

@RestController
@RequestMapping("/documentos")
@CrossOrigin("*")
public class DocumentosController {

    private final DocumentoService documentoService;

    public DocumentosController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping(value = "/carta-presentacion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> generarCartaPresentacion(@RequestBody CartaData data) {
        try {
            byte[] bytes = documentoService.generarCartaPresentacionDocx(data);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"));
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"carta-presentacion.docx\"");
            return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
