package org.converter.util;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.converter.Grandeur;
import org.converter.Unite;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Classe permettant de faire des opérations utilitaires. Voir docs méthodes
 * pour plus d'infos.
 *
 * @author Cyril
 */
public class Utils {

    /**
     * Logger par défaut
     */
    private static final Logger LOG = Logger.getLogger(Utils.class.getName());

    /**
     * Map de stockage des ratios de conversion entre les unités. Chaque rang
     * contient une grandeur qui contient tous les ratios de conversion entre
     * les différentes unités de la grandeur considérée. Voir le fichier XML
     * Unites.xml pour une meilleur compréhension.
     */
    private static Map<Grandeur, List<Unite>> grandeurs;

    /**
     * Initialise la map des grandeurs depuis le fichier "Unites.xml" contenu
     * dans le dossier org.data
     *
     */
    public static void initGrandeurs() {

        DocumentBuilderFactory dbf;
        DocumentBuilder db;
        Document dom;
        Node noeudCourant;
        XPath xPath;
        String grandeursPath, unitesPath, nomGrandeur, nomUnite, symboleUnite;
        NodeList grandeursList, unitesList;
        Unite uniteTemp;
        ArrayList<Unite> listeUnites;

        if (grandeurs == null) {
            grandeurs = new HashMap<>();
            try {
                // Création des objets utilitaires
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                dom = db.parse(new FileInputStream("src/main/java/org/data/Unites.xml"));
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

                        uniteTemp = new Unite();
                        noeudCourant = unitesList.item(j);

                        uniteTemp.setGrandeur(Utils.getGrandeurFromString(nomGrandeur));
                        uniteTemp.setNom(noeudCourant.getAttributes().getNamedItem("nom").getNodeValue());
                        uniteTemp.setSymbole(noeudCourant.getAttributes().getNamedItem("symbole").getNodeValue());
                        // TODO : reste à fixer le concept de ratio de conversion

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
     * Retourne la valeur de l'énumération correspondant à la chaîne de caractères demandée.
     *
     * @param grandeur la représentation de la grandeur sous forme de chaîne de caractères
     *
     * @return Grandeur, la grandeur correspondante
     *
     * @throws IllegalArgumentException si la chaîne demandée ne correspond à aucune grandeur connue
     */
    public static Grandeur getGrandeurFromString(String grandeur) {

        Grandeur ret;

        switch (grandeur) {
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
     * @param grandeur
     *
     * @return la liste des unités associées à la grandeur, ou null si aucune unité n'existe dans le fichier de
     *         paramétrage pour la grandeur donnée.
     */
    public List<Unite> getListeUnitesDepuisGrandeur(Grandeur grandeur) {
        if (grandeurs == null || grandeurs.isEmpty()) {
            initGrandeurs();
        }
        return grandeurs.get(grandeur);
    }
}
