package view;

import model.Funcionario;
import controller.ConexaoBD;
import java.awt.HeadlessException;
import javax.swing.*;
import java.lang.*;
import java.sql.*;
import java.util.*;

public class TelaCadastroFuncionario extends javax.swing.JFrame {

    private Statement st;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroFuncionario.class.getName());

    public TelaCadastroFuncionario() {
        initComponents();
        try {
            st = ConexaoBD.conectar().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            rs = st.executeQuery("SELECT * FROM FUNCIONARIOS");
            if (rs.next()) {
                atualizaTela();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum funcionario encontrado, cadastre o funcionario");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possil conecata ao banco de dados na tabela funcionarios" + ex.getMessage());
        }
    }

    public void atualizaTela() {
        try {
            txtIdFuncionario.setText(rs.getString("ID_FUNCIONARIO"));
            txtNomeFuncionario.setText(rs.getString("nome"));
            txtxCPFFuncionario.setText(rs.getString("CPF"));
            txtIdadeFuncionario.setText(rs.getString("idade"));
            jComboBoxSexoFuncionario.setSelectedItem(rs.getString("sexo"));
            jComboBoxFuncionarioCargo.setSelectedItem(rs.getString("cargo"));
            txtSalarioFuncionario.setText(rs.getString("salario"));
            jTextAreaDescricaoFuncionario.setText(rs.getString("descricao"));
            txtLoginFuncionario.setText(rs.getString("login"));
            jPasswordFieldSenhaFuncionario.setText(rs.getString("senha"));
        } catch (Exception e) {
        }
    }

    public void limparCampos() {
        try {
            txtIdFuncionario.setText("");
            txtNomeFuncionario.setText("");
            txtxCPFFuncionario.setText("");
            txtIdadeFuncionario.setText("");
            jComboBoxSexoFuncionario.setSelectedItem(null);
            jComboBoxFuncionarioCargo.setSelectedItem(null);
            txtSalarioFuncionario.setText("");
            jTextAreaDescricaoFuncionario.setText("");
            txtLoginFuncionario.setText("");
            jPasswordFieldSenhaFuncionario.setText("");
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeFuncionario = new javax.swing.JLabel();
        txtNomeFuncionario = new javax.swing.JTextField();
        jLabelIdadeFuncionario = new javax.swing.JLabel();
        txtxCPFFuncionario = new javax.swing.JTextField();
        jLabelCargoFuncionario = new javax.swing.JLabel();
        jComboBoxSexoFuncionario = new javax.swing.JComboBox<>();
        jLabelSalarioFuncionario = new javax.swing.JLabel();
        txtSalarioFuncionario = new javax.swing.JTextField();
        btnCadastrarFuncionario = new javax.swing.JButton();
        btnLimparCadastroFuncionario = new javax.swing.JButton();
        btnCancelarCadastroFuncionario = new javax.swing.JButton();
        jLabelLoginFuncionario = new javax.swing.JLabel();
        txtLoginFuncionario = new javax.swing.JTextField();
        jLabelSenhaFuncionario = new javax.swing.JLabel();
        jLabelDescricaoFuncionario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricaoFuncionario = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtIdadeFuncionario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxFuncionarioCargo = new javax.swing.JComboBox<>();
        jPasswordFieldSenhaFuncionario = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtIdFuncionario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de funcionario");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("JFrameTelaCadastroFuncionario"); // NOI18N
        setResizable(false);

        jLabelNomeFuncionario.setText("Nome");

        txtNomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeFuncionarioActionPerformed(evt);
            }
        });

        jLabelIdadeFuncionario.setText("CPF");

        txtxCPFFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtxCPFFuncionarioActionPerformed(evt);
            }
        });

        jLabelCargoFuncionario.setText("Cargo");

        jComboBoxSexoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nao Informar", "Masculino", "Feminino" }));

        jLabelSalarioFuncionario.setText("Salario");

        btnCadastrarFuncionario.setText("Cadastrar");
        btnCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncionarioActionPerformed(evt);
            }
        });

        btnLimparCadastroFuncionario.setText("Limpar");
        btnLimparCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCadastroFuncionarioActionPerformed(evt);
            }
        });

        btnCancelarCadastroFuncionario.setText("Cancelar");
        btnCancelarCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroFuncionarioActionPerformed(evt);
            }
        });

        jLabelLoginFuncionario.setText("Login");

        txtLoginFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginFuncionarioActionPerformed(evt);
            }
        });

        jLabelSenhaFuncionario.setText("Senha");

        jLabelDescricaoFuncionario.setText("Descrição");

        jTextAreaDescricaoFuncionario.setColumns(5);
        jTextAreaDescricaoFuncionario.setLineWrap(true);
        jTextAreaDescricaoFuncionario.setRows(5);
        jTextAreaDescricaoFuncionario.setMaximumSize(new java.awt.Dimension(113, 84));
        jTextAreaDescricaoFuncionario.setMinimumSize(new java.awt.Dimension(113, 84));
        jScrollPane1.setViewportView(jTextAreaDescricaoFuncionario);

        jLabel6.setText("Idade");

        txtIdadeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeFuncionarioActionPerformed(evt);
            }
        });

        jLabel7.setText("Sexo");

        jComboBoxFuncionarioCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atendente", "Gerente" }));

        jLabel1.setText("ID");

        txtIdFuncionario.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNomeFuncionario)
                                    .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtIdFuncionario)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxFuncionarioCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordFieldSenhaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLoginFuncionario)
                                    .addComponent(txtLoginFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelIdadeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSenhaFuncionario)
                                    .addComponent(txtxCPFFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCargoFuncionario))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(47, 47, 47)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtIdadeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jComboBoxSexoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelDescricaoFuncionario)
                                    .addComponent(txtSalarioFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSalarioFuncionario)
                                    .addComponent(jScrollPane1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btnCadastrarFuncionario)
                        .addGap(20, 20, 20)
                        .addComponent(btnLimparCadastroFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarCadastroFuncionario)))
                .addGap(218, 218, 218))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeFuncionario)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIdadeFuncionario)
                        .addGap(4, 4, 4)
                        .addComponent(txtxCPFFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCargoFuncionario)
                            .addComponent(jLabelSalarioFuncionario))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxFuncionarioCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalarioFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabelLoginFuncionario)
                        .addGap(6, 6, 6)
                        .addComponent(txtLoginFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelSenhaFuncionario)
                        .addGap(10, 10, 10)
                        .addComponent(jPasswordFieldSenhaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdadeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxSexoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(jLabelDescricaoFuncionario)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarFuncionario)
                    .addComponent(btnLimparCadastroFuncionario)
                    .addComponent(btnCancelarCadastroFuncionario)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFuncionarioActionPerformed

    private void txtxCPFFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtxCPFFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtxCPFFuncionarioActionPerformed

    private void btnCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncionarioActionPerformed
        // TODO add your handling code here:
        try (Connection conexao = ConexaoBD.conectar()) {

            String nome = txtNomeFuncionario.getText().trim();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe o nome do funcionario");
                return;
            }
            String sqlVerificaFuncionario = "SELECT ID_FUNCIONARIO FROM FUNCIONARIOS WHERE NOME =?";
            try (PreparedStatement pstVerifica = conexao.prepareStatement(sqlVerificaFuncionario)) {
                pstVerifica.setString(1, nome);
                try (ResultSet rsVerifica = pstVerifica.executeQuery()) {
                    if (rsVerifica.next()) {
                        JOptionPane.showMessageDialog(this, "Funcionario ja cadastrado");
                        return;
                    }
                }
            }
            String sqlInsert = "INSERT INTO FUNCIONARIOS ( NOME,CPF, SEXO, IDADE, CARGO, SALARIO, DESCRICAO_FUNCIONARIO, LOGIN, SENHA)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement pst = conexao.prepareStatement(sqlInsert)) {
                pst.setString(1, txtNomeFuncionario.getText());
                pst.setString(2, txtxCPFFuncionario.getText());
                pst.setString(3, (String) jComboBoxSexoFuncionario.getSelectedItem());
                pst.setString(4, txtIdadeFuncionario.getText());
                pst.setString(5, (String) jComboBoxFuncionarioCargo.getSelectedItem());
                pst.setString(6, txtSalarioFuncionario.getText());
                pst.setString(7, jTextAreaDescricaoFuncionario.getText());
                pst.setString(8, txtLoginFuncionario.getText());
                pst.setString(9, new String(jPasswordFieldSenhaFuncionario.getPassword()));
                pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Funcionario cadastrado com sucesso!");
                limparCampos();

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar o funcionario." + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCadastrarFuncionarioActionPerformed

    private void txtLoginFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginFuncionarioActionPerformed

    private void txtIdadeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeFuncionarioActionPerformed

    private void btnCancelarCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroFuncionarioActionPerformed
        // TODO add your handling code here:
        limparCampos();
        dispose();
    }//GEN-LAST:event_btnCancelarCadastroFuncionarioActionPerformed

    private void btnLimparCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadastroFuncionarioActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnLimparCadastroFuncionarioActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TelaCadastroFuncionario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarFuncionario;
    private javax.swing.JButton btnCancelarCadastroFuncionario;
    private javax.swing.JButton btnLimparCadastroFuncionario;
    private javax.swing.JComboBox<String> jComboBoxFuncionarioCargo;
    private javax.swing.JComboBox<String> jComboBoxSexoFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCargoFuncionario;
    private javax.swing.JLabel jLabelDescricaoFuncionario;
    private javax.swing.JLabel jLabelIdadeFuncionario;
    private javax.swing.JLabel jLabelLoginFuncionario;
    private javax.swing.JLabel jLabelNomeFuncionario;
    private javax.swing.JLabel jLabelSalarioFuncionario;
    private javax.swing.JLabel jLabelSenhaFuncionario;
    private javax.swing.JPasswordField jPasswordFieldSenhaFuncionario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescricaoFuncionario;
    private javax.swing.JTextField txtIdFuncionario;
    private javax.swing.JTextField txtIdadeFuncionario;
    private javax.swing.JTextField txtLoginFuncionario;
    private javax.swing.JTextField txtNomeFuncionario;
    private javax.swing.JTextField txtSalarioFuncionario;
    private javax.swing.JTextField txtxCPFFuncionario;
    // End of variables declaration//GEN-END:variables

}
