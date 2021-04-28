package com.wwilkes.RomanNumerals.POJOs;

import lombok.Getter;
import lombok.Setter;

/**
 * Wrapper for a Roman Numeral
 */
@Getter
@Setter
public class RomanNumeral
{
    private String numeral;
    private int    latin;

    public RomanNumeral( int latin )
    {
        this.latin = latin;
    }

}