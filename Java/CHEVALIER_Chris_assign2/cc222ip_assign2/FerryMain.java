package cc222ip_assign2;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Chris_Chevalier
 *
 */
public class FerryMain implements Ferry {
	private final int maxPassengers = 200; // The ferry has space for 200 passengers
	private final int maxSpace = 50; // and 50 cars.
	private int currentSpace = 0; // The current space is initialized to 0.
	private int money = 0; // The current earned money is initialized to 0.
	private static Stack<Vehicle> vehicleList; // Stack to stock the vehicles on board.
	private static Stack<Passenger> passengerList2; // Stack to stock the passengers on board.
	int bicycles = 0; // Counts the bicycles on board.
	
	public FerryMain() {
		vehicleList = new Stack<Vehicle>(); // Initialization of the both stacks.
		passengerList2 = new Stack<Passenger>();
	}
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		FerryMain F = new FerryMain(); // Creation of the ferry with no one on board -> The both stack are empty.
		Passenger p = new Passenger("Chevalier", "Chris", 25); // A first passenger is created.
		Car c = new Car(); // Creation of few different vehicles.
		Bicycle b = new Bicycle();
		Bus B = new Bus();
		Lorry l = new Lorry();
		try {
			c.addPassenger(new Passenger("Poulet", "Basquaise", 80)); // Add 4 new passengers in the car.
			c.addPassenger(new Passenger("Ayache", "Mehdi", 20));
			c.addPassenger(new Passenger("Anselme", "Manon", 23));
			c.addPassenger(new Passenger("Andria", "Valentin", 23));
			
			b.addPassenger(new Passenger("Paul", "Franck", 40)); // Add 1 new passenger in the bicycle.
			
			B.addPassenger(new Passenger("Jean", "Barque", 29)); // Add 5 new passengers in the bus.
			B.addPassenger(new Passenger("Jean", "Pierre", 59));
			B.addPassenger(new Passenger("Jean", "Jean", 38));
			B.addPassenger(new Passenger("Jean", "Minet", 56));
			B.addPassenger(new Passenger("Jean", "Paul", 76));
			
			l.addPassenger(new Passenger("Jessica", "Galou", 66)); // Add 2 new passengers in the lorry.
			l.addPassenger(new Passenger("Eddy", "Malou", 30));
		}
		catch(FerryException e) { e.printStackTrace(); }
			
		F.embark(p); // Embark the passenger alone and all the vehicles in the ferry.
		F.embark(b);
		F.embark(c);
		F.embark(B);
		F.embark(l);
			
		Bus B2 = new Bus(); // Creation of a new bus to test the "hasSpaceFor" method.
		if(F.hasSpaceFor(B2)) // Test if there is enough space for the bus B2.
			System.out.println("There is still free space for a " + B2.name);
			
		System.out.println();
		System.out.println(F); // Clear display of the board's status.
			
		Iterator <Vehicle> ite = vehicleList.iterator(); // Displays the different vehicles on board with iterators.
		System.out.println("List of differents vehicles on board:");
		while(ite.hasNext())
			System.out.println("- " + ite.next().name);
		System.out.println();
		
		F.disembark(); // Disembark all the vehicles and all the passengers.
		System.out.println("Number of passengers on board (after disembark): " + F.countPassengers());
		System.out.println("Available free space (after disembark): " + F.countVehicleSpace());
	}

	@Override
	public int countPassengers() { // Return the number of passengers on board.
		return passengerList2.size(); // Indeed, it's equal to the size of this stack.
	}

	@Override
	public Iterator<Vehicle> iterator() { // Creation of the iterator of vehicles.
		return new Iterator<Vehicle>() {
			int pos = 0;

			@Override
			public boolean hasNext() { // Test if the current iterator has a next.
				return pos < vehicleList.size();
			}

			@Override
			public Vehicle next() { // The current position of the iterator switch to the next.
				return vehicleList.elementAt(pos++);
			}
		};
	}

	@Override
	public int countVehicleSpace() { // Return the used vehicle space.
		return currentSpace + (bicycles / 5);
	}

	@Override
	public int countMoney() {  // Return the earned money.
		return money;
	}

	@Override
	public void embark(Vehicle v) { // Embark vehicle, with a display if there is not enough space.
		if(currentSpace >= maxSpace) {
			System.out.println("Warning ! The ferry has no more space, " + v.name + " can't embarks.");
			return;
		}
		else if(alreadyEmbark(v)) { // Avoid that a vehicles already on board embark a second time.
			System.out.println("Warning ! This " + v.name + " is already on board.");
			return;
		}
		if(v.name == "bicycle") // Increases the number of bicycles on board.
			bicycles += 1;
		
		money += v.price + (v.passengerPrice * v.passengerList.size()); // Calcul the total price for the vehicle and his passengers.
		while(v.nbPassengers > 0) {
			passengerList2.push(v.removePassenger()); // Embark all the passengers of the vehicle on board.
		}
		currentSpace += v.space; // Increase the current space taken by vehicles.
		vehicleList.push(v); // Push the vehicle v in the vehicles on board's stack.
	}
	
	public boolean alreadyEmbark(Vehicle v) { // Check if a vehicle is already on board.
		for(int i = 0; i < vehicleList.size(); i++) {
			if(vehicleList.elementAt(i) == v)
				return true;
		}
		return false;
	}

	@Override
	public void embark(Passenger p) { // Embark passenger, warning if not enough room.
		if(passengerList2.size() >= maxPassengers) { // Check if the passenger can embark.
			System.out.println("Warning ! There is no free space for " + p.surname + " " + p.name + ".");
			return;
		}
		money += 25; // Increase earned money.
		passengerList2.push(p); // Push the passenger p in the passengers on board's stack.
	}

	@Override
	public void disembark() { // Empty the ferry. The money earned remains.
		passengerList2.clear(); // Empty the passengers on board's stack.
		vehicleList.clear(); // Empty the vehicles on board's stack.
		currentSpace = 0;
	}

	@Override
	public boolean hasSpaceFor(Vehicle v) { // Check if the vehicle v can embark.
		if((v.space + currentSpace) <= maxSpace)
			return true;
		return false;
	}

	@Override
	public boolean hasRoomFor(Passenger p) { // Chekc if the passenger p can embark.
		if(passengerList2.size() < maxPassengers)
			return true;
		return false;
	}
	
	@Override
	public String toString() { // Display a nice looking of the ferry status.
		return "Ferry's status: \n \n"
				+"Number of Passengers on board: " + countPassengers() + "/" + maxPassengers + "\n"
				+"Used space: " + countVehicleSpace() + "/" + maxSpace + "\n"
				+"Money earned: " + countMoney() + " kr \n"
				+"Number of vehicles on board: " + vehicleList.size() + "\n";
	}
}