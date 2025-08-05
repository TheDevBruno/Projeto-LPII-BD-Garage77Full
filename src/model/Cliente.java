/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Cliente {
    private int codCliente;
    private String nomeCliente;
    private String CPF;
    private String sexo;
    private String idade;
    private String Logradouro;
    private String bairro;
    private String numeroCasa;
    
    public Cliente(){
        this.codCliente = 0;
        this.nomeCliente = "";
        this.CPF = "";
        this.sexo = "";
        this.idade = "";
        this.Logradouro = "";
        this.bairro = "";
        this.numeroCasa = "";
    }
    public int GetCodCliente(){
        return codCliente;
    }
    public void SetCodCliente( int codCliente){
        this.codCliente = codCliente;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public String getLogradouro() {
        return Logradouro;
    }
    public void setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    
}
