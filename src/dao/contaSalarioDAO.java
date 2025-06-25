/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Conta;
import beans.ContaSalario;
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
public class contaSalarioDAO {
     private Connection conn;
    
    public contaSalarioDAO() {
        this.conn = Conexao.getConexao();
    }
    
    public void inserirContaSalario(String nome, String senha, String empresaContratante) throws Exception {
    long idUsuario = -1;

    
    String sqlBusca = "SELECT id_usuario FROM usuario WHERE nome = ? AND senha_hash = md5(?)";

    try (PreparedStatement stmtBusca = this.conn.prepareStatement(sqlBusca)) {
        stmtBusca.setString(1, nome);
        stmtBusca.setString(2, senha);
        ResultSet rs = stmtBusca.executeQuery();

        if (rs.next()) {
            idUsuario = rs.getLong("id_usuario");
        } else {
            throw new Exception("Usuário não encontrado.");
        }

    } catch (Exception e) {
        throw new Exception("Erro ao buscar ID do usuário: " + e.getMessage());
    }

    
    String sqlInsert = "INSERT INTO conta_salario (id_usuario, empresa_contratante, saldo) VALUES (?, ?, ?)";
    try (PreparedStatement stmtInsert = this.conn.prepareStatement(sqlInsert)) {
        stmtInsert.setLong(1, idUsuario);
        stmtInsert.setString(2, empresaContratante);
        stmtInsert.setDouble(3, 0.0); 
        stmtInsert.execute();
    } catch (Exception e) {
        throw new Exception("Erro ao inserir conta salário: " + e.getMessage());
    }
    

    
}
    
      public void inserirContaSalario(int idUsuario, String empresaContratante) throws Exception {
    String sql = "INSERT INTO conta_salario (id_usuario, empresa_contratante, saldo) VALUES (?, ?, 0.0)";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idUsuario);
        stmt.setString(2, empresaContratante);
        stmt.execute();
    } catch (Exception e) {
        throw new Exception("Erro ao inserir conta salário: " + e.getMessage());
    }
}
      
      public boolean verificarContaSalarioPorId(int idUsuario) throws Exception {
    String sql = "SELECT 1 FROM conta_salario WHERE id_usuario = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
}
      
     public ContaSalario obterInformacoesContaSalario(int idUsuario) throws Exception {
    String sql = "SELECT u.nome, cs.saldo, cs.empresa_contratante " +
                 "FROM conta_salario cs " +
                 "JOIN usuario u ON cs.id_usuario = u.id_usuario " +
                 "WHERE cs.id_usuario = ?";

    try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            ContaSalario conta = new ContaSalario();
            conta.setId(idUsuario); 
            conta.setNome(rs.getString("nome")); 
            conta.setSaldo(rs.getDouble("saldo"));
            conta.setEmpresaContratante(rs.getString("empresa_contratante"));
            return conta;
        } else {
            return null; 
        }

    } catch (Exception e) {
        throw new Exception("Erro ao obter informações da conta salário: " + e.getMessage());
    }
}
     
    public List<ContaSalario> listarUsuariosContaSalario() throws Exception {
    List<ContaSalario> lista = new ArrayList<>();
    String sql = "SELECT u.id_usuario, u.nome, cs.empresa_contratante " +
                 "FROM usuario u " +
                 "JOIN conta_salario cs ON u.id_usuario = cs.id_usuario";

    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            ContaSalario cs = new ContaSalario();
            cs.setId(rs.getInt("id_usuario"));
            cs.setNome(rs.getString("nome"));
            cs.setEmpresaContratante(rs.getString("empresa_contratante"));
            lista.add(cs);
        }
    } catch (Exception e) {
        throw new Exception("Erro ao listar usuários com conta salário: " + e.getMessage());
    }

    return lista;
}
        public void realizarPagamentoSalario(String empresa, int idUsuario, double valor) throws Exception {
    String sqlInsert = "INSERT INTO pagamento_salario (empresa, id_usuario, valor) VALUES (?, ?, ?)";
    try (PreparedStatement stmt = conn.prepareStatement(sqlInsert)) {
        stmt.setString(1, empresa);
        stmt.setInt(2, idUsuario);
        stmt.setDouble(3, valor);
        stmt.execute();
    } catch (Exception e) {
        throw new Exception("Erro ao registrar o pagamento de salário: " + e.getMessage());
    }

    String sqlUpdate = "UPDATE conta_salario SET saldo = saldo + ? WHERE id_usuario = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sqlUpdate)) {
        stmt.setDouble(1, valor);
        stmt.setInt(2, idUsuario);
        int linhasAfetadas = stmt.executeUpdate();
        if (linhasAfetadas == 0) {
            throw new Exception("Conta salário não encontrada para o usuário informado.");
        }
    } catch (Exception e) {
        throw new Exception("Erro ao atualizar saldo da conta salário: " + e.getMessage());
    }
}

 public double buscarSaldoPorIdUsuarioSalario(int idUsuario) throws Exception {
    String sql = "SELECT saldo FROM conta_salario WHERE id_usuario = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("saldo");
        } else {
            throw new Exception("Conta corrente não encontrada para o usuário.");
        }
    }
}





}