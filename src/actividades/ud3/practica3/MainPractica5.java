package actividades.ud3.practica3;

public class MainPractica5 {
    public static void main(String[] args) {
        Direccion direccion = new Direccion("Avenida de la Feria", "34", "2ºB", 11650, "Villamartín", "Cádiz");
        Alumno alumno = new Alumno("Fulanito", "Pérez", "Rodríguez", 19);
        Casa casa = new Casa(12500.85, 'A', "1234567 AB1234A 0000 AB");

        casa.setDireccion(direccion);
        alumno.setDireccion(direccion);

        Alumno
                alumno1 = new Alumno("Javier",
                "Silva",
                "Carrero",
                19,
                false,
                8.22,
                "javiscar11@gmail.com",
                new Direccion("Calle Salineras",
                        "22",
                        "Bajo A",
                        11650,
                        "Villamartín",
                        "Cádiz")),
                alumno2 = new Alumno("José",
                        "Ortega",
                        "Silva",
                        20,
                        true,
                        7.54,
                        "Jortesil22@gmail.com",
                        new Direccion("Avenida de la feria",
                                "34",
                                "5ºA",
                                11650,
                                "Villamartín",
                                "Cádiz"));
        System.out.println(Alumno.mayorMedia(alumno1, alumno2));
    }
}
