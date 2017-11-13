/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author student
 */
public class ServerListener {
    
    public static void main(String args[]){
/*        //test registration 1
        System.out.println(ServerAction.registerUser("Clayton", "badpassword", "1.0.0.127"));
        //test registration 2
        System.out.println(ServerAction.registerUser("Kyle", "anotherbadpassword", "1.0.0.129"));
        //test message
        System.out.println(ServerAction.sendMessage("Clayton", "This is a new message", "#software"));
        //test adding a follower
        System.out.println(ServerAction.addFollower("Clayton", "Kyle"));
        //test private message
        System.out.println(ServerAction.sendPvtMessage("Clayton", "Kyle", "This is a new private message", "#software"));
    }
*/
	try {

	    // Create the server socket that will be used to accept
	    // incoming connections
	    ServerSocket listen = new ServerSocket(2001); // Bind to any port

	    System.out.println( "Listening on port:  " +
				listen.getLocalPort() );
            System.out.println("Listening on address: " +
                    InetAddress.getLocalHost());

	    // Process clients
	    while (true) {
		Socket client = listen.accept();
		PrintWriter out =
		    new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

                String line = in.readLine();
                if (line.equals("REGISTER")){
                    out.println("OK");
                    line = in.readLine();
                    String username = line;
                    out.println("OK");
                    line = in.readLine();
                    if (line.equals("PASSWORD")){
                        out.println("OK");
                        line = in.readLine();
                        String password = line;
                        out.println("OK");
                        line = in.readLine();
                        if (line.equals("IP")){
                            out.println("OK");
                            line = in.readLine();
                            String ip = line;
                            if (ServerAction.registerUser(username, password, ip)){
                                out.println("OK");
                            }
                        }     
                    }  
                }
                if (line.equals("LOGON")){
                    out.println("OK");
                    line = in.readLine();
                    String username = line;
                    out.println("OK");
                    line = in.readLine();
                    if (line.equals("PASSWORD")){
                        out.println("OK");
                        line = in.readLine();
                        String password = line;
                        out.println("OK");
                        line = in.readLine();
                        if (line.equals("IP")){
                            out.println("OK");
                            line = in.readLine();
                            String ip = line;
                            if (ServerAction.logIn(username, password, ip)){
                                out.println("OK");
                            }
                        }     
                    }  
                }
                if (line.equals("LOGOFF")){
                    out.println("OK");
                    line = in.readLine();
                    String username = line;
                    out.println("OK");
                    ServerAction.logOut(username); 
                }
                if (line.equals("SENDMESSAGE")){
                    out.println("OK");
                    line = in.readLine();
                    String username = line;
                    out.println("OK");
                    line = in.readLine();
                    if(line.equals("BODY")){
                        out.println("OK");
                        line = in.readLine();
                        String body = line;
                        out.println("OK");
                        if(line.equals("HASHTAG")){
                            out.println("OK");
                            line = in.readLine();
                            String hashtag = line;
                            if (ServerAction.sendMessage(username, body, hashtag)){
                                out.println("OK");
                            }
                        }
                    }
                }
                if (line.equals("ADDFOLLOW")){
                    out.println("OK");
                    line = in.readLine();
                    String follower = line;
                    out.println("OK");
                    line = in.readLine();
                    if(line.equals("FOLLOW")){
                        out.println("OK");
                        line = in.readLine();
                        String tofollow = line;
                        if (ServerAction.addFollower(follower, tofollow)){
                            out.println("OK");
                        }
                    }
                }
                if (line.equals("FOLLOWLIST")){
                    out.println("OK");
                    line = in.readLine();
                    String username = line;
                    out.println("OK");
                }
		out.close();
		client.close();
	    }
	} catch(IOException e) {
	    System.err.println(e.getMessage());
	}
    }    
}
