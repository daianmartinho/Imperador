/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import excecao.AniversarianteNaoEncontradoException;
import java.awt.CardLayout;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Aniversariante;
import modelo.Festa;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AniversarianteAppService;

/**
 *
 * @author Daian Martinho
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    public static AniversarianteAppService aniversarianteAppService;
    static {
        @SuppressWarnings("resource")
        ApplicationContext fabrica = new ClassPathXmlApplicationContext("beans-jpa.xml");
        aniversarianteAppService = (AniversarianteAppService) fabrica.getBean("aniversarianteAppService");
    }
    public FramePrincipal() {
        initComponents();
        
       
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inicioBtn = new javax.swing.JButton();
        aniversariantesBtn = new javax.swing.JButton();
        festasBtn = new javax.swing.JButton();
        bodyContainer = new javax.swing.JPanel();
        inicioPainel = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<String>();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<String>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<String>();
        aniversariantesPainel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaDeAniversariantes = new javax.swing.JTable();
        novoAniversarianteBtn = new javax.swing.JButton();
        buscarAniversarianteBtn = new javax.swing.JButton();
        campoBuscarAniversariante = new javax.swing.JTextField();
        campoBuscarAniversariante1 = new javax.swing.JTextField();
        festasPainel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaDeFestas = new javax.swing.JTable();
        novaFestaBtn = new javax.swing.JButton();
        buscarFestaBtn = new javax.swing.JButton();
        campoBuscaFesta = new javax.swing.JTextField();
        campoBuscaFesta1 = new javax.swing.JTextField();
        campoBuscaFesta2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Trajan Pro 3", 0, 18)); // NOI18N
        jLabel1.setText("Imperador");

        inicioBtn.setText("In�cio");
        inicioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioBtnActionPerformed(evt);
            }
        });

        aniversariantesBtn.setText("Aniversariantes");
        aniversariantesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aniversariantesBtnActionPerformed(evt);
            }
        });

        festasBtn.setText("Festas");
        festasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                festasBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inicioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aniversariantesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(festasBtn)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(inicioBtn)
                    .addComponent(aniversariantesBtn)
                    .addComponent(festasBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bodyContainer.setLayout(new java.awt.CardLayout());

        inicioPainel.setBorder(null);
        inicioPainel.setDividerLocation(240);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aniversariantes do m�s"));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        inicioPainel.setLeftComponent(jScrollPane1);

        jSplitPane2.setBorder(null);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pr�ximas festas"));

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jSplitPane2.setTopComponent(jScrollPane2);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Notifica��es"));

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jSplitPane2.setRightComponent(jScrollPane3);

        inicioPainel.setRightComponent(jSplitPane2);

        bodyContainer.add(inicioPainel, "inicioCard");

        tabelaDeAniversariantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaDeAniversariantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDeAniversariantesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaDeAniversariantesMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaDeAniversariantes);

        novoAniversarianteBtn.setText("Novo Aniversariante");
        novoAniversarianteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoAniversarianteBtnActionPerformed(evt);
            }
        });

        buscarAniversarianteBtn.setText("Buscar");
        buscarAniversarianteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAniversarianteBtnActionPerformed(evt);
            }
        });

        campoBuscarAniversariante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscarAniversarianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aniversariantesPainelLayout = new javax.swing.GroupLayout(aniversariantesPainel);
        aniversariantesPainel.setLayout(aniversariantesPainelLayout);
        aniversariantesPainelLayout.setHorizontalGroup(
            aniversariantesPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aniversariantesPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aniversariantesPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addGroup(aniversariantesPainelLayout.createSequentialGroup()
                        .addComponent(novoAniversarianteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(271, 271, 271)
                        .addComponent(buscarAniversarianteBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, aniversariantesPainelLayout.createSequentialGroup()
                        .addComponent(campoBuscarAniversariante1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoBuscarAniversariante, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        aniversariantesPainelLayout.setVerticalGroup(
            aniversariantesPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aniversariantesPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aniversariantesPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoAniversarianteBtn)
                    .addComponent(buscarAniversarianteBtn))
                .addGap(5, 5, 5)
                .addGroup(aniversariantesPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBuscarAniversariante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBuscarAniversariante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bodyContainer.add(aniversariantesPainel, "aniversariantesCard");

        tabelaDeFestas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaDeFestas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDeFestasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaDeFestasMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaDeFestas);

        novaFestaBtn.setText("Nova festa");
        novaFestaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaFestaBtnActionPerformed(evt);
            }
        });

        buscarFestaBtn.setText("Buscar");
        buscarFestaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFestaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout festasPainelLayout = new javax.swing.GroupLayout(festasPainel);
        festasPainel.setLayout(festasPainelLayout);
        festasPainelLayout.setHorizontalGroup(
            festasPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(festasPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(festasPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, festasPainelLayout.createSequentialGroup()
                        .addGroup(festasPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                            .addGroup(festasPainelLayout.createSequentialGroup()
                                .addComponent(novaFestaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(336, 336, 336)))
                        .addGap(20, 20, 20))
                    .addGroup(festasPainelLayout.createSequentialGroup()
                        .addGroup(festasPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscarFestaBtn)
                            .addGroup(festasPainelLayout.createSequentialGroup()
                                .addComponent(campoBuscaFesta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoBuscaFesta1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoBuscaFesta2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        festasPainelLayout.setVerticalGroup(
            festasPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, festasPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(festasPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novaFestaBtn)
                    .addComponent(buscarFestaBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(festasPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBuscaFesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBuscaFesta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBuscaFesta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bodyContainer.add(festasPainel, "festasCard");
        festasPainel.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bodyContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bodyContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(501, 412));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inicioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioBtnActionPerformed
        
        CardLayout lm = (CardLayout) bodyContainer.getLayout();
        lm.show(bodyContainer, "inicioCard");
    }//GEN-LAST:event_inicioBtnActionPerformed

    private void aniversariantesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aniversariantesBtnActionPerformed
        CardLayout lm = (CardLayout)bodyContainer.getLayout();
        TabelaDeAniversariantesModel model = new TabelaDeAniversariantesModel();
        model.setBusca("");
        tabelaDeAniversariantes.setModel(model);
        lm.show(bodyContainer,"aniversariantesCard");
    }//GEN-LAST:event_aniversariantesBtnActionPerformed

    private void buscarFestaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFestaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarFestaBtnActionPerformed

    private void novaFestaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaFestaBtnActionPerformed
        DialogFesta dialog = new DialogFesta(this,true);
        dialog.novo(true);
        dialog.setVisible(true);
    }//GEN-LAST:event_novaFestaBtnActionPerformed

    private void tabelaDeFestasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDeFestasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaDeFestasMousePressed

    private void tabelaDeAniversariantesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDeAniversariantesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaDeAniversariantesMousePressed

    private void novoAniversarianteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoAniversarianteBtnActionPerformed
        DialogAniversariante dialog = new DialogAniversariante(this,true);
        dialog.novo();
        dialog.setTabelaParaUpdate(tabelaDeAniversariantes);
        dialog.setVisible(true);
        
    }//GEN-LAST:event_novoAniversarianteBtnActionPerformed

    private void buscarAniversarianteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAniversarianteBtnActionPerformed
        TabelaDeAniversariantesModel model = new TabelaDeAniversariantesModel();
        
        model.setBusca(campoBuscarAniversariante.getText());
        tabelaDeAniversariantes.setModel(model);
    }//GEN-LAST:event_buscarAniversarianteBtnActionPerformed

    private void festasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_festasBtnActionPerformed
        CardLayout lm = (CardLayout)bodyContainer.getLayout();
        TabelaDeFestasModel model = new TabelaDeFestasModel();        
        tabelaDeFestas.setModel(model);
        lm.show(bodyContainer,"festasCard");
    }//GEN-LAST:event_festasBtnActionPerformed

    private void tabelaDeFestasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDeFestasMouseClicked
        if(evt.getClickCount()==2){
            long festaID = (long)tabelaDeFestas.getModel().getValueAt(tabelaDeFestas.getSelectedRow(),0);
            DialogFesta dialog = new DialogFesta(this,true);
            dialog.setFesta(festaID);
            dialog.salvo();
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_tabelaDeFestasMouseClicked

    private void tabelaDeAniversariantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDeAniversariantesMouseClicked
        if(evt.getClickCount()==2){
            long aniversarianteID = (long)tabelaDeAniversariantes.getModel().getValueAt(tabelaDeAniversariantes.getSelectedRow(),0);
            DialogAniversariante dialog = new DialogAniversariante(this,true);
            dialog.setTabelaParaUpdate(tabelaDeAniversariantes);
            dialog.setAniversariante(aniversarianteID);
            dialog.salvo();
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_tabelaDeAniversariantesMouseClicked

    private void campoBuscarAniversarianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscarAniversarianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscarAniversarianteActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aniversariantesBtn;
    private javax.swing.JPanel aniversariantesPainel;
    private javax.swing.JPanel bodyContainer;
    private javax.swing.JButton buscarAniversarianteBtn;
    private javax.swing.JButton buscarFestaBtn;
    private javax.swing.JTextField campoBuscaFesta;
    private javax.swing.JTextField campoBuscaFesta1;
    private javax.swing.JTextField campoBuscaFesta2;
    private javax.swing.JTextField campoBuscarAniversariante;
    private javax.swing.JTextField campoBuscarAniversariante1;
    private javax.swing.JButton festasBtn;
    private javax.swing.JPanel festasPainel;
    private javax.swing.JButton inicioBtn;
    private javax.swing.JSplitPane inicioPainel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JButton novaFestaBtn;
    private javax.swing.JButton novoAniversarianteBtn;
    private javax.swing.JTable tabelaDeAniversariantes;
    private javax.swing.JTable tabelaDeFestas;
    // End of variables declaration//GEN-END:variables
}
