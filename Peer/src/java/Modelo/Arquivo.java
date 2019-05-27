package Modelo;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import Controle.TorrentFilesManage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Helbert Monteiro
 */
public class Arquivo {
    
    private String       nome;
    private double       tamanhoArquivo;
    private int          tamanhoVetor;
    private String       hashArquivo;
    
    public Arquivo(File file) throws IOException, NoSuchAlgorithmException{
        this.nome           = file.getName();
        this.tamanhoArquivo = file.length() / 1024 + 1;
        this.tamanhoVetor   = (int) file.length();
        this.hashArquivo    = new TorrentFilesManage().getHashCode(new TorrentFilesManage().CreateFullArrayFromFile(file));
    }
    
}