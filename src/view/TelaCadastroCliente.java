package view;

import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import controller.ConexaoBD;

public final class TelaCadastroCliente extends javax.swing.JFrame {

    private Statement st;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName());

    public TelaCadastroCliente() {
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
            txtCodigoCliente.setText(rs.getString("id"));
            txtNome.setText(rs.getString("nome"));
            txtCPF.setText(rs.getString("CPF"));
            txtIdade.setText(rs.getString("idade"));
            jComboBoxSexoCliente.setSelectedItem(rs.getString("sexo"));
            txtTelefone.setText(rs.getString("telefone"));
            txtemail.setText(rs.getString("email"));
            txtLogradouro.setText(rs.getString("logradouro"));
            txtNumeroCasa.setText(rs.getString("numeroCasa"));
            txtBairro.setText(rs.getString("bairro"));

        } catch (SQLException ex) {
        }
    }

    public void atualizarCampos() throws SQLException {
        txtCodigoCliente.setText(rs.getString("id"));
        txtNome.setText(rs.getString("nome"));
        txtCPF.setText(rs.getString("CPF"));
        txtIdade.setText(rs.getString("id"));
        jComboBoxSexoCliente.setSelectedItem(rs.getString("sexo"));
        txtTelefone.setText(rs.getString("telefone"));
        txtemail.setText(rs.getString("email"));
        txtLogradouro.setText(rs.getString("logradouro"));
        txtNumeroCasa.setText(rs.getString("numeroCasa"));
        txtBairro.setText(rs.getString("bairro"));
    }

    private void limparCampos() {
        txtCodigoCliente.setText("");
        txtNome.setText("");
        txtCPF.setText("");
        txtIdade.setText("");
        jComboBoxSexoCliente.setSelectedItem(null);
        txtTelefone.setText("");
        txtemail.setText("");
        txtLogradouro.setText("");
        txtNumeroCasa.setText("");
        txtBairro.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelDescricaoFuncionario = new javax.swing.JLabel();
        jComboBoxSexoCliente = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        btnCadastrarFuncionario = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnLimparCadastroFuncionario = new javax.swing.JButton();
        btnCancelarCadastroFuncionario = new javax.swing.JButton();
        txtNumeroCasa = new javax.swing.JPasswordField();
        jLabelNomeFuncionario = new javax.swing.JLabel();
        jLabelLoginFuncionario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLogradouro = new javax.swing.JTextField();
        txtCodigoCliente = new javax.swing.JTextField();
        jLabelIdadeFuncionario = new javax.swing.JLabel();
        jLabelSenhaFuncionario = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Clientes");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("jFrameTelaCadastroCliente"); // NOI18N

        jLabelDescricaoFuncionario.setText("Bairro");

        jComboBoxSexoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nao Informar", "Masculino", "Feminino" }));

        jLabel6.setText("Idade");

        txtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeActionPerformed(evt);
            }
        });

        btnCadastrarFuncionario.setText("Cadastrar");
        btnCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncionarioActionPerformed(evt);
            }
        });

        jLabel7.setText("Sexo");

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

        jLabelNomeFuncionario.setText("Nome");

        jLabelLoginFuncionario.setText("Endereço");

        jLabel1.setText("ID");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouroActionPerformed(evt);
            }
        });

        txtCodigoCliente.setEditable(false);

        jLabelIdadeFuncionario.setText("CPF");

        jLabelSenhaFuncionario.setText("N°");

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        jLabel2.setText("Contato");

        jLabel3.setText("Email");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLoginFuncionario)
                            .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSenhaFuncionario)
                            .addComponent(txtNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDescricaoFuncionario)
                            .addComponent(txtBairro)))
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomeFuncionario)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigoCliente)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdadeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jComboBoxSexoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnCadastrarFuncionario)
                        .addGap(20, 20, 20)
                        .addComponent(btnLimparCadastroFuncionario)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarCadastroFuncionario))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtemail)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeFuncionario)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelIdadeFuncionario)
                                .addGap(4, 4, 4)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxSexoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelLoginFuncionario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelSenhaFuncionario)
                                .addGap(24, 24, 24))))
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelDescricaoFuncionario)
                        .addGap(24, 24, 24)))
                .addGap(112, 112, 112)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarFuncionario)
                    .addComponent(btnLimparCadastroFuncionario)
                    .addComponent(btnCancelarCadastroFuncionario))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

    private void btnCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncionarioActionPerformed
        // TODO add your handling code here:
        try (Connection conexao = ConexaoBD.conectar()) {
            String nome = txtNome.getText().trim();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe o nome do cliente.");
                return;
            }
            String sqlVericaCliente = "SELECT ID FROM CLIENTES WHERE NOME = ?";
            try (PreparedStatement pstVerifica = conexao.prepareStatement(sqlVericaCliente)) {
                pstVerifica.setString(1, nome);
                try (ResultSet rsVerifica = pstVerifica.executeQuery()) {
                    if (rsVerifica.next()) {
                        JOptionPane.showMessageDialog(this, "Cliente ja cadastrado.");
                        return;
                    }
                }
            }
            String sqlInsert = "INSERT INTO CLIENTES (NOME, CPF, IDADE, TELEFONE, EMAIL, LOGRADOURO, NUMEROCASA, BAIRRO)"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            try (PreparedStatement pst = conexao.prepareStatement(sqlInsert)) {
                pst.setString(1, txtNome.getText());
                pst.setString(2, txtCPF.getText());
                pst.setString(3, txtIdade.getText());
                pst.setString(4, txtTelefone.getText());
                pst.setString(5, txtemail.getText());
                pst.setString(6, txtLogradouro.getText());
                pst.setString(7, txtNumeroCasa.getText());
                pst.setString(8, txtBairro.getText());
                pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Cliente cadastado com sucesso");
            limparCampos();
        }catch(SQLException ex){
            System.out.println("view.TelaCadastroCliente.btnCadastrarFuncionarioActionPerformed()" + ex.getMessage());
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnCadastrarFuncionarioActionPerformed

    private void btnLimparCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadastroFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparCadastroFuncionarioActionPerformed

    private void btnCancelarCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarCadastroFuncionarioActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouroActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TelaCadastroCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarFuncionario;
    private javax.swing.JButton btnCancelarCadastroFuncionario;
    private javax.swing.JButton btnLimparCadastroFuncionario;
    private javax.swing.JComboBox<String> jComboBoxSexoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDescricaoFuncionario;
    private javax.swing.JLabel jLabelIdadeFuncionario;
    private javax.swing.JLabel jLabelLoginFuncionario;
    private javax.swing.JLabel jLabelNomeFuncionario;
    private javax.swing.JLabel jLabelSenhaFuncionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtNumeroCasa;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables

