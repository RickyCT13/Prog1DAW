package Actividades.UD7.Act72;

import Actividades.UD6.Excepciones.ElementAlreadyInListException;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        // TODO: Crea un fichero llamado alumnos.txt dentro de una nueva carpeta con nombre 1DAW,
        //  controlando que si ya existe no haga nada. La carpeta debe estar en la raíz de tu usuario.

        File alumnos = new File("src\\Actividades\\UD7\\Act72\\alumnos.txt");
        if (!alumnos.createNewFile()) {
            throw new FileAlreadyExistsException("El archivo ya existe");
        }

        // TODO: Introduce los nombres de los alumnos de la clase, una alumno por línea del fichero.
        //  Utiliza un buffer para realizar esta operación

        BufferedWriter bufWriter = new BufferedWriter(new FileWriter(alumnos));
        String[] names = {"Fulanito Gómez", "Menganito Pérez", "Manolo el cabezón malévolo"};
        for (String name : names) {
            bufWriter.write(name + "\n");
        }
        bufWriter.flush();

        // TODO: Copia (lee y escribe) el contenido del
        //  anterior fichero a uno nuevo con nombre prog.txt

        File prog = new File("src\\Actividades\\UD7\\Act72\\prog.txt");

        copyFileContent(alumnos.getPath(), prog.getPath());


        // TODO: Renombra el fichero a prog_codificado.txt

        File progEnc = new File("src\\Actividades\\UD7\\Act72\\prog-codificado.txt");
        copyFileContent(prog.getPath(), progEnc.getPath());
        prog.delete();


        // TODO: En este último fichero, añade al final un alumno nuevo

        // Añadimos el parámetro append = true
        FileWriter fileWriter = new FileWriter(progEnc.getPath(), true);
        bufWriter = new BufferedWriter(fileWriter);
        bufWriter.write("Un alumno nuevo");
        bufWriter.close();
    }

    private static void copyFileContent(String sourcePath, String destPath) throws IOException {
        BufferedWriter bufWriter;
        BufferedReader bufReader = new BufferedReader(new FileReader(sourcePath));
        bufWriter = new BufferedWriter(new FileWriter(destPath));

        String line;
        while((line = bufReader.readLine()) != null) {
            bufWriter.write(line + "\n");
        }
        bufWriter.close();
        bufReader.close();
    }
    
    // TODO: Sustituye el segundo y tercer caracter del nombre de cada alumno con una X

    // (No he sabido cómo hacer esta última parte)
}