package Design.elevator;

import java.util.TreeSet;
public class Elevator implements ElevatorService {
	private static final int MAX_FLOOR = 10;
	private static final int MIN_FLOOR = -2;
	private Integer currFloor;
	// In case of multiple lifts  
	private  Integer id;
	// to store the floor values when the elevator is moving in the upward direction
	private TreeSet<Integer> upQueue;
	// to store the floor values when the elevator is moving in the downward direction
	private TreeSet<Integer> downQueue;
	
	private DIRECTION direction;
	private STATUS status;
	
	public Elevator(int id, int currFloor) {
		this.id = id;
		this.currFloor = currFloor;
		this.upQueue = new TreeSet<Integer>();
		this.downQueue = new TreeSet<Integer>((a,b)-> a-b);
		this.direction = DIRECTION.NONE;
		this.status = STATUS.WORKING;
	}

	@Override
	public boolean updateStatus(STATUS status) {
		// TODO Auto-generated method stub
		if(getRequests()>0)
			return false;
		this.status = status;
		return true;
	}

	@Override
	public STATUS getStatus() {
		// TODO Auto-generated method stub
		return this.status;
	}

	@Override
	public void addDestination(int destination) {
		if(this.currFloor<destination)
			this.upQueue.add(destination);
		else
			this.downQueue.add(destination);
	}

	@Override
	public int getCurrentFloor() {
		// TODO Auto-generated method stub
		return this.currFloor;
	}

	@Override
	public boolean checkIfServed() {
		direction();
		if(direction==DIRECTION.UP) {
			if(upQueue.first()==currFloor) {
				upQueue.pollFirst();
				if(upQueue.size()==0) {
					this.direction = DIRECTION.NONE;
				}
				return true;
			}else {
				   currFloor++;
			}
		}else if(direction == DIRECTION.DOWN) {
			if(downQueue.first()==currFloor) {
				downQueue.pollFirst();
				if(downQueue.size()==0)
					this.direction = DIRECTION.NONE;
			}
			return true;
		}else {
			// DO nothing
		}
		
		return false;
	}
	public void direction() {
		if(direction== DIRECTION.NONE) {
			if(upQueue.size()>0 && downQueue.size()>0) {
				if(Math.abs(currFloor-upQueue.first())<Math.abs(currFloor-downQueue.first()))
					direction = DIRECTION.UP;
				else
					direction = DIRECTION.DOWN;
			}else if(upQueue.size()>0)
				direction = DIRECTION.UP;
			else if(downQueue.size()>0)
				direction = DIRECTION.DOWN;
		}
	}

	@Override
	public DIRECTION getDirection() {
		// TODO Auto-generated method stub
		return this.direction;
	}

	@Override
	public int getRequests() {
		// TODO Auto-generated method stub
		return this.upQueue.size() + this.downQueue.size();
	}

	@Override
	public int getNextFloor() {
		if(direction == DIRECTION.UP)
			 return upQueue.first();
		else if(direction== DIRECTION.DOWN)
			return downQueue.first();
		else
			 return 0;
	}
}
