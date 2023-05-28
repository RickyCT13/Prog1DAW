package actividades.ud7.act73;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /* Creamos y serializamos nuestra persona famosa. */
        Persona personaFamosa = new PersonaFamosa("Miguel de Cervantes Saavedra",
                68,
                new Persona("Rodrigo de Cervantes"),
                new Direccion("Alcalá de Henares"),
                false);

        try (FileOutputStream fos = new FileOutputStream("src\\Actividades\\UD7\\Act73\\persona_famosa.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(personaFamosa);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        /* Para adivinar la persona, simplemente tenemos que deserializarla. */
        FileInputStream fis = new FileInputStream("src\\Actividades\\UD7\\Act73\\persona_famosa.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Persona personaFamosaParseada = (Persona) ois.readObject();
        System.out.println(personaFamosaParseada.getNombre());
    }
}
