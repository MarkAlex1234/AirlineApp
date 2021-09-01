
/**
 * 
 * Mark Alexander
 * 
 * Student ID: 20112145
 * 
 * COMP503
 * 
 *  Column class stores a letter refering to a column of seats in the SeatLayout
 * 
 * 
 * */
public class Column {

	private Character theColumn;
	
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method
	 * 
	 * */	
	public char getLetter() {
		return this.theColumn;
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * Set method
	 * 
	 * */
	public void setLetter(char letter) {
		this.theColumn = letter;
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * Constructor takes as input a character representing the column letter
	 * 
	 * */
	public Column(char letter)
	{
		this.theColumn = letter; 
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * Two columns are equal when their letters match (case sensitive)
	 * 
	 * */
	public boolean equals(Column o)
	{
		return theColumn.equals(o.theColumn);
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * returns  the letter of the column as a string.
	 * 
	 * */
	public String toString()
	{
		String out = "";
		return out + this.theColumn;
	}
	//----------------------------------------------------------------------------------------------
}
