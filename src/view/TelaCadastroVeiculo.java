package view;

import model.Veiculo;
import model.Cliente;
import controller.ConexaoBD;
import javax.swing.*;
import java.lang.*;
import java.sql.*;
import java.util.*;

public class TelaCadastroVeiculo extends javax.swing.JFrame {

    private Statement st;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private Map<String, Integer> clientesMap = new HashMap<>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName());

    public TelaCadastroVeiculo() {
        initComponents();
        carregarClientes();
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
            JOptionPane.showMessageDialog(this, "Não foi possivel conectar ao banco de dados" + ex.getMessage());
        }
    }

    public void atualizaTela() {
        try {
            txtModeloVeiculo.setText(rs.getString("modelo"));
            jComboBoxMarcaVeiculo.setSelectedItem(rs.getString("marca"));
            txtPlacaVeiculo.setText(rs.getString("placa"));
            txtNomeProprietario.setText(rs.getString("proprietario"));
            txtContatoProprietario.setText(rs.getString("contato"));
        } catch (SQLException ex) {
        }
    }

    public void atualizarCampos() throws SQLException {
        txtModeloVeiculo.setText(rs.getString("modelo"));
        jComboBoxMarcaVeiculo.setSelectedItem(rs.getString("marca"));
        txtPlacaVeiculo.setText(rs.getString("placa"));

        int idCliente = rs.getInt("id_cliente");

        try (Connection conexao = ConexaoBD.conectar()) {
            String sql = "SELECT nome, contato FROM CLIENTES WHERE id = ?";
            try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.setInt(1, idCliente);
                ResultSet rsCliente = pst.executeQuery();
                if (rsCliente.next()) {
                    txtNomeProprietario.setText(rsCliente.getString("nome"));
                    txtContatoProprietario.setText(rsCliente.getString("contato"));
                } else {
                    txtNomeProprietario.setText("");
                    txtContatoProprietario.setText("");
                }
            }
        }
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
            String sqlClientes = "SELECT ID, NOME, TELEFONE FROM CLIENTES";
            try (Statement st = conexao.createStatement(); ResultSet rs = st.executeQuery(sqlClientes)) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String nome = rs.getString("NOME");
                    String contato = rs.getString("TELEFONE");

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
                String sqlInsert = "INSERT NOME, TELEFONE FROM CLIENTES WHERE NOME = ?";
                try (PreparedStatement pst = conexao.prepareStatement(sqlInsert)) {
                    pst.setString(1, nomeSelecionado);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            txtNomeProprietario.setText(rs.getString("NOME"));
                            txtContatoProprietario.setText(rs.getString("TELEFONE"));
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

        jLabelModelo = new javax.swing.JLabel();
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
        jComboBoxMarcaVeiculo = new javax.swing.JComboBox<>();
        txtNomeProprietario = new javax.swing.JTextField();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jLabelProprietario1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Veiculos");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("JFrameTelaCadastroVeiculos"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        jLabelModelo.setText("Modelo");

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

        jComboBoxMarcaVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiat", "Chevrolet", "Ford", "Wolksvagem" }));
        jComboBoxMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaVeiculoActionPerformed(evt);
            }
        });

        jComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClientesActionPerformed(evt);
            }
        });

        jLabelProprietario1.setText("Proprietario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastrarVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(btnLimparCadastroVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(btnCancelarCadastroVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelProprietario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelContatoProprietario))
                            .addComponent(jLabelModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                        .addGap(351, 351, 351))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMarcaVeiculo)
                            .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelProprietario1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContatoProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPlacaVeiculo))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabelPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMarcaVeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelProprietario1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProprietario)
                    .addComponent(jLabelContatoProprietario))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContatoProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarVeiculos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimparCadastroVeiculos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelarCadastroVeiculos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(176, 176, 176))
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

            String sqlInsert = "INSERT INTO VEICULOS (MODELO, MARCA, PLACA, NOME, TELEFONE) VALUES (?,?,?,?,?)";
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

    private void jComboBoxMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMarcaVeiculoActionPerformed

    private void btnLimparCadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadastroVeiculosActionPerformed
        // TODO add your handling code here:  
        limparCampos();
    }//GEN-LAST:event_btnLimparCadastroVeiculosActionPerformed

    private void btnCancelarCadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroVeiculosActionPerformed
        // TODO add your handling code here:
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnCancelarCadastroVeiculosActionPerformed

    private void jComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TelaCadastroVeiculo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarVeiculos;
    private javax.swing.JButton btnCancelarCadastroVeiculos;
    private javax.swing.JButton btnLimparCadastroVeiculos;
    private javax.swing.JComboBox<String> jComboBoxClientes;
    private javax.swing.JComboBox<String> jComboBoxMarcaVeiculo;
    private javax.swing.JLabel jLabelContatoProprietario;
    private javax.swing.JLabel jLabelMarcaVeiculo;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPlaca;
    private javax.swing.JLabel jLabelProprietario;
    private javax.swing.JLabel jLabelProprietario1;
    private javax.swing.JTextField txtContatoProprietario;
    private javax.swing.JTextField txtModeloVeiculo;
    private javax.swing.JTextField txtNomeProprietario;
    private javax.swing.JTextField txtPlacaVeiculo;
    // End of variables declaration//GEN-END:variables
}
