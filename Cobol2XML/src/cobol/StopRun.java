package cobol;

import parse.Assembler;
import parse.Assembly;
import parse.tokens.Token;

public class StopRun extends Assembler 
{

	@Override
	public void workOn(Assembly a) 
	{
		// TODO Auto-generated method stub
		Cobol c = new Cobol();

		// sets isStopRun to true
		c.setIsStopRun(true);
		a.setTarget(c);

	}

}
