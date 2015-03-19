//package modele;

import java.util.*;

public class Categorie{
    private String NomCateg;
    private Couleur color;

    
    public Categorie(){}
    public Categorie(String n,Couleur c){
	this.NomCateg = n;
	this.color = c;;
    }
    public Categorie(Categorie c){
	this.NomCateg = c.NomCateg;
	this.color = c.color;
    }

    public String getNomCateg(){return this.NomCateg;}
    public Couleur getCouleur(){return this.color;}

    public void setNomCateg(String n){this.NomCateg = n;}
    public void setCouleur(Couleur c){this.color = c;}
    
    public String toString(){
	return this.NomCateg+"("+this.color+")";
    }
    
}