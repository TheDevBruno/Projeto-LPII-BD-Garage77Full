package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:firebirdsql://127.0.0.1:3050/C:/BANCO/BancoGarage77.FDB";
    private static final String USUARIO = "SYSDBA";
    private static final String SENHA = "masterkey";

    public static Connection conectar() {   
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("conexao no banco de dados estabelecida com sucesso!");
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

}
