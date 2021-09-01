
/**
 * 
 * Mark Alexander
 * 
 * Student ID: 20112145
 * 
 * COMP503
 * 
 *  AirlineReservation class contains a SeatLayout 
 *  and methods to reserve seats
 * 
 * 
 * */
public class AirlineReservation {

	private SeatLayout seatLayout;

	//------------------------------------------------------------------
	public SeatLayout getSeatLayout()
	{
		return this.seatLayout;
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * Reserves a seat according to the row and column.
	 * returns true if the seat reservation was successful and false otherwise.
	 *
	 * */
	public boolean reserveSeat(Row row, Column column)
	{	
	
		try{
			Position selectedSeat = new Position(row,column);
			Seat theSeat = this.seatLayout.getSeat(selectedSeat);
			theSeat.setReserved(true);
			return true;
			}catch(Exception e) {
			return false;
		}
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * 
	 * Reserves an unreserved seat according to firstClass and the seatType.
	 * 
	 * */
	public Seat reserveAvailableSeatType(boolean firstClass,SeatType type)
	{
		Seat selectedSeat = this.getSeatLayout().getAvailableSeatType(firstClass, type);
		if (!selectedSeat.isReserved() && selectedSeat.isFirstClass() == firstClass) {
			selectedSeat.setReserved(true);
			return selectedSeat;
		}
		else {
			return selectedSeat;
		}
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * Takes as input a seatLayout parameter to set the instance variable
	 * 
	 * */
	public AirlineReservation(SeatLayout seatLayout)
	{
					this.seatLayout = seatLayout;
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * String representation of the AirlineReservation.
	 * 
	 * An example output is the toString from seatlayout and some availability statistics
	 * 
	 * ----------------------------------
	 * W[ ] A[X] A[ ] M[X] A[ ] A[ ] W[ ] 
	 * W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
	 * W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
	 * W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
	 * w[X] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * ----------------------------------
	 * # Window seats available: 19
	 * # Aisle seats available: 39
	 * # Middle seats available: 9
	 * 
	 * */
	public String toString()
	{
		
		String out="# Window seats available: " + this.seatLayout.getAvailabileAmount(SeatType.WINDOW) + "\n# Aisle seats available: " +this.seatLayout.getAvailabileAmount(SeatType.AISLE) + "\n# Middle seats available: " +this.seatLayout.getAvailabileAmount(SeatType.MIDDLE);
		return seatLayout.toString()+"\n"+out;
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * 
	 * Reserves an entire column of seats.
	 * You do not need to check if the seats are already reserved -- simple reserve them.
	 * 
	 * */
	public void reserveColumn(Column column)
	{
		Seat[] selectedColumn = getSeatLayout().getColumnOfSeats(column);
		try{
			for(int i=0;i<=this.seatLayout.getNumberOfRows();i++) {
				selectedColumn[i].setReserved(true);
			}
		}catch(Exception e) {
			String doNothing="";
		}
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * 
	 * Reserves an entire row of seats.
	 * You do not need to check if the seats are already reserved -- simple reserve them.
	 * 
	 * */
	public void reserveRow(Row row) 
	{
		Seat[] selectedRow = getSeatLayout().getRowOfSeats(row);
		try{
			for(int i=0;i<=this.seatLayout.getNumberOfColumns();i++) {
				selectedRow[i].setReserved(true);
			}
		}catch(Exception e) {
			String doNothing="";
		}
		
	}
	//------------------------------------------------------------------

}