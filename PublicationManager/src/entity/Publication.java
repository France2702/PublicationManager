/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phap Chau
 */
import java.io.Serializable;
import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "publication")
@XmlAccessorType(XmlAccessType.FIELD)
public class Publication implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String type;
    private String genre;
    private String author;
    private int price;
    private String abs;
    
    // Constructor
    public Publication(){
        
    }
    
    public Publication(int id, String title, String author, String type, String genre, int price, String abs) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
        this.genre = genre;
        this.price = price;
        this.abs = abs;
    }
    
    // Getter methods
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getType() {
        return type;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getAbstract() {
        return abs;
    }
    // Setter methods
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setAbstract(String abs) {
        this.abs = abs;
    }

    @Override
    public String toString(){
        return "[Publication|Id: " + this.id + ", Title: " + this.title + ", Author: "+ this.author+ ", Type: " + this.type 
        + ", Genre: "+ this.genre + ", Price: "+this.price+"].";
    }
    
    // Method to generate a random code for the publication
    private String generateCode() {
        int length = 10;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}
