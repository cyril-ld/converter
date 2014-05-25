package org.converter.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.mesure.Grandeur;
import org.mesure.Unite;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Utilitary class. Aims to give some services for the convertion of units
 *
 * @author Cyril
 */
public class Utils {

    /**
     * Default logger
     */
    private static final Logger LOG = Logger.getLogger(Utils.class.getName());

    /**
     * Storage map for units found into the resource file.
     *
     * Every range owns a scale / greatness and it own list of units. This list is a small init for conversions.
     * See resources/Unites.xml for a representation of the data
     */
    private static Map<Grandeur, List<Unite>> grandeurs;

    /**
     * No public constructor available for Util classes
     */
    private Utils() {

    }

    /**
     * Initializes the units private map from the API config file.
     */
    private static void initGrandeurs() {

        DocumentBuilderFactory dbf;
        DocumentBuilder db;
        Document dom;
        Node noeudCourant;
        XPath xPath;
        String grandeursPath, unitesPath, nomGrandeur;
        NodeList grandeursList, unitesList;
        Unite uniteTemp;
        List<Unite> listeUnites;

        // Construction de l'unité
        Grandeur grandeurTmp;
        String nomTmp, symboleTmp;

        if (grandeurs == null) {
            grandeurs = new HashMap<>();
            try {
                // Création des objets utilitaires
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                dom = db.parse(new FileInputStream("src/main/resources/Unites.xml"));
                xPath = XPathFactory.newInstance().newXPath();

                // Chemin des grandeurs dans le XML
                grandeursPath = "/grandeurs/grandeur";

                // Chemin des unités dans le XML
                unitesPath = "./unites/unite";

                // Récupération de la liste des noeuds de grandeurs
                grandeursList = (NodeList) xPath.compile(grandeursPath).evaluate(dom, XPathConstants.NODESET);

                // Initialisation des maps imbriquées par le parcours des collections
                for (int i = 0; i <= grandeursList.getLength() - 1; i++) {

                    listeUnites = new ArrayList<>();
                    noeudCourant = grandeursList.item(i);
                    nomGrandeur = noeudCourant.getAttributes().getNamedItem("nom").getNodeValue();

                    unitesList = (NodeList) xPath.compile(unitesPath).evaluate(noeudCourant, XPathConstants.NODESET);

                    // Initialisation de la map des unités correspondant à la grandeur
                    for (int j = 0; j <= unitesList.getLength() - 1; j++) {

                        noeudCourant = unitesList.item(j);

                        grandeurTmp = Utils.getGrandeurFromString(nomGrandeur);
                        nomTmp = noeudCourant.getAttributes().getNamedItem("nom").getNodeValue();
                        symboleTmp = noeudCourant.getAttributes().getNamedItem("symbole").getNodeValue();

                        uniteTemp = new Unite(grandeurTmp, nomTmp, symboleTmp);

                        uniteTemp.setRatio(new BigDecimal(Double.parseDouble(noeudCourant.getAttributes().getNamedItem("ratio").getNodeValue())).round(MathContext.DECIMAL32));
                        if (noeudCourant.getAttributes().getNamedItem("decalage") == null) {
                            uniteTemp.setDecalage(new BigDecimal(BigInteger.ZERO));
                        } else {
                            uniteTemp.setDecalage(new BigDecimal(Double.parseDouble(noeudCourant.getAttributes().getNamedItem("decalage").getNodeValue())).round(MathContext.DECIMAL32));
                        }
                        listeUnites.add(uniteTemp);
                    }
                    grandeurs.put(Utils.getGrandeurFromString(nomGrandeur), listeUnites);
                }

            } catch (IOException | ParserConfigurationException | XPathExpressionException | DOMException | SAXException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * Returns a size from a string represanted size.
     *
     * @param grandeur the size's string representation.
     *
     * @return Grandeur, the corresponding size
     *
     * @throws IllegalArgumentException if the given string does not match any size
     */
    public static Grandeur getGrandeurFromString(String grandeur) {

        Grandeur ret;

        switch (grandeur.toUpperCase()) {
            case "LONGUEUR":
                ret = Grandeur.LONGUEUR;
                break;
            case "TEMPS":
                ret = Grandeur.TEMPS;
                break;
            case "COURANT_ELECTRIQUE":
                ret = Grandeur.COURANT_ELECTRIQUE;
                break;
            case "INTENSITE_LUMINEUSE":
                ret = Grandeur.INTENSITE_LUMINEUSE;
                break;
            case "MASSE":
                ret = Grandeur.MASSE;
                break;
            case "MATIERE":
                ret = Grandeur.MATIERE;
                break;
            case "TEMPERATURE":
                ret = Grandeur.TEMPERATURE;
                break;
            default:
                throw new IllegalArgumentException("La grandeur demandée est inconnue");
        }
        return ret;
    }

    /**
     *
     * @param grandeur - Units of this size will be returned
     *
     * @return a list of units corresponding to the given size.
     */
    public static List<Unite> getListeUnitesDepuisGrandeur(Grandeur grandeur) {
        if (grandeurs == null || grandeurs.isEmpty()) {
            initGrandeurs();
        }
        return grandeurs.get(grandeur);
    }

    /**
     * Returns an unit object from the given parameters.
     *
     * @param grandeur      - The size of the unit
     * @param nomUniteCible - Unit's name that we want to get back from this method
     *
     * @return l'unité initialisée avec ses informations depuis le fichier de configuration interne
     */
    public static Unite getUniteDepuisNomUnite(Grandeur grandeur, String nomUniteCible) {
        if (nomUniteCible == null || nomUniteCible.isEmpty()) {
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être vides.");
        }

        List<Unite> listeUnites = Utils.getListeUnitesDepuisGrandeur(grandeur);
        for (Unite uniteTemp : listeUnites) {
            if (uniteTemp.getNom().equalsIgnoreCase(nomUniteCible)) {
                return uniteTemp;
            }
        }
        throw new IllegalArgumentException("La grandeur " + grandeur.toString() + " est incompatible avec l'unité " + nomUniteCible);
    }

    /**
     * Find back a size from an unit name
     *
     * @param unite - the unit size if existing in the collection
     *
     * @return the corresponding size
     */
    public static Grandeur getGrandeurFromUnite(String unite) {

        DocumentBuilderFactory dbf;
        DocumentBuilder db;
        Document dom;
        XPath xPath;
        String nomGrandeurPath, nomGrandeur;
        Grandeur ret = null;

        try {

            // Création des objets utilitaires
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            dom = db.parse(new FileInputStream("src/main/resources/Unites.xml"));
            xPath = XPathFactory.newInstance().newXPath();

            nomGrandeurPath = "/grandeurs/grandeur[unites/unite/@nom='" + unite.toLowerCase() + "']/@nom";

            // Récupération de la liste des noeuds de grandeurs
            nomGrandeur = (String) xPath.compile(nomGrandeurPath).evaluate(dom, XPathConstants.STRING);

            if (nomGrandeur == null || nomGrandeur.isEmpty()) {
                throw new IllegalArgumentException("L'unité passée en paramètre n'a pas été reconnue");
            }
            ret = getGrandeurFromString(nomGrandeur);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    /**
     * Find back a size from an unit name.
     *
     * @param unite - unit that the method will give back the size
     *
     * @return corresponding size
     */
    public static Grandeur getGrandeurFromUnite(Unite unite) {
        return getGrandeurFromString(unite.getGrandeur().toString());
    }
}
