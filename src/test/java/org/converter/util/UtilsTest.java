/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mesure.Grandeur;
import org.mesure.Mesure;
import org.mesure.Unite;

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
    @Test
    public void testGetGrandeurFromString() {
        LOG.log(Level.INFO, "TEST ============= testGetGrandeurFromString");
        String grandeur = "temperature";
        Grandeur expResult = Grandeur.TEMPERATURE;
        Grandeur result = Utils.getGrandeurFromString(grandeur);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of getListeUnitesDepuisGrandeur method, of class Utils.
     */
    @Test
    public void testGetListeUnitesDepuisGrandeur() {
        LOG.log(Level.INFO, "TEST ============= testGetListeUnitesDepuisGrandeur");
        Grandeur grandeur = Grandeur.LONGUEUR;
        List<Unite> result = Utils.getListeUnitesDepuisGrandeur(grandeur);
        boolean toutesMesuresDeMemeGrandeur = false;
        int i = 0;

        for (Unite unite : result) {
            if (unite.getGrandeur() != grandeur) {
                break;
            }
            i++;
        }

        if (i == result.size()) {
            toutesMesuresDeMemeGrandeur = true;
        }

        Assert.assertEquals(true, toutesMesuresDeMemeGrandeur);
    }

    /**
     * Test of getUniteDepuisNomUnite method, of class Utils.
     */
    @Test
    public void testGetUniteDepuisNomUnite() {
        LOG.log(Level.INFO, "TEST ============= testGetUniteDepuisNomUnite");
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
        LOG.log(Level.INFO, "TEST ============= testGetGrandeurFromUnite_String");
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

    @Test
    public void testGetGrandeurFromUnite() {
        LOG.log(Level.INFO, "TEST ============= testGetGrandeurFromUnite");
        Unite unite = new Unite(Grandeur.LONGUEUR, null, null, BigDecimal.ZERO, BigDecimal.ZERO);
        Grandeur expResult = Grandeur.LONGUEUR;
        Assert.assertEquals(expResult, Utils.getGrandeurFromUnite(unite));
    }

    @Test
    public void testAddUnitIntoReferential() {
        LOG.log(Level.INFO, "TEST ============= testAddUnitIntoReferential");
        Unite unite = new Unite(Grandeur.LONGUEUR, "Truc", null, BigDecimal.ZERO, BigDecimal.ZERO);
        Utils.addUnitIntoReferential(unite);
        String expResult = "Truc";
        Assert.assertEquals(expResult, Utils.getUniteDepuisNomUnite(Grandeur.LONGUEUR, "Truc").getNom());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExistingUnitIntoReferential() {
        LOG.log(Level.INFO, "TEST ============= testAddExistingUnitIntoReferential");
        Unite unite = new Unite(Grandeur.LONGUEUR, "metre", null, BigDecimal.ZERO, BigDecimal.ZERO);
        Utils.addUnitIntoReferential(unite);
    }

    @Test
    public void convertCreatedUnits() {
        LOG.log(Level.INFO, "TEST ============= convertCreatedUnits");
        Unite unite = new Unite(Grandeur.LONGUEUR, "test1", null, BigDecimal.TEN, BigDecimal.ZERO);
        Mesure mesure = new Mesure(new BigDecimal("2"), unite);
        Assert.assertEquals(new BigDecimal("20.000000000000000"), mesure.convertTo("metre").getValeur());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddUnitIntoReferential() {
        LOG.log(Level.INFO, "TEST ============= TestAddUnitIntoReferential");
        Utils.addUnitIntoReferential(null);
    }

    private static final Logger LOG = Logger.getLogger(UtilsTest.class.getName());

}
