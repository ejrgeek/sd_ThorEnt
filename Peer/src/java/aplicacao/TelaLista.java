/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import Controle.TorrentFilesManage;
import java.util.ArrayList;
import java.util.List;
import Modelo.Arquivo;
import Modelo.DownloadFile;
import com.google.gson.Gson;
import controle.Conexao;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raphael Felipe
 */
public class TelaLista extends javax.swing.JPanel {

    /**
     * Creates new form telalog
     */
    public TelaLista() {
        initComponents();
    }
    
    public List<Arquivo> arquivos = new ArrayList<>();
    public TorrentFilesManage  tfm = new TorrentFilesManage();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnDownload = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaDeArquivos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAtualizar = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 20, 10));
        jPanel1.setPreferredSize(new java.awt.Dimension(391, 420));
        jPanel1.setRequestFocusEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lista de arquivos para download:");

        jPanel2.setBackground(new java.awt.Color(0, 206, 149));

        btnDownload.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        btnDownload.setForeground(new java.awt.Color(255, 255, 255));
        btnDownload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDownload.setText("D O W N L O A D");
        btnDownload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDownload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDownloadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(btnDownload)
                .addContainerGap())
        );

        tblListaDeArquivos.setBackground(new java.awt.Color(0, 206, 149));
        tblListaDeArquivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Arquivo", "Tamanho"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListaDeArquivos);

        jPanel3.setBackground(new java.awt.Color(0, 206, 149));

        btnAtualizar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAtualizar.setText("Atualizar lista");
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAtualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGap(260, 260, 260))
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarMouseClicked
        for(int i = 0; i < arquivos.size(); i++){
            tblListaDeArquivos.setValueAt(arquivos.get(i).getNome(), i, 0);
            tblListaDeArquivos.setValueAt(arquivos.get(i).getTamanhoArquivo(), i, 1);
        }
    }//GEN-LAST:event_btnAtualizarMouseClicked

    private void btnDownloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDownloadMouseClicked
        /*int linha = tblListaDeArquivos.getSelectedRow();
        String nomeArquivo = tblListaDeArquivos.getModel().getValueAt(linha, 0).toString();
        Arquivo arquivo = new Arquivo();
        for(int i = 0; i < arquivos.size(); i++)
            if(arquivos.get(i).getNome().equals(nomeArquivo))
                arquivo = arquivos.get(i);
        System.out.println(arquivo.getNome()+" "+arquivo.getTamanhoArquivo()+" "+arquivo.getHashArquivo());*/
        
        String url = "http://localhost:8080/Peer/webresources/peer/download/" + "-3ffd12faa5199c68a9be017ced264b8a";
        
        try {
            tfm.createFileFromByteArray("C:\\teste\\teste.jpg", new Gson().fromJson(new Conexao().conectaWSGD(url, "GET"), byte[].class));
        } catch (IOException ex) {
            Logger.getLogger(TelaLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, new Conexao().conectaWSGD(url, "GET"));
        
    }//GEN-LAST:event_btnDownloadMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtualizar;
    private javax.swing.JLabel btnDownload;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaDeArquivos;
    // End of variables declaration//GEN-END:variables
}
