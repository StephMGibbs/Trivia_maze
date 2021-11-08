/**
 * 
 */
package maze;

/**
 * @author stephg02
 *
 */
public class Room {
  /*
   - has door object (up to 4)
   - 4 doors if in middle, 3 doors if edge-side , 2 doors if corner or BUFFER
   - makes up maze locations in 2D array
   - should look like: [ ]
   */
  
  public String displayPlayerInRoom() {
    return "[o]";
  }
  
  public String displayEmptyRoom() {
    return "[ ]";
  }
  
  public String displayClosedRoom() {
    return "[x]";
  }
}
