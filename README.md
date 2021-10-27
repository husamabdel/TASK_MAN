# TASK_SD
Ticket logger, helps me with my job!

/*
	V1.0.0.2 

	Beta (TESTING)

	Ticket Logger.
	Sam Abdalla.
	
	CONTACT (habdalla@loc.gov, Husamabdalla98@gmail.com) to report Bugs.

	Description:

The purpose of this program is to provide the user with dynamic functionality for 
operating daily tasks, and to have everything in the click of a button.
This can help the technitian or the user of the program complete tasks and repetetive activities much faster.
This is also intended to increase workflow productivity and to help the user keep track of tickets and tasks.

The first two buttons launch webpages, one for Idaptive and one for a new ticket on service now.
The third button "all data" scans the file and returns the last line of data appended to the file in a message box.
This is to help the user identify where they left off.
The forth button "Full logs" launches the file that contains all of the data in readable format. (.txt)
the last two buttons provide the option of appending data to the existing file with or without the date. 
This is to help the user of the program keep track of the data that is being stored in the file.


	For Nerds:

The program upon first installation, User will indicate that 
they are the first user, This will trigger the boolean flag function to return FALSE,
and will invoke an object of the IO class to create a text file to append the data to.
The program extends the Java JFrame class and thus inherets all of its methods.
The JFrame class is used to provide a user friendly GUI environment.
The program comes with three buttons, all of which host a private sub class that implements
action listeners.
Some functions have been commented out for possible later implementation like the option to send the data to an email.

Exception handling for most classes and functions is by try/catch blocks and some are thrown at function declaration.
non-compiler related issues and exceptions in some cases will kill the process with the System.exit(0); Object.
These are usually cases where the user has refused the file creation.
*/
