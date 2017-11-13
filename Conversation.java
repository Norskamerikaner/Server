/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.ArrayList;

/**
 *
 * @author Clayton
 */
public class Conversation {
    User user1;
    User user2;
    
    ArrayList<PrivateMessage> allMessages = new ArrayList<>();
    
    public Conversation(User u1, User u2) {
        user1 = u1;
        user2 = u2;
    }
    
}
