/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Cyril
 */
public class UniteTest {

    private static final Logger LOG = Logger.getLogger(UniteTest.class.getName());

    public UniteTest() {
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
     * Test of getGrandeur method, of class Unite.
     */
    @Test
    public void testGetGrandeur() {
        LOG.log(Level.INFO, "TEST ============= testGetGrandeur");
        Unite instance = new Unite(Grandeur.LONGUEUR, null, null, true, BigDecimal.ZERO, BigDecimal.ZERO);
        Grandeur expResult = Grandeur.LONGUEUR;
        Grandeur result = instance.getGrandeur();
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of setGrandeur method, of class Unite.
     */
    @Test
    public void testSetGrandeur() {
        LOG.log(Level.INFO, "TEST ============= testSetGrandeur");
        Grandeur grandeur = Grandeur.COURANT_ELECTRIQUE;
        Unite instance = new Unite();
        instance.setGrandeur(grandeur);
        Assert.assertEquals(instance.getGrandeur(), Grandeur.COURANT_ELECTRIQUE);
    }

    /**
     * Test of getNom method, of class Unite.
     */
    @Test
    public void testGetNom() {
        LOG.log(Level.INFO, "TEST ============= testGetNom");
        Unite instance = new Unite(Grandeur.LONGUEUR, "test", null, true, BigDecimal.ZERO, BigDecimal.ZERO);
        String expResult = "test";
        String result = instance.getNom();
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of setNom method, of class Unite.
     */
    @Test
    public void testSetNom() {
        LOG.log(Level.INFO, "TEST ============= testSetNom");
        String nom = "test";
        Unite instance = new Unite();
        instance.setNom(nom);
        Assert.assertEquals(nom, instance.getNom());
    }

    /**
     * Test of getRatio method, of class Unite.
     */
    @Test
    public void testGetRatio() {
        LOG.log(Level.INFO, "TEST ============= testGetRatio");
        Unite instance = new Unite(Grandeur.LONGUEUR, null, null, true, new BigDecimal("42"), BigDecimal.ZERO);
        BigDecimal expResult = new BigDecimal("42");
        BigDecimal result = instance.getRatio();
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of setRatio method, of class Unite.
     */
    @Test
    public void testSetRatio() {
        LOG.log(Level.INFO, "TEST ============= testSetRatio");
        BigDecimal ratio = new BigDecimal(BigInteger.ONE);
        Unite instance = new Unite();
        instance.setRatio(ratio);
        Assert.assertEquals(ratio, instance.getRatio());
    }

    /**
     * Test of getDecalage method, of class Unite.
     */
    @Test
    public void testGetDecalage() {
        LOG.log(Level.INFO, "TEST ============= testGetDecalage");
        Unite instance = new Unite();
        BigDecimal expResult = null;
        BigDecimal result = instance.getDecalage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDecalage method, of class Unite.
     */
    @Test
    public void testSetDecalage() {
        System.out.println("setDecalage");
        BigDecimal decalage = null;
        Unite instance = new Unite();
        instance.setDecalage(decalage);
    }

    /**
     * Test of getSymbole method, of class Unite.
     */
    @Test
    public void testGetSymbole() {
        LOG.log(Level.INFO, "TEST ============= testGetSymbole");
        Unite instance = new Unite(Grandeur.LONGUEUR, null, "symbole", true, BigDecimal.ZERO, BigDecimal.ZERO);
        String expResult = "symbole";
        String result = instance.getSymbole();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSymbole method, of class Unite.
     */
    @Test
    public void testSetSymbole() {
        System.out.println("setSymbole");
        String symbole = "";
        Unite instance = new Unite();
        instance.setSymbole(symbole);
    }

}
