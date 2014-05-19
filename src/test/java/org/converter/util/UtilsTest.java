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
        Utils instance = new Utils();
        Grandeur expResult = Grandeur.LONGUEUR;
        Grandeur result = instance.getGrandeurFromUnite(unite);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrandeurFromUnite method, of class Utils.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetGrandeurFromUnite_String_Unite_Inexistante() {
        LOG.log(Level.INFO, "TEST ============= getGrandeurFromUnite");
        String unite = "millimètre";
        Utils instance = new Utils();
        Grandeur expResult = Grandeur.LONGUEUR;
        Grandeur result = instance.getGrandeurFromUnite(unite);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrandeurFromUnite method, of class Utils.
     */
    @Ignore
    @Test
    public void testGetGrandeurFromUnite_Unite() {
        LOG.log(Level.INFO, "TEST ============= getGrandeurFromUnite");
        Unite unite = null;
        Utils instance = new Utils();
        Grandeur expResult = null;
        Grandeur result = instance.getGrandeurFromUnite(unite);
        assertEquals(expResult, result);
    }
    private static final Logger LOG = Logger.getLogger(UtilsTest.class.getName());

}
