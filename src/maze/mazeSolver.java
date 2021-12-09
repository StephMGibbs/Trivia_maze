package maze;

import java.io.Serializable;
import java.util.ArrayList;

public class mazeSolver implements Serializable {
	
	private static final long serialVersionUID = 5757286137364807706L;

	Room[][] my2DMaze;
	
	Player testPlayer;
	
	
	/** The visited rooms stored in ArrayList of type Room. */
	ArrayList<Room> visitedRooms = new ArrayList<Room>();
	
	
	/**
	 * Instantiates a new maze solver w/ Room 2d maze.
	 *
	 * @param my2DMaze the my 2 D maze
	 */
	public mazeSolver(Room[][] my2DMaze) {
		
		this.my2DMaze = my2DMaze;
		
	}
	
	public boolean solveMaze() {
		testPlayer = new Player();
		//explores while the stack has more moves
		do  {
			visitedRooms.add(my2DMaze[testPlayer.getY()][testPlayer.getX()]); //visitedRoom array adds players coordinate in maze
			
			//sees if top of backTracker stack isn't n(2)/e(1)/s(0)/w(3) (if -1 then pop to go to last move) & door open -> if in ArrayList contains direction then moves that way
			if (allowDoorAccess(0) && testPlayer.backTracker.peek() != 2 
					&& hasBeenVisited(my2DMaze[testPlayer.getY()-1][testPlayer.getX()])) { //if down visited
				testPlayer.moveSuccess(0);
			}
			else if(allowDoorAccess(1) && testPlayer.backTracker.peek() != 3
					&& hasBeenVisited(my2DMaze[testPlayer.getY()][testPlayer.getX()+1])) { //if right visited
				testPlayer.moveSuccess(1);
			}
			else if (allowDoorAccess(2) && testPlayer.backTracker.peek() != 0
					&& hasBeenVisited(my2DMaze[testPlayer.getY()+1][testPlayer.getX()])) { //if up visited
				testPlayer.moveSuccess(2);
			}
			else if (allowDoorAccess(3) && testPlayer.backTracker.peek() != 1
					&& hasBeenVisited(my2DMaze[testPlayer.getY()][testPlayer.getX()-1])) { //if left visited
				testPlayer.moveSuccess(3);
			}
			else if (testPlayer.backTracker.peek() != -1) {
				int previousMove = testPlayer.backTracker.pop();
				
				switch(previousMove) { //looks if last move N(2)/E(1)/S(0)/W(3) then pops it off stack (makes -1)
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
			
			if (finalRoomCheck()) { //true if final room
				return true;
			}
			
			
		} while (testPlayer.backTracker.peek() != -1);  //executes above code until top stack is -1
		    //-1 is initial value, if reached then reached end of player move history
		
		return false; //false if not final room 
	}
	
	/**
	 * Allow door access; true if maze door open.
	 *
	 * @param door the door
	 * @return true, if successful
	 */
	public boolean allowDoorAccess(int door) {
		return (!my2DMaze[testPlayer.getY()][testPlayer.getX()].cardinalDoors[door].getDoorLock());
	}
	
	/**
	 * Final room check; true if maze length -2 for x/y.
	 *
	 * @return true, if successful
	 */
	private boolean finalRoomCheck() {
		return (my2DMaze.length-2 == testPlayer.getY() &&
				my2DMaze[my2DMaze.length-2].length-2 == testPlayer.getX());
	}
	
	/**
	 * Checks if visitedRooms ArrayList has been visited (contains certain room obj).
	 *
	 * @param room the room
	 * @return true, if successful
	 */
	private boolean hasBeenVisited(Room room) {
		return !(visitedRooms.contains(room));
	}
}
