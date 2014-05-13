/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Cyril
 */
public class MesureTest {

    public MesureTest() {
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
     * Test of getValeur method, of class Mesure.
     */
    @Test
    public void testGetValeur() {
        LOG.log(Level.INFO, "getValeur");
        Mesure instance = new Mesure(new BigDecimal(0.0), null);
        BigDecimal expResult = new BigDecimal(0.0);
        assertEquals(expResult.doubleValue(), instance.getValeur().doubleValue(), 0.0);
    }

    /**
     * Test of setValeur method, of class Mesure.
     */
    @Test
    public void testSetValeur() {
        LOG.log(Level.INFO, "setValeur");
        BigDecimal valeur = new BigDecimal(0);
        Mesure instance = new Mesure();
        instance.setValeur(valeur);
    }

    /**
     * Test of getUnite method, of class Mesure.
     */
    @Test
    public void testGetUnite() {
        LOG.log(Level.INFO, "getUnite");
        Mesure instance = new Mesure();
        Unite expResult = null;
        Unite result = instance.getUnite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUnite method, of class Mesure.
     */
    @Test
    public void testSetUnite() {
        LOG.log(Level.INFO, "setUnite");
        Unite unite = null;
        Mesure instance = new Mesure();
        instance.setUnite(unite);
    }

    /**
     * Test of convertTo method, of class Mesure.
     */
    @Test
    public void testConvertTo() {
        LOG.log(Level.INFO, "convertTo");
        String nomUniteCible = "MILLIMETRE";
        Mesure mesure = new Mesure(new BigDecimal(1), Grandeur.LONGUEUR, "METRE");
        BigDecimal expResult = new BigDecimal(1000);
        Mesure result = mesure.convertTo(nomUniteCible);
        assertEquals(expResult.doubleValue(), result.getValeur().doubleValue(), 0.0);
    }

    private static final Logger LOG = Logger.getLogger(MesureTest.class.getName());

}
