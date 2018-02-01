import java.util.List;
import java.util.Map;

public interface  ThearterLayout {
	
	public int[][] getInputForTheater(int row, int section,String input);
	public List<Map<String, Integer>>  getTicketsForTheater(String[] ticketString);
	public void allocateTickets(int[][] arrayOfSeats, List<Map<String, Integer>> listOfTickets, int row, int section);

}
