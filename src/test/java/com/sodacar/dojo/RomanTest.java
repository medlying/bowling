package com.sodacar.dojo;

import com.sodacar.dojo.roman.Roman;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Hu bosong
 * @date 2018/5/2
 */
public class RomanTest {

    @Test
    public void testRomanToDecimal() {
        Roman roman = new Roman();
        assertEquals(roman.romanToDecimal("MMVI"), 2006);
    }

    @Test
    public void testRomainToDecimalWithSub() {
        Roman roman = new Roman();
        assertEquals(roman.romanToDecimal("MCMXLIV"), 1944);
    }

    @Test
    public void testDecimalToRoman() {
        Roman roman = new Roman();
        assertEquals(roman.decimalToRoman(1944), "MCMXLIV");
    }

    @Test
    public void testDecimalToRoman1() {
        Roman roman = new Roman();
        assertEquals(roman.decimalToRoman(1941), "MCMXLI");
    }
}
