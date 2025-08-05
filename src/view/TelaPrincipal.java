package view;

import controller.ConexaoBD;
import model.Cliente;
import model.Funcionario;
import model.Veiculo;
import model.Vaga;
import model.Locacao;
import javax.swing.JFrame;
import javax.swing.*;

public class TelaPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());

    private Cliente cliente;
    private Veiculo veiculo;
    private Funcionario funcionario;

    public TelaPrincipal() {
        initComponents();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        cliente = new Cliente();
        veiculo = new Veiculo();
        funcionario = new Funcionario();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemCadastroCliente = new javax.swing.JMenuItem();
        jMenuItemCadastroVeiculo = new javax.swing.JMenuItem();
        jMenuItemCadastarLocacao = new javax.swing.JMenuItem();
        jMenuItemCadastroVaga = new javax.swing.JMenuItem();
        jMenuItemCadastroFuncionario = new javax.swing.JMenuItem();
        jMenuPesquisar = new javax.swing.JMenu();
        jMenuItemPesquisaCliente = new javax.swing.JMenuItem();
        jMenuItemPesquisaVeiculo = new javax.swing.JMenuItem();
        jMenuItemPesuqisaVaga = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Garage 77 - Sistema Gestao de Vagas");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        // getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenuBar.setPreferredSize(new java.awt.Dimension(129, 26));

        jMenuCadastro.setText("Cadastro");
        jMenuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroActionPerformed(evt);
            }
        });

        jMenuItemCadastroCliente.setText("Cadastrar Cliente");
        jMenuItemCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroClienteActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroCliente);

        jMenuItemCadastroVeiculo.setText("Cadastrar Veiculo");
        jMenuItemCadastroVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroVeiculoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroVeiculo);

        jMenuItemCadastarLocacao.setText("Cadastrar Locação");
        jMenuItemCadastarLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastarLocacaoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastarLocacao);

        jMenuItemCadastroVaga.setText("Cadastrar Vaga");
        jMenuItemCadastroVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroVagaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroVaga);

        jMenuItemCadastroFuncionario.setText("Cadastrar Funcionario");
        jMenuItemCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroFuncionarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroFuncionario);

        jMenuBar.add(jMenuCadastro);

        jMenuPesquisar.setText("Pesquisar");

        jMenuItemPesquisaCliente.setText("Pesquisar Cliente");
        jMenuItemPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisaClienteActionPerformed(evt);
            }
        });
        jMenuPesquisar.add(jMenuItemPesquisaCliente);

        jMenuItemPesquisaVeiculo.setText("Pesquisar Veiculo");
        jMenuItemPesquisaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesquisaVeiculoActionPerformed(evt);
            }
        });
        jMenuPesquisar.add(jMenuItemPesquisaVeiculo);

        jMenuItemPesuqisaVaga.setText("Pesquisar Vaga");
        jMenuItemPesuqisaVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPesuqisaVagaActionPerformed(evt);
            }
        });
        jMenuPesquisar.add(jMenuItemPesuqisaVaga);

        jMenuItem1.setText("Pesquisar Locaçao");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuPesquisar.add(jMenuItem1);

        jMenuBar.add(jMenuPesquisar);

        setJMenuBar(jMenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jMenuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuCadastroActionPerformed

    private void jMenuItemCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroClienteActionPerformed
        TelaCadastroCliente telaCadCliente = new TelaCadastroCliente();
        telaCadCliente.setVisible(true);
        System.out.println("Aberto tela cadastro cliente.");
    }//GEN-LAST:event_jMenuItemCadastroClienteActionPerformed

    private void jMenuItemCadastroVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroVeiculoActionPerformed
        // TODO add your handling code here:
        TelaCadastroVeiculo telaCadVeiculo = new TelaCadastroVeiculo();
        telaCadVeiculo.setVisible(true);
        telaCadVeiculo.toFront();
        System.out.println("Aberto tela cadastro veiculo");
    }//GEN-LAST:event_jMenuItemCadastroVeiculoActionPerformed

    private void jMenuItemCadastroVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroVagaActionPerformed
        // TODO add your handling code here:
        TelaCadastroVaga telaCadVaga = new TelaCadastroVaga();
        telaCadVaga.setVisible(true);
        telaCadVaga.toFront();
        System.out.println("Aberto tela cadastro vaga");
    }//GEN-LAST:event_jMenuItemCadastroVagaActionPerformed

    private void jMenuItemPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisaClienteActionPerformed
        // TODO add your handling code here:
        TelaPesquisaCliente telaPesqCliente = new TelaPesquisaCliente();
        telaPesqCliente.setVisible(true);
        telaPesqCliente.toFront();
        System.out.println("Aberto tela pesquisa Cliente");
    }//GEN-LAST:event_jMenuItemPesquisaClienteActionPerformed

    private void jMenuItemPesquisaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesquisaVeiculoActionPerformed
        // TODO add your handling code here:
       

        System.out.println("Aberto tela pesquisa veiculo");
    }//GEN-LAST:event_jMenuItemPesquisaVeiculoActionPerformed

    private void jMenuItemPesuqisaVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPesuqisaVagaActionPerformed
        // TODO add your handling code here:
        TelaPesquisaVaga telaPesqVaga = new TelaPesquisaVaga();
        telaPesqVaga.setVisible(true);
        telaPesqVaga.toFront();
        System.out.println("Aberto tela pesquisa vaga");
    }//GEN-LAST:event_jMenuItemPesuqisaVagaActionPerformed

    private void jMenuItemCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroFuncionarioActionPerformed
        // TODO add your handling code here:
        TelaCadastroFuncionario telaCadFuncionario = new TelaCadastroFuncionario();
        telaCadFuncionario.setVisible(true);
        telaCadFuncionario.toFront();
        System.out.println("Aberto tela cadastro funcionario");
    }//GEN-LAST:event_jMenuItemCadastroFuncionarioActionPerformed

    private void jMenuItemCadastarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastarLocacaoActionPerformed
        // TODO add your handling code here:
        TelaCadastroLocacao telaCadLocacao = new TelaCadastroLocacao();
        telaCadLocacao.setVisible(true);
        telaCadLocacao.toFront();
        System.out.println("Aberto tela cadastro Locacao");

    }//GEN-LAST:event_jMenuItemCadastarLocacaoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSexoCliente;
    private javax.swing.ButtonGroup buttonGroupSexoFuncionario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemCadastarLocacao;
    private javax.swing.JMenuItem jMenuItemCadastroCliente;
    private javax.swing.JMenuItem jMenuItemCadastroFuncionario;
    private javax.swing.JMenuItem jMenuItemCadastroVaga;
    private javax.swing.JMenuItem jMenuItemCadastroVeiculo;
    private javax.swing.JMenuItem jMenuItemPesquisaCliente;
    private javax.swing.JMenuItem jMenuItemPesquisaVeiculo;
    private javax.swing.JMenuItem jMenuItemPesuqisaVaga;
    private javax.swing.JMenu jMenuPesquisar;
    // End of variables declaration//GEN-END:variables
}
