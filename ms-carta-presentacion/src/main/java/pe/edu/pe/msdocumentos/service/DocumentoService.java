package pe.edu.pe.msdocumentos.service;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

  @Service
  public class DocumentoService {
  
      public byte[] generarCartaPresentacionDocx(CartaData data) throws IOException {
        try (XWPFDocument doc = new XWPFDocument(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            // Titulo
            XWPFParagraph titulo = doc.createParagraph();
            titulo.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun rt = titulo.createRun();
            rt.setFontSize(14);
            rt.setText("Carta de Presentación");

            // Fecha/Ciudad
            XWPFParagraph pFecha = doc.createParagraph();
            pFecha.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun rf = pFecha.createRun();
            rf.setText(nonNullOr(data.ciudadFecha, LocalDate.now().toString()));

            // Destinatario
            addEmptyLine(doc);
            XWPFParagraph pDest = doc.createParagraph();
            XWPFRun rDest = pDest.createRun();
            rDest.setBold(true);
            rDest.setText(nonNullOr(data.destinatarioNombre, "Nombre destinatario"));
            newLine(rDest);
            rDest.setBold(false);
            rDest.setText(nonNullOr(data.destinatarioCargo, "Cargo"));
            newLine(rDest);
            rDest.setText(nonNullOr(data.empresaNombre, "Empresa"));
            newLine(rDest);
            rDest.setText("Presente.-");

            // Cuerpo
            addEmptyLine(doc);
            XWPFParagraph pCuerpo = doc.createParagraph();
            pCuerpo.setAlignment(ParagraphAlignment.BOTH);
            XWPFRun rCuerpo = pCuerpo.createRun();
            rCuerpo.setText(nonNullOr(data.cuerpo, "[Contenido de la carta]"));

            // Despedida
            addEmptyLine(doc);
            XWPFParagraph pDesp = doc.createParagraph();
            XWPFRun rDesp = pDesp.createRun();
            rDesp.setText(nonNullOr(data.despedida, "Atentamente,"));

            // Firma
            addEmptyLine(doc);
            XWPFParagraph pFirma = doc.createParagraph();
            XWPFRun rFirma = pFirma.createRun();
            rFirma.setBold(true);
            rFirma.setText(nonNullOr(data.postulanteNombre, "Nombre del postulante"));
            newLine(rFirma);
            rFirma.setBold(false);
            rFirma.setText("DNI: " + nonNullOr(data.postulanteDocumento, "00000000"));

            // Pie: correlativo opcional
            if (data.correlativoCarta != null && !data.correlativoCarta.isBlank()) {
                addEmptyLine(doc);
                XWPFParagraph pCorr = doc.createParagraph();
                pCorr.setAlignment(ParagraphAlignment.LEFT);
                XWPFRun rCorr = pCorr.createRun();
                rCorr.setItalic(true);
                rCorr.setFontSize(9);
                rCorr.setText("Carta N° " + data.correlativoCarta);
            }

            doc.write(out);
            return out.toByteArray();
        }
    }

    private static void addEmptyLine(XWPFDocument doc) {
        XWPFParagraph p = doc.createParagraph();
        XWPFRun r = p.createRun();
        r.setText(" ");
    }

    private static void newLine(XWPFRun run) {
        run.addBreak();
    }

    private static String nonNullOr(String value, String def) {
        return (value == null || value.isBlank()) ? def : value;
    }

    public static class CartaData {
        public String ciudadFecha;
        public String destinatarioNombre;
        public String destinatarioCargo;
        public String empresaNombre;
        public String cuerpo;
        public String despedida;
        public String postulanteNombre;
        public String postulanteDocumento;
        public String correlativoCarta; 
    }
}
