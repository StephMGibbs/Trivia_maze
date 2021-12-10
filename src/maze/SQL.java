/**
 * 
 */
package maze;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import org.sqlite.SQLiteDataSource;

/**
 * @author still
 *
 */
public class SQL {

  private static ArrayList<Question> questionArray = new ArrayList<> (); 
  private Queue<Question> questionQueue = new LinkedList<Question> ();
  private static SQLiteDataSource questions = null; 
  
  
  /**
   * @param args
   */
//  public static void main(String[] args) {
//    // TODO Auto-generated method stub
//    try {
//      questions = new SQLiteDataSource();
//      questions.setUrl("jdbc:sqlite:questions.db");
//
//  } catch (Exception e) {
//      e.printStackTrace();
//      System.exit(0);
//  }
//    System.out.println( "Opened database successfully" );
//    
//    
//    String queryMC = "CREATE TABLE IF NOT EXISTS multipleChoice ("
//        + "QUESTION TEXT PRIMARY KEY NOT NULL," //not null & 1 only
//        + "ISTOM BOOLEAN NOT NULL,"
//        + "CORRECTANS TEXT NOT NULL,"
//        + "ANSWER2 TEXT NOT NULL,"
//        + "ANSWER3 TEXT NOT NULL,"
//        + "ANSWER4 TEXT NOT NULL)";
//
////String queryTF = "CREATE TABLE IF NOT EXISTS trueFalse ("
////      + "QUESTION TEXT PRIMARY KEY,"
////      + "ISTOM BOOLEAN,"
////      + "CORRECTANS TEXT NOT NULL,"
////      + "FALSEANS TEXT NOT NULL)";
//
//
//try ( Connection conn = questions.getConnection();
//        Statement stmt = conn.createStatement();) {
//    
//    int rv = stmt.executeUpdate(queryMC);
//    System.out.println( "executeUpdate() returned " + rv );
//    
////  rv = stmt.executeUpdate(queryToTF);
////  System.out.println( "ExecuteUpdate() returned " + rv );
////  
//    
//} catch (SQLException e) {
//    e.printStackTrace();
//    System.exit(0);
//}
//
////0 = false, 1 = true
//  String queryToMC = "INSERT INTO multipleChoice (QUESTION, ISTOM, CORRECTANS, ANSWER2, ANSWER3, ANSWER4) VALUES ('What's the first commercially successful video game?', 0, 'n1.Pong', 'n2.Tank', 'n3.Spacewar!', 'n4.Tennis for Two') ";
//    
////String queryToTF = "INSERT INTO trueFalse (QUESTION, ISTOM, CORRECTANS, FALSEANS) VALUES ('Nintendo originally intended the PlayStation to be an add on to the SNES', false, true, false)";
//
//try ( Connection conn = questions.getConnection();
//    Statement stmt = conn.createStatement(); ) { // Statement stmt = conn.createStatement();
//    int rv = stmt.executeUpdate(queryToMC); //TODO: fix
//    System.out.println( "1st executeUpdate() returned " + rv );
//
//    //rv = stmt.executeUpdate(queryToTF);
//    //System.out.println( "2nd executeUpdate() returned " + rv );
//    
//} catch ( SQLException e ) {
//    e.printStackTrace();
//    System.exit( 0 );
//}
//  
//
//System.out.println( "Selecting all rows from test table" );
//queryMC = "SELECT * FROM multipleChoice";
//
//
//try ( Connection conn = questions.getConnection();
//    Statement stmt = conn.createStatement(); ) {
//  
//  ResultSet rs = stmt.executeQuery(queryMC);
//  
//  while(rs.next()) {
//      String question = rs.getString("QUESTION");
//      boolean isTom = rs.getBoolean("ISTOM");
//      String correctAns = rs.getString("CORRECTANS");
//      String answer2 = rs.getString("ANSWER2");
//      String answer3 = rs.getString("ANSWER3");
//      String answer4 = rs.getString("ANSWER4");
//      
//      
//      Question multChoice = new MultipleChoiceQuestion(question, isTom, correctAns, answer2, answer3, answer4);
//      questionArray.add(multChoice);
//  }
//  
////System.out.println( "Selecting all rows from test table" );
////queryTF = "SELECT * FROM trueFalse";
////
////rs = stmt.executeQuery(queryTF);
////
////while(rs.next()) {
////    String question = rs.getString("QUESTION");
////    boolean isTom = rs.getBoolean("ISTOM");
////    String correctAns = rs.getString("CORRECTANS");
////    String falseAns = rs.getString("FALSEANS");
////    
////    Question trueFalseQ = new TrueFalseQuestion(question, isTom, correctAns, falseAns);
////    questionArray.add(trueFalseQ);
////}
//  
//  
//} catch ( SQLException e ) {
//  e.printStackTrace();
//  System.exit( 0 );
//}
//
//

  
  
  public static void main(String[] args) {
    SQLiteDataSource ds = null;

    //establish connection (creates db file if it does not exist :-)
    try {
        ds = new SQLiteDataSource();
        ds.setUrl("jdbc:sqlite:questions.db");
    } catch ( Exception e ) {
        e.printStackTrace();
        System.exit(0);
    }

    System.out.println( "Opened database successfully" );
    
    
    //now create a table
    String queryTF = "CREATE TABLE IF NOT EXISTS trueFalse ( " +
            "QUESTION TEXT NOT NULL, " +
            "ANSWER BOOLEAN NOT NULL)";
    
    String queryMC = "CREATE TABLE IF NOT EXISTS multipleChoice ("
      + "QUESTION TEXT PRIMARY KEY NOT NULL," //not null & 1 only
      + "ISTOM BOOLEAN NOT NULL,"
      + "CORRECTANS TEXT NOT NULL,"
      + "ANSWER2 TEXT NOT NULL,"
      + "ANSWER3 TEXT NOT NULL,"
      + "ANSWER4 TEXT NOT NULL)";
    
    try ( Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement(); ) {
          int rv = stmt.executeUpdate( queryTF );
          System.out.println( "executeUpdate() returned " + rv );
          
          int rv2 = stmt.executeUpdate(queryMC);
          System.out.println("executeUpdate() returned " + rv2);
      } catch ( SQLException e ) {
          e.printStackTrace();
          System.exit( 0 );
      }
      System.out.println( "Created questions table successfully" );
    
    //next insert two rows of data
    System.out.println( "Attempting to insert two rows into trueFalse table" );

    //1 = true, 0 = false
//    String query1 = "INSERT INTO trueFalse ( QUESTION, ANSWER ) VALUES ( 'Nintendo originally intended the PlayStation to be an add on to the SNES. True or False?', 1)";
//
//    try ( Connection conn = ds.getConnection();
//          Statement stmt = conn.createStatement(); ) {
//        int rv = stmt.executeUpdate( query1 );
//        System.out.println( "1st executeUpdate() returned " + rv );
//
//    } catch ( SQLException e ) {
//        e.printStackTrace();
//        System.exit( 0 );
//    }
    
    
    //now query the database table for all its contents and display the results
    System.out.println( "Selecting all rows from test table" );
    queryTF = "SELECT * FROM trueFalse";
    queryMC = "SELECT * FROM multipleChoice";

    try ( Connection conn = ds.getConnection();
          Statement stmt = conn.createStatement(); ) {
        
        ResultSet rs = stmt.executeQuery(queryTF);
        
        //walk through each 'row' of results, grab data by column/field name
        // and print it
        while ( rs.next()) {
            String question = rs.getString( "QUESTION" );
            //String answer = rs.getString( "ANSWER" );
            boolean answer = rs.getBoolean("ANSWER");

            System.out.println( "Result: Question = " + question +
                ", Answer = " + answer );
        }
        System.out.println("\n__________________________________________________________________\n");
        
        ResultSet rs2 = stmt.executeQuery(queryMC);
        
        while ( rs2.next()) {
          String question = rs2.getString( "QUESTION" );
          //boolean isTom = rs2.getBoolean("ISTOM");
          String answer = rs2.getString("CORRECTANS");
          String wrongAns1 = rs2.getString("ANSWER2");
          String wrongAns2 = rs2.getString("ANSWER3");
          String wrongAns3 = rs2.getString("ANSWER4");

          System.out.println( "Result: Question = " + question +
              ", Answer = " + answer + ", Wrong answers = " + wrongAns1 + ", " + wrongAns2 + ", " + wrongAns3);
      }
    } catch ( SQLException e ) {
        e.printStackTrace();
        System.exit( 0 );
    }
}
  
  

  public void randomizeQuestions() {
    Collections.shuffle(questionArray);
    for(int i = 0; i < questionArray.size(); i++) {
        Question q = questionArray.get(i);
        questionQueue.add(q);
    }
  }

  public Question getRandQuestion() {
    Question randQ = questionQueue.poll();
    questionQueue.add(randQ);
    return randQ;
  }
  
}
