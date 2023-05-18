package Actividades.UD8.ActsDiapositivas.Ej10;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3310/tienda", "root", "root");
            Statement stmt = con.createStatement();

            String deleteAllProducts = "DELETE FROM tienda.productos;";

            String addThreeProducts = "INSERT INTO tienda.productos VALUES (NULL, 'manzana', 'Manzanas Golden', 0.50, 'Francia'), (NULL, 'pera', 'Peras conferencia', 0.25, 'España'), (NULL, 'uva', 'Uvas Gourmet', 0.30, 'España');";

            String lowerPearPrice = "UPDATE tienda.productos SET precio = 0.20 WHERE nombre = 'pera';";

            con.setAutoCommit(false);

            stmt.addBatch(deleteAllProducts);
            stmt.addBatch(addThreeProducts);
            stmt.addBatch(lowerPearPrice);

            int[] affectedRows = stmt.executeBatch();

            System.out.println(affectedRows);

            con.commit();

            stmt.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
