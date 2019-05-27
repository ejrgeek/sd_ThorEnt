package modelo;

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
    
    public String getNome(){
        return nome;
    }
    
    public double getTamanhoArquivo(){
        return tamanhoArquivo;
    }
    
    public int getTamanhoVetor(){
        return tamanhoVetor;
    }
    
    public String getHashArquivo(){
        return hashArquivo;
    }
    
}