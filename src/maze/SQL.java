/**
 * 
 */
package maze;

import java.sql.Connection;
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

	private static ArrayList<Question> questionArray = new ArrayList<>();
	
	private Queue<Question> questionQueue = new LinkedList<Question>();
	
	//private static SQLiteDataSource questions = null;


	public static void main(String[] args) {
		SQLiteDataSource ds = null;

		// establish connection (creates db file if it does not exist :-)
		try {
			ds = new SQLiteDataSource();
			ds.setUrl("jdbc:sqlite:questions.db");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Opened database successfully");

		// now create a table
		
		String query = "CREATE TABLE IF NOT EXISTS questions ( " + "QUESTION TEXT NOT NULL,"
				+ "ANSWER TEXT NOT NULL," + "ISTOM BOOLEAN)";
		
//		String queryTF = "CREATE TABLE IF NOT EXISTS trueFalse ( " + "QUESTION TEXT NOT NULL,"
//				+ "ANSWER TEXT NOT NULL," + "ISTOM BOOLEAN)";
//
//		String queryMC = "CREATE TABLE IF NOT EXISTS multipleChoice (" + "QUESTION TEXT PRIMARY KEY NOT NULL," 
//				+ "ISTOM BOOLEAN NOT NULL," + "CORRECTANS TEXT NOT NULL," + "ANSWER2 TEXT NOT NULL,"
//				+ "ANSWER3 TEXT NOT NULL," + "ANSWER4 TEXT NOT NULL)";
		
		try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement();) {
			int rv = stmt.executeUpdate(query);
			System.out.println("executeUpdate() returned " + rv);
			
//			int rv = stmt.executeUpdate(queryTF);
//			System.out.println("executeUpdate() returned " + rv);
//
//			int rv2 = stmt.executeUpdate(queryMC);
//			System.out.println("executeUpdate() returned " + rv2);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Created questions table successfully");

		// now query the database table for all its contents and display the results
		System.out.println("Selecting all rows from test table");
		query = "SELECT * FROM questions";
	
//		queryTF = "SELECT * FROM trueFalse";
//		queryMC = "SELECT * FROM multipleChoice";

		try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement();) {

			ResultSet rs = stmt.executeQuery(query);

			// walk through each 'row' of results, grab data by column/field name
			// and print it
			while (rs.next()) {
				String question = rs.getString("QUESTION");
				boolean isTom = rs.getBoolean("ISTOM");
				String answer = rs.getString("CORRECTANS");

//				System.out.println("Result: Question = " + question + ", Answer = " + answer + ", isTom = " + isTom);
				Question q = new Question(question, isTom, answer);
				q.displayQuestion();
				questionArray.add(q);
			}
			//System.out.println("\n__________________________________________________________________\n");

//			while (rs2.next()) {
//				String question = rs2.getString("QUESTION");
//				boolean isTom = rs2.getBoolean("ISTOM");
//				String answer = rs2.getString("CORRECTANS");
//
////				System.out.println("Result: Question = " + question + ", isTom = " + isTom + ", Answer = " + answer + ", Wrong answers = "
////						+ wrongAns1 + ", " + wrongAns2 + ", " + wrongAns3);
//				Question q = new Question(question, isTom, answer);
//				q.displayQuestion();
//				
//				questionArray.add(q);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void randomizeQuestions() {
		Collections.shuffle(questionArray);
		for (int i = 0; i < questionArray.size(); i++) {
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
