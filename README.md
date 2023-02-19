# ConsultationManager
This is a program for managing a Skin Consultation Centre, allowing users to add and delete doctors, as well as to print, save and load lists of doctors from the command line. The program also allows the launching of a GUI for booking and managing appointments on behalf of patients for specific doctors. 


<h1 style="font-size: 6px;">Getting Started</h1>

The program is written in Java, and the source code is available in the src folder.

It consists of an interface SkinConsultationManager, an implemented version containing the main WestminsterSkinConsultationManager and the classes GuiMenu and Consultation (for the appointments). Also the superclass Person and subclasses Patient and Doctor.

To run the program, you can compile the source code and run the resulting WestminsterSkinConsultationManager.java file.


<h1 style="font-size: 6px;">Usage</h1>

Upon running the program, users will be presented with a command line menu that allows them to perform various actions:

A: Add New Doctor - Allows users to add a new doctor to the system by entering their details.

D: Delete a Doctor - Allows users to delete a doctor from the system by entering their medical licence number.

P: Print List of Doctors - Prints a list of all doctors registered to the centre, sorted alphabetically by surname.

S: Save List of Doctors - Saves the current list of doctors to a file.

L: Load List of Doctors - Loads a list of doctors from a file.

G: Launch GUI - Launches a GUI for the booking and managing of appointments.

Q: Quit Program - Exits the program.


<h1 style="font-size: 6px;">Author</h1>

This program was written by Matt Bradstreet.


<h1 style="font-size: 6px;">Version History</h1>

1.0 - Initial release.
