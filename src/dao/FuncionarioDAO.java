package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Funcionario;

public class FuncionarioDAO {

    // -------------------------------------------------------
    // INSERT — Cadastrar novo funcionário
    // -------------------------------------------------------
    public void inserir(Funcionario funcionario) {
        Connection conexao       = null;
        PreparedStatement ps     = null;

        String sql = "INSERT INTO funcionario " +
                     "(nome, sobrenome, idade, salario) " +
                     "VALUES (?, ?, ?, ?)";
        try {
            conexao = ConnectionFactory.createConnection();
            conexao.setAutoCommit(false);

            ps = conexao.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getSobrenome());
            ps.setInt   (3, funcionario.getIdade());
            ps.setDouble(4, funcionario.getSalario());

            int retorno = ps.executeUpdate();

            conexao.commit();

            if (retorno > 0) {
                System.out.println("Funcionário inserido com sucesso!");
            } else {
                System.out.println("Nenhum registro inserido.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
            try {
                if (conexao != null) {
                    conexao.rollback();
                    System.out.println("Rollback efetuado.");
                }
            } catch (SQLException e2) {
                System.out.println("Erro no rollback: " + e2.getMessage());
            }
        } finally {
            fecharRecursos(conexao, ps, null);
        }
    }

    // SELECT — Listar todos os funcionários
    
    public List<Funcionario> listarTodos() {
        Connection conexao       = null;
        PreparedStatement ps     = null;
        ResultSet rs             = null;
        List<Funcionario> lista  = new ArrayList<>();

        String sql = "SELECT codigo, nome, sobrenome, idade, salario " +
                     "FROM funcionario";
        try {
            conexao = ConnectionFactory.createConnection();
            ps      = conexao.prepareStatement(sql);
            rs      = ps.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario(
                    rs.getInt   ("codigo"),
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getInt   ("idade"),
                    rs.getDouble("salario")
                );
                lista.add(f);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        } finally {
            fecharRecursos(conexao, ps, rs);
        }

        return lista;
    }

    // UPDATE — Atualizar dados do funcionário

    public void atualizar(Funcionario funcionario) {
        Connection conexao   = null;
        PreparedStatement ps = null;

        String sql = "UPDATE funcionario " +
                     "SET nome=?, sobrenome=?, idade=?, salario=? " +
                     "WHERE codigo=?";
        try {
            conexao = ConnectionFactory.createConnection();
            conexao.setAutoCommit(false);

            ps = conexao.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getSobrenome());
            ps.setInt   (3, funcionario.getIdade());
            ps.setDouble(4, funcionario.getSalario());
            ps.setInt   (5, funcionario.getCodigo());

            int retorno = ps.executeUpdate();

            conexao.commit();

            if (retorno > 0) {
                System.out.println("Funcionário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado para atualizar.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
            try {
                if (conexao != null) {
                    conexao.rollback();
                    System.out.println("Rollback efetuado.");
                }
            } catch (SQLException e2) {
                System.out.println("Erro no rollback: " + e2.getMessage());
            }
        } finally {
            fecharRecursos(conexao, ps, null);
        }
    }

    // DELETE — Remover funcionário por código

    public void deletar(int codigo) {
        Connection conexao   = null;
        PreparedStatement ps = null;

        String sql = "DELETE FROM funcionario WHERE codigo=?";

        try {
            conexao = ConnectionFactory.createConnection();
            conexao.setAutoCommit(false);

            ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);

            int retorno = ps.executeUpdate();

            conexao.commit();

            if (retorno > 0) {
                System.out.println("Funcionário deletado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado para deletar.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionário: " + e.getMessage());
            try {
                if (conexao != null) {
                    conexao.rollback();
                    System.out.println("Rollback efetuado.");
                }
            } catch (SQLException e2) {
                System.out.println("Erro no rollback: " + e2.getMessage());
            }
        } finally {
            fecharRecursos(conexao, ps, null);
        }
    }

    // Método privado auxiliar — vai fechar todos os recursos
    
    private void fecharRecursos(Connection conexao,
                                PreparedStatement ps,
                                ResultSet rs) {
        try {
            if (rs      != null) rs.close();
            if (ps      != null) ps.close();
            if (conexao != null) ConnectionFactory.closeConnection(conexao);
        } catch (SQLException e) {
            System.out.println("Erro ao fechar recursos: " + e.getMessage());
        }
    }
}