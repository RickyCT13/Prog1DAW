package actividades.ud8.actsDiapositivas.ej11;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3310/tienda", "root", "root");
            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery("SELECT * FROM productos;");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
