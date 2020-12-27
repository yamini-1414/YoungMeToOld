package Design.elevator;

public interface ElevatorService {
	// To update the status of elevator - WORKING, MAINTAINENCE
   public boolean updateStatus(STATUS status);
   // To get the status of the elevator
   public STATUS getStatus();
   // To add the destination to the elevator
   public void addDestination(int destination);
   // To get the current floor
   public int getCurrentFloor();
   // To check if its working by moving one floor at a time
   public boolean checkIfServed();
   //To check the direction of the elevator
   public DIRECTION getDirection();
   // To get the total requests need to be served
   public int getRequests();
   // To get the next floor
   public int getNextFloor();
}
