package maze;

import java.io.Serializable;
import java.util.ArrayList;

public class mazeSolver implements Serializable {
	
	private static final long serialVersionUID = 5757286137364807706L;

	private Room[][] my2DMaze;
	
	private Player testPlayer;
	
	private ArrayList<Room> visitedRooms = new ArrayList<Room>();
	
	public mazeSolver(final Room[][] my2DMaze) {
		
		this.my2DMaze = my2DMaze;
		
	}
	
	public boolean solveMaze() {
		testPlayer = new Player();
		//explores while the stack has more moves
		do  {
			visitedRooms.add(my2DMaze[testPlayer.getY()][testPlayer.getX()]);
			
			if (allowDoorAccess(0) && testPlayer.backTracker.peek() != 2 
					&& hasBeenVisited(my2DMaze[testPlayer.getY()-1][testPlayer.getX()])) {
				testPlayer.moveSuccess(0);
			}
			else if(allowDoorAccess(1) && testPlayer.backTracker.peek() != 3
					&& hasBeenVisited(my2DMaze[testPlayer.getY()][testPlayer.getX()+1])) {
				testPlayer.moveSuccess(1);
			}
			else if (allowDoorAccess(2) && testPlayer.backTracker.peek() != 0
					&& hasBeenVisited(my2DMaze[testPlayer.getY()+1][testPlayer.getX()])) {
				testPlayer.moveSuccess(2);
			}
			else if (allowDoorAccess(3) && testPlayer.backTracker.peek() != 1
					&& hasBeenVisited(my2DMaze[testPlayer.getY()][testPlayer.getX()-1])) {
				testPlayer.moveSuccess(3);
			}
			else if (testPlayer.backTracker.peek() != -1) {
				
				int previousMove = testPlayer.backTracker.pop();
				
				switch(previousMove) {
				case(0):
					testPlayer.moveSuccess(2);
					testPlayer.backTracker.pop();
					break;
				case(1):
					testPlayer.moveSuccess(3);
					testPlayer.backTracker.pop();
					break;
				case(2):
					testPlayer.moveSuccess(0);
					testPlayer.backTracker.pop();
					break;
				case(3):
					testPlayer.moveSuccess(1);
					testPlayer.backTracker.pop();
					break;
				}
				
			}
			
			if (finalRoomCheck()) {
				return true;
			}
			
			
		} while (testPlayer.backTracker.size() != 0);
		
		return false;
	}
	
	private boolean allowDoorAccess(int door) {
		return (!my2DMaze[testPlayer.getY()][testPlayer.getX()].cardinalDoors[door].getDoorLock());
	}
	
	private boolean finalRoomCheck() {
		return (my2DMaze.length-2 == testPlayer.getY() &&
				my2DMaze[my2DMaze.length-2].length-2 == testPlayer.getX());
	}
	private boolean hasBeenVisited(Room room) {
		return !(visitedRooms.contains(room));
	}
}
