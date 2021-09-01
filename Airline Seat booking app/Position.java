
/**
 * 
 * Mark Alexander
 * 
 * Student ID: 20112145
 * 
 * COMP503
 * 
 *  Position refers to a seat's row and column location within the SeatLayout class 
 * 
 * 
 * */


public class Position 
{

	private Row posRow;
	private Column posColumn;
	
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Constructor with input for row and column
	 * 
	 * */
	public Position(Row row, Column column)
	
	{
		this.posRow = row;
		this.posColumn = column; 
	}	
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * returns a string representation of the position object. e.g. (5,E)
	 * 
	 * */
	public String toString()
	{
		String out = "";
		return out + "(" + this.posRow + "," + this.posColumn + ")";
		
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method
	 * 
	 * */
	public Column getColumn() 
	{
		return this.posColumn;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method
	 * 
	 * */
	public Row getRow() 
	{
		return this.posRow;
	}
	//------------------------------------------------------------------------------------------------------------------------
	public boolean equals(Position o)
	{
		return posRow.equals(o.posRow) && posColumn.equals(o.posColumn);	
	}
	//------------------------------------------------------------------------------------------------------------------------
}
