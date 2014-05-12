/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter;

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
     * Valeur de la mesure
     */
    private float valeur;

    /**
     * Unité de la mesure courante
     */
    private Unite unite;

}
