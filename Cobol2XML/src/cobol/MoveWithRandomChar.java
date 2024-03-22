package cobol;

import parse.Assembler;
import parse.Assembly;
import parse.tokens.Token;

public class MoveWithRandomChar extends Assembler 
{

	@Override
	public void workOn(Assembly a) 
	{
		// TODO Auto-generated method stub
				Cobol c = new Cobol();
				
				//adds the required fields
				Token t = (Token) a.pop();
				String moveVariableRange = t.nval() + "";
				
				t = (Token) a.pop();
				c.setMoveToVariable(t.sval());
				
				t = (Token) a.pop();
				String randomRange ="BETWEEN " + t.sval() + " TO ";
				
				t = (Token) a.pop();
				randomRange += t.sval();
				
				c.setmoveToVariableRange(moveVariableRange);
				c.setRandomRange(randomRange);
				c.setIsMoveValueInt(false);
				a.setTarget(c);

	}

}
