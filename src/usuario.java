/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vicente
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class usuario {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.cj.jdbc.Driver";
        String sURL = "jdbc:mysql://localhost:3306/base";

        try {
            Class.forName(sDriver).newInstance();
            con = DriverManager.getConnection(sURL, "root", "root");
         
            // cambiar id no se puede  repetir
            String idusuarios = "14";
            String nombre = "angel";
            String correo = "bladimir123@gmail.com";
            String telefono = "123pao";

            stmt = con.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?)");
            stmt.setString(1, idusuarios);
            stmt.setString(2, nombre);
            stmt.setString(3, correo);
            stmt.setString(4, telefono);

            int retorno = stmt.executeUpdate();
            if (retorno > 0) {
                System.out.println("Insertado correctamente");
            }

        } catch (SQLException sqle) {
            System.out.println("SQLState: "
                    + sqle.getSQLState());
            System.out.println("SQLErrorCode: "
                    + sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    stmt.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
