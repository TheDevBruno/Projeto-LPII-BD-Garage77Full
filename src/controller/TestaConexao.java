package controller;

import java.sql.*;

public class TestaConexao {
    public static void main(String[] args) {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            String url = "jdbc:firebirdsql://127.0.0.1:3050/C:/BANCO/BancoGarage77.FDB";
            Connection conn = DriverManager.getConnection(url, "SYSDBA", "masterkey");
            System.out.println("Conectado com sucesso!");
            conn.close();
        } catch (Exception e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
