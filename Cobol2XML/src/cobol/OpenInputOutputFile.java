package cobol;

import parse.Assembler;
import parse.Assembly;
import parse.tokens.Token;

public class OpenInputOutputFile extends Assembler 
{

	@Override
	public void workOn(Assembly a) 
	{
		// TODO Auto-generated method stub
		Cobol c = new Cobol();
		
		//adds the required fields
		Token t = (Token) a.pop();
		c.setOutputFile(t.sval());
		
		t = (Token) a.pop();
		c.setInputFile(t.sval());
		a.setTarget(c);
		
		System.out.println("Working");
	}

}
