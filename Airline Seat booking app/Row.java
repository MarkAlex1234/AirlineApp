
/**
 * 
 * Mark Alexander
 * 
 * Student ID: 20112145
 * 
 * COMP503
 * 
 * Maintains an integer value representing a SeatLayout row number 1..10
 * 
 * 
 * */
public class Row 
{

	private Integer rowNumber;

	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * Constructor with an input row number.
	 * 
	 * */
	public Row(int number)
	{
		this.rowNumber = number;
	}
	
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method
	 * 
	 * */
	public int getNumber() 
	{
		return this.rowNumber;
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * set method
	 * 
	 * */
	public void setNumber(int number) 
	{
		this.rowNumber = number;
	}
	//----------------------------------------------------------------------------------------------
	public boolean equals(Row o)
	{
		return rowNumber.equals(o.rowNumber);
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * String representation of the row.
	 * 
	 * */
	public String toString()
	{
		String out = "";
		return out + this.rowNumber;
	}
	//----------------------------------------------------------------------------------------------
}
