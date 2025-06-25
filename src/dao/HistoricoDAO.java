/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.HistoricoTransacao;
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
public class HistoricoDAO {
      private Connection conn;
      
      public HistoricoDAO() {
        this.conn = Conexao.getConexao();
    }
      
      public void registrarTransacao(int pagante, int recebedor, String tipo, double valor) throws Exception {
        String sql = "INSERT INTO historico_transacoes (id_usuario_pagante, id_usuario_recebedor, tipo, valor) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pagante);
            stmt.setInt(2, recebedor);
            stmt.setString(3, tipo);
            stmt.setDouble(4, valor);
            stmt.execute();
        }catch (Exception e) {
        throw new Exception("Erro ao registrar a Transação: " + e.getMessage());
    }
    }
      
      public List<HistoricoTransacao> listarTransacoes() throws Exception {
        List<HistoricoTransacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM historico_transacoes";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                HistoricoTransacao ht = new HistoricoTransacao();
                ht.setId(rs.getInt("id_transacao"));
                ht.setIdPagante(rs.getInt("id_usuario_pagante"));
                ht.setIdRecebedor(rs.getInt("id_usuario_recebedor"));
                ht.setTipo(rs.getString("tipo"));
                ht.setValor(rs.getDouble("valor"));
                ht.setDataTransacao(rs.getTimestamp("data_transacao"));
                lista.add(ht);
            }
        }
        return lista;
    }
      
      public List<HistoricoTransacao> listarTransacoesPorTipo(String tipo) throws Exception {
    List<HistoricoTransacao> lista = new ArrayList<>();

    String sql = """
        SELECT 
            u1.nome AS nome_pagante,
            u2.nome AS nome_recebedor,
            ht.tipo,
            ht.valor,
            ht.data_transacao
        FROM historico_transacoes ht
        JOIN usuario u1 ON ht.id_usuario_pagante = u1.id_usuario
        LEFT JOIN usuario u2 ON ht.id_usuario_recebedor = u2.id_usuario
        WHERE ht.tipo = ?
        """;

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, tipo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            HistoricoTransacao ht = new HistoricoTransacao();
            ht.setNomePagante(rs.getString("nome_pagante"));
            ht.setNomeRecebedor(rs.getString("nome_recebedor"));
            ht.setTipo(rs.getString("tipo"));
            ht.setValor(rs.getDouble("valor"));
            ht.setDataTransacao(rs.getTimestamp("data_transacao"));
            lista.add(ht);
        }
    } catch (Exception e) {
        throw new Exception("Erro ao listar transações por tipo: " + e.getMessage());
    }

    return lista;
}
      
      



}
