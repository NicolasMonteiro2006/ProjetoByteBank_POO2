/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author nicol
 */
public class ContaSalario extends Conta {
     private long idContaSalario;
    private String empresaContratante;
    private double saldo;

    public long getIdContaSalario() {
        return idContaSalario;
    }

    public void setIdContaSalario(long idContaSalario) {
        this.idContaSalario = idContaSalario;
    }

    public String getEmpresaContratante() {
        return empresaContratante;
    }

    public void setEmpresaContratante(String empresaContratante) {
        this.empresaContratante = empresaContratante;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
     
    
}
