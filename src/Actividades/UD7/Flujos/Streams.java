package Actividades.UD7.Flujos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Streams {
    public static void main(String[] args) {
        byte CR = 13;
        byte LF = 10;
        try {
            FileOutputStream fio = new FileOutputStream("EscrituraFlujoBinario.bin");
            BufferedOutputStream buf = new BufferedOutputStream(fio);
            buf.write("H".getBytes());
            buf.write((byte)'o');
            buf.write((byte)'l');
            buf.write((byte)'a');
            buf.write(CR);
            buf.write(LF);
            buf.write((byte)'a');
            buf.write(CR);
            buf.write(LF);
            buf.close();
            fio.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
