package maze;

import java.util.Random;

public class Tom {
  
  static Door dr;
  
  //randomize Tom into random position in maze
  public int randomLocation() {
    Random rand = new Random();
    int randNum = rand.nextInt(4); //0-3
    
    while (randNum == 0) {
      randNum = rand.nextInt(4);
    }
    
    //System.out.println(randNum);
    return randNum;
  }
  
  //https://www.asciiart.eu/people/occupations/wizards
  //https://ascii.co.uk/art/key
  public void tomIntroPrompt() {
    System.out.println("A wizard by the name of OmniTom has appeared!");
    System.out.println("OmniTom: \"Answer my riddle and I'll open the next door too! If you fail I'll let you resume your regular maze questions~!\"\n");
    dr = new Door();
    
    dr.openDoorQuestion();
    dr.doorOpenOrLocked();
    if (dr.getDoorStatus() == true) {
    
      System.out.println("                             /\\\r\n"
          + "                            /  \\\r\n"
          + "                           |    |\r\n"
          + "                         --:'''':--\r\n"
          + "                           :'_' :\r\n"
          + "                           _:\"\":\\___\r\n"
          + "            ' '      ____.'*:::  * '._\r\n"
          + "           . *=====<<=)* *  *   * \\  * :\r\n"
          + "            .  '      '-'-'\\_*   * /'._.'\r\n"
          + "                             \\====:_ \"\"\r\n"
          + "                            .'*  * \\\\\r\n"
          + "                           : *  *  :\r\n"
          + "                          / * : * *\\\r\n"
          + "                         :*  .   *  '.\r\n"
          + "         ,. _            : *: :*   * :\r\n"
          + "      '-'    ).          :__:-:__.;--'\r\n"
          + "    (        '  )        '-'   '-'\r\n"
          + " ( -          - _\r\n"
          + "(      __         )\r\n"
          + " -    /o \\_____    )\r\n"
          + " (    \\__/-=\"=\"`  )");
      
      System.out.println("\nOmniTom: \"Woohoo~! You did it! Here's a key for the next door, it'll break after that use though. \nMagic could put it back together, but I'm tired now so good luck! Bye-bye~!\"");
      
    } else {
      System.out.println(""
          + "         /\\       \r\n"
          + "        / *\\      \r\n"
          + "       /   *\\     \r\n"
          + "      /  *   \\   \r\n"
          + "     |     *  | \r\n"
          + "     | *     *| \r\n"
          + "     |  *     | \r\n"
          + "  ___:-\"\"\"\"\"\"-:___\r\n"
          + "   .' _      _ '.\r\n"
          + "  /   O      O   \\\r\n"
          + " :        |   `.  :\r\n"
          + " |        J       |   sad\r\n"
          + " :     .\"\"\"\".     :\r\n"
          + "  \\   /  === \\   /\r\n"
          + "   '. |      | .'\r\n"
          + "     '|      |'\r\n"
          + "       \\    /           \r\n"
          + "        \"\"\"\"");
      
      System.out.println("OmniTom: \"Ooooh, you failed. Sorry, but my work here is done. Toodles~!\"");
    }
   
  }
  
  public boolean tomDoorStatus() {
    return dr.getDoorLock();
  }
  
//  public static void main(String[] args) {
//    tomIntroPrompt();
//  }
  
}
