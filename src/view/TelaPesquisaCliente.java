package view;

import controller.ConexaoBD;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class TelaPesquisaCliente extends javax.swing.JFrame {

    private Statement st;
    ResultSet rs =null;
    PreparedStatement pst = null;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPesquisaCliente.class.getName());

    TelaPesquisaCliente() {
        initComponents();
        try {
            st = ConexaoBD.conectar().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            rs = st.executeQuery("SELECT * FROM clientes");
            if (rs.next()) {
                atualizaTela();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum cliente encontrado, cadastre o cliente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível conectar ao banco de dados.");
        }
    }

    public void atualizaTela() {
        try {
            txtPesquisaCodigoCliente.setText(rs.getString("id"));
            txtPesquisaClienteNome.setText(rs.getString("nome"));
            txtPesquisaClienteCPF.setText(rs.getString("CPF"));
            txtPesquisaClienteIdade.setText(rs.getString("idade"));
            txtPesquisaClienteLogradouro.setText(rs.getString("logradouro"));
            txtPesquisaClienteNumeroCasa.setText(rs.getString("numeroCasa"));
            txtPesquisaClienteBairro.setText(rs.getString("bairro"));

        } catch (SQLException ex) {
           // Logger.getLogger(TelaPesquisaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarCampos() throws SQLException {
        txtPesquisaCodigoCliente.setText(rs.getString("id"));
        txtPesquisaClienteNome.setText(rs.getString("nome"));
        txtPesquisaClienteCPF.setText(rs.getString("CPF"));
        txtPesquisaClienteIdade.setText(rs.getString("id"));
        txtPesquisaClienteLogradouro.setText(rs.getString("logradouro"));
        txtPesquisaClienteNumeroCasa.setText(rs.getString("numeroCasa"));
        txtPesquisaClienteBairro.setText(rs.getString("bairro"));
    }
    
    private void limparCampos() {
        txtPesquisaCodigoCliente.setText("");
        txtPesquisaClienteNome.setText("");
        txtPesquisaClienteCPF.setText("");
        txtPesquisaClienteIdade.setText("");
        txtPesquisaClienteLogradouro.setText("");
        txtPesquisaClienteNumeroCasa.setText("");
        txtPesquisaClienteBairro.setText("");    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPesquisaClienteNome = new javax.swing.JLabel();
        txtPesquisaClienteNome = new javax.swing.JTextField();
        jLabelPesquisaClienteSexo = new javax.swing.JLabel();
        txtPesquisaClienteSexo = new javax.swing.JTextField();
        jLabelPesquisaClienteIdade = new javax.swing.JLabel();
        txtPesquisaClienteIdade = new javax.swing.JTextField();
        jLabelPesquisaClienteCPF = new javax.swing.JLabel();
        txtPesquisaClienteCPF = new javax.swing.JTextField();
        jLabelPesquisaClienteLogradouro = new javax.swing.JLabel();
        txtPesquisaClienteLogradouro = new javax.swing.JTextField();
        jLabelPesquisaClienteNumeroCasa = new javax.swing.JLabel();
        txtPesquisaClienteNumeroCasa = new javax.swing.JTextField();
        jLabelPesquisaClienteBairro = new javax.swing.JLabel();
        btnPesquisarCliente = new javax.swing.JButton();
        txtPesquisaClienteBairro = new javax.swing.JTextField();
        btnPesquisaVoltar = new javax.swing.JButton();
        jButtonNovoPesquisaCliente = new javax.swing.JButton();
        btnPrimeiroCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnproximoCliente1 = new javax.swing.JButton();
        jButtonUltimoCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisaCodigoCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Clientes");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("JFrameTelaPesquisaCliente"); // NOI18N
        setResizable(false);

        jLabelPesquisaClienteNome.setText("Nome");

        txtPesquisaClienteNome.setEditable(false);
        txtPesquisaClienteNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaClienteNomeActionPerformed(evt);
            }
        });

        jLabelPesquisaClienteSexo.setText("Sexo");

        txtPesquisaClienteSexo.setEditable(false);

        jLabelPesquisaClienteIdade.setText("Idade");

        txtPesquisaClienteIdade.setEditable(false);

        jLabelPesquisaClienteCPF.setText("CPF");

        txtPesquisaClienteCPF.setEditable(false);

        jLabelPesquisaClienteLogradouro.setText("Endereço");

        txtPesquisaClienteLogradouro.setEditable(false);

        jLabelPesquisaClienteNumeroCasa.setText("Numero");

        txtPesquisaClienteNumeroCasa.setEditable(false);

        jLabelPesquisaClienteBairro.setText("Bairro");

        btnPesquisarCliente.setText("Pesquisar Cliente");
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        txtPesquisaClienteBairro.setEditable(false);

        btnPesquisaVoltar.setText("Voltar");
        btnPesquisaVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaVoltarActionPerformed(evt);
            }
        });

        jButtonNovoPesquisaCliente.setText("Novo Cliente");
        jButtonNovoPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoPesquisaClienteActionPerformed(evt);
            }
        });

        btnPrimeiroCliente.setText("|< Primeiro");
        btnPrimeiroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroClienteActionPerformed(evt);
            }
        });

        jButton1.setText("<< Anterior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnproximoCliente1.setText("Proximo >>");
        btnproximoCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproximoCliente1ActionPerformed(evt);
            }
        });

        jButtonUltimoCliente.setText("Ultimo >|");
        jButtonUltimoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimoClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        txtPesquisaCodigoCliente.setEditable(false);
        txtPesquisaCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaCodigoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPesquisaClienteLogradouro)
                        .addGap(241, 241, 241)
                        .addComponent(jLabelPesquisaClienteNumeroCasa))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisaClienteLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPesquisaClienteNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jButtonNovoPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(btnPesquisaVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPesquisaClienteBairro)
                                    .addComponent(txtPesquisaClienteBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPesquisaClienteCPF)
                            .addComponent(txtPesquisaClienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPesquisaClienteIdade)
                            .addComponent(txtPesquisaClienteIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPesquisaClienteSexo)
                            .addComponent(txtPesquisaClienteSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPesquisaClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPesquisaClienteNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtPesquisaCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnPrimeiroCliente)
                    .addGap(11, 11, 11)
                    .addComponent(jButton1)
                    .addGap(8, 8, 8)
                    .addComponent(btnproximoCliente1)
                    .addGap(6, 6, 6)
                    .addComponent(jButtonUltimoCliente)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPesquisaClienteNome)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPesquisaClienteCPF)
                        .addGap(6, 6, 6)
                        .addComponent(txtPesquisaClienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPesquisaClienteIdade)
                            .addComponent(jLabelPesquisaClienteSexo))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisaClienteIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPesquisaClienteSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPesquisaClienteLogradouro)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPesquisaClienteNumeroCasa)
                        .addComponent(jLabelPesquisaClienteBairro)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaClienteLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaClienteNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaClienteBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPesquisarCliente)
                        .addComponent(jButtonNovoPesquisaCliente))
                    .addComponent(btnPesquisaVoltar))
                .addContainerGap(233, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPrimeiroCliente)
                        .addComponent(jButton1)
                        .addComponent(btnproximoCliente1)
                        .addComponent(jButtonUltimoCliente))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaClienteNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaClienteNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaClienteNomeActionPerformed

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed

    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void btnPesquisaVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaVoltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisaVoltarActionPerformed

    private void jButtonNovoPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoPesquisaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoPesquisaClienteActionPerformed

    private void btnPrimeiroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroClienteActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.first()) {
                atualizaTela();
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnPrimeiroClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.previous()) {
                atualizaTela();
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnproximoCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproximoCliente1ActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.next()) {
                atualizaTela();
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnproximoCliente1ActionPerformed

    private void jButtonUltimoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimoClienteActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.last()) {
                atualizaTela();
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jButtonUltimoClienteActionPerformed

    private void txtPesquisaCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaCodigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaCodigoClienteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TelaPesquisaCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisaVoltar;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPrimeiroCliente;
    private javax.swing.JButton btnproximoCliente1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonNovoPesquisaCliente;
    private javax.swing.JButton jButtonUltimoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPesquisaClienteBairro;
    private javax.swing.JLabel jLabelPesquisaClienteCPF;
    private javax.swing.JLabel jLabelPesquisaClienteIdade;
    private javax.swing.JLabel jLabelPesquisaClienteLogradouro;
    private javax.swing.JLabel jLabelPesquisaClienteNome;
    private javax.swing.JLabel jLabelPesquisaClienteNumeroCasa;
    private javax.swing.JLabel jLabelPesquisaClienteSexo;
    private javax.swing.JTextField txtPesquisaClienteBairro;
    private javax.swing.JTextField txtPesquisaClienteCPF;
    private javax.swing.JTextField txtPesquisaClienteIdade;
    private javax.swing.JTextField txtPesquisaClienteLogradouro;
    private javax.swing.JTextField txtPesquisaClienteNome;
    private javax.swing.JTextField txtPesquisaClienteNumeroCasa;
    private javax.swing.JTextField txtPesquisaClienteSexo;
    private javax.swing.JTextField txtPesquisaCodigoCliente;
    // End of variables declaration//GEN-END:variables
}
