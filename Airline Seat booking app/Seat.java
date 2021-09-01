
/**
 * 
 * Mark Alexander
 * 
 * Student ID: 20112145
 * 
 * COMP503
 *  
 * */
public class Seat 
{
	//static variables to assist code readability
	static public final boolean FIRST_CLASS = true;
    static public final boolean ECONOMY_CLASS = !FIRST_CLASS;
    private String displaySeatType, displayReserved;
	private SeatType type;
	private Position position;
	private boolean reservedStatus,firstClass;

	//---------------------------------------------------------------------------------
	/**
	 * Constructor initialies the position and type of the seat with input.
	 * All boolean instance variables to false
	 * */
	public Seat(SeatType type,Position position)
	{		
		this.type = type;
		this.position = position;
		this.reservedStatus = false;
		this.firstClass = false;
	}	
	//---------------------------------------------------------------------------------
	/**
	 * get method for the firstClass instance variable.
	 * */
	public boolean isFirstClass() 
	{
			return this.firstClass;
	}
	//---------------------------------------------------------------------------------
	/**
	 * set method for the firstClass instance variable
	 * */
	public void setFirstClass(boolean firstClass) 
	{
		this.firstClass = firstClass;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * Get method for the type instance variable
	 * 
	 * */
	public SeatType getType()
	{
		return this.type;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * Get method for the reserved instance variable
	 * 
	 * */
	public boolean isReserved()
	{
		return this.reservedStatus;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * set method for the reserved instance variable
	 * 
	 * */
	public void setReserved(boolean reserved)
	{		
		this.reservedStatus = true;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * get method for the position instance variable
	 * 
	 * */
	public Position getPosition() 
	{
		return this.position;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * Returns a concise string representation of a Seat object 
	 * A[X] = AISLE seat in first class, reserved.
	 * w[ ] = WINDOW seat in economy, not reserved
	 * M[ ] = MIDDLE seat in first class, not reserved
	 * */
	public String toString()
	{
		
		switch(type) {
		case AISLE:
			if (this.firstClass == true) {
			displaySeatType = "A";
			}
			else displaySeatType = "a";
			break;
		case MIDDLE:
			if (this.firstClass == true) {
				displaySeatType = "M";
				}
				else displaySeatType = "m";
				break;
		case WINDOW:
			if (this.firstClass == true) {
				displaySeatType = "W";
				}
				else displaySeatType = "w";
				break;
		}
		
		if (this.reservedStatus == true) {
			displayReserved = "X";
		}
		else displayReserved = " ";
		
		String out = "";
		return out + displaySeatType +"["+ displayReserved +"]";
	}
	//---------------------------------------------------------------------------------
}