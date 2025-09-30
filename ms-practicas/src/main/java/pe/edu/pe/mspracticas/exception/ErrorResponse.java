package pe.edu.pe.mspracticas.exception;

public class ErrorResponse {
    private int estado;
    private String mensaje;

    public ErrorResponse(int estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }
}
