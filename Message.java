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
public class Message {
    Date dateStamp;
    String body;
    String hashtag;
    
    public Message(String bd, String ht) {
        dateStamp = new Date();
        body = bd;
        hashtag = ht;
    }
}
