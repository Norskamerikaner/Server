/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.Date;

/**
 *
 * @author Clayton
 */
public class PrivateMessage {
    Date dateStamp;
    private String body;
    private String hashtag;
    String sender;
    
    
    
    public PrivateMessage(String body, String hashtag, String sender) {
        dateStamp = new Date();
        this.body = body;
        this.hashtag = hashtag;
        this.sender = sender;
    }
}
