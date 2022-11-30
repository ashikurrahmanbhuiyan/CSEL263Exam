import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please put a argument and try again.");
		} else {
			if (args[0].equals(constant.comma)) {
				System.out.println(constant.loading);
				try {
					String i[] = students().split(constant.separator);
					for (String j : i) {
						System.out.println(j);
					}
					
				} catch (Exception e) {
				}
				System.out.println(constant.endMessage);
			} else if (args[0].equals("r")) {
				System.out.println(constant.loading);
				try {
					String i[] = students().split(constant.separator);
					Random x = new Random();
					System.out.println(i[x.nextInt(4)]);
				} catch (Exception e) {
				}
				System.out.println("Data Loaded.");
			} else if (args[0].contains("+")) {
				System.out.println(constant.loading);
				try {
					String i = students();
					File file = new File(constant.textFile);
					file.delete();
					File file1 = new File(constant.textFile);
					file1.createNewFile();
					BufferedWriter s = studentName();
					s.write(i);
					DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
					s.write(", " + args[0].substring(1) + "\nList last updated on " + dateFormat.format(new Date()));
					s.close();
				} catch (Exception e) {
				}

				System.out.println(constant.endMessage);
			} else if (args[0].contains("?")) {
				System.out.println(constant.loading);
				try {
					String i[] = students().split(constant.separator);
					for (int idx = 0; idx < i.length; idx++) {
						if (i[idx].equals(args[0].substring(1))) {
							System.out.println("We found it!");
							break;
						}
					}
				} catch (Exception e) {
				}
				System.out.println(constant.endMessage);
			} else if (args[0].contains("c")) {
				System.out.println(constant.loading);
				try {
					char a[] = students().toCharArray();
					boolean in_word = false;
					int count = 0;
					for (char c : a) {
						if (c == ' ') {
							if (in_word == false) {
								count++;
								in_word = true;
							} else {
								in_word = false;
							}
						}
					}
					System.out.println(count + " word(s) found " + a.length);
				} catch (Exception e) {
				}
				System.out.println(constant.endMessage);
			} else {
				System.out.println("please put a valid argument and try again");
			}
		}
	}

	private static BufferedWriter studentName() throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("students.txt", true));
		return writer;
	}

	private static String students() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("students.txt")));
		String names = reader.readLine();
		reader.close();
		return names;
	}
}