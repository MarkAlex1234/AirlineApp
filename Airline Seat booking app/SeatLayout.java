
/**
 * 
 * Mark Alexander
 * 
 * Student ID: 20112145
 * 
 * COMP503
 * 
 */

public class SeatLayout 
{
	private final char OFFSET_LETTER = 'A';
	private int numberOfRows,numberOfColumns;
	private Seat seats[][];
	
	
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Constructor takes as input and sets the number of rows and columns
	 * must invoke the initialize() method.
	 * 
	 * 
	 * */
	public SeatLayout(int numberOfRows,int numberOfColumns)
	{
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		this.initialise();		
	}	
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * initializes the seats two-dimensional array as shown on the 
	 * right hand side of Figure 1 of the assignment brief.
	 * 
	 * */
	private void initialise()
	{	
		this.seats = new Seat[this.numberOfRows][this.numberOfColumns];
		
		for(int i=0;i<numberOfRows;i++) {
			for(int j=0;j<numberOfColumns;j++) {
				if(i>=0 && i<4){
					this.seats[i][j] = new Seat(seatType(j),translate(i,j)); 
					this.seats[i][j].setFirstClass(true);
				}
				else {
					this.seats[i][j] = new Seat(seatType(j),translate(i,j)); 
				}
			}
		}
		
		
		
	}
	//------------------------------------------------------------------------------------------------------------------------
	/***
	 * 
	 * Translates 2 dimensional array indicies (i,j) to a row column pair, returned as a new Position object.
	 *  
	 *    translate(0,0) returns Position with Row = 1 and Column = 'A'
	 *    translate(1,2) returns Position with Row = 2 and Column = 'B'
	 *    translate(2,2) returns Position with Row = 3 and Column = 'C' 
	 */
	private Position translate(int i,int j)
	{
		return new Position(new Row(i + 1), new Column((char) (OFFSET_LETTER + j)));
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * Translates a row to an i-index of the 2-dim array.
	 * translate(1) = 0
	 * translate(2) = 1 etc..
	 * */	
	private int translate(Row row)
	{
		return row.getNumber() - 1;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Translates a Column object to a j-index of the 2-dim array. Use OFFSET_LETTER final var
	 * translate('A') = 0
	 * translate('B') = 1
	 * translate('C') = 2
	 * 
	 * */
	private int translate(Column column)
	{
		return column.getLetter() - OFFSET_LETTER;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns the correct seat type given a j index for the seat layout 
	 * 
	 * 
	 * */
	private SeatType seatType(int j)
	{
		SeatType out = null;
		switch(j) {
		case 0:
			out = SeatType.WINDOW;
			break;
		case 3:
			out = SeatType.MIDDLE;
			break;
		case 6:
			out = SeatType.WINDOW;
			break;
		default: 
			out = SeatType.AISLE;
			break;
		}
		return out;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Given a position p, return the corresponding Seat.
	 * 
	 * If the position is not valid then return null.
	 * 
	 * */
	public Seat getSeat(Position p)
	{		
		try{Row row = p.getRow();
		Column column = p.getColumn();
		int newRow = translate(row);
		int newColumn = translate(column);
		
		return seats[newRow][newColumn];
		
		}catch(Exception e) {
			return null;
		}
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns a string representation of the seat layout similar to Figure 1 
	 * 
	 * */
	public String toString()
	{
		String out = "-------------------------------\n";
		for(int i=0;i<numberOfRows;i++) {
			for(int j=0;j<numberOfColumns;j++) {
				out = out+this.seats[i][j];
			}
			out = out+"\n";
		}	
		return out+"-------------------------------";
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * get method for seats instance variable
	 * */
	public Seat[][] getSeats()
	{		
		return this.seats;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns a row of seat objects.
	 * 
	 * 
	 * If the input row is not valid, then an empty array of Seat objects is returned.
	 * 
	 * 
	 * */
	public Seat[] getRowOfSeats(Row row)
	{	
		int realRow = translate(row);
		if (realRow > numberOfRows) {
			Seat[] emptyArray={};
			return emptyArray;
		}
		else {
			Seat[] rowArray = seats[realRow];
			return rowArray;
		}
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns a column of seat objects.
	 * 
	 * 
	 * If the input column is not valid, then an empty array of Seat objects is returned.
	 * 
	 * 
	 * */
	public Seat[] getColumnOfSeats(Column column) 
	{
		int realColumn = translate(column);
		if(realColumn <= numberOfColumns) {
			int counter=0;
		
			Seat[] Column = new Seat[this.numberOfRows];
		
			for(int cCounter=0;cCounter<this.numberOfColumns;cCounter++) {
				for(int rCounter=0;rCounter<this.numberOfRows;rCounter++) {
					if(seats[rCounter][cCounter].getPosition().getColumn().equals(column)) {
						Column[counter] = seats[rCounter][cCounter];
						counter++;
					}
				}
			}
			return Column;	
		}
			else {
			Seat[] emptyArray={};
			return emptyArray;
		}
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method for the number of rows
	 * 
	 * */
	public int getNumberOfRows()
	{
		return this.numberOfRows -1;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method for the number of columns
	 * 
	 * */
	public int getNumberOfColumns()
	{
		return this.numberOfColumns -1;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Counts and returns the amount of unreserved seats of the input type.
	 * 
	 * */
	public int getAvailabileAmount(SeatType type) 
	{
		int totalAmount=0;
		
		for(int row=0;row<numberOfRows;row++) {
			for (int column=0;column<numberOfColumns;column++) {
				if(this.seats[row][column].isReserved() == false && this.seats[row][column].getType() == type) {
						totalAmount++;
				}
			}
		}
		
		return totalAmount;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns any seat that matches firstClass and the seat type and is unreserved.
	 * 
	 * If no such seat is available then null is returned.
	 * 
	 * */
	public Seat getAvailableSeatType(boolean firstClass, SeatType type) 
	{
		Seat theSeat = seats[0][0];
		try {
			for(int row=0;row<numberOfRows;row++) {
				for (int column=0;column<numberOfColumns;column++) {
					if(this.seats[row][column].isFirstClass() == firstClass && this.seats[row][column].getType() == type && this.seats[row][column].isReserved() == false) {
							theSeat = seats[row][column];
							return theSeat;		
				}
			}
		}
		}catch(Exception e) {
			return null;
		}
		return null;
	}
	//------------------------------------------------------------------------------------------------------------------------
}
