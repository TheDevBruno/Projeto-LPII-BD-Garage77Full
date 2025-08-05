/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private String anoFabricacao;
    private String anoModelo;
    private Cliente proprietario;

    public Veiculo() {
    this.marca = "";
    this.modelo = "";
    this.placa = "";
    this.anoFabricacao = "";
    this.anoModelo = "";
    this.proprietario = new Cliente();
    
}

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getAnoModelo() {
        return anoModelo;
    }
    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }
    
    public Cliente getPropietario (){
        return proprietario;
    }
    public void setProprietario (Cliente proprietario){
        this.proprietario = proprietario;
    }
    
}
