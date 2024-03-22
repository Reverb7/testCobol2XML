package cobol;

import parse.Assembler;
import parse.Assembly;
import parse.tokens.Token;

public class MoveWithRandomNum extends Assembler 
{

	@Override
	public void workOn(Assembly a) 
	{
		// TODO Auto-generated method stub
		Cobol c = new Cobol();
		
		//adds the required fields
		Token t = (Token) a.pop();
		String moveVariableRange = t.nval() + " AND ";
		t = (Token) a.pop();
		moveVariableRange += t.nval();
		
		t = (Token) a.pop();
		c.setMoveToVariable(t.sval());
		
		t = (Token) a.pop();
		String randomRange ="BETWEEN " + t.nval() + " TO ";
		
		t = (Token) a.pop();
		randomRange += t.nval();
		
		c.setmoveToVariableRange(moveVariableRange);
		c.setRandomRange(randomRange);
		c.setIsMoveValueInt(true);
		a.setTarget(c);

	}

}
