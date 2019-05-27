/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import Modelo.Arquivo;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Helbert Monteiro
 */
@Path("peer")
public class PeerWebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PeerWebService
     */
    public PeerWebService() {
    }

    /**
     * Retrieves representation of an instance of webservice.PeerWebService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PeerWebService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @Path("/lista")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() throws IOException, NoSuchAlgorithmException{
        
        List<Arquivo> listaArquivos = new ArrayList<>();
        
        File diretorio = new File("C:\\ThorEnt");
        File[] arquivos = diretorio.listFiles();
        
        for(int i = 0; i < arquivos.length; i++){
            Arquivo arquivo = new Arquivo(arquivos[i]);
            listaArquivos.add(arquivo);
        }
        
        return new Gson().toJson(listaArquivos);
        
    }
}
