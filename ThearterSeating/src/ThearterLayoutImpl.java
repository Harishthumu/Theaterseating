import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThearterLayoutImpl implements ThearterLayout {

	@Override
	public int[][] getInputForTheater(int row, int section, String input) {
		int k = 0;
		String[] tempSeats = input.split(" ");
		List<Integer> listOfSeats = new ArrayList<Integer>();
		if (tempSeats.length != (row * section)) {
			System.out.println("The numbers in sections doesnt match row and section count. Please renter");
			System.exit(1);

		}
		for (String seat : tempSeats) {
			int seats = Integer.parseInt(seat);
			listOfSeats.add(seats);
		}
		int[][] arrayOfSeats = new int[row][section];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < section; j++) {

				arrayOfSeats[i][j] = listOfSeats.get(k);

				System.out.print(arrayOfSeats[i][j] + " ");
				k++;
			}
			System.out.println("");
		}

		return arrayOfSeats;
	}

	@Override
	public List<Map<String, Integer>> getTicketsForTheater(String[] ticketString) {

		List<Map<String, Integer>> listOfTickets = new CopyOnWriteArrayList<Map<String, Integer>>();
		Map<String, Integer> ticketsMap = null;
		for (int i = 0; i < ticketString.length; i += 2) {
			ticketsMap = new ConcurrentHashMap<String, Integer>();
			ticketsMap.put(ticketString[i], Integer.parseInt(ticketString[i + 1]));

			listOfTickets.add(ticketsMap);
		}
		return listOfTickets;
	}

	@Override
	public void allocateTickets(int[][] arrayOfSeats, List<Map<String, Integer>> listOfTickets, int row, int section) {
		int m = 0;
		for (Map<String, Integer> eachTic : listOfTickets) {
			for (Object ticket : eachTic.entrySet()) {
				m = 0;
				Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) ticket;
				for (int i = 0; i < row; i++) {
					if (m == 0) {
						for (int j = 0; j < section; j++) {
							if (entry.getValue() <= arrayOfSeats[i][j]) {
								int newSeats = arrayOfSeats[i][j] - entry.getValue();
								arrayOfSeats[i][j] = newSeats;
								System.out.println(entry.getKey() + " ROW " + i + " Section " + j);
								m++;
								listOfTickets.remove(eachTic);
								break;
							}

						}
					}

				}
			}

		}

		for (Map<String, Integer> eachTic : listOfTickets) {
			for (Object ticket : eachTic.entrySet()) {

				Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) ticket;
				System.out.println(entry.getKey() + " There is no vacancy. Please split your party");

			}

		}

	}

}
