/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import Modelo.PeerModelo;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import controle.Conexao;
import java.io.File;

/**
 *
 * @author Helbert Monteiro
 */

public class Peer {
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException{
        participar();
        //runSystemCommand("ping 10.53.0.13");
        /*try {
       InetAddress address = InetAddress.getByName("101.153.0.17");
       System.out.println("Name: " + address.getHostName());
       System.out.println("Addr: " + address.getHostAddress());
       System.out.println("Reach: " + address.isReachable(3000));
     }
     catch (UnknownHostException e) {
       System.err.println("Unable to lookup web.mit.edu");
     }
     catch (IOException e) {
       System.err.println("Unable to reach web.mit.edu");
     }*/
    }
    
    public static void participar() throws UnknownHostException, IOException, NoSuchAlgorithmException{
        new File("C:\\ThorEnt").mkdir();
        try{
            String ip = InetAddress.getLocalHost().getHostAddress();
            PeerModelo peer = new PeerModelo();
            peer = new PeerModelo(ip, peer.setArquivos());
            String jsonPeer = new Gson().toJson(peer);

            System.out.println(jsonPeer);

            String url = "http://localhost:8080/Tracker/webresources/tracker/participar";

            Conexao.conectaWSPP(url, jsonPeer, "POST");
        }catch(Exception erro){
            System.out.println("Participar: " + erro.getMessage());
        }
    }
    
    public static void ping(String ipAddress)throws UnknownHostException, IOException{ 
        InetAddress geek = InetAddress.getByName(ipAddress);
        System.out.println("Sending Ping Request to " + ipAddress);
        if (geek.isReachable(5000)){
            System.out.println("Host is reachable");
        }else{
            System.out.println("Sorry ! We can't reach to this host");
        }
    }
    
    public static void runSystemCommand(String command) {

		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(p.getInputStream()));

			String s = "";
			// reading output stream of the command
			while ((s = inputStream.readLine()) != null) {
				System.out.println(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}