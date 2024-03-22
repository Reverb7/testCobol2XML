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

/**
 * Test class for the existing functionality in CobolParser.
 * Tests various Cobol syntax patterns and checks if they are parsed correctly.
 */
public class ExistingFunctionalityTest 
{
	Tokenizer t;
	Parser p;

	/**
     * Setup method to initialize Tokenizer and Parser before each test.
     *
     * @throws Exception if setup fails
     */
	@Before
	public void setUp() throws Exception 
	{
		t = CobolParser.tokenizer();
		p = CobolParser.start();
				
	}

	/**
     * Teardown method to clean up Tokenizer and Parser after each test.
     *
     * @throws Exception if teardown fails
     */
	@After
	public void tearDown() throws Exception 
	{
		t = null;
		p = null;
	}
	
	/**
     * program-id.  base_jb.
     */
	@Test
	public void testProgramID() 
	{
		String s = "program-id.  base_jb.";
		System.out.println("Debug " + s);
		System.out.println("");
		
		t.setString(s);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertTrue(c != null);
	}
	
	 /**
     * Test parsing date-written.  07-mar-1995 - mb.
     */
	@Test
	public void testDate() 
	{
		String s = "date-written.  07-mar-1995 - mb.";
		System.out.println("Debug " + s);
		System.out.println("");
		
		t.setString(s);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertTrue(c != null);
	}
	
	 /**
     * Test parsing identification division.
     */
	@Test
	public void testDivision() 
	{
		String s = "identification division.";
		System.out.println("Debug " + s);
		System.out.println("");
		
		t.setString(s);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertTrue(c != null);
	}
	
	 /**
     * Test parsing working-storage section.
     */
	@Test
	public void testSectionName() 
	{
		String s = "working-storage section.";
		System.out.println("Debug " + s);
		System.out.println("");
		
		t.setString(s);
		Assembly in = new TokenAssembly(t);
		Assembly out = p.bestMatch(in);
		Cobol c = new Cobol();
		c = (Cobol) out.getTarget();
		
		assertTrue(c != null);
	}

}
