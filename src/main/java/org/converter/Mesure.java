/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;
import org.converter.util.Utils;

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
    private BigDecimal valeur;

    /**
     * Unité de la mesure courante
     */
    private Unite unite;

    public Mesure() {
    }

    /**
     * Constructeur
     *
     * @param valeur - la valeur de la mesure
     * @param unite  - l'unité dans laquelle exprimer la mesure
     */
    public Mesure(BigDecimal valeur, Unite unite) {
        this.valeur = valeur;
        this.unite = unite;
    }

    /**
     * Constructeur
     *
     * @param valeur   - valeur de la mesure
     * @param grandeur - grandeur de la mesure
     * @param nomUnite - unité de la mesure
     */
    public Mesure(BigDecimal valeur, Grandeur grandeur, String nomUnite) {
        this.valeur = valeur;
        this.unite = Utils.getUniteDepuisNomUnite(grandeur, nomUnite);
    }

    /**
     * Retourne la valeur de la mesure
     *
     * @return
     */
    public BigDecimal getValeur() {
        return valeur;
    }

    /**
     * Modifie la valeur de la mesure
     *
     * @param valeur
     */
    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }

    /**
     * Retourne l'unité de la mesure
     *
     * @return
     */
    public Unite getUnite() {
        return unite;
    }

    /**
     * Modifie la valeur de l'unité
     *
     * @param unite
     */
    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    /**
     * Renvoi l'équivalent de la mesure courante dans l'unité cible
     *
     * @param nomUniteCible - l'unité dans laquelle la mesure doit être convertie
     *
     * @return la mesure une fois convertie
     */
    public Mesure convertTo(String nomUniteCible) {

        List<Unite> listeUnites = Utils.getListeUnitesDepuisGrandeur(this.unite.getGrandeur());
        Mesure ret = null;
        BigDecimal valeurUniteEtalon;

        for (Unite uniteTemp : listeUnites) {
            if (uniteTemp.getNom().equalsIgnoreCase(nomUniteCible)) {

                ret = new Mesure();

                // On converti la valeur courante dans l'unité étalon : valeur mesure * ratio mesure
//                valeurUniteEtalon = (this.valeur * this.unite.getRatio()) - this.unite.getDecalage();
                valeurUniteEtalon = this.valeur.multiply(this.unite.getRatio()).subtract(this.unite.getDecalage());

                // On converti la valeur dans l'unité cible
                // = mesure dans l'unité étalon * (ratio de l'unité étalon/ratio de l'unité courante)
//                ret.setValeur((valeurUniteEtalon * (1.0F / uniteTemp.getRatio())));
                ret.setValeur(valeurUniteEtalon.multiply(new BigDecimal(1.0)).divide(uniteTemp.getRatio()));

                ret.setUnite(uniteTemp);
                break;
            }
        }
        return ret;
    }
}