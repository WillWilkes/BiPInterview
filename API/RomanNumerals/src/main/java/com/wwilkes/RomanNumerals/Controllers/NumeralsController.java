package com.wwilkes.RomanNumerals.Controllers;

import com.wwilkes.RomanNumerals.Convertors.RomanNumerals;
import com.wwilkes.RomanNumerals.POJOs.RomanNumeral;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeralsController
{
    @CrossOrigin( origins = "*" )
    @GetMapping( "/convert/roman-numeral/{number}" )
    public ResponseEntity<RomanNumeral> dashboardGet( @PathVariable int number )
    {
        return ResponseEntity.ok()
                             .body( RomanNumerals.convertLatinToRomanNumeral( number ) );
    }

}
