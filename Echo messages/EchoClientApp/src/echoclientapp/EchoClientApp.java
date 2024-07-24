
package echoclientapp;

import java.io.*;
import java.net.*;

/**
 *
 * @author Student
 */
public class EchoClientApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String msg = "Hola!";
        Socket socket = null;
        try{
            
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            System.out.println("Address: " + addr);
            
            //create a socket to send data to the server
            socket = new Socket(addr, 9999);
            System.out.println("Connection established.....");
            
            //create a reading and writing stream stream because it will receive back a response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            //end
            
            //send and receive
            //send hi five times to the server
            for(int x = 0; x < 10; x++){
            
                //display the messsage
                System.out.println("Client: " + msg);
                
                //send the message to the sever
                out.println(msg);
                
                //read the message sent back by the user
                String serverMsg = in.readLine();
                
                //display the message received from the sserver
                System.out.println("Server message: " + serverMsg);
            }
            
            out.println("END");
        }
        catch(UnknownHostException ex){
            
            ex.printStackTrace();
        }
        catch(IOException ioe){
            
            ioe.printStackTrace();
        }
        finally{
        
            System.out.println("Closing");
            
            try{
                
                socket.close();
            }
            catch(IOException ioe){
                
                ioe.printStackTrace();
            }
            
        }
    }
    
}
