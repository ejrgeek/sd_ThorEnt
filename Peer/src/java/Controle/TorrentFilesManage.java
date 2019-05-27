/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Raphael Felipe
 */
public class TorrentFilesManage {

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

    public File getFileByHash(String hash) throws IOException, NoSuchAlgorithmException{
        
        File diretorio = new File("C:\\ThorEnt");
        File[] arquivos = diretorio.listFiles();
        
        for(int i = 0; i < arquivos.length; i++){
           if( hash.equals(getHashCode(createFullArrayFromFile(arquivos[i]))) )
               return arquivos[i];
        }
        
        return null;
    }
    
    
    /**
     *<b>Autor: Raphael Felipe.</b><br><br>
     *<b>DESCRIÇÂO:</b><br>
     *  Gera um HashCode MD5 do array de bytes.
     *<br><br> 
     *<b>PARÂMETROS:</b><br>
     *<i>  String fileName</i> : Nome ou Diretório do arquivo vazio(novo).<br>
     *<i>  byte[] fileBytes</i> : Array de bytes necessários para montar um arquivo.<br> 
     *
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public void createFileFromByteArray(String fileName, byte[] fileBytes) throws FileNotFoundException, IOException{
        FileOutputStream fullArray = new FileOutputStream(fileName);
        fullArray.write(fileBytes);
    }
    /**
     *<b>Autor: Raphael Felipe.</b><br><br>
     *<b>DESCRIÇÂO:</b><br>
     *  Gera um HashCode MD5 do array de bytes.
     *<br><br> 
     *<b>PARÂMETROS:</b><br>
     *<i>   String fileName</i> : Arquivo vazio (novo) que conterá as informações do Array.<br>
     *<i>   byte[] fileBytes</i> : Array de bytes necessarios para montar um arquivo.<br> 
     *
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */    
    public void createFileFromByteArray(File fileName, byte[] fileBytes) throws FileNotFoundException, IOException{
        FileOutputStream fullArray = new FileOutputStream(fileName);
        fullArray.write(fileBytes);
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
    public byte[] createFullArrayFromFile(File fileName) throws FileNotFoundException, IOException{
        File file = fileName;
        int lengthFullArray = (int) file.length();
        byte[] fullArray = new byte[lengthFullArray];
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        
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
    public byte[] createPackArrayFromFile(String fileName, int startIndex, int endIndex) throws FileNotFoundException, IOException{
        File file = new File(fileName);
        int lengthFullArray = (int) file.length();
        int lengthPackArray = (int) endIndex - startIndex;
        byte[] fullArray = createFullArrayFromFile(file);
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        
        int x = startIndex;
        byte[] packArray = new byte[lengthPackArray];
        
        for(int i = 0; i < lengthPackArray; i++){
            packArray[i] = fullArray[x];
            x++;
        }
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
    public byte[] createPackArrayFromFile(File fileName, int startIndex, int endIndex) throws FileNotFoundException, IOException{
        File file = fileName;
        int lengthFullArray = (int) file.length();
        int lengthPackArray = (int) endIndex - startIndex;
        byte[] fullArray = createFullArrayFromFile(file);
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        
        int x = startIndex;
        byte[] packArray = new byte[lengthPackArray];
        
        for(int i = 0; i < lengthPackArray; i++){
            packArray[i] = fullArray[x];
            x++;
        }
        return packArray;
    }    
    
    public byte[] createPackArrayFromFile(File fileName, int partsNumber) throws FileNotFoundException, IOException{
        File file = fileName;
        int lengthFullArray = (int) file.length();
        int lengthPackArray = lengthFullArray/partsNumber;
        int restSize = lengthFullArray - ((int)lengthPackArray * partsNumber);
        byte[] fullArray = createFullArrayFromFile(file);
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        
        int x = partsSize*(part+1);
        byte[] packArray = new byte[lengthPackArray];
        
        for(int i = 0; i < lengthPackArray; i++){
            packArray[i] = fullArray[x];
            x++;
        }
        return packArray;
    }      
    
    public byte[][] createPacksFromFile(String fileName, int peersNumber, int partsSize){
        File file = new File(fileName);
        
    }
    
    public File downloadFile(String fileName){
        
        return new File("");
    }
    
}
