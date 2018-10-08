/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Example.ResponseMessage;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;





/**
 *
 * @author Bena
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException {

        Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
       WebTarget webTarget = client.target("http://localhost:49819/api").path("region/1");
 
        Invocation.Builder invocationBuilder =  
                webTarget.request(MediaType.APPLICATION_JSON);
        
        Response response 
            = invocationBuilder.get();
        String responseMessage = response.readEntity(String.class);
        JSONObject jsonObj = new JSONObject(responseMessage);
        System.out.println(jsonObj.get("respuesta"));
        
    }
    
}
