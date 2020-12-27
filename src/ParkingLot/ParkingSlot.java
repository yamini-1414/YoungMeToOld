package ParkingLot;

public  class ParkingSlot {

	int slotId;
	
	SLOT_SIZE slotSize;
	
	int level;
	
	Vehicle vehicle;
	
	ParkingSlot(int slotId,SLOT_SIZE size,int level){
		this.slotId = slotId;
		this.slotSize = size;
		this.level = level;
	}
	
	public boolean isEmpty() {
		return this.vehicle==null;
	}

	public int getSlotId() {
		return slotId;
	}

	public SLOT_SIZE getSlotSize() {
		return slotSize;
	}

	public int getLevel() {
		return level;
	}

	
}
