/*
import java.io.File;
	import static java.lang.Math.toIntExact;
	import java.io.FileNotFoundException;
	import java.util.Random;
	import java.util.Scanner;
	import java.util.Hashtable;
	
public class HashLeaderWithJava<T> {

		private HashObject [] table,tableH;
		private int duplicate;
		private int probeCount;
		private int totalProbeLinear,totalProbeDouble;
		private int totalDuplicatesLinear, totalDuplicatesDouble;
		private int input;
		private int prime;
		private int first;
		private int second;
		private int endMe;
		private Integer size;
		private Integer count;
		Scanner scn = new Scanner(System.in);
		private Integer amount;
		private double dCode;
		private int code;
		private int h1,h2;
		private int cap;
		private int newCode;


		/**
		 * finds a twin prime
		 * @return
		 */
	/*	public int bigPrime() {

			prime = 95791;
			first = 0;
			second = 0;
			endMe = 0;

			/*for(int i = 95448; i < 95999; i++) {
				int count = 0;
				System.out.println("i's current value " + i + " ");

				for(int j = 2; j * j <= 96000; j++) {

					if(j%i == 0) {
						count++;
					}
					if(count == 2) {return i;}


					/*if(i >= prime && i % j != 0) { first = i;}
					if(second != 0) {
						if(i % 2 == 0 & first + 2 > second) {
							second = first;
							System.out.println("the value of first and the value of second: " + first + " " + second + "");

						}

						if(second - first == 2) {
							System.out.println("im subtracting second from first");
							prime = second;
							i = 96000;	
						}
					}
					else { second = first; }
				}
			}
			System.out.println(" big prime = " + prime + "");

			return prime;
		}
*/
		/**
		 * hashes the code for double hasher
		 * @param code
		 * @return
		 */
	/*	public int giveMeDouble(int code) {


			cap = bigPrime();
			int i = 0;
			h1 = code % (cap);


			while(table[code] != null && table[code].getKey() != h1 && i < cap) {
				h2 =  code + i*h1 % cap;
				h1 = h2;
				code = h1;
				i++;

				if(table[code] == null) {
					return code;
				}
			}

			newCode = h1;
			return newCode;
		}


		/**
		 * basic constructor
		 
		public HashLeaderWithJava() {
			
			
			
		  /*  size = bigPrime();
			duplicate = 0;
			probeCount = 0;
			table = new HashObject[size]; 
		}


		/**
		 * consturct for those without files does both linear and double
		 * @param type
		 * @param load
		 * @param debug
		 
		public HashLeader(int type, double load, int debug) { 

			size = bigPrime();
			amount = 0;
			endMe = 0;
			table = new HashObject[size];
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
					total = amount.doubleValue()/size.doubleValue();
					System.out.println("load >= amount/size"  + amount + " >+ " + total + "");
					rnd = Math.abs(Math.random()*(prime));
					code = rnd.intValue();

					if(table[code] != null) {
						table[code].equals(rnd);
						probeCount = table[code].getProbe();
						probeCount++;
						totalProbeLinear++;
						table[code].setProbe(probeCount);
						duplicate = table[code].getDuplicate();
						duplicate++;
						totalDuplicatesLinear++;
						table[code].setDuplicate(duplicate);

						for(int i = 0; i > (total); i++) {

							if(table[i].getKey() == 0) {
								table[i]= new HashObject(rnd,code);
								table[i].setProbe(1);
							}

						}
					}

					if(table[code] == null) {
						table[code] = new HashObject (rnd, code);
						//table[code].setObject(rnd);
						//table[code].setKey(code);
						table[code].setProbe(1);
						totalProbeLinear++;
						amount++;
					}
				}
				if(debug ==0) {
					System.out.println("\n\n");
					System.out.println("Using Linear Hashing");
					System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesLinear + " are duplicates linear");
					System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesDouble + " are duplicates double");
					System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeLinear/size + "\n");
				}
			}
			if(type == 2) {
				int time;
				int temp = 0;

				time = (int) System.currentTimeMillis();
				System.out.println("give me the time: " + time + "");
				total = amount.doubleValue()/size.doubleValue();
				System.out.println("load >= amount/size"  + amount + " >+ " + total + "");

				while(load >= total) {
					System.out.println(System.currentTimeMillis());
					System.out.println("load >= amount/size"  + amount + " >+ " + total + "");
					total = amount.doubleValue()/size.doubleValue();
					if(debug ==0) {
						System.out.println("amount and size :" + amount + " " + size + "");
						System.out.println("Data source type: time in milliseconds");
					}
					code = toIntExact(time/100000000);
					time = code;
					//while(temp != code) {
					System.out.println("inside temp not equal code loop");
					temp = code;
					amount++;

					if(table[code] != null) {
						if(table[code].equals(code) == true) {
							probeCount = table[code].getProbe();
							probeCount++;
							totalProbeLinear++;
							table[code].setProbe(probeCount);
							duplicate = table[code].getDuplicate();
							duplicate++;
							totalDuplicatesLinear++;
							table[code].setDuplicate(duplicate);
						}
						for(int i = 0; i > (amount/size); i++) {

							if(table[i].getKey() == 0) {
								table[i].setKey(code);
								table[i].setObject(code);
								table[i].setProbe(1);
							}
						}
					}

					if(table[code] == null) {
						System.out.println("code and time: " + code +" " + time + "");
						table[code] = new HashObject(code,code);
						table[code].setProbe(1);
						totalProbeLinear++;


					}
					System.out.println("amount: " + amount + "");
					//}
				}

				alpha = amount/size;
				if(debug ==0) {
					System.out.println("\n\n");
					System.out.println("Using Linear Hashing");
					System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesLinear + " are duplicates linear");
					System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesDouble + " are duplicates double");
					System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeLinear/size + "\n");
				}

				if(debug == 1) {
					for(int i = 0; i/size < alpha; i++) {
						if(table[i].getKey() != 0) {

							System.out.println(table[i]);
						}
					}

					if(type == 1) {
						if(debug ==0) {
							System.out.println("Data source type: random number generator");
						}
						while(load <= amount/size) {
							rnd = Math.abs(Math.random()*(prime));
							System.out.println("rnds value : " + rnd + "");

							if(table[code] != null) {
								if(table[code].equals(rnd) == true) {
									probeCount = table[code].getProbe();
									probeCount++;
									totalProbeDouble++;
									table[code].setProbe(probeCount);
									duplicate = table[code].getDuplicate();
									duplicate++;
									totalDuplicatesDouble++;
									table[code].setDuplicate(duplicate);
								}

								System.out.println("running give me double");
								newCode = giveMeDouble(code);
								table[newCode].setObject(rnd);
								table[newCode].setKey(newCode);
								System.out.println("amount : " + amount + " ");
								amount++;
								newCode = 1;
							}

							if(table[code] == null && newCode == 0) {
								table[code]= new HashObject(rnd,code);
								table[code].setProbe(1);
								totalProbeDouble = 2;
								amount++;

							}
						}
					}
					if(debug ==0) {
						System.out.println("\n\n");
						System.out.println("Using Linear Hashing");
						System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesLinear + " are duplicates linear");
						System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesDouble + " are duplicates double");
						System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeLinear/size + "\n");
					}
				}
				if(type == 2) {
					int time2 = 0;
					time = (int) System.currentTimeMillis();
					if(debug ==0) {
						System.out.println("Data source type: time in milliseconds");
					}
					if(table[code].getObject() != null) {
						table[code].equals(time2);
						probeCount = table[code].getProbe();
						probeCount++;
						table[code].setProbe(probeCount);
						duplicate = table[code].getDuplicate();
						duplicate++;
						table[code].setDuplicate(duplicate);
						totalDuplicatesDouble++;
						newCode = giveMeDouble(code);
						amount++;

					}

					if(table[newCode].getObject() == null) {
						table[newCode]= new HashObject(time2,newCode);
						table[newCode].setProbe(1);
						amount++;
					}
				}
				if(debug ==0) {
					System.out.println("\n\n");
					System.out.println("Using Linear Hashing");
					System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesLinear + " are duplicates linear");
					System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesDouble + " are duplicates double");
					System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeLinear/size + "\n");
				}
			}
		}


		/**
		 * for files linear and double hasher
		 * @param type
		 * @param load
		 * @param debug
		 * @param file
		 
		public HashLeader(int type, double load, int debug, File file) {

			size = bigPrime();
			file = new File ("word-list");
			table = new HashObject[size];
			tableH = new HashObject[size];
			String s;
			size = bigPrime();
			amount = 0;
			double total = 0;
			

			if(type == 3) {
				if(debug ==0) {
					System.out.println("Data source type: word-list");
				}

				while(scn.hasNext() && load >= (total)) {

					total = amount.doubleValue()/size.doubleValue();
					s = scn.next();
					s = s.trim();

					code = Math.abs(s.hashCode());

					if(table[code].getObject() != null) {
						table[code].equals(s);
						probeCount = table[code].getProbe();
						probeCount++;
						totalProbeLinear++;
						table[code].setProbe(probeCount);
						duplicate = table[code].getDuplicate();
						duplicate++;
						totalDuplicatesLinear++;
						table[code].setDuplicate(duplicate);

						for(int i = 0; i > (amount/size); i++) {

							if(table[i].getKey() == 0) {
								table[i].setKey(code);
								table[i].setObject(s);
								table[i].setProbe(1);
							}

						}
					}

					if(tableH[code].getObject() == null) {
						tableH[code]= new HashObject(s,code);
						tableH[code].setProbe(1);
						totalProbeLinear++;
						amount++;
					}

					s = scn.next();
					s = s.trim();

					code = Math.abs(s.hashCode());

					if(tableH[code].getObject() != null) {
						tableH[code].equals(s);
						probeCount = tableH[code].getProbe();
						probeCount++;
						tableH[code].setProbe(probeCount);
						duplicate = tableH[code].getDuplicate();
						duplicate++;
						tableH[code].setDuplicate(duplicate);
						newCode = giveMeDouble(code);
						amount++;

					}

					if(tableH[newCode].getObject() == null) {
						tableH[newCode] = new HashObject(s,newCode);
						tableH[newCode].setProbe(1);
						amount++;
					}
				}

			}
			if(debug ==0) {
				System.out.println("\n\n");
				System.out.println("Using Linear Hashing");
				System.out.println("Inserted " + amount + " elements, of which " + totalDuplicatesLinear + " are duplicates");
				System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeLinear/size + "\n");
			}
			int alpha = amount/size;

			if(debug == 1) {
				for(int i = 0; i/size < alpha; i++) {
					if(table[i].getKey() != 0) {

						System.out.println(table[i]);


					}
				}
			}
		}
	}
		public void HashLeaderDouble(int type, double load, int debug) {

			size = bigPrime();
			amount = 0;
			int alpha;



			double rnd;

			if(type == 1) {
				if(debug ==0) {
					System.out.println("Data source type: random number generator");
				}
				while(load <= amount/size) {
					rnd = Math.abs(Math.random());

					if(table[code].getObject() != null) {
						table[code].equals(rnd);
						probeCount = table[code].getProbe();
						probeCount++;
						totalProbeDouble++;
						table[code].setProbe(probeCount);
						duplicate = table[code].getDuplicate();
						duplicate++;
						totalDuplicatesDouble++;
						table[code].setDuplicate(duplicate);
						giveMeDouble(code);
						amount++;

					}

					if(table[code].getObject() == null) {
						table[code].setObject(rnd);
						table[code].setKey(code);
						table[code].setProbe(1);
						totalProbeDouble = 2;
						amount++;

					}
				}
			}
			if(type == 2) {
				long time;
				time = System.currentTimeMillis();
				if(debug ==0) {
					System.out.println("Data source type: time in milliseconds");
				}
				if(table[code].getObject() != null) {
					table[code].equals(time);
					probeCount = table[code].getProbe();
					probeCount++;
					table[code].setProbe(probeCount);
					duplicate = table[code].getDuplicate();
					duplicate++;
					table[code].setDuplicate(duplicate);
					giveMeDouble(code);
					amount++;

				}

				if(table[code].getObject() == null) {
					table[code].setObject(time);
					table[code].setKey(code);
					table[code].setProbe(1);
					amount++;
				}
			}
		}


		public void HashLeaderDouble(int type, double load, int debug, File file) throws FileNotFoundException {

			file = new File ("file");
			Scanner scn3 = new Scanner(file);
			String s;

			if(type == 3) {
				if(debug ==0) {
					System.out.println("Data source type: word-list");
				}
				while(scn3.hasNext() && load <= (amount/size)) {

					s = scn3.next();
					s = s.trim();

					code = Math.abs(s.hashCode());

					if(table[code].getObject() != null) {
						table[code].equals(s);
						probeCount = table[code].getProbe();
						probeCount++;
						table[code].setProbe(probeCount);
						duplicate = table[code].getDuplicate();
						duplicate++;
						table[code].setDuplicate(duplicate);

						giveMeDouble(code);
						amount++;

					}

					if(table[code].getObject() == null) {
						table[code].setObject(s);
						table[code].setKey(code);
						table[code].setProbe(1);
						amount++;
					}
				}

			}
			if(debug ==0) {
				System.out.println("\n\n");
				System.out.println("Using Double Hashing");
				System.out.println("Inserted" + amount + "elements, of which" + totalDuplicatesDouble + "");
				System.out.println("load factor= " + load + ", Avg. no. of probes " +  totalProbeDouble/size + "\n");
			}
			int alpha = amount/size;

			if(debug == 1) {
				for(int i = 0; i/size < alpha; i++) {
					if(table[i].getKey() != 0) {

						System.out.println(table[i]);

						//table.toString(table[i],i);

					}
				}
			}
		}

	}
		 
	
	
} */
