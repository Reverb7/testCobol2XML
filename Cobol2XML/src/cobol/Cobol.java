/*
 * @(#)Cobol.java	 0.0.1
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

import utensil.*;

public class Cobol implements PubliclyCloneable {
	protected String commentLine;
	protected String program_id;
	protected String sectionName;
	protected String divisionName;
	protected int dayDateWritten = 0;
	protected String monthDateWritten;
	protected int yearDateWritten = 0;
	
	protected String constantName;
	protected double constantValue;
	protected int lineNumber = 0;
	protected boolean isStopRun;
	
	// Boolean to hold if move value is int
		protected boolean moveValueIsInt = false;
		
	// String to hold the range for Move with random numbers or characters
	protected String randomRange = "";
	
	// String to hold the variable to move the value to for Move command
	protected String moveToVariable = null;
	
	// String to hold the moveToVariable locations to move the value to
	protected String moveToVariableRange = "";
	
	// String to hold input file
	protected String inputFile = null;
	
	// String to hold output file
	protected String outputFile = null;

	
	/**
	 * Return a copy of this object.
	 *
	 * @return a copy of this object
	 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError();
		}
	}
	/**
	 * Compares two objects for equality, treating nulls carefullly,
	 * and relying on the first object's implementation of <code>
	 * equals()</code>.
	 *
	 * @param   o1   one object
	 *
	 * @param   o2   the other
	 *
	 * @return  <code>true</code> if the objects are equal and
	 *          <code>false</code> otherwise.
	 */
	public static boolean ifCobolObjEqual(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return o1 == null && o2 == null;
		}
		return o1.equals(o2);
	}
	/**
	 * Compares this object against the specified object. The 
	 * result is <code>true</code> if and only if the argument is 
	 * not <code>null</code> and is a <code>Coffee</code> object 
	 * whose attributes all equal this object's attributes.
	 *
	 * @param   o   the object to compare with.
	 *
	 * @return  <code>true</code> if the objects are equal and
	 *          <code>false</code> otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Cobol)) {
			return false;
		}
		Cobol c = (Cobol) o;
		
		
		if (!ifCobolObjEqual(program_id, c.program_id)) {
			return false;
		}
		
		if (!ifCobolObjEqual(sectionName, c.sectionName)) {
			return false;
		}
		

		return true;
	}
	
	 @Override
	  public int hashCode() {
	    return super.hashCode();
	  }


	/**
	 * Return line of commented text from the COBOL program.
	 *
	 * @return line of commented text from the COBOL program
	 */
	public String getCommentLine() {
		return commentLine;
	}
	

	/**
	 * Return the name of this COBOL program.
	 *
	 * @return the name of this COBOL program
	 */
	public String getProgram_ID() {
		return program_id;
	}

	/**
	 * Return the section name.
	 *
	 * @return the section name
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * Return the division name.
	 *
	 * @return the division name
	 */
	public String getDivisionName() {
		return divisionName;
	}
	
	/**
	 * Return the dayDateWritten of this COBOL program.
	 *
	 * @return the dayDateWritten of this COBOL program
	 */
	public int getDayDateWritten() {
		return dayDateWritten;
	}

	
	/**
	 * Return the monthWritten of this COBOL program.
	 *
	 * @return the monthWritten of this COBOL program
	 */
	public String getMonthDateWritten() {
		return monthDateWritten;
	}
	
	/**
	 * Return the dayDateWritten of this COBOL program.
	 *
	 * @return the dayDateWritten of this COBOL program
	 */
	public int getYearDateWritten() {
		return yearDateWritten;
	}
	
	/**
	 * Set a line of commented text from the COBOL program.
	 *
	 * @return line of commented text from the COBOL program
	 */
	public void setCommentLine(String commentLine) {
		this.commentLine = commentLine;
	}



	/**
	 * Set the name of this cobol file.
	 *
	 * @param   String   the name
	 */
	public void setProgram_ID(String program_idString) {
		this.program_id = program_idString;
	}

	/**
	 * Set the dayDateWritten of this COBOL program.
	 *
	 * @param the dayDateWritten of this COBOL program
	 */
	public void setDayDateWritten(int dayDateWritten) {
		this.dayDateWritten = dayDateWritten;
	}
	
	/**
	 * Return the monthWritten of this COBOL program.
	 *
	 * @return the monthWritten of this COBOL program
	 */
	public void setMonthDateWritten(String monthDateWritten) {
		this.monthDateWritten = monthDateWritten;
	}
	
	/**
	 * Set the yearDateWritten of this COBOL program.
	 *
	 * @param the yearDateWritten of this COBOL program
	 */
	public void setYearDateWritten(int yearDateWritten) {
		this.yearDateWritten = yearDateWritten;
	}
	

	/**
	 * Set the section name 
	 *
	 * @param  String sectionName
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	/**
	 * Set the division name 
	 *
	 * @param  String divisionName
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * Return a textual description of this cobol type.
	 * 
	 * @return a textual description of this cobol type
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(program_id);
		buf.append(", ");
		buf.append(divisionName);
		buf.append(", ");
		buf.append(sectionName);
		
		return buf.toString();
	}
	public String getConstantName() 
	{
		return constantName;
	}
	
	public void setConstantName(String constantName) 
	{
		this.constantName = constantName;
	}
	
	public double getConstantValue() 
	{
		return constantValue;
	}
	
	public void setConstantValue(double constantValue) 
	{
		this.constantValue = constantValue;
	}
	
	public int getLineNumber() 
	{
		return lineNumber;
	}
	
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
	/**
	 * Return the is Stop Run.
	 *
	 * @returns stopRun
	 */
	public boolean getIsStopRun() 
	{
		return isStopRun;
	}
	
	/**
	 * Set the section name 
	 *
	 * @param  String sectionName
	 */
	public void setIsStopRun(boolean isStopRun) 
	{
		this.isStopRun = isStopRun;
	}
	
	/**
	 * Return the random range.
	 *
	 * @returns randomRange
	 */
	public String getRandomRange() 
	{
		return randomRange;
	}
	
	/**
	 * Set the random range
	 *
	 * @param  String randomRange
	 */
	public void setRandomRange(String randomRange) 
	{
		this.randomRange = randomRange;
	}
	
	/**
	 * Return the moveToVariable.
	 *
	 * @returns moveToVariable
	 */
	public String getMoveToVariable() 
	{
		return moveToVariable;
	}
	
	/**
	 * Set the moveToVariable
	 *
	 * @param  String moveToVariable
	 */
	public void setMoveToVariable(String moveToVariable) 
	{
		this.moveToVariable = moveToVariable;
	}
	
	/**
	 * Return the moveToVariableRange.
	 *
	 * @returns moveToVariableRange
	 */
	public String getmoveToVariableRange() 
	{
		return moveToVariableRange;
	}
	
	/**
	 * Set the moveToVariableRange 
	 *
	 * @param  String moveToVariableRange
	 */
	public void setmoveToVariableRange(String moveToVariableRange) 
	{
		this.moveToVariableRange = moveToVariableRange;
	}
	
	/**
	 * Return the moveValueIsInt.
	 *
	 * @returns moveValueIsInt
	 */
	public boolean getIsMoveValueInt() 
	{
		return moveValueIsInt;
	}
	
	/**
	 * Set the moveValueIsInt 
	 *
	 * @param  boolean moveValueIsInt
	 */
	public void setIsMoveValueInt(boolean moveValueIsInt) 
	{
		this.moveValueIsInt = moveValueIsInt;
	}
	
	/**
	 * Return the input file.
	 *
	 * @returns inputFile
	 */
	public String getInputFile() 
	{
		return inputFile;
	}
	
	/**
	 * Set the input file 
	 *
	 * @param String inputFile
	 */
	public void setInputFile(String inputFile) 
	{
		this.inputFile = inputFile;
	}
	
	/**
	 * Return the output file.
	 *
	 * @returns outputFile
	 */
	public String getOutputFile() 
	{
		return outputFile;
	}
	
	/**
	 * Set the output file 
	 *
	 * @param String outputFile
	 */
	public void setOutputFile(String outputFile) 
	{
		this.outputFile = outputFile;
	}
	
}
