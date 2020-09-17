import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Raffi Alan Bezirjian
 *
 */
public class SmartAR {

	public static boolean isLargeThreshold = false;

	static Scanner scanner = new Scanner(System.in);
	static StringBuilder sb;
	private static String NEWLINE = System.getProperty("line.separator");
	private static int totalcar = 0;
	private static int keyLength = 0;
	private static int totalKey = 0;
	private static SecureRandom random = new SecureRandom();
	private static Map<String, Car> smartARdata = new LinkedHashMap<String, Car>();

	static final String KEY_INPUT = "A0B1C2D3E4F5G6H7I8J9K0LMNOPQRSTUVWXYZ";

	private static TreeSet<String> treeSet;

	/**
	 * This is the entry level method for starting the program
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		try {

			while (true) {

				printUserChoice();

				String input = scanner.nextLine();
				String[] inputArray = input.split(" ");
				List<String> commandData = Arrays.asList(inputArray);

				switch (inputArray[0]) {
				case "totalCar":
					totalCar(commandData.get(1));
					break;
				case "setKeyLength":
					setKeyLength(commandData.get(1));
					break;
				case "generate":
					generate(commandData.get(1));
					break;
				case "allKeys":
					allKeys();
					break;
				case "add":
					add(commandData.get(1), commandData.get(2));
					break;
				case "remove":
					remove(commandData.get(1));
					break;
				case "getValues":
					getValues(commandData.get(1));
					break;
				case "nextKey":
					nextKey(commandData.get(1));
					break;
				case "prevKey":
					prevKey(commandData.get(1));
					break;
				case "previousCars":
					previousCars(commandData.get(1));
					break;
				case "exit":
					System.exit(0);

				default:
					System.out.println("Wrong Choice. Please enter correct Input");

				}

			}
		} catch (Exception e) {
			System.out.println("Wrong Choice. Please enter correct Input");
		}

	}

	/**
	 * This mehtod will find the previousCars information based on user given key
	 * 
	 * @param key
	 */
	private static void previousCars(String key) {

		Map<String, Car> temp = new LinkedHashMap<String, Car>();

		if (smartARdata.containsKey(key)) {

			for (Map.Entry<String, Car> value : smartARdata.entrySet()) {

				if (value.getKey().equals(key)) {
					break;
				} else {
					temp.put(value.getKey(), value.getValue());
				}

			}

			if (temp.size() > 0) {

				ListIterator<Map.Entry<String, Car>> iterator = new ArrayList<Map.Entry<String, Car>>(temp.entrySet())
						.listIterator(temp.size());
				while (iterator.hasPrevious()) {
					Map.Entry<String, Car> entry = iterator.previous();
					System.out
							.println("licenseplate: " + entry.getKey() + " CarName: " + entry.getValue().getCarName());
				}

			} else {
				System.out.println("previousCars not found in system");
			}

		} else {
			System.out.println("Key is not found in system. Please provid valid details.");
		}

	}

	/**
	 * This method will find prevKey of given Key
	 * 
	 * @param key
	 */
	private static void prevKey(String key) {

		String prevKey = null;

		if (smartARdata.containsKey(key)) {

			for (Map.Entry<String, Car> value : smartARdata.entrySet()) {

				if (value.getKey().equals(key)) {
					break;
				} else {
					prevKey = value.getKey();
				}

			}
			if (prevKey != null) {
				System.out.println("prevKey Key is : " + prevKey);
			} else {
				System.out.println("prevKey is not found in system. Please provid valid details.");
			}

		} else {
			System.out.println("Key is not found in system. Please provid valid details.");
		}

	}

	/**
	 * This method will find nextKey of given Key
	 * 
	 * @param key
	 */
	private static void nextKey(String key) {

		String nextKey = null;
		boolean keyFound = false;

		if (smartARdata.containsKey(key)) {
			for (Map.Entry<String, Car> value : smartARdata.entrySet()) {
				if (value.getKey().equals(key)) {
					keyFound = true; // check if we have found entry or not
					continue;
				}
				if (keyFound) {
					nextKey = value.getKey();
					break;
				}
			}

			if (nextKey != null) {
				System.out.println("Next Key is : " + nextKey);
			} else {
				System.out.println("NextKey is not found in system. Please provid valid details.");
			}

		} else {
			System.out.println("Key is not found in system. Please provid valid details.");
		}

	}

	/**
	 * This method will print the value of given key
	 * 
	 * @param key
	 */
	private static void getValues(String key) {

		if (smartARdata.containsKey(key)) {
			System.out.println(smartARdata.get(key));
		} else {
			System.out.println("Key is not found in system. Please provid valid details.");
		}

	}

	/**
	 * This method will remove entry from system based on given key
	 * 
	 * @param key
	 */
	private static void remove(String key) {

		if (smartARdata.containsKey(key)) {
			smartARdata.remove(key);
			System.out.println("Entry with key: " + key + " removed successfully from SmartAR system");
		} else {
			System.out.println("Key not found in system. Please provid valid details.");
		}

	}

	/**
	 * This method will add new entry in system based on given key and carName
	 * 
	 * @param key
	 * @param carName
	 */
	private static void add(String key, String carName) {

		if (treeSet.contains(key) && !smartARdata.containsKey(key)) {

			smartARdata.put(key, new Car(key, carName));

			System.out.println("Key: " + key + "and carName:" + carName + " Added successfully in SmartAR system");
		} else {
			System.out.println("Key is not found or already registered in system. Please provid valid details.");
		}
	}

	/**
	 * This method will print all keys
	 */
	private static void allKeys() {

		for (String string : treeSet) {
			System.out.println(string);
		}

	}

	/**
	 * This method will generate n number of keys
	 * 
	 * @param string
	 */
	private static void generate(String string) {

		if (keyLength > 0 && totalcar > 0) {

			int nKey = getint(string);
			if (nKey > 0) {
				totalKey = nKey;
				generateKey();
			} else {
				System.out.println("total Key should be > 0");
			}

		} else {
			System.out.println("Please enter KeyLength command and totalCar first");
		}

	}

	/**
	 * This is the calling method of generate
	 */
	private static void generateKey() {

		treeSet = new TreeSet<String>();
		StringBuilder sb;

		while (treeSet.size() < totalKey) {

			sb = new StringBuilder(keyLength);
			for (int i = 0; i < keyLength; i++) {
				sb.append(KEY_INPUT.charAt(random.nextInt(KEY_INPUT.length())));
			}
			treeSet.add(sb.toString());
		}
		System.out.println(totalKey + " non-existing keys of alphanumeric characters has been generated");
	}

	/**
	 * This method will set the keylength for generating n number of keys
	 * 
	 * @param string
	 */
	private static void setKeyLength(String string) {
		int keysize = getint(string);

		if (keysize >= 6 && keysize <= 12) {
			keyLength = keysize;
		} else {
			System.out.println("Please enter valid Keylength");
		}

	}

	/**
	 * This method will set the totalcar number in global parameter
	 * 
	 * @param string
	 */
	private static void totalCar(String string) {
		totalcar = getint(string);

		if (totalcar >= 100) {
			isLargeThreshold = true;
		}

	}

	/**
	 * This method will print user selection menu
	 */
	public static void printUserChoice() {
		sb = new StringBuilder();

		sb.append(NEWLINE).append("Please Select Method to Perform Operation").append(NEWLINE)
				.append(" 1. total number of n car registrations (Example -> totalCar 150)").append(NEWLINE)
				.append(" 2. setKeyLength(Length) (Example -> setKeyLength 8").append(NEWLINE)
				.append(" 3. generate(n) (Example -> generate 30)").append(NEWLINE)
				.append(" 4. allKeys() (Example -> allKeys)").append(NEWLINE)
				.append(" 5. add(key,value2) (Example -> add R4G5OO54TE Mycar)").append(NEWLINE)
				.append(" 6. remove(key) (Example -> remove R4G5OO54TE)").append(NEWLINE)
				.append(" 7. getValues(key) (Example -> getValues R4G5OO54TE)").append(NEWLINE)
				.append(" 8. nextKey(key) (Example -> nextKey R4G5OO54TE)").append(NEWLINE)
				.append(" 9. prevKey(key) (Example -> prevKey R4G5OO54TE)").append(NEWLINE)
				.append("10. previousCars(key) (Example -> previousCars R4G5OO54TE)").append(NEWLINE).append("11. exit")
				.append(NEWLINE).append("->");

		System.out.println(sb.toString());

	}

	/**
	 * This method will convert String to Integer
	 * 
	 * @param str
	 * @return Integer
	 */
	private static int getint(String str) {
		return Integer.parseInt(str);
	}

}
