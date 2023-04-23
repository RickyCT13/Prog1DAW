package Actividades.UD6.Practica6.Ejercicio1;

import java.io.*;

public class MainEj1 {
    public static void main(String[] args) {

    }

    public void writeAFile(String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\RikyProductions\\IdeaProjects\\Prog1DAW\\src\\Actividades\\UD6\\Practica6\\Ejercicio1\\txtEj1.txt"));
        writer.write(text);
        writer.close();
    }
    public void readAFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\RikyProductions\\IdeaProjects\\Prog1DAW\\src\\Actividades\\UD6\\Practica6\\Ejercicio1\\txtEj1.txt"));
        }
        catch (IOException e) {
            System.err.println("Error: ha habido un error en la entrada/salida.");
            e.printStackTrace();
        }
    }
}
