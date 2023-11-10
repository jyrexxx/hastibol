package ass;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class studentTable {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> hashTable = new HashMap<>();

		public void addStudent() {
			String response;
			 do {
			 System.out.print("Enter the student ID to add: ");
             String insertKey = sc.nextLine();
             
             System.out.print("Enter the name to add: ");
             String insertName = sc.nextLine();
             
             hashTable.put(insertKey, insertName);

             System.out.println("Student ID and Name added: " + insertKey + " | " + insertName);
             
             System.out.print("\nDo you want to add another student? (Y/N): ");
             response = sc.nextLine();
         } 
         while (response.equalsIgnoreCase("y"));
		}
		
		public  void searchStudent() {
			String response;
			 do {
			System.out.print("Enter the student ID to search: ");
			String searchKey = sc.nextLine();
            if (hashTable.containsKey(searchKey)) {
                String searchName = hashTable.get(searchKey);
                System.out.println("Student ID found: " + searchKey + " | Name: " + searchName);
            }
            else {
                System.out.println("Student ID not found");
            }
            System.out.print("\nDo you want to search another student? (Y/N): ");
            response = sc.nextLine();
        } 
        while (response.equalsIgnoreCase("y"));
		}
		
		public void deleteStudent() {
			String response;
			 do {
			 System.out.print("Enter the student ID to delete: ");
             String deleteKey = sc.nextLine();

             if (hashTable.containsKey(deleteKey)) {
                 hashTable.remove(deleteKey);
                 System.out.println("Student ID deleted: " + deleteKey);
             } else {
                 System.out.println("Student ID not found");
             }
             System.out.print("\nDo you want to delete another student? (Y/N): ");
             response = sc.nextLine();
         } 
         while (response.equalsIgnoreCase("y"));
		}
		
		public void displayStudent() {
			displayStudentRecords(hashTable);
		}
	 
		public static void main(String[] args) {
			
			Scanner scanner = new Scanner(System.in);
			studentTable SDL = new studentTable();
			
			boolean repeat;
			try {
			while (repeat = true) {
				System.out.println("\n~~~~~Choose an Option~~~~");
	            System.out.println("1. Add Student.");
	            System.out.println("2. Search Student.");
	            System.out.println("3. Delete Student.");
	            System.out.println("4. Display Student.");
	            System.out.println("5. Exit.");
	            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	            System.out.println("Choose from the option:");
	            
				int select = scanner.nextInt();
				
				switch(select) {
				case 1:
					SDL.addStudent();
					break;
				case 2:
					SDL.searchStudent();
					break;
				case 3:
					SDL.deleteStudent();
					break;
				case 4:
					SDL.displayStudent();
					break;
				case 5:
					System.out.println("Thank you for using the system!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Input. Choose from the options only!");
					
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input. Select from the choices only!");
			main(args);
		}
	  }
		
		private static void displayStudentRecords(Map<String, String> records) {
	        System.out.println("Student Records:");
	        if (records.isEmpty()) {
	            System.out.println("No records found.");
	        } else {
	            for (Map.Entry<String, String> entry : records.entrySet()) {
	                System.out.println("Student ID: " + entry.getKey() + " | Name: " + entry.getValue());
	            }
	        }
	}
}