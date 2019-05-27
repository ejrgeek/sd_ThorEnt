/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

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

    public TorrentFilesManage() {}
    
    //Gera um HashCode MD5 do array de bytes
    public String getHashCode(byte[] array) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(array);
        return new BigInteger(md.digest()).toString(16);
    }
    
    //Cria um arquivo no apatir de um array de bytes
    public void CreateFileFromByteArray(String fileName, byte[] fileBytes) throws FileNotFoundException, IOException{
        FileOutputStream fullArray = new FileOutputStream(fileName);
        fullArray.write(fileBytes);
    }
    
    public void CreateFileFromByteArray(File fileName, byte[] fileBytes) throws FileNotFoundException, IOException{
        FileOutputStream fullArray = new FileOutputStream(fileName);
        fullArray.write(fileBytes);
    }
    
    //Cria um array de bytes apartir de um arquivo
    public byte[] CreateFullArrayFromFile(String fileName) throws FileNotFoundException, IOException{
        File file = new File(fileName);
        int lengthFullArray = (int) file.length();
        byte[] fullArray = new byte[lengthFullArray];
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        
        return fullArray;
    }
    
    public byte[] CreateFullArrayFromFile(File fileName) throws FileNotFoundException, IOException{
        File file = fileName;
        int lengthFullArray = (int) file.length();
        byte[] fullArray = new byte[lengthFullArray];
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        
        return fullArray;
    }    
    
    //Cria um pedaço de array de bytes apartir de um arquivo
    public byte[] CreatePackArrayFromFile(String fileName, int startIndex, int endIndex) throws FileNotFoundException, IOException{
        File file = new File(fileName);
        int lengthFullArray = (int) file.length();
        int lengthPackArray = (int) endIndex - startIndex;
        byte[] fullArray = CreateFullArrayFromFile(file);
        
        FileInputStream in = new FileInputStream(file);
        in.read(fullArray);
        
        int x = startIndex;
        byte[] packArray = new byte[lengthPackArray];
        
        for(int i = startIndex; i < lengthPackArray; i++){
            packArray[i] = fullArray[x];
            x++;
        }
        return packArray;
    }
    
}
