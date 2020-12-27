package ParkingLot;

import java.util.List;

public  abstract class Vehicle {
	 
	String licenseId;
	
	SLOT_SIZE size;
	
	List<ParkingSlot> slots;
	
	int slotsNeedesd;
	
	public void parkingInSlot(ParkingSlot s) {
		slots.add(s);
	}
	public void clearingSlots() {
		
	}
	
	public abstract boolean canFitInSpot();
	
	

}
