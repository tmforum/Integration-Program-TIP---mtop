/*
 * BaseInstance.java
 *
 * Created on 9 juin 2007, 16:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mtopsimulatorappclient;

public class BaseInstance {
     protected String title;
     protected String artist;
     protected String album;

     public BaseInstance() {
         title = "";
         artist = "";
         album = "";
     }

     public String getTitle() {
         return title;
     }

     public void setTitle(String title) {
         this.title = title;
     }

     public String getArtist() {
         return artist;
     }

     public void setArtist(String artist) {
         this.artist = artist;
     }

     public String getAlbum() {
         return album;
     }

     public void setAlbum(String album) {
         this.album = album;
     }
 }
