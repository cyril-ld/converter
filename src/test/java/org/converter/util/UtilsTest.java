/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.converter.Grandeur;
import org.converter.Unite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Cyril
 */
public class UtilsTest {

    public UtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getGrandeurFromString method, of class Utils.
     */
    @Ignore
    @Test
    public void testGetGrandeurFromString() {
        LOG.log(Level.INFO, "TEST ============= getGrandeurFromString");
        String grandeur = "";
        Grandeur expResult = null;
        Grandeur result = Utils.getGrandeurFromString(grandeur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListeUnitesDepuisGrandeur method, of class Utils.
     */
    @Ignore
    @Test
    public void testGetListeUnitesDepuisGrandeur() {
        LOG.log(Level.INFO, "TEST ============= getListeUnitesDepuisGrandeur");
        Grandeur grandeur = null;
        List<Unite> expResult = null;
        List<Unite> result = Utils.getListeUnitesDepuisGrandeur(grandeur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUniteDepuisNomUnite method, of class Utils.
     */
    @Test
    public void testGetUniteDepuisNomUnite() {
        LOG.log(Level.INFO, "TEST ============= getUniteDepuisNomUnite");
        Grandeur grandeur = Grandeur.LONGUEUR;
        String nomUniteCible = "millimetre";
        Unite result = Utils.getUniteDepuisNomUnite(grandeur, nomUniteCible);
        assertEquals(nomUniteCible, result.getNom());
    }

    /**
     * Test of getGrandeurFromUnite method, of class Utils.
     */
    @Test
    public void testGetGrandeurFromUnite_String() {
        LOG.log(Level.INFO, "TEST ============= getGrandeurFromUnite");
        String unite = "millimetre";
        Grandeur expResult = Grandeur.LONGUEUR;
        Grandeur result = Utils.getGrandeurFromUnite(unite);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrandeurFromUnite method, of class Utils.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetGrandeurFromUnite_String_Unite_Inexistante() {
        LOG.log(Level.INFO, "TEST ============= testGetGrandeurFromUnite_String_Unite_Inexistante");
        String unite = "millimètre";
        Grandeur expResult = Grandeur.LONGUEUR;
        Grandeur result = Utils.getGrandeurFromUnite(unite);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGrandeurFromStringCourantElectrique() {
        LOG.log(Level.INFO, "TEST ============= testGetGrandeurFromStringCourantElectrique");
        String grandeur = "COURANT_ELECTRIQUE";
        Grandeur expResult = Grandeur.COURANT_ELECTRIQUE;
        Assert.assertEquals(Utils.getGrandeurFromString(grandeur), expResult);
    }

    @Test
    public void testGetGrandeurFromStringIntensiteLumineuse() {
        LOG.log(Level.INFO, "TEST ============= testGetGrandeurFromStringIntensiteLumineuse");
        String grandeur = "INTENSITE_LUMINEUSE";
        Grandeur expResult = Grandeur.INTENSITE_LUMINEUSE;
        Assert.assertEquals(Utils.getGrandeurFromString(grandeur), expResult);
    }

    @Test
    public void testGetGrandeurFromStringMasse() {
        LOG.log(Level.INFO, "TEST ============= testGetGrandeurFromStringMasse");
        String grandeur = "MASSE";
        Grandeur expResult = Grandeur.MASSE;
        Assert.assertEquals(Utils.getGrandeurFromString(grandeur), expResult);
    }

    @Test
    public void testGetGrandeurFromStringMatiere() {
        LOG.log(Level.INFO, "TEST ============= testGetGrandeurFromStringMatiere");
        String grandeur = "MATIERE";
        Grandeur expResult = Grandeur.MATIERE;
        Assert.assertEquals(Utils.getGrandeurFromString(grandeur), expResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetGrandeurFromStringException() {
        LOG.log(Level.INFO, "TEST ============= testGetGrandeurFromStringMatiere");
        String grandeur = "FAIL";
        Grandeur result = Utils.getGrandeurFromString(grandeur);
        Assert.fail("La grandeur FAIL ne doit pas exister dans le fichier" + result.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetUniteDepuisNomUniteException() {
        LOG.log(Level.INFO, "TEST ============= testGetUniteDepuisNomUniteException");
        Unite result = Utils.getUniteDepuisNomUnite(Grandeur.LONGUEUR, null);
        Assert.fail("Le système ne doit pas permettre de trouver une unité depuis une chaîne vide" + result.getNom());
    }

    private static final Logger LOG = Logger.getLogger(UtilsTest.class.getName());

}
