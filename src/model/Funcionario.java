package model;

public class Funcionario {

    // Atributos privados — espelham as colunas da tabela
    private int codigo;
    private String nome;
    private String sobrenome;
    private int idade;
    private double salario;

    // Construtor vazio — necessário para instanciar sem dados
    public Funcionario() {}

    // Construtor completo — usado ao recuperar dados do banco
    public Funcionario(int codigo, String nome, String sobrenome,
                       int idade, double salario) {
        this.codigo   = codigo;
        this.nome     = nome;
        this.sobrenome = sobrenome;
        this.idade    = idade;
        this.salario  = salario;
    }

    // Construtor sem codigo — usado ao inserir novo registro
    
    // (o banco gera o codigo automaticamente via AUTO_INCREMENT)
    public Funcionario(String nome, String sobrenome,
                       int idade, double salario) {
        this.nome      = nome;
        this.sobrenome = sobrenome;
        this.idade     = idade;
        this.salario   = salario;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // toString — facilita a exibir os dados do objeto no console
    @Override
    public String toString() {
        return "Funcionario {" +
               "\n  codigo    = " + codigo +
               "\n  nome      = " + nome +
               "\n  sobrenome = " + sobrenome +
               "\n  idade     = " + idade +
               "\n  salario   = R$ " + String.format("%.2f", salario) +
               "\n}";
    }
}