/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Arquivo;
import Modelo.DownloadFileModel;
import Modelo.DownloadFile;
import Modelo.Listas;
import Modelo.PeerModelo;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

/**
 *
 * @author Raphael Felipe
 */
public class TorrentFilesManage {
    
    public static final int TAMANHO_BLOCO = 1000;

    /**
     *
     */
    public TorrentFilesManage() {}
    
    /**
     * 
     *<b>Autor: Raphael Felipe.</b><br><br>
     *<b>DESCRIÇÂO:</b><br>
     *  Gera um HashCode MD5 do array de bytes.
     *<br><br>
     *<b>PARÂMETROS:</b><br>
     *  <i>byte[] array</i> : Array de bytes.
     *<br><br>
     *<b>RETORNO:</b><br> 
     *  <i>String hash</i> : HashCode referente ao array de bytes.
     *<br><br>
     * 
     *@throws java.security.NoSuchAlgorithmException
     */  
    public String getHashCode(byte[] array) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(array);
        return new BigInteger(md.digest()).toString(16);
    }
    /**
     * 
     *<b>Autor: Raphael Felipe.</b><br><br>
     *<b>DESCRIÇÂO:</b><br>
  Faz uma varredura na pasta de LISTA_ARQUIVOS e compara o hash de cada um<br>
     *  com o hash informado no parâmetro.
     *<br><br>
     *<b>PARÂMETROS:</b><br>
     *  <i>String hash</i> : Hash MD5 do arquivo escolhido para download.
     *<br><br>
     *<b>RETORNO:</b><br> 
     *  <i>File file</i> : Arquivo referente ao hash especificado.
     *<br><br>
     * 
     *@throws java.security.NoSuchAlgorithmException
     *@throws java.io.IOException
     */
    public File getFileByHash(String hash) throws IOException, NoSuchAlgorithmException{
        
        for(int i = 0; i < Listas.LISTA_ARQUIVOS.size(); i++){
            if( hash.equals(Listas.LISTA_ARQUIVOS.get(i).getHashArquivo()) ){
                File file = new File("C:\\ThorEnt\\"+Listas.LISTA_ARQUIVOS.get(i).getNome());
                return file;
            }
               
        }
        
        return null;
    }
    
    
    /**
     *<b>Autor: Raphael Felipe.</b><br><br>
     *<b>DESCRIÇÂO:</b><br>
     *  Gera um HashCode MD5 do array de bytes.
     *<br><br> 
     *<b>PARÂMETROS:</b><br>
     *<i>  String dir</i> : Diretório onde o arquivo será salvo.<br>
     *<i>  byte[] fileBytes</i> : Array de bytes necessários para montar um arquivo.<br> 
     *
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void createFileFromByteArray(String dir, byte[] fileBytes) throws FileNotFoundException, IOException{
        FileOutputStream fullArray = new FileOutputStream(dir);
        fullArray.write(fileBytes);
        fullArray.close();
    }
    
    /**
     *<b>Autor: Raphael Felipe.</b><br><br>
     *<b>DESCRIÇÂO:</b><br>
     *  Cria um array de bytes apartir de um arquivo.
     *<br><br> 
     *<b>PARÂMETROS:</b><br>
     *<i>   File fileName</i> : Nome ou Diretório do arquivo existente.<br>
     *<br><br> 
     *<b>RETORNO:</b><br> 
     *<i>   byte[] BytesArray</i> : Array de bytes do arquivo especificado.<br>
     * 
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public byte[] createFullArrayFromFile(String fileName) throws FileNotFoundException, IOException{
        File file = new File(fileName);
        int lengthFullArray = (int) file.length();
        byte[] fullArray = new byte[lengthFullArray];
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        in.close();
        return fullArray;
    }
    /**
     *<b>Autor: Raphael Felipe.</b><br><br>
     *<b>DESCRIÇÂO:</b><br>
     *  Cria um array de bytes apartir de um arquivo.<br>
     *<br><br> 
     *<b>PARÂMETROS:</b><br>
     *<i>   File fileName</i> : Arquivo existente que conterá as informações do Array.<br>
     *<br><br> 
     *<b>RETORNO:</b><br> 
     *<i>   byte[] BytesArray - Array de bytes do arquivo especificado.<br>
     * 
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */   
    public byte[] createFullArrayFromFile(File fileName) throws FileNotFoundException, IOException, NoSuchAlgorithmException{
        
        File file = fileName;
        int lengthFullArray = (int) file.length();
        byte[] fullArray = new byte[lengthFullArray];
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        in.close();
        return fullArray;
    } 
    
    /**
     *<b>Autor: Raphael Felipe.</b><br><br>
     *<b>DESCRIÇÂO:</b><br>
     *  Cria um pedaço de array de bytes apartir de um arquivo. Especifique<br>
     *  corretamente o incício e o fim do pedaço do array do arquivo.
     *<br><br> 
     *<b>PARÂMETROS:</b><br>
     *<i>   String fileName</i> : Nome ou Diretório do arquivo existente.<br>
     *<i>   int startIndex</i> : Posição inicial de onde o array será copiado.<br>
     *<i>   int endIndex</i> : Posição final de onde o array será copiado.<br>
     *<br><br> 
     *<b>RETORNO:</b><br>
     *<i>   byte[] BytesArray</i> : Array de bytes do arquivo especificado.<br>
     *  
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */ 
    public byte[] createPackArrayFromFile(String fileName, int startIndex, int endIndex) throws FileNotFoundException, IOException, NoSuchAlgorithmException{
        File file = new File(fileName);
        int lengthFullArray = (int) file.length();
        int lengthPackArray = (int) (endIndex - startIndex) + 1;
        byte[] fullArray = createFullArrayFromFile(file);
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        
        int x = startIndex;
        byte[] packArray = new byte[lengthPackArray];
        
        for(int i = 0; i < lengthPackArray; i++){
            packArray[i] = fullArray[x];
            x++;
        }
        in.close();
        return packArray;
    }

    /**
     *<b>Autor: Raphael Felipe.</b><br><br>
     *<b>DESCRIÇÂO:</b><br>
     *  Cria um pedaço de array de bytes apartir de um arquivo. Especifique<br>
     *  corretamente o incício e o fim do pedaço do array do arquivo.
     *<br><br> 
     *<b>PARÂMETROS:</b><br>
     *<i>   File fileName</i> : Arquivo existente que conterá as informações do Array.<br>
     *<i>   int startIndex</i> : Posição inicial de onde o array será copiado.<br>
     *<i>   int endIndex</i> : Posição final de onde o array será copiado.<br>
     *<br><br> 
     *<b>RETORNO:</b><br>
     *<i>   byte[] BytesArray</i> : Array de bytes do arquivo especificado.<br>
     *  
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */ 
    public byte[] createPackArrayFromFile(File fileName, int startIndex, int endIndex) throws FileNotFoundException, IOException, NoSuchAlgorithmException{
        File file = fileName;
        int lengthFullArray = (int) file.length();
        int lengthPackArray = (int) (endIndex - startIndex) + 1;
        byte[] fullArray = createFullArrayFromFile(file);
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        
        int x = startIndex;
        byte[] packArray = new byte[lengthPackArray];
        
        for(int i = 0; i < lengthPackArray; i++){
            packArray[i] = fullArray[x];
            x++;
        }
        in.close();
        return packArray;
    }    
    
    public String downloadBytesFile(String params) throws IOException, NoSuchAlgorithmException{
        Gson gson = new Gson();
        
        File toDownload = getFileByHash(params);
        if(toDownload != null){
            return new Gson().toJson(createFullArrayFromFile(toDownload));//servidor retorna esse array via post
        }else{
            System.out.println("Arquivo não encontrado.");
            return null;
        }//ou retorna null se o arquivo não for encontrado
    }
    
    public List<Arquivo> participar(String ipTracker) throws UnknownHostException, IOException, NoSuchAlgorithmException{
        Listas.LISTA_ARQUIVOS = new ArrayList<>();
        
        new File("C:\\ThorEnt").mkdir();
        try{
            String ip = InetAddress.getLocalHost().getHostAddress();
            PeerModelo peer = new PeerModelo();
            Listas.LISTA_ARQUIVOS = peer.getArquivos();
            peer = new PeerModelo(ip, Listas.LISTA_ARQUIVOS);
            String jsonPeer = new Gson().toJson(peer);

            String url = "http://"+ipTracker+":8080/Tracker/webresources/tracker/participar";

            new Conexao().conectaWebService(url, jsonPeer, "POST");
            
            return Listas.LISTA_ARQUIVOS;
        }catch(Exception erro){
            System.out.println("Participar: " + erro.getMessage());
            return null;
        }
    }
    
    public List<Arquivo> getTrackerList(String ipTracker){
        List<Arquivo> listaArquivo = new ArrayList<>();
        Type listTypeArquivo = new TypeToken<ArrayList<Arquivo>>(){}.getType(); 
        String url = "http://"+ipTracker+":8080/Tracker/webresources/tracker/listar";
        listaArquivo = new Gson().fromJson(new Conexao().conectaWebService(url, null, "GET"), listTypeArquivo);
        return listaArquivo;
    }
    
}
