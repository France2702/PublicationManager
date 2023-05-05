/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Phap Chau
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.PubDao;
import entity.Publication;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import view.PubView;

public class PubController {
    private PubDao pubDao;
    private PubView pubView;

    public PubController(PubView view) {
        this.pubView = view;
        pubDao = new PubDao();

        view.addAddPublicationListener(new AddPublicationListener());
        view.addUpdatePublicationListener(new UpdatePublicationListener());
        view.addDeletePublicationListener(new DeletePublicationListener());
        view.addClearListener(new ClearPublicationListener());
        view.addSortPublicationListener(new SortPublicationListener());
        view.addSearchPublicationListenerbtnSearch(new SearchPublicationListenerbtnSearch());
        view.addSearchPublicationListenertextFieldFind(new SearchPublicationListenertextFieldFind());
        view.addSearchPublicationListenercbFind(new SearchPublicationListenercbFind());
        view.addRefreshPublicationListener(new RefreshPublicationListener());
        view.addListPublicationSelectionListener(new ListPublicationSelectionListener());
    }

    public void showPublicationView() {
        List<Publication> publicationList = pubDao.getListPublications();
        pubView.setVisible(true);
        pubView.showListPublications(publicationList);
    }

    /**
     * Lớp AddPublicationListener 
     * chứa cài đặt cho sự kiện click button "Add"
     * 
     */
    class AddPublicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Publication pub = pubView.getPublicationInfo();
            if (pub != null) {
                pubDao.add(pub);
                pubView.showPublication(pub);
                pubView.showListPublications(pubDao.getListPublications());
                pubView.showMessage("Add new publication successfully!");
            }
        }
    }

    /**
     * Lớp UpdatePublicationListener 
     * chứa cài đặt cho sự kiện click button "Update"
     * 
     */
    class UpdatePublicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Publication student = pubView.getPublicationInfo();
            if (student != null) {
                pubDao.update(student);
                pubView.showPublication(student);
                pubView.showListPublications(pubDao.getListPublications());
                pubView.showMessage("Update this publication successfully!");
            }
        }
    }

    /**
     * Lớp DeletePublicationListener 
     * chứa cài đặt cho sự kiện click button "Delete"
     */
    class DeletePublicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Publication student = pubView.getPublicationInfo();
            if (student != null) {
                pubDao.delete(student);
                pubView.clearPublicationInfo();
                pubView.showListPublications(pubDao.getListPublications());
                pubView.showMessage("Delete this publication successfully!");
            }
        }
    }

    /**
     * Lớp ClearPublicationListener 
     * chứa cài đặt cho sự kiện click button "Clear"
     */
    class ClearPublicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            pubView.clearPublicationInfo();
        }
    }

    /**
     * Lớp SortPublicationListener 
     * chứa cài đặt cho sự kiện chọn các item tương ứng trong cbArrange
     */
    class SortPublicationListener implements ItemListener {
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
                String selectedItem = (String) e.getItem();
                switch(selectedItem) {
            case "ID" -> {
                pubDao.sortPublicationById();
                pubView.showListPublications(pubDao.getListPublications());
                }
            case "Title" -> {
                pubDao.sortPublicationByTitle();
                pubView.showListPublications(pubDao.getListPublications());
                }
            case "Author" -> {
                pubDao.sortPublicationByAuthor();
                pubView.showListPublications(pubDao.getListPublications());
                }
            case "Type" -> {
                pubDao.sortPublicationByType();
                pubView.showListPublications(pubDao.getListPublications());
                }
            case "Genre" -> {
                pubDao.sortPublicationByGenre();
                pubView.showListPublications(pubDao.getListPublications());
                }
            case "Price" -> {
                pubDao.sortPublicationByPrice();
                pubView.showListPublications(pubDao.getListPublications());
                }
            default -> pubView.showMessage("Invalid option type!");
            }
        }
    }
    }

    /**
     * Lớp SearchPublicationListener 
     * chứa cài đặt cho sự kiện click cac item tuong ung cua cbFind
     * 
     */
    class SearchPublicationListenerbtnSearch implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedItem = pubView.getSelectedItemFind();
            String textFind = pubView.getTextFind();
            if (textFind == null || "".equals(textFind.trim())) {
                pubView.showMessage("The content in Search field can not be blank!");
            } else {
            //List<Publication> result = new ArrayList<Publication>();
                switch(selectedItem) {
            case "ID" -> {
                try {
                    int id = Integer.parseInt(textFind);
                    if (id <= 0) {
                        pubView.showMessage("The ID is not valid because it must be greater than 0.");
                    } else {
                        //result = pubDao.searchPublicationById(Integer.parseInt(textFind));
                        pubView.showListPublications(pubDao.searchPublicationById(id));
                    }
                } catch (NumberFormatException event) {
                    pubView.showMessage("The ID field is not valid. It must be integer number.");
                }
                }
            case "Title" -> {
                //result = pubDao.searchPublicationByTitle(textFind);
                pubView.showListPublications(pubDao.searchPublicationByTitle(textFind));
                }
            case "Author" -> {
                //result = pubDao.searchPublicationByAuthor(textFind);
                pubView.showListPublications(pubDao.searchPublicationByAuthor(textFind));
                }
            case "Type" -> {
                //result = pubDao.searchPublicationByType(textFind);
                pubView.showListPublications(pubDao.searchPublicationByType(textFind));
                }
            case "Genre" -> {
                //result = pubDao.searchPublicationByGenre(textFind);
                pubView.showListPublications(pubDao.searchPublicationByGenre(textFind));
                }
            case "Price" -> {
                try {
                    int price = Integer.parseInt(textFind);
                    if (price < 0) {
                        pubView.showMessage("The Price is not valid because it must be greater than 0.");
                    } else {
                        //result = pubDao.searchPublicationById(Integer.parseInt(textFind));
                        pubView.showListPublications(pubDao.searchPublicationByPrice(price));
                    }
                } catch (NumberFormatException event) {
                    pubView.showMessage("The Price field is not valid. It must be integer number.");
                }
                }
            default -> pubView.showMessage("Invalid option!");
            }
            } 
        }
    }
    
    class SearchPublicationListenertextFieldFind implements KeyListener {
        public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String selectedItem = pubView.getSelectedItemFind();
            String textFind = pubView.getTextFind();
            if (textFind == null || "".equals(textFind.trim())) {
                pubView.showMessage("The content in Search field can not be blank!");
            } else {
            //List<Publication> result = new ArrayList<Publication>();
                switch(selectedItem) {
            case "ID" -> {
                try {
                    int id = Integer.parseInt(textFind);
                    if (id <= 0) {
                        pubView.showMessage("The ID is not valid because it must be greater than 0.");
                    } else {
                        //result = pubDao.searchPublicationById(Integer.parseInt(textFind));
                        pubView.showListPublications(pubDao.searchPublicationById(id));
                    }
                } catch (NumberFormatException event) {
                    pubView.showMessage("The ID field is not valid. It must be integer number.");
                }
                }
            case "Title" -> {
                //result = pubDao.searchPublicationByTitle(textFind);
                pubView.showListPublications(pubDao.searchPublicationByTitle(textFind));
                }
            case "Author" -> {
                //result = pubDao.searchPublicationByAuthor(textFind);
                pubView.showListPublications(pubDao.searchPublicationByAuthor(textFind));
                }
            case "Type" -> {
                //result = pubDao.searchPublicationByType(textFind);
                pubView.showListPublications(pubDao.searchPublicationByType(textFind));
                }
            case "Genre" -> {
                //result = pubDao.searchPublicationByGenre(textFind);
                pubView.showListPublications(pubDao.searchPublicationByGenre(textFind));
                }
            case "Price" -> {
                try {
                    int price = Integer.parseInt(textFind);
                    if (price < 0) {
                        pubView.showMessage("The Price is not valid because it must be greater than 0.");
                    } else {
                        //result = pubDao.searchPublicationById(Integer.parseInt(textFind));
                        pubView.showListPublications(pubDao.searchPublicationByPrice(price));
                    }
                } catch (NumberFormatException event) {
                    pubView.showMessage("The Price field is not valid. It must be integer number.");
                }
                }
            default -> pubView.showMessage("Invalid option!");
            }
            } 
        }
        }
            // Implement the remaining KeyListener methods
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }
    
    class SearchPublicationListenercbFind implements  ItemListener {
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
            String selectedItem = (String) e.getItem();
            String textFind = pubView.getTextFind();
            if (textFind == null || "".equals(textFind.trim())) {
                pubView.showMessage("The content in Search field can not be blank!");
            } else {
            //List<Publication> result = new ArrayList<Publication>();
                switch(selectedItem) {
            case "ID" -> {
                try {
                    int id = Integer.parseInt(textFind);
                    if (id <= 0) {
                        pubView.showMessage("The ID is not valid because it must be greater than 0.");
                    } else {
                        //result = pubDao.searchPublicationById(Integer.parseInt(textFind));
                        pubView.showListPublications(pubDao.searchPublicationById(id));
                    }
                } catch (NumberFormatException event) {
                    pubView.showMessage("The ID field is not valid. It must be integer number.");
                }
                }
            case "Title" -> {
                //result = pubDao.searchPublicationByTitle(textFind);
                pubView.showListPublications(pubDao.searchPublicationByTitle(textFind));
                }
            case "Author" -> {
                //result = pubDao.searchPublicationByAuthor(textFind);
                pubView.showListPublications(pubDao.searchPublicationByAuthor(textFind));
                }
            case "Type" -> {
                //result = pubDao.searchPublicationByType(textFind);
                pubView.showListPublications(pubDao.searchPublicationByType(textFind));
                }
            case "Genre" -> {
                //result = pubDao.searchPublicationByGenre(textFind);
                pubView.showListPublications(pubDao.searchPublicationByGenre(textFind));
                }
            case "Price" -> {
                try {
                    int price = Integer.parseInt(textFind);
                    if (price < 0) {
                        pubView.showMessage("The Price is not valid because it must be greater than 0.");
                    } else {
                        //result = pubDao.searchPublicationById(Integer.parseInt(textFind));
                        pubView.showListPublications(pubDao.searchPublicationByPrice(price));
                    }
                } catch (NumberFormatException event) {
                    pubView.showMessage("The Price field is not valid. It must be integer number.");
                }
                }
            default -> pubView.showMessage("Invalid option!");
            }
            }
        }
        }
    }
    
    class RefreshPublicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           pubDao.sortPublicationById();
           pubView.showListPublications(pubDao.getListPublications());
        }
    }

    /**
     * Lớp ListPublicationSelectionListener 
     * chứa cài đặt cho sự kiện chọn student trong bảng student
     * 
     * @author viettuts.vn
     */
    class ListPublicationSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            pubView.fillPublicationFromSelectedRow();
        }
    }
}
