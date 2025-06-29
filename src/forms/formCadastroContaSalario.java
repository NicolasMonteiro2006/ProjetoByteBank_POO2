/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import beans.Conta;
import dao.contaDAO;
import dao.contaSalarioDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class formCadastroContaSalario extends javax.swing.JFrame {

    /**
     * Creates new form formCadastroContaSalario
     */
    public formCadastroContaSalario() {
        initComponents();
    }
    
    private void limparCampos() {
    txtNomeContaSalario.setText("");
    txtSenhaContaSalario.setText("");
    txtEmailContaSalario.setText("");
    txtCpfContaSalario.setText("");
    txtIdadeContaSalario.setText("");
    txtEmpContratante.setText("");
    }   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnContaCorrente = new javax.swing.JButton();
        txtNomeContaSalario = new javax.swing.JTextField();
        Nome6 = new javax.swing.JLabel();
        Nome2 = new javax.swing.JLabel();
        txtSenhaContaSalario = new javax.swing.JPasswordField();
        txtCpfContaSalario = new javax.swing.JTextField();
        Nome4 = new javax.swing.JLabel();
        txtIdadeContaSalario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtEmailContaSalario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSalvarContaSalario = new javax.swing.JButton();
        Nome1 = new javax.swing.JLabel();
        Nome3 = new javax.swing.JLabel();
        Nome5 = new javax.swing.JLabel();
        txtEmpContratante = new javax.swing.JTextField();
        Nome7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Conta Salario");

        btnContaCorrente.setFont(new java.awt.Font("Calibri", 1, 25)); // NOI18N
        btnContaCorrente.setText("Conta Corrente");
        btnContaCorrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContaCorrenteActionPerformed(evt);
            }
        });

        txtNomeContaSalario.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtNomeContaSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeContaSalarioActionPerformed(evt);
            }
        });

        Nome6.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        Nome6.setText("Ir para a:");

        Nome2.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        Nome2.setText("Cpf:");

        txtSenhaContaSalario.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        txtCpfContaSalario.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        Nome4.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        Nome4.setText("Idade:");

        txtIdadeContaSalario.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 2, 24)); // NOI18N
        jLabel1.setText("Bem vindo(a), insira suas informações");

        txtEmailContaSalario.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setText("Banco ByteBank - Conta Salario");

        btnSalvarContaSalario.setFont(new java.awt.Font("Calibri", 1, 25)); // NOI18N
        btnSalvarContaSalario.setText("Enviar");
        btnSalvarContaSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarContaSalarioActionPerformed(evt);
            }
        });

        Nome1.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        Nome1.setText("Senha:");

        Nome3.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        Nome3.setText("Nome:");

        Nome5.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        Nome5.setText("Email:");

        txtEmpContratante.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N

        Nome7.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        Nome7.setText("Empresa Contratante:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nome3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Nome1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Nome5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSenhaContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nome2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Nome4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCpfContaSalario)
                                    .addComponent(txtIdadeContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEmailContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(Nome6)
                                .addGap(20, 20, 20)
                                .addComponent(btnContaCorrente))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(293, 293, 293)
                                .addComponent(btnSalvarContaSalario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Nome7)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmpContratante, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(142, 142, 142))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdadeContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nome4)
                    .addComponent(Nome3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCpfContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nome2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSenhaContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nome1))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nome6)
                            .addComponent(btnContaCorrente)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nome5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpContratante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nome7))
                .addGap(44, 44, 44)
                .addComponent(btnSalvarContaSalario)
                .addGap(44, 44, 44))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnContaCorrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContaCorrenteActionPerformed
        formCadastroContaCorrente tela = new formCadastroContaCorrente();  
        tela.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnContaCorrenteActionPerformed

    private void btnSalvarContaSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarContaSalarioActionPerformed
        try {
        
        String nome = txtNomeContaSalario.getText().trim();
        String senha = new String(txtSenhaContaSalario.getPassword()).trim();
        String email = txtEmailContaSalario.getText().trim();
        String cpf = txtCpfContaSalario.getText().trim();
        String idadeStr = txtIdadeContaSalario.getText().trim();
        String empresa = txtEmpContratante.getText().trim();

        if (nome.isEmpty() || senha.isEmpty() || email.isEmpty() || cpf.isEmpty() || idadeStr.isEmpty() || empresa.isEmpty()) {
            throw new Exception("Todos os campos devem ser preenchidos.");
        }

        int idade = Integer.parseInt(idadeStr);
        if (idade < 18) throw new Exception("Usuário precisa ter 18 anos ou mais.");

        
        Conta conta = new Conta();
        conta.setNome(nome);
        conta.setSenha(senha);
        conta.setEmail(email);
        conta.setCpf(cpf);
        conta.setIdade(idade);

        contaDAO dao = new contaDAO();
        
        
        if (dao.usuarioExiste(nome, cpf)) {
            throw new Exception("Usuário com este nome ou CPF já existe.");
        }

        dao.inserir(conta);

        
        int idUsuario = dao.buscarIdPorNome(nome);

        
        contaSalarioDAO daoSalario = new contaSalarioDAO();
        daoSalario.inserirContaSalario(idUsuario, empresa);

        JOptionPane.showMessageDialog(this, "Conta salário criada com sucesso!");
        limparCampos(); 
        new formLogin().setVisible(true);
        this.dispose();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
    }
        
    }//GEN-LAST:event_btnSalvarContaSalarioActionPerformed

    private void txtNomeContaSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeContaSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeContaSalarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formCadastroContaSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCadastroContaSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCadastroContaSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCadastroContaSalario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCadastroContaSalario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nome1;
    private javax.swing.JLabel Nome2;
    private javax.swing.JLabel Nome3;
    private javax.swing.JLabel Nome4;
    private javax.swing.JLabel Nome5;
    private javax.swing.JLabel Nome6;
    private javax.swing.JLabel Nome7;
    private javax.swing.JButton btnContaCorrente;
    private javax.swing.JButton btnSalvarContaSalario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtCpfContaSalario;
    private javax.swing.JTextField txtEmailContaSalario;
    private javax.swing.JTextField txtEmpContratante;
    private javax.swing.JTextField txtIdadeContaSalario;
    private javax.swing.JTextField txtNomeContaSalario;
    private javax.swing.JPasswordField txtSenhaContaSalario;
    // End of variables declaration//GEN-END:variables
}
