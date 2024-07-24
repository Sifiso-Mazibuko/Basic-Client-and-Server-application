
package echoserverapp;

import java.io.*;
import java.net.*;

/**
 *
 * @author Student
 */
public class EchoServerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try{
            
            ServerSocket s = new ServerSocket(9999); 
            System.out.println("Server starting: " + s);
            
            //wait for connection
            Socket socket = s.accept();
            System.out.println("Communication established....");
            
            //creating a reaidng and writinfg stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            
            //read data form client ansd display it, and send it back
            
            while(true){
            
                //read data
                String data = in.readLine();
                
                //check if data is not end
                
                if(data.endsWith("END")){
                
                    break;
                }
                else{
                    //diplsy the data
                    System.out.println(data);
                    
                    //send it back - echo
                    out.println(data);
                }
            }
            
        }
        catch(UnknownHostException ex){
            ex.printStackTrace();
        }
        catch(IOException ioe){
        
            ioe.printStackTrace();
        }
    }
    
}
