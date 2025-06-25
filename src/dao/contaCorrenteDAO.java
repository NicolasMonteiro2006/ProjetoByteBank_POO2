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
/**
 *
 * @author nicol
 */
public class contaCorrenteDAO {
     private Connection conn;
    
    public contaCorrenteDAO() {
        this.conn = Conexao.getConexao();
    }
    
    public void inserirContaCorrente(String nome, String senha) throws Exception {
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

    String sqlInsert = "INSERT INTO conta_corrente (id_usuario, saldo) VALUES (?, 0.0)";
    try (PreparedStatement stmtInsert = this.conn.prepareStatement(sqlInsert)) {
        stmtInsert.setLong(1, idUsuario);
        stmtInsert.execute();
    } catch (Exception e) {
        throw new Exception("Erro ao inserir conta corrente: " + e.getMessage());
    }
}
    
    public Conta obterInformacoesContaCorrente(int idUsuario) throws Exception {
        String sql = "SELECT u.nome, c.saldo " +
                     "FROM usuario u " +
                     "JOIN conta_corrente c ON u.id_usuario = c.id_usuario " +
                     "WHERE u.id_usuario = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Conta conta = new Conta();
                conta.setNome(rs.getString("nome"));
                conta.setSaldo(rs.getDouble("saldo"));
                return conta;
            } else {
                throw new Exception("Conta não encontrada.");
            }

        } catch (Exception e) {
            throw new Exception("Erro ao buscar conta: " + e.getMessage());
        }
    }
    
   public double buscarSaldoPorIdUsuario(int idUsuario) throws Exception {
    String sql = "SELECT saldo FROM conta_corrente WHERE id_usuario = ?";
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
   
   public void depositar(int idUsuario, double valor) throws Exception {
    String sql = "UPDATE conta_corrente SET saldo = saldo + ? WHERE id_usuario = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setDouble(1, valor);
        stmt.setInt(2, idUsuario);
        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas == 0) {
            throw new Exception("Conta corrente não encontrada para o usuário.");
        }
    } catch (Exception e) {
        throw new Exception("Erro ao realizar o depósito: " + e.getMessage());
    }
}


    
    public void transferirSaldo(int idPagante, int idRecebedor, double valor) throws Exception {
    contaCorrenteDAO correnteDAO = new contaCorrenteDAO();
    contaSalarioDAO salarioDAO = new contaSalarioDAO();

    boolean paganteContaCorrente = correnteDAO.verificarContaCorrentePorId(idPagante);
    boolean paganteContaSalario = salarioDAO.verificarContaSalarioPorId(idPagante);

    boolean recebedorContaCorrente = correnteDAO.verificarContaCorrentePorId(idRecebedor);
    boolean recebedorContaSalario = salarioDAO.verificarContaSalarioPorId(idRecebedor);

    if (!paganteContaCorrente && !paganteContaSalario) {
        throw new Exception("Usuário pagante não possui conta válida.");
    }

    if (!recebedorContaCorrente && !recebedorContaSalario) {
        throw new Exception("Usuário recebedor não possui conta válida.");
    }

    String sqlDebito;
    if (paganteContaCorrente) {
        sqlDebito = "UPDATE conta_corrente SET saldo = saldo - ? WHERE id_usuario = ?";
    } else {
        sqlDebito = "UPDATE conta_salario SET saldo = saldo - ? WHERE id_usuario = ?";
    }

    String sqlCredito;
    if (recebedorContaCorrente) {
        sqlCredito = "UPDATE conta_corrente SET saldo = saldo + ? WHERE id_usuario = ?";
    } else {
        sqlCredito = "UPDATE conta_salario SET saldo = saldo + ? WHERE id_usuario = ?";
    }

    conn.setAutoCommit(false);

    try (
        PreparedStatement debito = conn.prepareStatement(sqlDebito);
        PreparedStatement credito = conn.prepareStatement(sqlCredito)
    ) {
        
        debito.setDouble(1, valor);
        debito.setInt(2, idPagante);
        int linhasDebito = debito.executeUpdate();
        if (linhasDebito == 0) throw new Exception("Erro ao debitar do pagante.");

        
        credito.setDouble(1, valor);
        credito.setInt(2, idRecebedor);
        int linhasCredito = credito.executeUpdate();
        if (linhasCredito == 0) throw new Exception("Erro ao creditar no recebedor.");

        conn.commit();
    } catch (Exception e) {
        conn.rollback();
        throw new Exception("Erro na transferência: " + e.getMessage());
    } finally {
        conn.setAutoCommit(true);
    }
}


    
    public void sacar(int idUsuario, double valor) throws Exception {
    String sql = "UPDATE conta_corrente SET saldo = saldo - ? WHERE id_usuario = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setDouble(1, valor);
        stmt.setInt(2, idUsuario);
        stmt.execute();
    } catch (Exception e) {
        throw new Exception("Erro ao sacar: " + e.getMessage());
    }
}


    public boolean verificarContaCorrentePorId(int idUsuario) throws Exception {
    String sql = "SELECT 1 FROM conta_corrente WHERE id_usuario = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }
}



}
