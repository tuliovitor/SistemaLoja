package main;

import java.util.List;

import dao.FuncionarioDAO;
import model.Funcionario;

public class Main {

    public static void main(String[] args) {

        FuncionarioDAO dao = new FuncionarioDAO();

        // INSERT — Cadastrando os funcionários
        
        System.out.println("========================================");
        System.out.println("         CADASTRANDO FUNCIONÁRIOS       ");
        System.out.println("========================================");

        Funcionario f1 = new Funcionario("Octávio", "Marcelo", 17, 2132.12);
        Funcionario f2 = new Funcionario("Tulio", "Vítor", 17, 4332.44);
        Funcionario f3 = new Funcionario("Keven", "Cordeiro", 17, 2322.39);

        dao.inserir(f1);
        dao.inserir(f2);
        dao.inserir(f3);

        // SELECT — Listando todos os funcionários
        
        System.out.println("\n========================================");
        System.out.println("       LISTANDO TODOS OS FUNCIONÁRIOS   ");
        System.out.println("========================================");

        List<Funcionario> lista = dao.listarTodos();

        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário encontrado.");
        } else {
            for (Funcionario f : lista) {
                System.out.println(f);
            }
        }

        // UPDATE — Atualizando/Substituindo o funcionário de código 1
        
        System.out.println("\n========================================");
        System.out.println("         ATUALIZANDO FUNCIONÁRIO        ");
        System.out.println("========================================");

        Funcionario fAtualizado = new Funcionario(1, "Pedro", "Farias", 64, 2500.00);
        dao.atualizar(fAtualizado);

        // SELECT — Listando após atualização
        
        System.out.println("\n========================================");
        System.out.println("     LISTANDO APÓS ATUALIZAÇÃO          ");
        System.out.println("========================================");

        lista = dao.listarTodos();
        for (Funcionario f : lista) {
            System.out.println(f);
        }

        // DELETE — Removendo o funcionário de código/identidade 3

        System.out.println("\n========================================");
        System.out.println("         REMOVENDO FUNCIONÁRIO          ");
        System.out.println("========================================");

        dao.deletar(3);

        // SELECT final — Confirmando estado da tabela

        System.out.println("\n========================================");
        System.out.println("     LISTANDO APÓS REMOÇÃO              ");
        System.out.println("========================================");

        lista = dao.listarTodos();
        for (Funcionario f : lista) {
            System.out.println(f);
        }

        System.out.println("\n========================================");
        System.out.println("         SISTEMA ENCERRADO              ");
        System.out.println("========================================");
    }
}