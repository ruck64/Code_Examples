import java.io.File;

/**
 * @author rutgerluther
 *tester for my classes
 */
public class HashTest {

	private static int type;
	private static int debug;
	private static double load;
	static File file = new File("/home/RutgerLuther/eclipse-workspace/HashTables/word-list");
	private HashLeader table;

	private static HashLeader lead = new HashLeader();
	private static HashLeader nFile; 
	private static HashLeader filed;


	public static void main(String args[]) {

		type = Integer.parseInt(args[0]);
		load = Double.parseDouble(args[1]);
		debug = Integer.parseInt(args[2]);
		
		if(type > 3 || load > 1 || debug != 0) {
			System.out.println("wrong form or args");
			return;
		}

		if(type != 3) {
			nFile= new HashLeader(type,load, debug);
			
		}
		if(type == 3) {
			filed = new HashLeader(type,load,debug,file);

		}


	}
}