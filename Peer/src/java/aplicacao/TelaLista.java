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
import com.google.gson.Gson;
import Controle.Conexao;
import Modelo.DownloadFileModel;
import Modelo.Listas;
import Modelo.PeerModelo;
import static aplicacao.TelaPrincipal.listaArquivos;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

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
        progressBar.setStringPainted(false);
    }
    
    List<Arquivo> arquivos = new ArrayList<>();
    TorrentFilesManage  tfm = new TorrentFilesManage();
    
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
        progressBar = new javax.swing.JProgressBar();

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

        progressBar.setBackground(new java.awt.Color(0, 20, 10));
        progressBar.setForeground(new java.awt.Color(0, 206, 149));
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGap(260, 260, 260))
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
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
    
    public void atualizar(){
        try {
            listaArquivos = new TorrentFilesManage().participar(Conexao.IP_TRACKER);
        } catch (IOException ex) {
            Logger.getLogger(TelaLista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TelaLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "http://localhost:8080/Peer/webresources/peer/salvar/";
        new Conexao().conectaWebService(url, new Gson().toJson(listaArquivos), "POST");
        arquivos = tfm.getTrackerList(Conexao.IP_TRACKER);
        tblListaDeArquivos.removeAll();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Nome do Arquivo","Tamanho (kb)"});
        tblListaDeArquivos.setModel(model);
        for(int i = 0; i < arquivos.size(); i++){
            for(int j = 0; j < Listas.LISTA_ARQUIVOS.size(); j++){
                if(arquivos.get(i).gethashFile().equals(Listas.LISTA_ARQUIVOS.get(j).gethashFile())){
                    break;
                }
                if(j == Listas.LISTA_ARQUIVOS.size() - 1 && !arquivos.get(i).gethashFile().equals(Listas.LISTA_ARQUIVOS.get(j).gethashFile())){
                    model.addRow(new Object[]{arquivos.get(i).getNome(),arquivos.get(i).getTamanhoArquivo()});
                }
            }
        //model.addRow(new Object[]{arquivos.get(i).getNome(),arquivos.get(i).getTamanhoArquivo()});
        }
    }
    
    private void btnAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarMouseClicked
        atualizar();
    }//GEN-LAST:event_btnAtualizarMouseClicked

    public TelaLog telaLog = new TelaLog();
    private void btnDownloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDownloadMouseClicked
        int fileLine = tblListaDefiles.getSelectedRow();
        String fileName = tblListaDefiles.getModel().getValueAt(fileLine, 0).toString();
        file file = new file();
        for(int i = 0; i < files.size(); i++){
            if(files.get(i).getName().equals(fileName)){
                file = files.get(i);
            }
        }

        //PREPARANDO PEERS PARA CONEXAO
        int    arrayLength   = 200;//file.getTamanhoVetor();
        int    numberOfPeers    = file.getPeer().size();
        int    l               = 0;
        int[]  initialVector = new int[arrayLength];
        byte[] finalVector;
        int    blockLength   = (int) arrayLength / (numberOfPeers * 5);

        int progress = 0;
        progressBar.setMinimum(0);
        progressBar.setMaximum(arrayLength-1);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        List<Thread> threadArrayList = new ArrayList<>();

        List<PeerModel> peers = new ArrayList<>();
        PeerModel peer;

        for(int i = 0; i < file.getPeer().size(); i ++){
            peer = new PeerModel();
            peer.setIp(file.getPeer().get(i));
            peer.setAvailability(true);
            peers.add(peer);
        }

        for(int i = 0; i < initialVector.length; i++) {
            initialVector[i] = 200;
        }

        telaLog.logArea.append("fazendo download...\n");
        telaLog.logArea.append("file: " + file.getName());
        telaLog.logArea.append("Tamanho: " + file.getFileLength());

        System.out.println("fazendo download...\n");
        System.out.println("arquivo: " + file.getName());
        System.out.println("Tamanho: " + file.getFileLength());

        for(int i = 0; i < initialVector.length; i++){
            if(initialVector[i] < -128 || initialVector[i] > 127){
                for(int j = 0; j < numero_peers; j++){
                    if(peers.get(j).getAvailability()){
                        int ii = i;
                        i += blockLength;
                        int jj = j;
                        String hashFile = file.gethashFile();
                        String name = file.getName();
                        Thread thread;

                        thread = createThread(peer);


                        threadArrayList.add(thread, blockLength);
                        thread.start();
                    }else{
                        l = j;
                        while(!peers.get(l).getAvailability()){
                            //System.out.println("peer off " + peers.get(l).getIp());
                            l++;
                            if(l >= peers.size()){
                                //System.out.println("recomeça lista de peers...");
                                l = 0;
                            }
                        }
                        j = l - 1;
                    }
                }
                i--;
            }
            progress++;
            progressBar.setStringPainted(true);
            progressBar.setValue(progress);
            telaLog.logArea.append(progressBar.getString()+"\n");
        }
     
        
        //VERIFICANDO SE AS THREADS JA ENCERRARAM
        checkIfTheThreadsHaveTerminated(threadArrayList);
        
        //SALVANDO ARQUIVO DO DOWNLOAD
        saveDownloadFile(finalVector, initialVector, file);

        atualizar();
        
    }//GEN-LAST:event_btnDownloadMouseClicked

    Thread createThread(PeerModel peer, int blockLength){
        return new Thread(new Runnable() {
            @Override
            public void run() {
                peers.get(jj).setAvailability(false);
                int initicalBlock = ii;
                telaLog.logArea.append("Peer escolhido " + peers.get(jj).getIp() + ": pacote " + initicalBlock);
                System.out.println("Peer escolhido " + peers.get(jj).getIp() + ": pacote " + initicalBlock);
                DownloadFileModel downloadFile = new DownloadFileModel();
                String url = "http://"+peers.get(jj).getIp()+":8080/Peer/webresources/peer/download/"+blockLength+"/"+initicalBlock+"/"+hashFile;
                try{
                    String jsonDownload = new Conexao().conectaWebService(url, null, "GET");
                    if(!jsonDownload.equals(null)){
                        downloadFile = new Gson().fromJson(jsonDownload, downloadFile.class);
                        peers.get(jj).setAvailability(true);

                        byte[] smallerVector = new byte[downloadFile.getVetor().length];
                        smallerVector = downloadFile.getVetor();
                        String hash = new TorrentFilesManage().getHashCode(smallerVector);
                        if(hash.equals(downloadFile.getHash())){
                            telaLog.logArea.append("hash vetor ok: pacote " + initicalBlock);
                            System.out.println("hash vetor ok: pacote " + initicalBlock);
                            for(int k = 0; k < smallerVector.length; k++){
                                if(initicalBlock < tamanho_vetor){
                                    initialVector[initicalBlock] = smallerVector[k];
                                    initicalBlock++;
                                }
                            }
                            //i += smallerVector.length;
                        }else{
                            System.out.println("not");
                            for(int k = 0; k < smallerVector.length; k++){
                                if(initicalBlock < tamanho_vetor){
                                    initialVector[initicalBlock] = -200;
                                    initicalBlock++;
                                }
                            }
                            //i = initicalBlock;
                        }
                    }else{
                        peers.get(jj).setAvailability(false);
                    }
                }catch(JsonSyntaxException | NoSuchAlgorithmException erro){
                    System.out.println("Erro na thread: " + erro.getMessage());
                }
            }
        });
    }

    saveDownloadFile(byte[] finalVector, int[] initialVector, File file){

        finalVector = new byte[initialVector.length];

        for(int i = 0; i < initialVector.length; i++){
            finalVector[i] = (byte) initialVector[i];
        }
        telaLog.logArea.append("verificando...");
        System.out.println("verificando...");
        try {
            if(new TorrentFilesManage().getHashCode(finalVector).equals(file.gethashFile())){
                new TorrentFilesManage().createFileFromByteArray("C://ThorEnt//" + file.getNome(), finalVector);
                System.out.println("ok");
                System.out.println("salvo!");
            }else{
                telaLog.logArea.append("Hash incorreto");
                telaLog.logArea.append("Hash esperado: " + file.gethashFile());
                telaLog.logArea.append("Hash do arquivo baixado: " + new TorrentFilesManage().getHashCode(finalVector));
                System.out.println("Hash incorreto");
                System.out.println("Hash esperado: " + file.gethashFile());
                System.out.println("Hash do arquivo baixado: " + new TorrentFilesManage().getHashCode(finalVector));
            }
            //new TorrentFilesManage().createFileFromByteArray("C://ThorEnt//testando.jpg", finalVector);
        } catch (Exception ex) {
            telaLog.logArea.append("Salvar arquivo: " + ex.getMessage());
            System.out.println("Salvar arquivo: " + ex.getMessage());
            Logger.getLogger(TelaLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    checkIfTheThreadsHaveTerminated(List<Thread> threadArrayList){
        int index = threadArrayList.size();
        while(index > 0){
            for(int i = 0; i < threadArrayList.size(); i++){
                if(!threadArrayList.get(i).isAlive()){
                    threadArrayList.remove(threadArrayList.get(i));
                    index--;
                    telaLog.logArea.append("Threads abertas: " + index);
                    System.out.println("Threads abertas: " + index);
                }
            }
        }
        progressBarprogressBar.setStringPainted(false);
        telaLog.logArea.append("download feito!\n");
        System.out.println("download feito!\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar progressBar;
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
