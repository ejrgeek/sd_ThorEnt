/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import Modelo.PeerModelo;
import static com.google.common.base.CharMatcher.is;
import com.google.gson.Gson;
import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import servidor.Conexao;
import static sun.nio.cs.Surrogate.is;
import java.io.*;
import java.net.*;

/**
 *
 * @author Helbert Monteiro
 */

public class Peer {
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException{
        runSystemCommand("ping 10.53.0.13");
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




        //runSystemCommand("ping 10.0.0.103");
        //participar();
    
    public static void participar() throws UnknownHostException, IOException, NoSuchAlgorithmException{
        String ip = InetAddress.getLocalHost().getHostAddress();
        PeerModelo peer = new PeerModelo();
        peer = new PeerModelo(ip, peer.setArquivos());
        String jsonPeer = new Gson().toJson(peer);
        
        System.out.println(jsonPeer);
        
        String url = "http://localhost:8080/ThorEnt/webresources/tracker/participar";
        
        Conexao.conectaWSPP(url, jsonPeer, "POST");
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