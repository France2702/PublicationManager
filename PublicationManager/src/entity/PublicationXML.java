/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phap Chau
 */
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "publications")
@XmlAccessorType(XmlAccessType.FIELD)
public class PublicationXML {
    
    private List<Publication> publication;

    public List<Publication> getPublication() {
        return publication;
    }

    public void setPublication(List<Publication> publication) {
        this.publication = publication;
    }
}
