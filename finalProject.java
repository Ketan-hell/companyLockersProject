
import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;

public class finalProject {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//displaying the welcome Screen
		 System.out.println("========================");
	     System.out.println("Welcome to Locked me.com");
	     System.out.println("========================");
	     System.out.println("Developed by: Ketan Kholia");
	     System.out.println("Company Lockers Pvt. Ltd.");
	     System.out.println("\n");
	     projectFeature();

	}
	static void projectFeature() throws IOException{      
		String[] arr = 
			{"1- Enter 1 to retrieve file names in Ascending order",
            "2- Enter 2 to check user interface",
            "3- Enter 3 to close application"};
    int[] arr1 = {1, 2, 3};
    for (int i = 0; i < arr1.length; i++) {
        System.out.println(arr[i]);
    }
    Scanner sc = new Scanner(System.in);
    System.out.println("\nEnter your choice:\n");
    int options = sc.nextInt();
   
            switch (options) {
                case (1):
                	System.out.println("\n");
                    retrieveFile();
                    System.out.println("\n");
                    projectFeature();
                    break;

                case (2):
                    String[] arr2 = {
                            "a- Enter 'add' to add a file in the application ",
                            "b- Enter 'delete' to delete a file",
                            "c- Enter 'search' to search a file",
                            "d- Enter 'menu 'to return to main Menu",
                    };
                    //String[] arr3 = {"add", "delete", "search", "menu"};
                    //printing out the options
                    for (int i = 0; i < arr2.length; i++) {
                        System.out.println(arr2[i]);
                    }
                    //taking user input
                    System.out.println("\nEnter your choice:\t");
                    Scanner user = new Scanner(System.in);
                    String input = user.nextLine();
                    //using switch cases to execute multiple conditions
                    switch (input) {
                        case ("add"):
                        	System.out.println("1. Add a file \n");
                            addFile();
                        System.out.println("\n");
                            projectFeature();
                            break;

                        case ("delete"):
                            System.out.println("2. Delete a file \n");
                            delFile();
                            System.out.println("\n");
                            projectFeature();
                            break;

                        case ("search"):
                            System.out.println("3. Search a file name \n");
                            searchFile();
                            System.out.println("\n");
                            projectFeature();
                            break;

                        case ("menu"):
                            System.out.println("4. Return to main menu");
                        System.out.println("\n");
                            projectFeature();
                            break;

                        default:
                            System.out.println("Wrong input try again");
                            projectFeature();
                            break;
                    }

            case (3):
                System.out.println("Application Closed - Thank You for logging");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Input");
                System.out.println("Try again");
                projectFeature();
                break;
        }
    }
	
	
    static void retrieveFile() throws IOException {
    	//list of all file present is created
    	//ArrayList<String> fPresent = new ArrayList<String>();
    	File myFile = new File("/home/kholiaketan2gma/FinalProject/src/myFiles");
    	File downloadDir[] = myFile.listFiles();
    	//sorting an array
    	Arrays.sort(downloadDir);
    	//printing the list of files present
    	System.out.println("The files present in the directory in ascending oder:\n ");
    	for (File e : downloadDir) {
            if (e.isFile()) {
                System.out.print(e.getName() + ",  ");
            } else {
                System.out.println("Not present");
            }
        }
    }

        
        static void addFile() throws IOException {
        	Scanner inp2 = new Scanner(System.in);
        	//path of directory where i want to store my file.
        	System.out.println("Enter the path of the directory");
        	String path = inp2.nextLine();
        	//taking user input for file name
        	System.out.println("Enter the file name you want to add the directory");
            String input_file = inp2.nextLine();
            //creating absolute path of my file
            String aFile = new String(path.concat(input_file));
            File myFile = new File(aFile);
        	if(myFile.exists()) {
        		System.out.println("File already exist");
        	}
        	else {
        		myFile.createNewFile();
        		System.out.println("File added successfully : " + myFile.getName());
        	} 
        	//add file complete
    }
        
        static void delFile() throws FileNotFoundException{
			Scanner inp3 = new Scanner(System.in);
			//path of directory
			System.out.println("Enter the path of the directory");
        	String path = inp3.nextLine();
        	//taking file name as input. 
        	System.out.println("Enter the file name you want to delete from the directory");
            String input_file = inp3.nextLine();
            String dFile = new String(path.concat(input_file));
            File myFile = new File(dFile);
            //if file name exactly matches file will be deleted
            if (myFile.exists()){
            	System.out.println("File exists: " + myFile.getName());
                myFile.delete();
                System.out.println("File is deleted successfully : " + myFile.getName());
                }
            else {
                System.out.println("File not found");
                  }
            //delete file complete
        }
        
        
        static void searchFile(){
            Scanner inp4 = new Scanner(System.in);
            System.out.println("Enter path of directory where you want to search file");
            String path = inp4.nextLine();
            System.out.println("Enter a file name you want to search");
            String input_file = inp4.nextLine();
            String serFile = new String(path.concat(input_file));
            File aFile = new File(serFile);
            if (aFile.exists()){
                System.out.println("File is present in directory : " + aFile.getName());
            }
            else {
                System.out.println("File not found  \n");
            }
            //search a file complete
        }

}
