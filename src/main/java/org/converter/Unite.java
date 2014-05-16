/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter;

import java.math.BigDecimal;
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

    /**
     * Nom de l'unité (Mètre, seconde, ...)
     */
    private String nom;

    /**
     * Symbole correspondant au nom (m, s, ...)
     */
    private String symbole;

    /**
     * Marque l'unité comme étalon de comparaison pour la conversion
     */
    private boolean isEtalon;

    /**
     * Ratio de conversion
     */
    private BigDecimal ratio;

    /*
     * Décalage éventuel, permet de faire des conversion de type ax + b où a est le ratio et b est le décalage
     */
    private BigDecimal decalage;

    /**
     * Constructeur par défaut
     */
    public Unite() {

    }

    /**
     * Constructeur avec paramètres d'initialisation
     *
     * @param grandeur
     * @param nom
     * @param symbole
     * @param isEtalon
     * @param ratio
     * @param decalage
     */
    public Unite(Grandeur grandeur, String nom, String symbole, boolean isEtalon, BigDecimal ratio, BigDecimal decalage) {
        this.grandeur = grandeur;
        this.nom = nom;
        this.symbole = symbole;
        this.isEtalon = isEtalon;
        this.ratio = ratio;
        this.decalage = decalage;
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

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public BigDecimal getDecalage() {
        return decalage;
    }

    public void setDecalage(BigDecimal decalage) {
        this.decalage = decalage;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public boolean isIsEtalon() {
        return isEtalon;
    }

    public void setIsEtalon(boolean isEtalon) {
        this.isEtalon = isEtalon;
    }

    private static final Logger LOG = Logger.getLogger(Unite.class.getName());
}
