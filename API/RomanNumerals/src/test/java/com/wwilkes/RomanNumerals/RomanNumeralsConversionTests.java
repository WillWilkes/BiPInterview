package com.wwilkes.RomanNumerals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.wwilkes.RomanNumerals.Convertors.RomanNumerals;
import com.wwilkes.RomanNumerals.Exceptions.InvalidInputException;
import com.wwilkes.RomanNumerals.POJOs.RomanNumeral;
import org.junit.jupiter.api.Test;

class RomanNumeralsConversionTests
{

    @Test
    void convert1111ToRomanNumerals()
    {
        RomanNumeral result = RomanNumerals.convertLatinToRomanNumeral( 1111 );
        assertEquals( "MCXI", result.getNumeral() );
    }

    @Test
    void convert999ToRomanNumerals()
    {
        RomanNumeral result = RomanNumerals.convertLatinToRomanNumeral( 999 );
        assertEquals( "CMXCIX", result.getNumeral() );
    }

    @Test
    void convert555ToRomanNumerals()
    {
        RomanNumeral result = RomanNumerals.convertLatinToRomanNumeral( 555 );
        assertEquals( "DLV", result.getNumeral() );
    }

    @Test
    void convert444ToRomanNumerals()
    {
        RomanNumeral result = RomanNumerals.convertLatinToRomanNumeral( 444 );
        assertEquals( "CDXLIV", result.getNumeral() );
    }

    @Test
    void convert2367ToRomanNumerals()
    {
        RomanNumeral result = RomanNumerals.convertLatinToRomanNumeral( 2367 );
        assertEquals( "MMCCCLXVII", result.getNumeral() );
    }

    @Test
    void convert8ToRomanNumerals()
    {
        RomanNumeral result = RomanNumerals.convertLatinToRomanNumeral( 8 );
        assertEquals( "VIII", result.getNumeral() );
    }

    @Test
    void convertNegativeToRomanNumerals()
    {
        assertThrows( InvalidInputException.class, () ->
        {
            RomanNumerals.convertLatinToRomanNumeral( -5 );
        } );
    }

    @Test
    void convert4000ToRomanNumerals()
    {
        assertThrows( InvalidInputException.class, () ->
        {
            RomanNumerals.convertLatinToRomanNumeral( 4000 );
        } );
    }

}
