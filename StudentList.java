import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println(constant.inputMessage);
		} else {
			if (args[0].equals(constant.displayCommand)) {
				System.out.println(constant.waitingMessage);
				try {
					String student[] = students().split(constant.separator);
					for (String names : student) {
						System.out.println(names);
					}
					
				} catch (Exception e) {
					System.out.println(constant.errorMessage);
				}
				System.out.println(constant.endMessage);
			} else if (args[0].equals(constant.randomAccessCommand)) {
				System.out.println(constant.waitingMessage);
				try {
					String student[] = students().split(constant.separator);
					Random pick = new Random();
					System.out.println(student[pick.nextInt(4)]);
				} catch (Exception e) {
					System.out.println(constant.errorMessage);
				}
				System.out.println(constant.endMessage);
			} else if (args[0].contains(constant.addCommand)) {
				System.out.println(constant.waitingMessage);
				try {
					String students = students();
					File file = new File(constant.inputFileName);
					file.delete();
					File file1 = new File(constant.inputFileName);
					file1.createNewFile();
					BufferedWriter student = studentName();
					student.write(students);
					DateFormat dateFormat = new SimpleDateFormat(constant.timeFormat);
					student.write(constant.separator + args[0].substring(1) + constant.updateMessage + dateFormat.format(new Date()));
					student.close();
				} catch (Exception e) {
					System.out.println(constant.errorMessage);
				}

				System.out.println(constant.endMessage);
			} else if (args[0].contains(constant.searchCommand)) {
				System.out.println(constant.waitingMessage);
				try {
					String student[] = students().split(constant.separator);
					for (int idx = 0; idx < student.length; idx++) {
						if (student[idx].equals(args[0].substring(1))) {
							System.out.println(constant.foundMessage);
							break;
						}
					}
				} catch (Exception e) {
					System.out.println(constant.errorMessage);
				}
				System.out.println(constant.endMessage);
			} else if (args[0].contains(constant.countCommand)) {
				System.out.println(constant.waitingMessage);
				try {
					String student[] = students().split(constant.separator);
					System.out.println(student.length + constant.foundMessage);
				} catch (Exception e) {
					System.out.println(constant.errorMessage);
				}
				System.out.println(constant.endMessage);
			} else {
				System.out.println(constant.errorMessage);
			}
		}
	}

	private static BufferedWriter studentName() throws IOException {
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(constant.inputFileName, true));
		return writer;
	}

	private static String students() throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(constant.inputFileName)));
		String names = reader.readLine();
		reader.close();
		return names;
	}
}