package cobol;

import parse.Assembler;
import parse.Assembly;
import parse.tokens.Token;

public class CommentLineAssembler extends Assembler 
{

	@Override
	public void workOn(Assembly a) 
	{
		// TODO Auto-generated method stub
		Cobol c = new Cobol();
		
		//Removes initial **
		Token t = (Token) a.pop();
		t = (Token) a.pop();
		t = (Token) a.pop();
		String comment = "";
		
		// Runs loop to extract words between ** and **
		while(!t.sval().equalsIgnoreCase("*"))
		{
			comment = t.sval() + " " + comment;
			t = (Token) a.pop();
		}
		c.setCommentLine(comment.trim());
		a.setTarget(c);
	}

}
