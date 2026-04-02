package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Constantes privadas de configuração
    private static final String URL      = "jdbc:mysql://localhost:3306/loja";
    private static final String USER     = "root";
    private static final String PASSWORD = "aluno";

    // Construtor privado — impede instanciar essa classe
    private ConnectionFactory() {}

    // Abre e retorna uma conexão com o banco
    public static Connection createConnection() throws SQLException {
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco: " + e.getMessage());
            throw e;
        }
    }

    // Fecha a conexão com segurança
    public static void closeConnection(Connection conexao) {
        if (conexao != null) {
            try {
                if (!conexao.isClosed()) {
                    conexao.close();
                    System.out.println("Conexão encerrada com sucesso!");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}