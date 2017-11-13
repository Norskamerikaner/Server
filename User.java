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
public class User {
    String username;
    String password;
    String ipAddress;
    boolean loggedIn;
    
    ArrayList<User> whoIAmFollowing = new ArrayList<>();
    ArrayList<User> peopleFollowingMe = new ArrayList<>();
    
    ArrayList<Message> tweets = new ArrayList<>();
    
    public User(String username, String password, String ip) {
        this.username = username;
        this.password = password;
        ipAddress = ip;
        loggedIn = false;
    }
}
