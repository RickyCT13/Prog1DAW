package Actividades.UD8.ActsDiapositivas.Ej9;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3310/tienda", "root", "root");
            Statement st = con.createStatement();
            ResultSet rSet = st.executeQuery("SELECT * FROM productos ORDER BY precio DESC");
            while (rSet.next()) {
                System.out.println("Nombre: " + rSet.getString("nombre"));
                System.out.println("Precio: " + rSet.getBigDecimal("precio"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
