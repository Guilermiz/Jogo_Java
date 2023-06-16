/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author gfsan
 */
public class Conexao {
    
    private static String host = "jdbc:mysql://localhost/faculdade";
    private static String user = "root";
    private static String password = "";
    private static Connection con = null;
    
    public static Connection getConexao() {
        try {
            con = DriverManager.getConnection(host, user, password);
        } catch (SQLException error) {
            System.out.println("Erro na conexao: " + error.getMessage());
        }
        return con;
    }
}
