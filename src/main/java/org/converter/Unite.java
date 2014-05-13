/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter;

import java.util.logging.Logger;

/**
 *
 * @author Cyril
 */
public class Unite {

    /**
     * Type d'unité
     */
    private Grandeur grandeur;

    private String nom;

    private String symbole;
    
    /**
     * Constructeur par défaut
     */
    public Unite() {
        
    }
    
    public Grandeur getGrandeur() {
        return grandeur;
    }

    public void setGrandeur(Grandeur grandeur) {
        this.grandeur = grandeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    private static final Logger LOG = Logger.getLogger(Unite.class.getName());
}
