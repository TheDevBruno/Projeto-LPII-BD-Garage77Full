/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Vaga {
    private int codVaga;
    private String nomeVaga;
    private String tipoVaga;
    private float largura;
    private float comprimento;
    private String cobertura;
    private double valor;
    
    public Vaga(){
        this.codVaga = 0;
        this.tipoVaga = "";
        this.nomeVaga = "";
        this.comprimento = 0;
        this.largura = 0;
        this.cobertura = "";
        this.valor = 0;
    }


    public int getCodigoVaga(){
        return codVaga;
    }
    public void setCodigoVaga ( int codigoVaga){
        this.codVaga = codigoVaga;
    }
    
    public String getTipoVaga(){
        return tipoVaga;
    }
    public void setTipoVaga( String tipoVaga){
        this.tipoVaga = tipoVaga;
    }
    
    public String getNomeVaga() {
        return nomeVaga;
    }
    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getComprimento() {
        return comprimento;
    }
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
