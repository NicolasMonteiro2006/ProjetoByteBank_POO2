/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Conta;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class contaDAO {
    private Connection conn;
    
    public contaDAO() {
        this.conn = Conexao.getConexao();
    }
    
    public void inserir (Conta conta) throws Exception {
        String sql = "INSERT INTO usuario (nome, senha_hash, cpf, email, idade) VALUES (?, md5(?), ?, ?, ?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, conta.getNome());
            stmt.setString(2, conta.getSenha());
            stmt.setString(3, conta.getCpf());
            stmt.setString(4, conta.getEmail());
            stmt.setInt(5, conta.getIdade());
            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao criar a conta: " + e.getMessage());
        }
    }
    
    public Conta login (Conta conta) throws Exception {
        String sql = "SELECT id_usuario FROM usuario WHERE nome = ? and senha_hash = md5(?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, conta.getNome());
            stmt.setString(2, conta.getSenha());
            ResultSet rs = stmt.executeQuery();
            rs.first();
            
            Conta c = new Conta();
            c.setId(rs.getInt("id_usuario"));
            
            return c;          
        } catch (Exception e) {
            throw new Exception("Nenhuma Conta encontrada");
        }
        
    }
    
    public boolean existeUsuario(String nome) throws Exception {
        
    String sql = "SELECT id_usuario FROM usuario WHERE nome = ?";
    
    try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); 
    } catch (Exception e) {
        throw new Exception("Erro ao verificar existência do usuário: " + e.getMessage());
    }
}
    
    public int buscarIdPorNome(String nome) throws Exception {
    String sql = "SELECT id_usuario FROM usuario WHERE nome = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_usuario");
        } else {
            throw new Exception("Usuário destinatário não encontrado.");
        }
    }
}

    public void debitarSaldo(int idUsuario, double valor) throws Exception {
    String sql = "UPDATE conta_corrente SET saldo = saldo - ? WHERE id_usuario = ? AND saldo >= ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setDouble(1, valor);
        stmt.setInt(2, idUsuario);
        stmt.setDouble(3, valor); 
        int rows = stmt.executeUpdate();
        if (rows == 0) {
            throw new Exception("Saldo insuficiente ou conta não encontrada.");
        }
    } catch (Exception e) {
        throw new Exception("Erro ao debitar saldo: " + e.getMessage());
    }
}

    
    public boolean verificarSenha(int idUsuario, String senha) throws Exception {
    String sql = "SELECT * FROM usuario WHERE id_usuario = ? AND senha_hash = md5(?)";

    try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
        stmt.setInt(1, idUsuario);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();

        return rs.next();
    } catch (Exception e) {
        throw new Exception("Erro ao verificar senha: " + e.getMessage());
    }
}
    
    public boolean usuarioExiste(String nome, String cpf) throws Exception {
    String sql = "SELECT * FROM usuario WHERE nome = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); 
    } catch (Exception e) {
        throw new Exception("Erro ao verificar existência do usuário: " + e.getMessage());
    }
}
    public List<Conta> listarUsuarios() throws Exception {
        List<Conta> lista = new ArrayList<>();
        String sql = "SELECT id_usuario, nome FROM usuario";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Conta c = new Conta();
                c.setId(rs.getInt("id_usuario"));
                c.setNome(rs.getString("nome"));
                lista.add(c);
            }
        } catch (Exception e) {
            throw new Exception("Erro ao listar usuários: " + e.getMessage());
        }

        return lista;
    }






}
