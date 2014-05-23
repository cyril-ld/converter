/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mesure;

import java.math.BigDecimal;

/**
 * Représente une unité de mesure de manière relative par rapport à une unité établie comme unité étalon (unité de
 * comparaison).
 *
 * Il n'est pas possible de modifier Grandeur, nom et symbole de l'unité car cela sous entendrait que l'on peut arriver
 * dans un état incohérent. Recréer une unité à la place.
 *
 * @author Cyril
 * @version 1.1
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
     * Constructeur d'une unité minimaliste.
     *
     * @param grandeur - La grandeur de l'unité
     * @param nom      - Le nom de l'unité
     * @param symbole  - Le symbole de l'unité (seconde &lt;=&gt; s)
     */
    public Unite(Grandeur grandeur, String nom, String symbole) {
        this.grandeur = grandeur;
        this.nom = nom;
        this.symbole = symbole;
    }

    /**
     * Constructeur avec initialisations
     *
     * @param grandeur - La grandeur de l'unité
     * @param nom      - Le nom de l'unité
     * @param symbole  - Le symbole de l'unité (seconde &lt;=&gt; s)
     * @param ratio    - Le ratio de l'unité par rapport à l'unité étalon.
     * @param decalage - Le décalage éventuel de l'unité par rapport à l'unité étalon
     */
    public Unite(Grandeur grandeur, String nom, String symbole, BigDecimal ratio, BigDecimal decalage) {
        this.grandeur = grandeur;
        this.nom = nom;
        this.symbole = symbole;
        this.ratio = ratio;
        this.decalage = decalage;
    }

    /**
     * Returns the grandeur
     *
     * @return la grandeur de l'unité
     */
    public Grandeur getGrandeur() {
        return grandeur;
    }

    /**
     * Retourne le nom
     *
     * @return le nom de l'unité
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le ratio
     *
     * @return le ratio de conversion vers l'unité étalon
     */
    public BigDecimal getRatio() {
        return ratio;
    }

    /**
     * Affecte le ratio
     *
     * @param ratio - le ratio de conversion
     */
    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    /**
     * Retourne le décalage par rapport à l'unité étalon
     *
     * @return le décalage
     */
    public BigDecimal getDecalage() {
        return decalage;
    }

    /**
     * Affecte le décalage par rapport à l'unité étalon
     *
     * @param decalage - Le décalage par rapport à l'unité étalon
     */
    public void setDecalage(BigDecimal decalage) {
        this.decalage = decalage;
    }

    /**
     * Retourne le symbole de l'unité courante
     *
     * @return le symbole sous forme de string
     */
    public String getSymbole() {
        return symbole;
    }
}
