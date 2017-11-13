/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Clayton
 */
public class ServerAction {

    static HashMap<String, User> users = new HashMap<>();
    static ArrayList<Conversation> conversations = new ArrayList<>();
    
    public static boolean registerUser(String username, String password, String ip){
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password, ip));
        return true;
    }
    
    public static boolean logIn(String username, String password, String ip){
        if (!users.containsKey(username)) {
            return false;
        }
        
        User user = users.get(username);
        
        if (!user.password.equals(password)) { return false; }
        user.ipAddress = ip;
        return user.loggedIn = true;
    }
    
    public static boolean logOut(String username){
        if (!users.containsKey(username)) {
            return false;
        }
        
        User user = users.get(username);
        
        user.loggedIn = false;
        return true;
    }
    
    public static boolean addFollower(String currentUser, String toFollow){
        if (!users.containsKey(currentUser)) {
            return false;
        }
        
        users.get(currentUser).whoIAmFollowing.add(users.get(toFollow));
        users.get(toFollow).peopleFollowingMe.add(users.get(currentUser));
        
        return true;
    }
    
    public static boolean sendMessage(String username, String message, String hashtag){
        if (!users.containsKey(username)) {
            return false;
        }
        
        User user = users.get(username);
        
        user.tweets.add(new Message(message, hashtag));
        
        return true;
    }
    
    public static boolean sendPvtMessage(String sender, String receiver, String body, String hashtag){
        if (!users.containsKey(sender) || !users.containsKey(receiver)) {
            return false;
        }
        
        Conversation pairConvo;
        for (Conversation convo : conversations) {
            if ((convo.user1.equals(sender) 
                    || convo.user1.equals(receiver)) &&
                    (convo.user2.equals(sender)
                    || convo.user2.equals(receiver))) {
                pairConvo = convo;
                break;
            }
        }
        
        conversations.add((pairConvo = new Conversation(users.get(sender), users.get(receiver))));
        
        pairConvo.allMessages.add(new PrivateMessage(body, hashtag, sender));
        
        return true;
    }
}
