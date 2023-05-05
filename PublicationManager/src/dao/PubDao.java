/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Phap Chau
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.Publication;
import entity.PublicationXML;
import utils.FileUtils;

public class PubDao {
    private static final String PUBLICATION_FILE_NAME = "publication.xml";
    private List<Publication> listPublications;

    public PubDao() {
        this.listPublications = readListPublications();
        if (listPublications == null) {
            listPublications = new ArrayList<Publication>();
        }
    }

    /**
     * Lưu các đối tượng publication vào file publication.xml
     * 
     * @param publications
     */
    public void writeListPublications(List<Publication> publications) {
        PublicationXML publicationXML = new PublicationXML();
        publicationXML.setPublication(publications);
        FileUtils.writeXMLtoFile(PUBLICATION_FILE_NAME, publicationXML);
    }

    /**
     * Đọc các đối tượng publication từ file publication.xml
     * 
     * @return list publication
     */
    public List<Publication> readListPublications() {
        List<Publication> list = new ArrayList<Publication>();
        PublicationXML publicationXML = (PublicationXML) FileUtils.readXMLFile(
                PUBLICATION_FILE_NAME, PublicationXML.class);
        if (publicationXML != null) {
            list = publicationXML.getPublication();
        }
        return list;
    }
    

    /**
     * thêm publication vào listPublications và lưu listPublications vào file
     * 
     * @param publication
     */
    public void add(Publication publication) {
        int id = 1;
        if (listPublications != null && !listPublications.isEmpty()) {
            id = listPublications.size() + 1;
        }
        publication.setId(id);
        listPublications.add(publication);
        writeListPublications(listPublications);
    }

    /**
     * cập nhật publication vào listPublications và lưu listPublications vào file
     * 
     * @param publication
     */
    public void update(Publication publication) {
        int size = listPublications.size();
        for (int i = 0; i < size; i++) {
            if (listPublications.get(i).getId() == publication.getId()) {
                listPublications.get(i).setTitle(publication.getTitle());
                listPublications.get(i).setAuthor(publication.getAuthor());
                listPublications.get(i).setType(publication.getType());
                listPublications.get(i).setGenre(publication.getGenre());
                listPublications.get(i).setPrice(publication.getPrice());
                listPublications.get(i).setAbstract(publication.getAbstract());
                writeListPublications(listPublications);
                break;
            }
        }
    }

    /**
     * xóa publication từ listPublications và lưu listPublications vào file
     * 
     * @param publication
     * @return 
     */
    public boolean delete(Publication publication) {
        boolean isFound = false;
        int size = listPublications.size();
        for (int i = 0; i < size; i++) {
            if (listPublications.get(i).getId() == publication.getId()) {
                publication = listPublications.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listPublications.remove(publication);
            writeListPublications(listPublications);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách publication theo title, author, type, genre theo tứ tự tăng dần
     */
    public void sortPublicationByTitle() {
        //Collections.sort(listPublications, (Publication publication1, Publication publication2) -> publication1.getTitle().compareTo(publication2.getTitle()));
        Collections.sort(listPublications, new Comparator<Publication>() {
            public int compare(Publication publication1, Publication publication2) {
                return publication1.getTitle().compareTo(publication2.getTitle());
            }
        });
    }

    public void sortPublicationByAuthor() {
        Collections.sort(listPublications, (Publication publication1, Publication publication2) -> publication1.getAuthor().compareTo(publication2.getAuthor()));
    }
    
    public void sortPublicationByType() {
        Collections.sort(listPublications, (Publication publication1, Publication publication2) -> publication1.getType().compareTo(publication2.getType()));
    }
    
    public void sortPublicationByGenre() {
        Collections.sort(listPublications, (Publication publication1, Publication publication2) -> publication1.getGenre().compareTo(publication2.getGenre()));
    }
    /**
     * sắp xếp danh sách publication theo id, price theo tứ tự tăng dần
     */
    public void sortPublicationById() {
        Collections.sort(listPublications, (Publication publication1, Publication publication2) -> {
            if (publication1.getId() > publication2.getId()) {
                return 1;
            }
            return -1;
        });
    }
    
    public void sortPublicationByPrice() {
        Collections.sort(listPublications, (Publication publication1, Publication publication2) -> {
            if (publication1.getPrice() > publication2.getPrice()) {
                return 1;
            }
            return -1;
        });
    }
    
    public List<Publication> searchPublicationById(int id){
            List<Publication> result = new ArrayList<Publication>();
            for (Publication publication : listPublications) {
                if (publication.getId() == id) {
                    result.add(publication);
                    break;
                }
            }
        return result;
    }
    
    public List<Publication> searchPublicationByTitle(String title){
        List<Publication> result = new ArrayList<Publication>();
        for (Publication p : listPublications) {
            if (p.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(p);
            }
        }
        Collections.sort(result, new Comparator<Publication>() {
            @Override
            public int compare(Publication p1, Publication p2) {
                String t1 = p1.getTitle().toLowerCase();
                String t2 = p2.getTitle().toLowerCase();
                int i1 = t1.indexOf(title.toLowerCase());
                int i2 = t2.indexOf(title.toLowerCase());
                if (i1 == i2) {
                    return Integer.compare(t1.length(), t2.length());
                }
                return Integer.compare(i1, i2);
            }
        });
        return result;
    
    }
    
    public List<Publication> searchPublicationByAuthor(String author){
        List<Publication> result = new ArrayList<Publication>();
        for (Publication p : listPublications) {
            if (p.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(p);
            }
        }
        Collections.sort(result, new Comparator<Publication>() {
            @Override
            public int compare(Publication p1, Publication p2) {
                String t1 = p1.getAuthor().toLowerCase();
                String t2 = p2.getAuthor().toLowerCase();
                int i1 = t1.indexOf(author.toLowerCase());
                int i2 = t2.indexOf(author.toLowerCase());
                if (i1 == i2) {
                    return Integer.compare(t1.length(), t2.length());
                }
                return Integer.compare(i1, i2);
            }
        });
        return result;
    }
    
    public List<Publication> searchPublicationByType(String type){
        List<Publication> result = new ArrayList<Publication>();
        for (Publication p : listPublications) {
            if (p.getType().toLowerCase().contains(type.toLowerCase())) {
                result.add(p);
            }
        }
        Collections.sort(result, new Comparator<Publication>() {
            @Override
            public int compare(Publication p1, Publication p2) {
                String t1 = p1.getType().toLowerCase();
                String t2 = p2.getType().toLowerCase();
                int i1 = t1.indexOf(type.toLowerCase());
                int i2 = t2.indexOf(type.toLowerCase());
                if (i1 == i2) {
                    return Integer.compare(t1.length(), t2.length());
                }
                return Integer.compare(i1, i2);
            }
        });
        return result;
    }
    
    public List<Publication> searchPublicationByGenre(String genre){
        List<Publication> result = new ArrayList<Publication>();
        for (Publication p : listPublications) {
            if (p.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                result.add(p);
            }
        }
        Collections.sort(result, new Comparator<Publication>() {
            @Override
            public int compare(Publication p1, Publication p2) {
                String t1 = p1.getGenre().toLowerCase();
                String t2 = p2.getGenre().toLowerCase();
                int i1 = t1.indexOf(genre.toLowerCase());
                int i2 = t2.indexOf(genre.toLowerCase());
                if (i1 == i2) {
                    return Integer.compare(t1.length(), t2.length());
                }
                return Integer.compare(i1, i2);
            }
        });
        return result;
    }
    
    public List<Publication> searchPublicationByPrice(int price){
        ArrayList<Publication> result = new ArrayList<Publication>();
        double lowerBound = 0.5 * price;
        double upperBound = 1.5 * price;

        for (Publication pub : listPublications) {
            double pubPrice = pub.getPrice();
            if (pubPrice >= lowerBound && pubPrice <= upperBound) {
                result.add(pub);
            }
        }

        // Sort result by accuracy to the price parameter
        Collections.sort(result, new Comparator<Publication>() {
            @Override
            public int compare(Publication p1, Publication p2) {
                double diff1 = Math.abs(p1.getPrice() - price);
                double diff2 = Math.abs(p2.getPrice() - price);
                if (diff1 < diff2) {
                    return -1;
                } else if (diff1 > diff2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return result;
    }

    public List<Publication> getListPublications() {
        return listPublications;
    }

    public void setListPublications(List<Publication> listPublications) {
        this.listPublications = listPublications;
    }
}
