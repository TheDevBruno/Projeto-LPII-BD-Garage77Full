/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String CPF;
    private String sexo;
    private String idade;
    private String cargo;
    private String salario;
    private String descricaoFuncionario;
    private String login;
    private String senha;
    
    public Funcionario(){
        this.idFuncionario = 0;
        this.nome = "";
        this.CPF = "";
        this.sexo = "";
        this.idade = "";
        this.cargo = "";
        this.salario = "";
        this.idade = "";
        this.descricaoFuncionario = "";
        this.login = "";
        this.senha = "";
    }

    /**
     * @return the nome
     */
    
    public int getIdFuncionario (){
        return idFuncionario;
    }
    public void setIdFuncionario ( int idFuncionario){
        this.idFuncionario = idFuncionario;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDescricaoFuncionario() {
        return descricaoFuncionario;
    }
    public void setDescricaoFuncionario(String descricaoFuncionario) {
        this.descricaoFuncionario = descricaoFuncionario;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
