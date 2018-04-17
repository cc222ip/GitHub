package cc222ip_assign2;

import java.util.Stack;

/**
 * @author Chris_Chevalier
 *
 */
public class Vehicle {
	protected String name;
	protected int nbPassengers;
	protected int maxPassengers;
	protected int space;
	protected int price;
	protected int passengerPrice;
	protected Stack<Passenger> passengerList; // Stack to stock the passengers in the vehicle.
	
	public Vehicle() {
		passengerList = new Stack<Passenger>(); // Initialization of the stack.
	}
	
	/**
	 * @param p
	 * @throws FerryException
	 */
	public void addPassenger(Passenger p) throws FerryException {
		if(passengerList.size() >= maxPassengers) // Check if the vehicle can receive more passenger and run an exception if it's necessary.
			throw new FerryException("The " + this.name +" is full.");
		passengerList.push(p); // Push the passenger 'p' in the passenger stack.
		nbPassengers++; // Increase the number of passenger in the vehicle.
	}
	
	/**
	 * @return
	 */
	public Passenger removePassenger() {
		nbPassengers--; // Decrease the number of passenger in the vehicle.
		return passengerList.pop(); // Pop and return a passenger from the vehicle.
	}
}
