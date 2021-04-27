package com.wwilkes.RomanNumerals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.wwilkes.RomanNumerals.Controllers.NumeralsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest( value = NumeralsController.class )
class RESTApiTests
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    void convertValidRomanNumeral() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get( "/convert/roman-numeral/3999" )
                                                              .accept( MediaType.APPLICATION_JSON );

        MvcResult result = mockMvc.perform( requestBuilder )
                                  .andReturn();

        MockHttpServletResponse response = result.getResponse();
        String expectedJSON = "{\"numeral\":\"MMMCMXCIX\",\"latin\":3999}";

        assertEquals( expectedJSON, response.getContentAsString() );
        assertEquals( HttpStatus.OK.value(), response.getStatus() );
    }

    @Test
    void convertInvalidRomanNumeral() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get( "/convert/roman-numeral/-1" )
                                                              .accept( MediaType.APPLICATION_JSON );

        MvcResult result = mockMvc.perform( requestBuilder )
                                  .andReturn();

        MockHttpServletResponse response = result.getResponse();
        String expectedJSON = "";

        assertEquals( expectedJSON, response.getContentAsString() );
        assertEquals( HttpStatus.NOT_FOUND.value(), response.getStatus() );
    }

}
