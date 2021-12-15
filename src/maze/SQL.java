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
	
	private static Queue<Question> questionQueue = new LinkedList<Question>();
	
	public static void randomizeQuestions() {
		Collections.shuffle(questionArray);
		for (int i = 0; i < questionArray.size(); i++) {
			Question q = questionArray.get(i);
			questionQueue.add(q);
		}
	}

	public static Question getRandQuestion() {
		Question randQ = questionQueue.poll();
		questionQueue.add(randQ);
		return randQ;
	}
	
	public void create() {
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
		
		String queryTF = "CREATE TABLE IF NOT EXISTS trueFalse ( " + "QUESTION TEXT PRIMARY KEY,"
				+ "ISTOM BOOLEAN," + "CORRECTANS INTEGER NOT NULL,"+ "ALTANS INTEGER NOT NULL)";

		String queryMC = "CREATE TABLE IF NOT EXISTS multipleChoice (" + "QUESTION TEXT PRIMARY KEY," 
				+ "ISTOM BOOLEAN," + "CORRECTANS INTEGER NOT NULL," + "ALTANS1 INTEGER NOT NULL,"
				+ "ALTANS2 INTEGER NOT NULL," + "ALTANS3 INTEGER NOT NULL)";
		
		try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement();) {
			
			int rv = stmt.executeUpdate(queryTF);
			System.out.println("executeUpdate() returned " + rv);

			int rv2 = stmt.executeUpdate(queryMC);
			System.out.println("executeUpdate() returned " + rv2);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Created questions table successfully");

		// now query the database table for all its contents and display the results
		System.out.println("Selecting all rows from test table");
		String query1 = "SELECT * FROM trueFalse";
		String query2 = "SELECT * FROM multipleChoice";

		try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement();) {

			ResultSet rs = stmt.executeQuery(query1);

			// walk through each 'row' of results, grab data by column/field name
			// and print it
			while (rs.next()) {
				String question = rs.getString("QUESTION");
				boolean isTom = rs.getBoolean("ISTOM");
				int answer = rs.getInt("CORRECTANS");
				int altAns = rs.getInt("ALTANS");
				
				TrueFalse q = new TrueFalse(question, isTom, answer, altAns);
				//q.displayQuestion();
				questionArray.add(q);
				
			}
			
			ResultSet rs2 = stmt.executeQuery(query2);
			
			while (rs2.next()) {
				String question = rs2.getString("QUESTION");
				boolean isTom = rs2.getBoolean("ISTOM");
				int answer = rs2.getInt("CORRECTANS");
				int altAns1 = rs2.getInt("ALTANS1");
				int altAns2 = rs2.getInt("ALTANS2");
				int altAns3 = rs2.getInt("ALTANS3");

				MultipleChoice q = new MultipleChoice(question, isTom, answer, altAns1, altAns2, altAns3);
				//q.displayQuestion();
				questionArray.add(q);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}


}
