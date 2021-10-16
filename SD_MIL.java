import java.util.Scanner;
import java.util.Date;
import java.io.*;
public class SD_MIL {

	//STOP complaining about the lack of documentation use the toString DAMMIT!
	
	public void fileOpen(String path, String data) throws IOException{
		
		FileWriter write = new FileWriter(path, true);
		PrintWriter file = new PrintWriter(write);
		file.println(data);
		file.close();
	}

	public void fileStart(String data1)throws IOException{
		
		PrintWriter Outputfile = new PrintWriter("devyTEXT.txt");
		Outputfile.println(data1);
		Outputfile.close();
		
	}
	
	public String IO_stream(String path, String task_data) throws FileNotFoundException {

		File read = new File(path);
		Scanner reader = new Scanner(read);
		while(reader.hasNextLine()) {task_data = reader.nextLine();}
		reader.close();
		return task_data;
	
	}
	
	public String toString() {
		String h = "The class has 3 methods\n 1. fileOpen: will open an existing file and write to the parameter.\n" + 
	"2. fileStart: will create a new file, will print data into the file with the data being in the parameter.\n"
	+ "3. IO_stream: will open a file and return a string of all the data in the file.";
		
		return h;
	}

		

	}


