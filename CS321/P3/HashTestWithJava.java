import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * @author rutgerluther
 *tester for my classes
 */

public class HashTestWithJava {

	private static int type;
	private static int tableSize;
	private static float load;
	private static Integer code;
	private static int debug;
	private static int inserts;
	private static int duplicate;
	private static int totalDuplicate;
	static File file = new File("/home/RutgerLuther/eclipse-workspace/HashTables/word-list");
	private Hashtable lead = new Hashtable();
	private static Hashtable nFile; 
	private static Hashtable filed;
	static String s = "Using JAVA Hashtable";
	static Scanner scn;



	public static void main(String args[]) {

		type = Integer.parseInt(args[0]);
		load = Float.parseFloat(args[1]);
		tableSize = Integer.parseInt(args[2]);

		if(type > 3 || load > 1 || debug != 0 || tableSize < 0) {
			System.out.println("wrong form or args");
			return;
		}

		System.out.println("Table size: " + tableSize + " ");
		if(type == 1) {System.out.println("Data source type: random number generator");}
		if(type == 2) {System.out.println("Data source type: time in milliseconds");}
		if(type == 3) {System.out.println("Data source type: word-list");}
		if(type != 3) {
			nFile= new Hashtable(tableSize,load);
			while(inserts < load * tableSize) {
				if(type == 1) {


					Double rnd;
					rnd = Math.abs(Math.random()*(tableSize));

					if(nFile.containsKey(rnd) == true) {
						duplicate = (int) nFile.get(rnd);
						nFile.put(rnd,duplicate + 1);
						totalDuplicate++;
						inserts++;
					}
					if(nFile.containsKey(rnd) == false) {
						nFile.put(rnd,0);
						totalDuplicate++;
						inserts++;
					}
				}

				if(type == 2) {
					int time = 0;
					int temp = 0;
					time = (int) System.currentTimeMillis();

					if(nFile.containsKey(time) == true) {
						duplicate = (int) nFile.get(time);
						nFile.put(time,duplicate + 1);
						totalDuplicate++;
						inserts++;
					}
					if(nFile.containsKey(time) == false) {
						nFile.put(time,0);
						totalDuplicate++;
						inserts++;

					}
					temp = time;		
				}
			}

			if(type == 3) {
				filed = new Hashtable(type,load);
				file = new File ("/home/RutgerLuther/eclipse-workspace/HashTables/word-list");

				try {
					scn = new Scanner(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				String reader;

				while(scn.hasNext() && load * tableSize > filed.size()) {

					reader = scn.next();
					reader = reader.trim();

					if(nFile.containsKey(reader) == true) {
						duplicate = (int) nFile.get(reader);
						nFile.put(reader,duplicate + 1);
						code = code.hashCode();
						totalDuplicate++;
						inserts++;
					}
					if(nFile.containsKey(reader) == false) {
						nFile.put(reader,0);
						totalDuplicate++;
						inserts++;

					}

				}

			}

		}
		System.out.println(s);
		System.out.println("Inserted " + inserts + " elements, of which " + totalDuplicate + " are duplicates");
		System.out.println("load factor: " + load);

	}

}
