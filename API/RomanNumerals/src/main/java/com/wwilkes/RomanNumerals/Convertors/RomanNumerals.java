package com.wwilkes.RomanNumerals.Convertors;

import com.wwilkes.RomanNumerals.Exceptions.InvalidInputException;
import com.wwilkes.RomanNumerals.POJOs.RomanNumeral;

public class RomanNumerals
{
    private static final String[]  numerals    = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C",
        "CD", "D", "CM", "M" };
    private static final Integer[] latinValues = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900,
        1000 };

    /**
     * Takes a latin number and converts it into a Roman Numeral
     *
     * @param latin the latin integer to convert
     * @return A RomanNumeral Object containing the Roman Numeral as a String
     */
    public static RomanNumeral convertLatinToRomanNumeral( int latin )
    {
        if ( latin < 1 || latin > 3999 )
        {
            throw new InvalidInputException( "Input out of range" );
        }

        RomanNumeral romanNumeral = new RomanNumeral( latin );

        int index = latinValues.length - 1;
        StringBuilder numeral = new StringBuilder();

        while ( latin > 0 )
        {
            int latinValue = latinValues[index];
            if ( latin >= latinValue )
            {
                int divides = latin / latinValue;
                numeral.append( numerals[index].repeat( divides ) );
                latin = latin % latinValue;
            }
            index--;
        }

        romanNumeral.setNumeral( numeral.toString() );
        return romanNumeral;
    }

}
