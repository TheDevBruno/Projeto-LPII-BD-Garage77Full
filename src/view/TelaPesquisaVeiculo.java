/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.Veiculo;
import model.Cliente;
import controller.ConexaoBD;
import javax.swing.*;
import java.lang.*;
import java.sql.*;
import java.util.*;

public class TelaPesquisaVeiculo extends javax.swing.JFrame {

    private Statement st;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private Map<String, Integer> clientesMap = new HashMap<>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPesquisaVeiculo.class.getName());

    public TelaPesquisaVeiculo() {
        initComponents();
        try {
            st = ConexaoBD.conectar().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            rs = st.executeQuery("SELECT * FROM VEICULOS");
            if (rs.next()) {
                atualizaTela();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum veiculo encontrado, cadastre um veiculo.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel conectar ao banco de dados" + ex.getMessage());
        }
    }

    public void atualizaTela() throws SQLException {

        txtModeloVeiculo.setText(rs.getString("modelo"));
        jComboBoxMarcaVeiculo.setSelectedItem(rs.getString("marca"));
        txtPlacaVeiculo.setText(rs.getString("placa"));

        int idCliente = rs.getInt("CLIENTE_ID");

        try (Connection conexao = ConexaoBD.conectar()) {
            String sqlCliente = "SELECT NOME, CONTATO FROM CLIENTES WHERE ID =?";
            try (PreparedStatement pstCliente = conexao.prepareCall(sqlCliente)) {
                pstCliente.setInt(1, idCliente);
                try (ResultSet rsCliente = pstCliente.executeQuery()) {
                    if (rsCliente.next()) {
                        txtNomeProprietario.setText(rsCliente.getString("NOME"));
                        txtContatoProprietario.setText(rsCliente.getString("CONTATO"));
                    } else {
                        txtNomeProprietario.setText("");
                        txtContatoProprietario.setText("");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar dados do cliente: " + ex.getMessage());
        }
    }

    public void atualizarCampos() throws SQLException {
        txtModeloVeiculo.setText(rs.getString("modelo"));
        jComboBoxMarcaVeiculo.setSelectedItem("marca");
        txtPlacaVeiculo.setText(rs.getString("placa"));
        txtNomeProprietario.setText(rs.getString("proprietario"));
        txtContatoProprietario.setText(rs.getString("contato"));
    }

    public void limparCampos() {
        txtModeloVeiculo.setText("");
        jComboBoxMarcaVeiculo.setSelectedItem("");
        txtPlacaVeiculo.setText("");
        txtNomeProprietario.setText("");
        txtContatoProprietario.setText("");
    }

    public void carregarClientes() {
        try (Connection conexao = ConexaoBD.conectar()) {
            String sqlClientes = "SELECT ID, NOME, CONTATO FROM CLIENTES";
            try (Statement st = conexao.createStatement(); ResultSet rs = st.executeQuery(sqlClientes)) {
                while (rs.next()) {
                    int id = rs.getInt("CLIENTE_ID");
                    String nome = rs.getString("NOME");
                    String contato = rs.getString("CONTATO");

                    jComboBoxClientes.addItem(nome);
                    clientesMap.put(nome, id);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar clientes: " + ex.getMessage());
        }
    }

    public void clienteSelecionado(java.awt.event.ActionEvent evt) throws SQLException {
        String nomeSelecionado = (String) jComboBoxClientes.getSelectedItem();
        if (nomeSelecionado != null) {
            try (Connection conexao = ConexaoBD.conectar()) {
                String sqlInsert = "INSERT NOME, CONTATO FROM CLIENTES WHERE NOME = ?";
                try (PreparedStatement pst = conexao.prepareStatement(sqlInsert)) {
                    pst.setString(1, nomeSelecionado);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            txtNomeProprietario.setText(rs.getString("NOME"));
                            txtContatoProprietario.setText(rs.getString("CONTATO"));
                        }
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar cliente:" + ex.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtModeloVeiculo = new javax.swing.JTextField();
        jLabelPlaca = new javax.swing.JLabel();
        txtPlacaVeiculo = new javax.swing.JTextField();
        jLabelProprietario = new javax.swing.JLabel();
        jLabelContatoProprietario = new javax.swing.JLabel();
        txtContatoProprietario = new javax.swing.JTextField();
        btnCadastrarVeiculos = new javax.swing.JButton();
        btnLimparCadastroVeiculos = new javax.swing.JButton();
        btnCancelarCadastroVeiculos = new javax.swing.JButton();
        jLabelMarcaVeiculo = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jComboBoxMarcaVeiculo = new javax.swing.JComboBox<>();
        btnPrimeiroVeiculo = new javax.swing.JButton();
        btnVeiculoAnterior = new javax.swing.JButton();
        btnproximoVeiculo = new javax.swing.JButton();
        jButtonUltimoVeiculo = new javax.swing.JButton();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtNomeProprietario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pesquisar Veiculos");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        txtModeloVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloVeiculoActionPerformed(evt);
            }
        });

        jLabelPlaca.setText("Placa");

        jLabelProprietario.setText("Proprietario");

        jLabelContatoProprietario.setText("Contato");

        btnCadastrarVeiculos.setText("Cadastrar");
        btnCadastrarVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarVeiculosActionPerformed(evt);
            }
        });

        btnLimparCadastroVeiculos.setText("Limpar");
        btnLimparCadastroVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCadastroVeiculosActionPerformed(evt);
            }
        });

        btnCancelarCadastroVeiculos.setText("Cancelar");
        btnCancelarCadastroVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroVeiculosActionPerformed(evt);
            }
        });

        jLabelMarcaVeiculo.setText("Marca");

        jLabelModelo.setText("Modelo");

        jComboBoxMarcaVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiat", "Chevrolet", "Ford", "Wolksvagem" }));
        jComboBoxMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaVeiculoActionPerformed(evt);
            }
        });

        btnPrimeiroVeiculo.setText("|< Primeiro");
        btnPrimeiroVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroVeiculoActionPerformed(evt);
            }
        });

        btnVeiculoAnterior.setText("<< Anterior");
        btnVeiculoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeiculoAnteriorActionPerformed(evt);
            }
        });

        btnproximoVeiculo.setText("Proximo >>");
        btnproximoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproximoVeiculoActionPerformed(evt);
            }
        });

        jButtonUltimoVeiculo.setText("Ultimo >|");
        jButtonUltimoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimoVeiculoActionPerformed(evt);
            }
        });

        jComboBoxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClientesActionPerformed(evt);
            }
        });

        jLabel1.setText("Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrarVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(btnLimparCadastroVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(btnCancelarCadastroVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btnPrimeiroVeiculo)
                        .addGap(11, 11, 11)
                        .addComponent(btnVeiculoAnterior)
                        .addGap(8, 8, 8)
                        .addComponent(btnproximoVeiculo)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonUltimoVeiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtNomeProprietario))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelContatoProprietario)
                                    .addComponent(txtContatoProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelProprietario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxMarcaVeiculo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelMarcaVeiculo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModeloVeiculo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(txtPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMarcaVeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelProprietario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContatoProprietario)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtContatoProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrimeiroVeiculo)
                    .addComponent(btnVeiculoAnterior)
                    .addComponent(btnproximoVeiculo)
                    .addComponent(jButtonUltimoVeiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarVeiculos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimparCadastroVeiculos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelarCadastroVeiculos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(214, 214, 214))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtModeloVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloVeiculoActionPerformed

    private void btnCadastrarVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarVeiculosActionPerformed
        // TODO add your handling code here:
        String placa = txtPlacaVeiculo.getText().trim();
        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe a placa do veiculo.");
            return;
        }
        try (Connection conexao = ConexaoBD.conectar()) {
            String sqlVerificaPlaca = "SELECT id FROM VEICULOS WHERE PLACA = ?";
            try (PreparedStatement pstVerifica = conexao.prepareStatement(sqlVerificaPlaca)) {
                pstVerifica.setString(1, placa);
                try (ResultSet rsVerifica = pstVerifica.executeQuery()) {
                    if (rsVerifica.next()) {
                        JOptionPane.showMessageDialog(this, "Veículo já cadastrado com esta placa.");
                        return;
                    }
                }
            }

            String sqlInsert = "INSERT INTO VEICULOS (MODELO, MARCA, PLACA, PROPRIETARIO, CONTATO) VALUES (?,?,?,?,?)";
            try (PreparedStatement pst = conexao.prepareStatement(sqlInsert)) {
                pst.setString(1, txtModeloVeiculo.getText());
                pst.setString(2, (String) jComboBoxMarcaVeiculo.getSelectedItem());
                pst.setString(3, txtPlacaVeiculo.getText());
                pst.setString(4, txtNomeProprietario.getText());
                pst.setString(5, txtContatoProprietario.getText());

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Veiculo cadastrado com sucesso.");
                limparCampos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o veiculo" + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCadastrarVeiculosActionPerformed

    private void btnLimparCadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadastroVeiculosActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnLimparCadastroVeiculosActionPerformed

    private void btnCancelarCadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroVeiculosActionPerformed
        // TODO add your handling code here:
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnCancelarCadastroVeiculosActionPerformed

    private void jComboBoxMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMarcaVeiculoActionPerformed

    private void btnPrimeiroVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroVeiculoActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.first()) {
                atualizaTela();
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnPrimeiroVeiculoActionPerformed

    private void btnVeiculoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeiculoAnteriorActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.previous()) {
                atualizaTela();
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnVeiculoAnteriorActionPerformed

    private void btnproximoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproximoVeiculoActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.next()) {
                atualizaTela();
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnproximoVeiculoActionPerformed

    private void jButtonUltimoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimoVeiculoActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.last()) {
                atualizaTela();
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jButtonUltimoVeiculoActionPerformed

    private void jComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TelaPesquisaVeiculo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarVeiculos;
    private javax.swing.JButton btnCancelarCadastroVeiculos;
    private javax.swing.JButton btnLimparCadastroVeiculos;
    private javax.swing.JButton btnPrimeiroVeiculo;
    private javax.swing.JButton btnVeiculoAnterior;
    private javax.swing.JButton btnproximoVeiculo;
    private javax.swing.JButton jButtonUltimoVeiculo;
    private javax.swing.JComboBox<String> jComboBoxClientes;
    private javax.swing.JComboBox<String> jComboBoxMarcaVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelContatoProprietario;
    private javax.swing.JLabel jLabelMarcaVeiculo;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPlaca;
    private javax.swing.JLabel jLabelProprietario;
    private javax.swing.JTextField txtContatoProprietario;
    private javax.swing.JTextField txtModeloVeiculo;
    private javax.swing.JTextField txtNomeProprietario;
    private javax.swing.JTextField txtPlacaVeiculo;
    // End of variables declaration//GEN-END:variables
}
