package actividades.ud3.practica3;

public class Direccion {
    private String calle, numero, piso, poblacion, provincia;
    private int codPostal;

    public Direccion() {}

    public Direccion(String calle, String numero, String piso, String poblacion) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.poblacion = poblacion;
    }

    public Direccion(String calle, String numero, String piso, int codPostal, String poblacion, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.codPostal = codPostal;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    @Override
    public String toString() {
        return calle + ", " + numero + ", " +
                piso + ". " + codPostal + " " +
                poblacion + " (" + provincia + ")";
    }

    public void imprimirDireccion() {
        System.out.println(this);
    }

    public void imprimirDireccion(Boolean soloCalleYDireccion) {
        System.out.printf("%s %s %s, %s%n", calle, numero, piso, poblacion);
    }

}
