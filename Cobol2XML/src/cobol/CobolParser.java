/*
 * @(#)CobolParser.java	 0.1.0
 *
 * Copyright (c) 2019 Julian M. Bass
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */
package cobol;

import parse.Alternation;
import parse.Empty;
import parse.Parser;
import parse.Sequence;
import parse.tokens.CaselessLiteral;
import parse.tokens.Literal;
import parse.tokens.Num;
import parse.tokens.Symbol;
import parse.tokens.Tokenizer;
import parse.tokens.Word;

public class CobolParser {
	/**
	 * Return a parser that will recognize the selected COBOL source code constructs:
	 * 
	 * 
	 * This parser creates a <code>COBOL</code> object
	 * as an assembly's target.
	 *
	 * @return a parser that will recognize and build a 
	 *         <object>COBOL</object> from a source code file.
	 */
	public Parser cobol() {
		Alternation a = new Alternation();
		
		Symbol fullstop = new Symbol('.');
		fullstop.discard();
		
		a.add(constantValue() );
		
		// Runs for loop to recognise comments line with 1 to 30 words 
		for(int i = 1; i <= 30; i++)
		{
			// TODO Auto-generated method stub
			Sequence s = new Sequence();
			s.add(new Symbol("*") );
			s.add(new Symbol("*") );
			
			// Runs for loop to form 1 to 15 words combination
			for(int k = 1; k <= i; k++)
			{
				s.add(new Word());
			}
			
			s.add(new Symbol("*") );
			s.add(new Symbol("*") );
			s.setAssembler(new CommentLineAssembler());
			a.add(s);
		}
		
		// Adds Stop Run
		a.add(stopRun() );
		
		// Adds Move command with randomly generated number
		a.add(moveWithRandomNum() );
		
		// Adds Move command with randomly generated character
		a.add(moveWithRandomChar() );
		
		// Adds Open input and output file
		a.add(openInputOutputFile() );
		
		a.add( ProgramID() );
		
		a.add( DivisionName() );
		
		a.add( SectionName() );
		
		a.add( DateWritten() );
		
		a.add(new Empty());
		return a;
	}
	
	/*
	* Return a parser that will recognize the grammar:
	*
	* ** [variable number of words] **
	*
	*/
	private Parser stopRun() 
	{
		// TODO Auto-generated method stub
		Sequence s = new Sequence();
		s.add(new Literal("STOP") );
		s.add(new Literal("RUN") );
		s.add(new Symbol('.').discard());
		s.setAssembler(new StopRun());
		return s;

	}
	
	
	/*
	* Return a parser that will recognize the grammar:
	*
	* MOVE RANDOM BETWEEN 10 AND 99 TO RANDOM_RECORD(1:2).
	*
	*/
	private Parser moveWithRandomNum() 
	{
		// TODO Auto-generated method stub
		Sequence s = new Sequence();
		s.add(new Literal("MOVE").discard() );
		s.add(new Literal("RANDOM").discard() );
		s.add(new Literal("BETWEEN").discard() );
		s.add(new Num());
		s.add(new Literal("AND").discard());
		s.add(new Num());
		s.add(new Literal("TO").discard());
		s.add(new Word() );
		s.add(new Symbol('(').discard());
		s.add(new Num());
		s.add(new Symbol(':').discard());
		s.add(new Num());
		s.add(new Symbol(')').discard());
		s.add(new Symbol('.').discard());
		s.setAssembler(new MoveWithRandomNum());
		return s;

	}
	
	/*
	* Return a parser that will recognize the grammar:
	*
	*  MOVE RANDOM BETWEEN 'A' AND 'Z' TO RANDOM_RECORD(3).
	*
	*/
	private Parser moveWithRandomChar() 
	{
		// TODO Auto-generated method stub
		Sequence s = new Sequence();
		s.add(new Literal("MOVE").discard() );
		s.add(new Literal("RANDOM").discard() );
		s.add(new Literal("BETWEEN").discard() );
		s.add(new Word());
		s.add(new Literal("AND").discard());
		s.add(new Word());
		s.add(new Literal("TO").discard());
		s.add(new Word() );
		s.add(new Symbol('(').discard());
		s.add(new Num());
		s.add(new Symbol(')').discard());
		s.add(new Symbol('.').discard());
		s.setAssembler(new MoveWithRandomChar());
		return s;

	}
	
	
	/*
	* Return a parser that will recognize the grammar:
	*
	*  OPEN INPUT RANDOM_FILE OUTPUT RANDOM1_FILE.
	*
	*/
	private Parser openInputOutputFile() 
	{
		// TODO Auto-generated method stub
		Sequence s = new Sequence();
		s.add(new Literal("OPEN").discard() );
		s.add(new Literal("INPUT").discard() );
		s.add(new Word());
		s.add(new Literal("OUTPUT").discard() );
		s.add(new Word());
		s.add(new Symbol('.').discard());
		s.setAssembler(new OpenInputOutputFile());
		return s;

	}
	

	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Program Identifier = Word
	 *
	 */
	protected Parser ProgramID() {
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("program-id") );
		s.add(new Symbol('.').discard());	
		s.add(new Word().setAssembler(new Program_idAssembler()));
		return s;
	}



	/*
	 * Return a parser that will recognise the grammar:
	 * 
	 *    <divisionName> division
	 *
	 */
	protected Parser DivisionName() {
		Sequence s = new Sequence();
		s.add(new Word().setAssembler(new DivisionAssembler()));
		s.add(new CaselessLiteral("division") );
		s.add(new Symbol('.').discard());
		return s;
	}
	
	/*
	 * Return a parser that will recognize the grammar:
	 * 
	 *    Section Name = Word
	 *
	 */
	protected Parser SectionName() {
		Sequence s = new Sequence();
		s.add(new Word().setAssembler(new SectionNameAssembler()));
		s.add(new CaselessLiteral("section") );
		s.add(new Symbol('.').discard());	

		return s;
	}
	
	/*
	 * Return a parser that will recognise the grammar:
	 * 
	 *    working-storage section
	 *
	 */
	protected Parser DateWritten() {
		Sequence s = new Sequence();
		s.add(new CaselessLiteral("date-written") );
		s.add(new Symbol('.').discard());
		s.add(new Num());
		s.add(new Symbol('-').discard());

		//This next Word actually contains month and year (which are extracted in DateAssembler
		s.add(new Word());
		s.add(new Symbol('-').discard());
		s.add(new Word().discard());
		s.add(new Symbol('.').discard());
		s.setAssembler(new DateAssembler());
		return s;
	}


	/**
	 * Return the primary parser for this class -- cobol().
	 *
	 * @return the primary parser for this class -- cobol()
	 */
	public static Parser start() {
		return new CobolParser().cobol();
	}

	/**
	 * Returns a tokenizer that does not allow spaces to appear inside
	 * the "words" that identify cobol's grammar.
	 *
	 * @return a tokenizer that does not allow spaces to appear inside
	 * the "words" that identify cobol grammar.
	 */
	public static Tokenizer tokenizer() {
		Tokenizer t = new Tokenizer();
		t.wordState().setWordChars(' ', ' ', false);
		return t;
	}
	
    
    /*
    * Return a parser that will recognize the grammar:
    *
    * <line number> <contstant name> "value" <constant value>.
    *
    */
    protected Parser constantValue() {
    //System.out.println("constantValue()");
    Sequence s = new Sequence();
    s.add(new Num() );
    s.add(new Word() );
    s.add(new CaselessLiteral("value") );
    s.add(new Num() );
    s.setAssembler(new ConstantValueAssembler());
    return s;
    }

}
