package Task_5;

import java.util.Scanner;

public class Main {

	enum Transaction {
		ON, OFF;
	}

	public static void main(String args[]) {

		Function<String, Integer> mainMap = new Function<String, Integer>();
		Function<String, Integer> localMap = new Function<String, Integer>();
		Transaction state = Transaction.OFF;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the Comment");
			String comment = scanner.nextLine();
			String[] arr = comment.split(" ");
			if (arr[0].equalsIgnoreCase("SET")) {

				if (state == Transaction.ON) {
					localMap.set(comment);
				} else {
					mainMap.set(comment);

				}
			} else if (arr[0].equalsIgnoreCase("GET")) {
				String key = arr[1];
				if (state == Transaction.ON) {
					if (localMap.get(key) == null) {
						System.out.println(mainMap.get(key));
					} else {
						System.out.println(localMap.get(key));
					}
				} else {
					System.out.println(mainMap.get(key));
				}
			} else if (arr[0].equalsIgnoreCase("BEGIN")) {
				state = Transaction.ON;
//				localMap = new Function<String, Integer>();
				System.out.println("Begin");
			} else if (arr[0].equalsIgnoreCase("COUNT")) {
				if (state == Transaction.ON) {
					if (localMap.count(comment) == 0) {
						
						System.out.println(mainMap.count(comment));
					} else {
						System.out.println(localMap.count(comment)+mainMap.count(comment));
					}
				} else {
					System.out.println(mainMap.count(comment)+localMap.count(comment));
				}

			} else if (arr[0].equalsIgnoreCase("UNSET")) {
				String key = arr[1];
				if(state==Transaction.ON)
				 {
					if(localMap.unset(key)==false)
					 {
						mainMap.unset(key);
						
					 }else
					 {
						 localMap.unset(key);
					 }
				 }else 
				   if(mainMap.unset(key) == false) {
					System.out.println("null");
				} else {
					mainMap.unset(key);
				}

			}
			else if (arr[0].equalsIgnoreCase("UPDATE")) {

				if (state == Transaction.ON) {
					localMap.update(comment);
				} else {
				System.out.println(mainMap.update(comment));
				}

			} 
			 else if(arr[0].equalsIgnoreCase("ROLLBACK"))
			 {
				 state=Transaction.OFF;
				 System.out.println("RollBack");
			 }
			 else if(arr[0].equals("COMMIT"))
			 {
			   mainMap.commit(localMap);
					
			 }
			 else if (arr[0].equalsIgnoreCase("KEYS")) {
					if (state == Transaction.ON) {
						if (localMap.printKey() == null) {
							mainMap.printKey();
						} else {
							localMap.printKey();
						}
					} else {
						mainMap.printKey();
					}
				} else if (arr[0].equalsIgnoreCase("VALUES")) {
					if (state == Transaction.ON) {
						if (localMap.printValues() == null) {
							mainMap.printValues();
						} else {
							localMap.printValues();
						}
					} else {
						mainMap.printValues();
					}
				}
			

		}

	}
}