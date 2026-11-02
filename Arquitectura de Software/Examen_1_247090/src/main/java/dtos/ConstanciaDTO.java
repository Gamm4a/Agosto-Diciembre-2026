package dtos;

public class ConstanciaDTO {

    private String folio;
    private String fechaEmision;
    private String texto;

    public ConstanciaDTO(String folio, String fechaEmision, String texto) {
        this.folio = folio;
        this.fechaEmision = fechaEmision;
        this.texto = texto;
    }

    public String getFolio() {
        return folio;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public String getTexto() {
        return texto;
    }
}
