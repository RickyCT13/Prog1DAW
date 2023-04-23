package Actividades.UD7.Serializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        Persona personaSerializada = new Persona("James Gosling", 67);

        FileOutputStream fos = new FileOutputStream("C:\\Users\\1DAW_2223_11\\IdeaProjects\\Prog 1DAW\\src\\Actividades\\UD7\\Serializacion\\persona.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(personaSerializada);

        oos.close();
    }
}
