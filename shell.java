
package myshell;
import java.io.*;
import java.util.ArrayList;

public class myshell_15060197 {

	public static void main(String[] args) throws IOException {

        //Use commandLine to store the command and the argument(s).
        String commandLine;

        //Store available commands into an array
        String a[]=new String[4];
        a[0]= "exit";
        a[1]= "hist";
        a[2]= "about";
        a[3]= "notepad";

        //Read and buffered the command and the argument(s).
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        //To store previous commands (declaration of the array list)
        ArrayList<String> commandHistory= new ArrayList<String>();

        //Just a banner
        System.out.println("My Shell Version 0.01");

        //Continue to loop until "exit" is entered.
        //Although it is uncommon for a normal application, it is normal for a shell.
        while (true) {
            //Print the console line.
            //Remember to replace "student_id" with your student number.
            System.out.print("15060197> ");
            //Read the input from user.
            commandLine = console.readLine();
            //Adds every commands into command history array
            commandHistory.add(commandLine);
            //Split the input into command and parameters.
            //commandParams is a list that are initially created to store all the parameters.
            //commandSplit is a string array that is used to store the command and the parameters after splitting them.
            ArrayList commandParams = new ArrayList();
            String[] commandSplit = commandLine.split(" ");


            //Check to see if there is any parameter.
            //If size of commandSplit is larger than one that means the user has included some parameters in the input.
            if (commandSplit.length > 1) {
                //Add the parameters into commandParams
                for (int i = 1; i < commandSplit.length; i++) {
                    commandParams.add(commandSplit[i]);
                }
            }

            //Detect unavailable commands by user
            boolean exist = true;
            for (int d = 0; d < a.length; d++) {
                if (a[d].equals(commandSplit[0])) {
                    exist = false;
                }
            }
            if (exist) {
                System.out.println("Invalid Command");
            }

            //Reprint the console line if user just pressed "enter" without any command.
            if (commandSplit[0].equals("")) {
                continue;
            }

            //Function that displays the author and the version number
            if (commandSplit[0].equals("about")) {
            	System.out.println("Author: Wee Chyanna");
            	System.out.println("Version: 0.01");
            }

            //Exit the console when "exit" is entered.
            if (commandSplit[0].equals("exit")) {
                System.exit(0);
            }

            //Opens notepad
            if(commandSplit[0].equals("notepad")){
            	/*ProcessBuilder pb = new ProcessBuilder("Notepad.exe","myfile.txt");
        		pb.start();*/
            	Runtime rs = Runtime.getRuntime();
            	try
            	{
            		rs.exec("notepad");
            	}
            	catch(IOException e){
            		System.out.println(e);
            	}

            }

            //Example of a built-in function that can be used to trace the command history.
           if (commandSplit[0].equals("hist")) {
                if (commandParams.size() < 1) {
                    System.out.println("Error : Not enough input argument(s). Please enter hist -h for help.");
                }

                else {
                    //Process based on the number of parameters attached to the command.
                    if (commandParams.get(0).equals("-h")) {
                        System.out.println("hist -l [int] : Retrieve the last [int] commands entered by the user.");
                        System.out.println("hist -c : Clear the command history.");
                    }
                    if (commandParams.get(0).equals("-l")){
                         //Assign value of third parameter into number
                    	 int num = Integer.valueOf((String) commandParams.get(1));
                    	 //Invalid if parameter is less than 1
                    	 if (num<1){
                    		 System.out.println("Invalid Number");
                    		 continue;
                    	 }
                    	 //Loops over commandHistory array list to print command history (latest first)
                    	 for(int i=num-1;i>=0;i--){
                    		 if (i==commandHistory.size()-1 || commandHistory.size() == 1){
                    			 continue;
                    		 }
                    		  System.out.println(commandHistory.get(i));
                    	 }
                    	 //another version (earlier first)
                    	 /*for(int i=0;i<num;i++){
                    		 if (i==commandHistory.size()-1 || commandHistory.size() == 1){
                    			 break;
                    		 }
                    	  System.out.println(commandHistory.get(i));
                    	 }*/
                    }
                    if (commandParams.get(0).equals("-c")){
                    	//clears command history
                    	commandHistory.clear();
                    	System.out.println("Command history has been deleted.");
                    }
                }
            }

           if (commandParams.size() == 3){
           	if (commandParams.get(2).equals("-c")){
           		commandHistory.clear();
            	System.out.println("Command history has been deleted.");
           	}
           	else {
           		 //int numAgain = Integer.valueOf((String) commandParams.get(2));
           		 continue;
         }
       }
     }
   }
 }
