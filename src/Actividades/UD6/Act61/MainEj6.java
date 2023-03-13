package Actividades.UD6.Act61;

public class MainEj6 {
    public static void main(String[] args) {
        String myStr = "Hola, Mundo";
        try {
            System.out.println(characterAt(myStr, -1));
        } catch (InvalidIndexException iie) {
            System.err.println(iie.getMessage());
            iie.printStackTrace();
        } finally {
            System.out.println("Adios mundo.");
        }
    }
    public static int characterAt(String str, int index) throws InvalidIndexException {
        if (index < 0 || index >= str.length()) {
            throw new InvalidIndexException("Este índice es inválido (Índice: " + index + ", longitud de la cadena: " + str.length() + ").");
        }
        return str.charAt(index);
    }
}

