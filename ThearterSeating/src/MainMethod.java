import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainMethod {
	
	public static void main(String[] args){
	System.out.println("Please enter the rows for the theartre");
	Scanner rowScanner = new Scanner(System.in);
	int row= Integer.parseInt(rowScanner.nextLine());
	System.out.println("Please enter number of sections in each row for the theartre");
	Scanner sectionScanner = new Scanner(System.in);
	int section =Integer.parseInt(sectionScanner.nextLine());
	System.out.println("Please enter the section number in each row in theatre followed by space");
	
	
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	
	System.out.println("Enter the name and tickets number");
	Scanner ticketScanner = new Scanner(System.in);
	String[] ticketString = (ticketScanner.nextLine()).split(" ");
	ThearterLayout layOut= new ThearterLayoutImpl();
	int[][] arrayOfSeats= layOut.getInputForTheater(row, section, input);
	List<Map<String,Integer>> listOfTickets=layOut.getTicketsForTheater(ticketString);
	layOut.allocateTickets(arrayOfSeats, listOfTickets, row, section);
	
	}
}
