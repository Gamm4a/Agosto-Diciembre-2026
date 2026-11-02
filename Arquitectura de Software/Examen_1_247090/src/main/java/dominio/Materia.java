package dominio;

public class Materia {

    private String clave;
    private String nombre;
    private int creditos;

    public Materia(String clave, String nombre, int creditos) {
        this.clave = clave;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public int getCreditos() {
        return creditos;
    }
}
