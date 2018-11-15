import java.io.File;
import static java.lang.Math.toIntExact;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


/**
 * @author rutgerluther
 *
 * @param <T>
 */
/**
 * @author rutgerluther
 *
 * @param <T>
 */
public class HashLeader <T>   {

	private HashObject [] table,tableH;
	private int duplicate;
	private int probeCount;
	private double totalProbeLinear,totalProbeDouble;
	private int totalDuplicatesLinear, totalDuplicatesDouble;
	private int input;
	private int prime;
	private int first;
	private int second;
	private int endMe;
	private Integer size;
	private Integer count;
	File file = new File("word-list");
	Scanner scn;
	private double amount,amountH;
	private double dCode;
	private int code;
	private int h1,h2;
	private int cap;
	private int newCode;
	private double avgProbe,avgProbeH;


	/**
	 * finds a twin prime sets the smaller of the two to prime
	 * @return
	 */
	public int bigPrime() {

		prime = 95501;
		// prime = 95791;
		first = 0;
		second = 0;
		endMe = 0;
		int j = 2;
		boolean flag = false;
		for(int i = prime; i < 96000 && first -2 != second; i++) {

			for(j = 2; j * 2 < i; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
				flag = true;

			}
			if(flag == true) {
				if(first != 0) {
					second = first;
				}
				first = i;	
			}
			i++;
		}

		prime = first;
		return prime;
	}

	/**
	 * hashes the code for double hasher
	 * @param code
	 * @return
	 */
	public int giveMeDouble(int code) {


		probeCount = table[code].getProbe();
		cap = size;
		int i = 0;
		h1 = code % (cap);


		while(table[code] != null && table[code].getKey() != h1 && i < cap) {
			h2 =  1 + (h1 % (cap -2));
			h1 = h2;
			code = h1;
			i++;
			table[code].setProbe(probeCount);

			if(table[code] == null) {
				return code;
			}
			probeCount++;
		}

		newCode = h1;
		return newCode;
	}


	/**
	 * basic constructor
	 */
	public HashLeader() {
		size = bigPrime();
		duplicate = 0;
		probeCount = 0;
		table = new HashObject[size];
	}


	/**
	 * construct for those without files does both linear and double
	 * @param type
	 * @param load
	 * @param debug
	 */
	public HashLeader(int type, double load, int debug) { 

		size = bigPrime();
		amount = 0;
		endMe = 0;
		table = new HashObject[size];
		tableH = new HashObject[size];
		int alpha;
		int newCode = 0;
		double total = 0;

		System.out.format("A good table size is found: %d\n", size);

		Double rnd;


		if(type == 1) {
			if(debug ==0) {
				System.out.println("Data source type: random number generator");
			}
			while(load >= total) {
				total = amount/size.doubleValue();
				rnd = Math.abs(Math.random()*(prime));
				code = rnd.intValue();

				if(table[code] != null) {
					table[code].equals(rnd);
					probeCount = table[code].getProbe();
					probeCount++;

					table[code].setProbe(probeCount);
					totalProbeLinear += table[code].getProbe();
					duplicate = table[code].getDuplicate();
					duplicate++;
					totalDuplicatesLinear++;
					table[code].setDuplicate(duplicate);
					amount++;

					int i = code;
					int counts = 0;

					while(counts >= size-1 && table[i] != null) {
						if(table[i] == null) {
							table[i] = new HashObject (rnd,i);
						}
						if(i == size) {
							i = 0;
						}
						counts++;
					}
				}


				if(table[code] == null) {
					table[code]= new HashObject(rnd,code);
					table[code].setProbe(1);
					totalProbeLinear++;
					amount++;
				}

				if(tableH[code] != null) {
					tableH[code].equals(rnd);
					probeCount = tableH[code].getProbe();
					probeCount++;
					totalProbeDouble += tableH[code].getProbe();
					tableH[code].setProbe(probeCount);
					duplicate = tableH[code].getDuplicate();
					duplicate++;
					totalDuplicatesDouble++;
					tableH[code].setDuplicate(duplicate);
					newCode = giveMeDouble(code);
					amountH++;

					if(tableH[newCode] == null) {
						tableH[newCode]= new HashObject(rnd,newCode);
						tableH[newCode].setProbe(1);
					}

				}

				if(tableH[code] == null) {
					tableH[code] = new HashObject(rnd,code);
					tableH[code].setProbe(1);
					totalProbeDouble++;
					amountH++;
				}
			}

			if(debug ==0) {
				System.out.println("\n");
				System.out.println("Using Linear Hashing");
				System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesLinear + " are duplicates linear");
				System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeLinear/amount + "\n");

				System.out.println("\n\n");
				System.out.println("Using Double Hashing");
				System.out.println("Inserted " + amountH + " elements, of which " + totalDuplicatesDouble + " are duplicates double");
				System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeDouble/amountH + "\n");

			}
		}


		if(type == 2) {
			int time = 0;
			int temp = 0;
			System.out.println("\nData source type: time in milliseconds");
			total = amount/size.doubleValue();

			while(load >= total) {
				time = (int) System.currentTimeMillis();
				total = amount/size.doubleValue();
				if(debug ==0) {

				}
				code = toIntExact(time % size);
				time = code;
				temp = code;
				amount++;

				if(table[code] != null) {
					table[code].equals(time);
					probeCount = table[code].getProbe();
					probeCount++;

					table[code].setProbe(probeCount);
					totalProbeLinear += table[code].getProbe();
					duplicate = table[code].getDuplicate();
					duplicate++;
					totalDuplicatesLinear++;
					table[code].setDuplicate(duplicate);
					amount++;

					int i = code;
					int counts = 0;

					while(counts >= size-1 && table[i] != null) {
						if(table[i] == null) {
							table[i] = new HashObject (time,i);
						}
						if(i == size) {
							i = 0;
						}
						counts++;
					}
				}


				if(table[code] == null) {
					table[code]= new HashObject(time,code);
					table[code].setProbe(1);
					totalProbeLinear++;
					amount++;
				}

				if(tableH[code] == null) {
					tableH[code] = new HashObject(time,code);
					tableH[code].setProbe(1);
					totalProbeDouble++;
					amountH++;
				}
				
				if(tableH[code] != null) {
					tableH[code].equals(time);
					probeCount = tableH[code].getProbe();
					probeCount++;
					totalProbeDouble += tableH[code].getProbe();
					tableH[code].setProbe(probeCount);
					duplicate = tableH[code].getDuplicate();
					duplicate++;
					totalDuplicatesDouble++;
					tableH[code].setDuplicate(duplicate);
					newCode = giveMeDouble(code);
					amountH++;

					if(tableH[newCode] == null) {
						tableH[newCode]= new HashObject(time,newCode);
						tableH[newCode].setProbe(1);
					}

				}



			}

			if(debug ==0) {
				System.out.println("\n");
				System.out.println("Using Linear Hashing");
				System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesLinear + " are duplicates linear");
				System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeLinear/amount + "\n");

				System.out.println("\n\n");
				System.out.println("Using Double Hashing");
				System.out.println("Inserted " + amountH + " elements, of which " + totalDuplicatesDouble + " are duplicates double");
				System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeDouble/amountH + "\n");

			}
		}
	}


	/**
	 * for files linear and double hasher
	 * @param type
	 * @param load
	 * @param debug
	 * @param file
	 */
	public HashLeader(int type, double load, int debug, File file) {

		size = bigPrime();
		file = new File ("/home/RutgerLuther/eclipse-workspace/HashTables/word-list");
		table = new HashObject[size];
		tableH = new HashObject[size];
		try {
			scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String s;
		size = bigPrime();
		amount = 0;
		double total = 0;
		amountH = 0;


		if(type == 3) {
			if(debug ==0) {
				System.out.println("Data source type: word-list");
			}

			while(scn.hasNext() && load >= (total)) {

				total = amount/size.doubleValue();
				s = scn.next();
				s = s.trim();

				code = Math.abs(s.hashCode());
				while(code > size-1) {
					code = code % size;
				}

				if(table[code] != null) {
					table[code].equals(s);
					probeCount = table[code].getProbe();
					probeCount++;

					table[code].setProbe(probeCount);
					totalProbeLinear += table[code].getProbe();
					duplicate = table[code].getDuplicate();
					duplicate++;
					totalDuplicatesLinear++;
					table[code].setDuplicate(duplicate);
					amount++;

					int i = code;
					int counts = 0;

					while(counts >= size-1 && table[i] != null) {
						if(table[i] == null) {
							table[i] = new HashObject (s,i);
						}
						if(i == size) {
							i = 0;
						}
						counts++;
					}
				}


				if(table[code] == null) {
					table[code]= new HashObject(s,code);
					table[code].setProbe(1);
					totalProbeLinear++;
					amount++;
				}

				if(tableH[code] != null) {
					tableH[code].equals(s);
					probeCount = tableH[code].getProbe();
					probeCount++;
					totalProbeDouble += tableH[code].getProbe();
					tableH[code].setProbe(probeCount);
					duplicate = tableH[code].getDuplicate();
					duplicate++;
					totalDuplicatesDouble++;
					tableH[code].setDuplicate(duplicate);
					newCode = giveMeDouble(code);
					amountH++;

					if(tableH[newCode] == null) {
						tableH[newCode]= new HashObject(s,newCode);
						tableH[newCode].setProbe(1);
					}

				}

				if(tableH[code] == null) {
					tableH[code] = new HashObject(s,code);
					tableH[code].setProbe(1);
					totalProbeDouble++;
					amountH++;
				}
			}

			if(debug ==0) {
				System.out.println("\n");
				System.out.println("Using Linear Hashing");
				System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesLinear + " are duplicates linear");
				System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeLinear/amount + "\n");

				System.out.println("\n\n");
				System.out.println("Using Double Hashing");
				System.out.println("Inserted " + amountH + " elements, of which " + totalDuplicatesDouble + " are duplicates double");
				System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeDouble/amountH + "\n");

			}

			if(debug == 1) {
				for(int i = 0; i/size < load; i++) {
					if(table[i].getKey() != 0) {

						System.out.println(table[i]);


					}
				}
			}
		}
	}
}