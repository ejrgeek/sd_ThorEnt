/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import controle.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Peer;

/**
 *
 * @author Helbert Monteiro
 */
public class TrackerDAO {
    
    private String            sql;
    private PreparedStatement preparedStatement;
    private ResultSet         resulSet;
    private boolean           retorno;
    
    public boolean inserirPeer(Peer peer){
        try{
            if(!verificaIp(peer.getIp())){
                sql               = "insert into peer (ip) values (?)";
                preparedStatement = Banco.getPreparedStatement(sql);
                preparedStatement.setString(1, peer.getIp());
                if(preparedStatement.executeUpdate() > 0){
                    retorno = inserirArquivo(peer);
                }
            }else{
                retorno = atualizaListaArquivos(peer);
            }
        }catch(SQLException erro){
            System.out.println("Inserir Peer: " + erro.getMessage());
            retorno = false;
        }
        return retorno;
    }
    
    private boolean verificaIp(String ip){
        sql               = "select ip from peer where ip = ?";
        preparedStatement = Banco.getPreparedStatement(sql);
        try{
            preparedStatement.setString(1, ip);
            resulSet = preparedStatement.executeQuery();
            if(resulSet.next()){
                return true;
            }else{
                return false;
            }
        }catch(SQLException erro){
            System.out.println("Verificar IP: " + erro.getMessage());
            return false;
        }
    }
    
    private boolean atualizaListaArquivos(Peer peer){
        sql               = "delete from arquivo where ip = ?";
        preparedStatement = Banco.getPreparedStatement(sql);
        try{
            preparedStatement.setString(1, peer.getIp());
            if(preparedStatement.executeUpdate()> 0){
                retorno = inserirArquivo(peer);
            }
        }catch(SQLException erro){
            System.out.println("Atualizar Lista de Arquivos: " + erro.getMessage());
            retorno = false;
        }
        return retorno;
    }
    
    private boolean inserirArquivo(Peer peer){
        for(int i = 0; i < peer.getArquivos().size(); i++){
            sql = "insert into arquivo (hashArquivo, nome, tamanhoArquivo, tamanhoVetor, ip) values (?, ?, ?, ?, ?)";
            preparedStatement = Banco.getPreparedStatement(sql);
            try{
                preparedStatement.setString(1, peer.getArquivos().get(i).getHashArquivo());
                preparedStatement.setString(2, peer.getArquivos().get(i).getNome());
                preparedStatement.setDouble(3, peer.getArquivos().get(i).getTamanhoArquivo());
                preparedStatement.setInt   (4, peer.getArquivos().get(i).getTamanhoVetor());
                preparedStatement.setString(5, peer.getIp());
                if(preparedStatement.executeUpdate() > 0){
                    retorno = true;
                }
            }catch(SQLException erro){
                System.out.println("Inserir Arquivo: " + erro.getMessage());
                retorno = false;
                break;
            }
        }
        return retorno;
    }
    
    private List<String> listarHash(){
        sql = "select distint hashArquivo from Arquivo";
        //0preparedStatement.
        return null;
    }
    
}
