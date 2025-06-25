/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import beans.Investimento;
import java.util.ArrayList;
import java.util.List;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author nicol
 */
public class InvestimentoDAO {
    private Connection conn;
    
    public InvestimentoDAO() {
        this.conn = Conexao.getConexao();
    }
    
    public void inserirInvestimento(Investimento inv) throws Exception {
        String sql = "INSERT INTO investimentos (id_usuario, tipo, valor, data_inicio, duracao_dias, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, inv.getIdUsuario());
            stmt.setString(2, inv.getTipo());
            stmt.setDouble(3, inv.getValor());
            stmt.setDate(4, new java.sql.Date(inv.getDataInicio().getTime()));
            stmt.setInt(5, inv.getDuracaoDias());
            stmt.setString(6, inv.getStatus());
            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao inserir investimento: " + e.getMessage());
        }
    }

    public List<Investimento> listarInvestimentosPorUsuario(int idUsuario) throws Exception {
    List<Investimento> lista = new ArrayList<>();
    String sql = "SELECT * FROM investimentos WHERE id_usuario = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Investimento inv = new Investimento();
            inv.setId(rs.getInt("id_investimento"));
            inv.setIdUsuario(rs.getInt("id_usuario"));
            inv.setTipo(rs.getString("tipo"));
            inv.setValor(rs.getDouble("valor"));
            inv.setDataInicio(rs.getDate("data_inicio"));
            inv.setDuracaoDias(rs.getInt("duracao_dias"));
            inv.setStatus(rs.getString("status"));
            lista.add(inv);
        }
    } catch (Exception e) {
        e.printStackTrace(); 
        throw new Exception("Erro ao listar investimentos: " + e.getMessage());
    }

    return lista;
}


    public void atualizarStatusInvestimento(int idInvestimento, String novoStatus) throws Exception {
        String sql = "UPDATE investimentos SET status = ? WHERE id_investimento = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus);
            stmt.setInt(2, idInvestimento);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar status: " + e.getMessage());
        }
    }
    
    public void removerInvestimento(int idInvestimento) throws Exception {
    String sql = "DELETE FROM investimentos WHERE id_investimento = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idInvestimento);
        stmt.execute();
    } catch (Exception e) {
        throw new Exception("Erro ao remover investimento: " + e.getMessage());
    }
}

    
    

}
