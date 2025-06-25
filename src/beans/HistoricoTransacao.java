/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;
import java.sql.Timestamp;


/**
 *
 * @author nicol
 */
public class HistoricoTransacao {
    private int id;
    private int idPagante;
    private int idRecebedor;
    private String tipo;
    private double valor;
    private Timestamp dataTransacao;
    private String nomePagante;
    private String nomeRecebedor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPagante() {
        return idPagante;
    }

    public void setIdPagante(int idPagante) {
        this.idPagante = idPagante;
    }

    public int getIdRecebedor() {
        return idRecebedor;
    }

    public void setIdRecebedor(int idRecebedor) {
        this.idRecebedor = idRecebedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Timestamp getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Timestamp dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
    
    public String getNomePagante() {
    return nomePagante;
    }
    
    public void setNomePagante(String nomePagante) {
    this.nomePagante = nomePagante;
    }

    public String getNomeRecebedor() {
    return nomeRecebedor;
    }
    
    public void setNomeRecebedor(String nomeRecebedor) {
    this.nomeRecebedor = nomeRecebedor;
    }
    
    
    
}
