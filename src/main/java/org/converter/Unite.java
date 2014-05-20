/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter;

import java.math.BigDecimal;

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
        this.ratio = ratio;
        this.decalage = decalage;
    }

    /**
     * Returns the grandeur
     *
     * @return
     */
    public Grandeur getGrandeur() {
        return grandeur;
    }

    /**
     * Sets the grandeur
     *
     * @param grandeur
     */
    public void setGrandeur(Grandeur grandeur) {
        this.grandeur = grandeur;
    }

    /**
     * Retourne le nom
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Affecte un nouveau nom
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le ratio
     *
     * @return
     */
    public BigDecimal getRatio() {
        return ratio;
    }

    /**
     * Affecte le ratio
     *
     * @param ratio
     */
    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    /**
     *
     * @return
     */
    public BigDecimal getDecalage() {
        return decalage;
    }

    /**
     *
     * @param decalage
     */
    public void setDecalage(BigDecimal decalage) {
        this.decalage = decalage;
    }

    /**
     *
     * @return
     */
    public String getSymbole() {
        return symbole;
    }

    /**
     *
     * @param symbole
     */
    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
}
