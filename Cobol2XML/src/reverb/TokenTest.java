package reverb;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parse.tokens.Token;
import parse.tokens.TokenType;

// This class is a JUnit test class for testing the Token class
public class TokenTest 
{
    public Token token;       // Declare Token object
    public TokenType TT_WORD; // Declare TokenType for word
    public TokenType TT_NUM;  // Declare TokenType for number
    public TokenType TT_SYMBOL;  // Declare TokenType for symbol
    public TokenType TT_QUOTED;  // Declare TokenType for quoted string

    // Method to run before each test case
    @Before
    public void setUp() throws Exception 
    {
        token = new Token("r");    // Create a Token with string "r"
        TT_WORD = new TokenType("word");     // Create a TokenType for word
        TT_NUM = new TokenType("number");    // Create a TokenType for number
        TT_SYMBOL = new TokenType("symbol"); // Create a TokenType for symbol
        TT_QUOTED = new TokenType("quoted"); // Create a TokenType for quoted string
    }

    // Method to run after each test case
    @After
    public void tearDown() throws Exception 
    {
        token = null;       // Set Token to null
        TT_WORD = null;     // Set TokenType for word to null
        TT_NUM = null;      // Set TokenType for number to null
        TT_SYMBOL = null;   // Set TokenType for symbol to null
        TT_QUOTED = null;   // Set TokenType for quoted string to null
    }

    // Test case for a word token
    @Test
    public void testWordToken() 
    {
        token = new Token("Dog");   // Create a Token with string "Dog"
        assertTrue(token.isWord()); // Assert that it is a word
        assertFalse(token.isNumber());  // Assert that it is not a number
        assertFalse(token.isSymbol());  // Assert that it is not a symbol
        assertFalse(token.isQuotedString());  // Assert that it is not a quoted string
        assertEquals("Dog", token.sval());  // Assert that the string value is "Dog"
    }
    
    // Test case for a number token
    @Test
    public void testNumberToken() 
    {
        token = new Token(1234);   // Create a Token with integer 1234
        assertTrue(token.isNumber());  // Assert that it is a number
        assertFalse(token.isWord());   // Assert that it is not a word
        assertFalse(token.isSymbol()); // Assert that it is not a symbol
        assertFalse(token.isQuotedString());  // Assert that it is not a quoted string
        assertTrue(token.nval() == 1234);   // Assert that the numeric value is 1234
    }
    
    // Test case for a symbol token
    @Test
    public void testSymbolToken() 
    {
        token = new Token('<');    // Create a Token with symbol '<'
        assertTrue(token.isSymbol());   // Assert that it is a symbol
        assertFalse(token.isWord());    // Assert that it is not a word
        assertFalse(token.isNumber());  // Assert that it is not a number
        assertFalse(token.isQuotedString());  // Assert that it is not a quoted string
        assertEquals("<", token.sval());    // Assert that the string value is "<"
    }

}
