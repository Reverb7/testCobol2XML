package reverb;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cobol.Cobol;
import cobol.CobolParser;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class ParserTest 
{
    Tokenizer t; // Declare Tokenizer object
    Parser p;    // Declare Parser object

    // Method to run before each test case
    @Before
    public void setUp() throws Exception 
    {
       
        t = CobolParser.tokenizer();
        p = CobolParser.start();           
    }

    // Method to run after each test case
    @After
    public void tearDown() throws Exception 
    {
        t = null;
        p = null;
    }

    // Test case for a valid token
    @Test
    public void testValidToken() 
    {
        String s = "INPUT-OUTPUT SECTION.";
        
        System.out.println("Debug " + s);
        System.out.println("");
        
        // Set Tokenizer's string to input string
        t.setString(s);
        Assembly in = new TokenAssembly(t);
        Assembly out = p.bestMatch(in);
        Cobol c = new Cobol();
        c = (Cobol) out.getTarget();
        
        // Assert that Cobol object is not null
        assertTrue(c != null);
    }
    
    // Test case for an invalid token
    @Test
    public void testInvalidToken() 
    {
        String s = "<p>You wassup<\\p>"; // Sample invalid input string
        
        // Set Tokenizer's string to input string
        t.setString(s);
        Assembly in = new TokenAssembly(t);
        Assembly out = p.bestMatch(in);
        Cobol c = new Cobol();
        c = (Cobol) out.getTarget();
        
        // Assert that Cobol object is null (invalid token)
        assertTrue(c == null);
    }
    
    // Test case for an empty token
    @Test
    public void testEmptyToken() 
    {
        String s = ""; // Empty input string
        
        // Set Tokenizer's string to input string
        t.setString(s);
        Assembly in = new TokenAssembly(t);
        Assembly out = p.bestMatch(in);
        Cobol c = new Cobol();
        c = (Cobol) out.getTarget();
        
        // Assert that Cobol object is null (empty token)
        assertTrue(c == null);
    }

}
