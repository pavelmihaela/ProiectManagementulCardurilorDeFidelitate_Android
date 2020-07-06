package com.example.myapplication;

public class Magazin {

    private String Titlu;
    private String Categorie;
    private String Descriere;
    private int Thumbnail;

    public Magazin() {


    }

    public Magazin(String titlu, String categorie, String descriere, int thumbnail) {
        Titlu = titlu;
        Categorie=categorie;
        Descriere = descriere;
        Thumbnail = thumbnail;
    }


    public String getTitlu() {
        return Titlu;
    }

    public void setTitlu(String titlu) {
        Titlu = titlu;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String categorie) {
        Categorie = categorie;
    }

    public String getDescriere() {
        return Descriere;
    }

    public void setDescriere(String descriere) {
        Descriere = descriere;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
