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
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
        LOG.log(Level.INFO, "TEST ============= getValeur");
        Mesure instance = new Mesure(new BigDecimal(0.0), null);
        BigDecimal expResult = new BigDecimal(0.0);
        assertEquals(expResult.doubleValue(), instance.getValeur().doubleValue(), 0.0);
    }

    /**
     * Test of setValeur method, of class Mesure.
     */
    @Test
    public void testSetValeur() {
        LOG.log(Level.INFO, "TEST ============= setValeur");
        BigDecimal valeur = new BigDecimal(0);
        Mesure instance = new Mesure();
        instance.setValeur(valeur);
    }

    /**
     * Test of getUnite method, of class Mesure.
     */
    @Test
    public void testGetUnite() {
        LOG.log(Level.INFO, "TEST ============= getUnite");
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
        LOG.log(Level.INFO, "TEST ============= setUnite");
        Unite unite = null;
        Mesure instance = new Mesure();
        instance.setUnite(unite);
    }

    /**
     * Test of convertTo method, of class Mesure.
     */
    @Test
    public void testConvertToDistance() {
        LOG.log(Level.INFO, "TEST ============= testConvertToDistance");
        String nomUniteCible = "MILLIMETRE";
        Mesure mesure = new Mesure(new BigDecimal(1), Grandeur.LONGUEUR, "METRE");
        BigDecimal expResult = new BigDecimal(1000);
        Mesure result = mesure.convertTo(nomUniteCible);
        assertEquals(expResult.doubleValue(), result.getValeur().doubleValue(), 0.0);
    }

    @Test
    @Ignore
    public void testConvertToDistanceMille() {
        LOG.log(Level.INFO, "TEST ============= testConvertToDistanceMille");
        String nomUniteCible = "mille_marin";
        Mesure mesure = new Mesure(new BigDecimal(1), Grandeur.LONGUEUR, "METRE");
        BigDecimal expResult = new BigDecimal("1852");
        Mesure result = mesure.convertTo(nomUniteCible);
        assertEquals(expResult.doubleValue(), result.getValeur().doubleValue(), 0.0);
    }

    @Test
    public void testConvertToTemps() {
        LOG.log(Level.INFO, "TEST ============= testConvertToTemps");
        String nomUniteCible = "JOUR";
        Mesure mesure = new Mesure(new BigDecimal(1), Grandeur.TEMPS, "SEMAINE");
        BigDecimal expResult = new BigDecimal(7);
        Mesure result = mesure.convertTo(nomUniteCible);
//        LOG.log(Level.INFO, "testConvertToTemps : expResult.doubleValue() = {0}, result.getValeur().doubleValue() = {1}", new Object[]{expResult.toString(), result.getValeur().toString()});
        assertEquals(expResult.doubleValue(), result.getValeur().doubleValue(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertToTempsUneDistance() {
        LOG.log(Level.INFO, "TEST ============= testConvertToTempsUneDistance");
        String nomUniteCible = "TEMPS";
        Mesure mesure = new Mesure(new BigDecimal(1), Grandeur.LONGUEUR, "METRE");
        Mesure result = mesure.convertTo(nomUniteCible);
        Assert.fail("On doit lever une exception de conversion : " + result.getUnite().getNom());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationMesureMauvaiseGrandeur() {
        LOG.log(Level.INFO, "TEST ============= testCreationMesureMauvaiseGrandeur");
        Mesure mesure;
        mesure = new Mesure(new BigDecimal(1), Grandeur.TEMPS, "METRE");
        Assert.fail("La mesure " + mesure.getUnite().getNom() + " a été initialisée à tord.");
    }

    @Test
    public void testConvertTemperatureAvecDecalage() {
        LOG.log(Level.INFO, "TEST ============= testConvertTemperatureAvecDecalage");
        String nomUniteCible = "KELVIN";
        Mesure mesure = new Mesure(new BigDecimal(BigInteger.ONE), Grandeur.TEMPERATURE, "degre_celsius");
        BigDecimal expResult = new BigDecimal("274.15");
        Mesure result = mesure.convertTo(nomUniteCible);
        LOG.log(Level.INFO, "testConvertTemperatureAvecDecalage : expResult.toString() = {0}, result.getValeur().toString() = {1}", new Object[]{expResult.toString(), result.getValeur().toString()});
        Assert.assertEquals(expResult.doubleValue(), result.getValeur().doubleValue());
    }

    @Test
    @Ignore
    public void testConvertTemperatureAvecDecalageBis() {
        LOG.log(Level.INFO, "TEST ============= testConvertTemperatureAvecDecalage");
        String nomUniteCible = "KELVIN";
        Mesure mesure = new Mesure(new BigDecimal("3"), Grandeur.TEMPERATURE, "degre_celsius");
        BigDecimal expResult = new BigDecimal("273.15").add(new BigDecimal("3"));
        Mesure result = mesure.convertTo(nomUniteCible);
        LOG.log(Level.INFO, "testConvertTemperatureAvecDecalage : expResult.toString() = {0}, result.getValeur().toString() = {1}", new Object[]{expResult.toString(), result.getValeur().toString()});
        Assert.assertEquals(expResult.doubleValue(), result.getValeur().doubleValue());
    }

    @Test
    @Ignore
    public void testConvertTemperatureAvecDecalageEtReel() {
        LOG.log(Level.INFO, "TEST ============= testConvertTemperatureAvecDecalage");
        String nomUniteCible = "KELVIN";
        Mesure mesure = new Mesure(new BigDecimal("3.5"), Grandeur.TEMPERATURE, "degre_celsius");
        BigDecimal expResult = new BigDecimal("273.15").add(new BigDecimal("3.5"));
        Mesure result = mesure.convertTo(nomUniteCible);
        LOG.log(Level.INFO, "testConvertTemperatureAvecDecalage : expResult.toString() = {0}, result.getValeur().toString() = {1}", new Object[]{expResult.toString(), result.getValeur().toString()});
        Assert.assertEquals(expResult.doubleValue(), result.getValeur().doubleValue());
    }

//    T(°F) = T(°C)×1,8 + 32
    @Test
    @Ignore
    public void testConvertTemperatureAvecDecalageEtReelBis() {
        LOG.log(Level.INFO, "TEST ============= testConvertTemperatureAvecDecalageEtReelBis");
        String nomUniteCible = "Fahrenheit";
        Mesure mesure = new Mesure(new BigDecimal("99.975"), Grandeur.TEMPERATURE, "degre_celsius");
        BigDecimal expResult = new BigDecimal("211.955");
        Mesure result = mesure.convertTo(nomUniteCible);
        LOG.log(Level.INFO, "testConvertTemperatureAvecDecalage : expResult.toString() = {0}, result.getValeur().toString() = {1}", new Object[]{expResult.toString(), result.getValeur().toString()});
        Assert.assertEquals(expResult.doubleValue(), result.getValeur().doubleValue());
    }

    private static final Logger LOG = Logger.getLogger(MesureTest.class.getName());

}
