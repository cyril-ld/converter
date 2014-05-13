/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter.util;

import java.util.Map;
import org.converter.Grandeur;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Cyril
 */
public class Utils {

    /**
     * Map de stockage des ratios de conversion entre les unités. Chaque rang
     * contient une grandeur qui contient tous les ratios de conversion entre
     * les différentes unités de la grandeur considérée. Voir le fichier XML
     * Unites.xml pour une meilleur compréhension.
     */
    private static Map<Grandeur, Map<String, Integer>> grandeurs;

    /**
     * Initialise la map des grandeurs depuis le fichier "Unites.xml" contenu
     * dans le dossier org.data
     *
     * @return true si la méthode s'est bien exécutée.
     */
    private static boolean initGrandeurs() {
        throw new NotImplementedException();
    }
}
