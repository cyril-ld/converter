/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter;

import java.util.logging.Logger;

/**
 * Une mesure est une valeur multipliant une unité afin d'exprimer une valeur
 * dans un référentiel donné.
 *
 * Ainsi, une mesure physique dans notre cas se représente par une valeur et une
 * unité.
 *
 * Une mesure peut être convertie dans une autre unité de la même grandeur
 * (distance, temps, masse, température, matière, courant électrique, intensité
 * lumineuse).
 *
 * @author Cyril
 */
public class Mesure {

    /**
     * Logger par défaut
     */
    private static final Logger LOG = Logger.getLogger(Mesure.class.getName());
    
    /**
     * Valeur de la mesure
     */
    private float valeur;

    /**
     * Unité de la mesure courante
     */
    private Unite unite;

    /**
     * Retourne la valeur de la mesure
     * @return 
     */
    public float getValeur() {
        return valeur;
    }

    /**
     * Modifie la valeur de la mesure
     * @param valeur 
     */
    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    /**
     * Retourne l'unité de la mesure
     * @return 
     */
    public Unite getUnite() {
        return unite;
    }

    /**
     * Modifie la valeur de l'unité
     * @param unite 
     */
    public void setUnite(Unite unite) {
        this.unite = unite;
    }

}
