package view;

import model.Vaga;
import model.Veiculo;
import controller.ConexaoBD;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class TelaCadastroVaga extends javax.swing.JFrame {

    private Statement st;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroVaga.class.getName());

    public TelaCadastroVaga() {
        initComponents();

        try {
            st = ConexaoBD.conectar().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            rs = st.executeQuery("SELECT * FROM VAGAS");
            if (rs.next()) {
                atualizaTela();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma Vaga encontrado, cadastre uma Vaga.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possivel conectar ao banco de dados" + ex.getMessage());
        }
    }

    public void atualizaTela() {
        try {
            txtNomeVaga.setText(rs.getString("NOME_VAGA"));
            txtTipoVaga.setText(rs.getString("TIPO_VAGA"));
            txtLarguraVaga.setText(rs.getString("LARGURA"));
            txtComprimentoVaga.setText(rs.getString("COMPRIMENTO"));
            txtCoberturaVaga.setText(rs.getString("COBERTURA"));
            txtValorVaga.setText(rs.getString("VALOR"));
        } catch (Exception e) {
        }
    }

    public void limparCampos() {
        txtNomeVaga.setText("");
        txtTipoVaga.setText("");
        txtLarguraVaga.setText("");
        txtComprimentoVaga.setText("");
        txtCoberturaVaga.setText("");
        txtValorVaga.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelVaga = new javax.swing.JLabel();
        txtNomeVaga = new javax.swing.JTextField();
        jLabelComprimento = new javax.swing.JLabel();
        txtComprimentoVaga = new javax.swing.JTextField();
        jLabelValorVaga = new javax.swing.JLabel();
        txtValorVaga = new javax.swing.JTextField();
        jLabelLarguraVaga = new javax.swing.JLabel();
        txtLarguraVaga = new javax.swing.JTextField();
        btnCadastrarVaga = new javax.swing.JButton();
        btnLimparCadastroVaga = new javax.swing.JButton();
        btnCancelarCadastroVaga = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodVaga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTipoVaga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCoberturaVaga = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Vagas");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("JFrameTelaCadastroVaga"); // NOI18N
        setResizable(false);

        jLabelVaga.setText("Vaga");

        txtNomeVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeVagaActionPerformed(evt);
            }
        });

        jLabelComprimento.setText("Comprimento");

        jLabelValorVaga.setText("Valor");

        jLabelLarguraVaga.setText("Largura");

        btnCadastrarVaga.setText("Cadastrar");
        btnCadastrarVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarVagaActionPerformed(evt);
            }
        });

        btnLimparCadastroVaga.setText("Limpar");
        btnLimparCadastroVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCadastroVagaActionPerformed(evt);
            }
        });

        btnCancelarCadastroVaga.setText("Cancelar");
        btnCancelarCadastroVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroVagaActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        txtCodVaga.setEditable(false);
        txtCodVaga.setFocusable(false);
        txtCodVaga.setRequestFocusEnabled(false);

        jLabel2.setText("Tipo");

        jLabel3.setText("Cobertura");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelValorVaga))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLarguraVaga)
                            .addComponent(txtLarguraVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelComprimento)
                            .addComponent(txtComprimentoVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnCadastrarVaga)
                        .addGap(20, 20, 20)
                        .addComponent(btnLimparCadastroVaga)
                        .addGap(16, 16, 16)
                        .addComponent(btnCancelarCadastroVaga))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVaga)
                            .addComponent(txtTipoVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtCoberturaVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVaga)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCoberturaVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelComprimento)
                            .addComponent(jLabelLarguraVaga))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelValorVaga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLarguraVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtComprimentoVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarVaga)
                    .addComponent(btnLimparCadastroVaga)
                    .addComponent(btnCancelarCadastroVaga))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeVagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeVagaActionPerformed

    private void btnCadastrarVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarVagaActionPerformed
        // TODO add your handling code here:
        try (Connection conexao = ConexaoBD.conectar()) {
            String vaga = txtNomeVaga.getText().trim();
            if (vaga.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe a vaga.");
                return;
            }
            String sqlVerificaVaga = "SELECT COD_VAGA FROM VAGAS WHERE NOME_VAGA = ?";
            try (PreparedStatement pstVerifica = conexao.prepareStatement(sqlVerificaVaga)) {
                pstVerifica.setString(1, vaga);
                try (ResultSet rsVerifica = pstVerifica.executeQuery()) {
                    if (rsVerifica.next()) {
                        JOptionPane.showMessageDialog(this, "Vaga já cadastrada.");
                        return;
                    }
                }
            }
            String sqlInsert = "INSERT INTO VAGAS (NOME_VAGA, TIPO_VAGA, LARGURA, COMPRIMENTO, COBERTURA, VALOR) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conexao.prepareStatement(sqlInsert)) {

                float largura = Float.parseFloat(txtLarguraVaga.getText());
                float comprimento = Float.parseFloat(txtComprimentoVaga.getText());
                double valor = Double.parseDouble(txtValorVaga.getText());

                pst.setString(1, txtNomeVaga.getText());
                pst.setString(2, txtTipoVaga.getText());
                pst.setFloat(3, largura);
                pst.setFloat(4, comprimento);
                pst.setString(5, txtCoberturaVaga.getText());
                pst.setDouble(6, valor);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Vaga cadastrada com sucesso!");
                limparCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar vaga: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCadastrarVagaActionPerformed

    private void btnLimparCadastroVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadastroVagaActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnLimparCadastroVagaActionPerformed

    private void btnCancelarCadastroVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroVagaActionPerformed
        // TODO add your handling code here:
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnCancelarCadastroVagaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TelaCadastroVaga().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarVaga;
    private javax.swing.JButton btnCancelarCadastroVaga;
    private javax.swing.JButton btnLimparCadastroVaga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelComprimento;
    private javax.swing.JLabel jLabelLarguraVaga;
    private javax.swing.JLabel jLabelVaga;
    private javax.swing.JLabel jLabelValorVaga;
    private javax.swing.JTextField txtCoberturaVaga;
    private javax.swing.JTextField txtCodVaga;
    private javax.swing.JTextField txtComprimentoVaga;
    private javax.swing.JTextField txtLarguraVaga;
    private javax.swing.JTextField txtNomeVaga;
    private javax.swing.JTextField txtTipoVaga;
    private javax.swing.JTextField txtValorVaga;
    // End of variables declaration//GEN-END:variables

}
