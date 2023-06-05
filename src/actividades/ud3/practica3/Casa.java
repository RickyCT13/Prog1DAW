package actividades.ud3.practica3;

public class Casa {
    private Double precio;
    private Character califEnergetica;
    private String refCatastral;
    private Integer
            iva = 21,
            ivaReducido = 16;

    private Direccion direccion;

    public Casa () {}

    public Casa(Double precio, Character califEnergetica, String refCatastral) {
        this.precio = precio;
        this.califEnergetica = califEnergetica;
        this.refCatastral = refCatastral;
    }

    public Casa(Double precio,
                Character califEnergetica,
                String refCatastral,
                Integer iva,
                Integer ivaReducido,
                Direccion direccion) {
        this.precio = precio;
        this.califEnergetica = califEnergetica;
        this.refCatastral = refCatastral;
        this.direccion = direccion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Character getCalifEnergetica() {
        return califEnergetica;
    }

    public void setCalifEnergetica(Character califEnergetica) {
        this.califEnergetica = califEnergetica;
    }

    public String getRefCatastral() {
        return refCatastral;
    }

    public void setRefCatastral(String refCatastral) {
        this.refCatastral = refCatastral;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Integer getIvaReducido() {
        return ivaReducido;
    }

    public void setIvaReducido(Integer ivaReducido) {
        this.ivaReducido = ivaReducido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Double calcularPrecioIva() {
        return precio * (iva / 100);
    }
    public Double calcularPrecioIvaReducido() {
        return precio * (ivaReducido / 100);
    }
    void imprimirDatos() {
        System.out.println("Referencia catastral: " + refCatastral + "\n" +
                "Precio sin IVA: " + precio + "\n" +
                "Precio con IVA: " + calcularPrecioIva() + "\n" +
                "Precio con IVA reducido: " + calcularPrecioIvaReducido() + "\n"
                );
    }
}
