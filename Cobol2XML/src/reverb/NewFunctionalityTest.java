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
 * Test class for the new functionality in CobolParser.
 * Tests various Cobol syntax patterns and checks if they are parsed correctly.
 */

public class NewFunctionalityTest 
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
     * Test parsing a comment with two words.
     */
	@Test
	public void testCommentTwoWords() 
	{
		String s = "**Random comment**";
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
     * Test parsing a comment with three words.
     */
	@Test
	public void testCommentThreeWords() 
	{
		String s = "**Random comment comment**";
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
     * Test parsing a comment with ten words.
     */
	@Test
	public void testCommentTenWords() 
	{
		String s = "**Random comment comment with at least ten pages test test**";
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
     * Test parsing the STOP RUN statement.
     */
	@Test
	public void testStopRunSyntax() 
	{
		String s = "STOP RUN.";
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
     * Test parsing the MOVE RANDOM BETWEEN 10 AND 99 TO RANDOM_RECORD(1:2) statement.
     */
	@Test
	public void testMoveRandomInt() 
	{
		String s = "MOVE RANDOM BETWEEN 10 AND 99 TO RANDOM_RECORD(1:2).";
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
     * Test parsing the MOVE RANDOM BETWEEN 20 AND 80 TO RANDOM_RECORD(1:4) statement.
     */
	@Test
	public void testMoveRandomInt2() 
	{
		String s = "MOVE RANDOM BETWEEN 20 AND 80 TO RANDOM_RECORD(1:4).";
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
     * Test parsing the MOVE RANDOM BETWEEN A AND Z TO RANDOM_RECORD(3) statement.
     */
	@Test
	public void testMoveRandomChar() 
	{
		String s = "MOVE RANDOM BETWEEN A AND Z TO RANDOM_RECORD(3).";
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
     * MOVE RANDOM BETWEEN B AND U TO RANDOM_RECORD(5).
     */
	@Test
	public void testMoveRandomChar2() 
	{
		String s = "MOVE RANDOM BETWEEN B AND U TO RANDOM_RECORD(5).";
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
     * Test parsing the OPEN INPUT RANDOM_FILE OUTPUT RANDOMONE_FILE. statement.
     */
	@Test
	public void testOpenInputOutputFile() 
	{
		String s = "OPEN INPUT RANDOM_FILE OUTPUT RANDOMONE_FILE.";
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
