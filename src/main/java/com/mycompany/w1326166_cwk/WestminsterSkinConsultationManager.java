package com.mycompany.w1326166_cwk;

import java.util.*;
import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.time.*;

/** 
 * Program for managing a Skin Consultation Centre
 * @author Matt Bradstreet
 * @version 1.0
*/

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    
    private static ArrayList<Doctor> doctorList = new ArrayList<Doctor>(); 
    private final int maxDoctorCap = 10;    

    public static void main(String[] args) 
    {
        boolean quit = false;
        Scanner in = new Scanner(System.in);
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        
        while (quit == false)
        {
            System.out.println();
            System.out.println("Menu ");
            System.out.println("A: Add New Doctor");
            System.out.println("D: Delete a Doctor");
            System.out.println("P: Print List of Doctors");
            System.out.println("S: Save List of Doctors");
            System.out.println("L: Load List of Doctors");
            System.out.println("G: Launch GUI");
            System.out.println("Q: Quit Program");
        
            System.out.print("Please enter key: ");
            String menu = in.next();        
    
            if (menu.equalsIgnoreCase("A"))
            {
                manager.addNewDoctor(in);
            }
            else if (menu.equalsIgnoreCase("D"))
            {
                manager.deleteDoctor(in);
            }
            else if (menu.equalsIgnoreCase("P"))
            {
                manager.printList();
            }
            else if (menu.equalsIgnoreCase("S"))
            {
                manager.saveList();
            }
            else if(menu.equalsIgnoreCase("L"))
            {
                manager.loadList();
            }
            else if (menu.equalsIgnoreCase("G"))
            {
                manager.launchGui();
            }
            else if (menu.equalsIgnoreCase("Q"))
            {
                quit = true;
            }
            else 
            {
                System.out.println("Key not recognised, please select appropriate key");
            }   
        }        
    }


    public void addNewDoctor(Scanner in)
    {
        /** 
        * Method for adding new Doctors to system
        * @param in Scanner object for taking user input
        */  

        boolean dobValid = true;

        if (doctorList.size() != maxDoctorCap)
        {
            System.out.println("Add New Doctor");

            System.out.print("First Name: ");
            String firstName = in.next();
            System.out.print("Surname: ");
            String surname = in.next();

            System.out.print("Date of Birth (dd/mm/yyyy): ");
            String dob = in.next();

            // check for valid user input
            if(dob.length() == 10)
            {
                try
                {
                    Integer.parseInt(dob.substring(0,2));
                    Integer.parseInt(dob.substring(3,5));
                    Integer.parseInt(dob.substring(6,10));
                }
                catch(NumberFormatException error)
                {
                    dobValid = false;
                }
            }
            else
            {
                dobValid = false;
            }

            System.out.print("Mobile Number: ");
            String mobileNumber = in.next();

            System.out.print("Medical Licence Number: ");
            String medLicenceNumber = in.next();
            
            System.out.print("Specialisation: ");
            String specialisation = in.next();

            // if user input valid, create Doctor object
            if(dobValid == true)
            {
                doctorList.add(new Doctor(firstName, surname, dob, mobileNumber, medLicenceNumber, specialisation));
            }
            else
            {
                System.out.println("Doctor Not Added, Input Error");
            }
        }
        else
        {
            System.out.println("Centre Full, Max 10 Doctors");
        }
    }


    public void deleteDoctor(Scanner in)
    {
        /** 
        * Method for deleting a Doctor from the system
        * @param in Scanner object for taking user input
        */  

        boolean licenceMatch = false;

        System.out.println("Delete Doctor");

        if(doctorList.size() != 0)
        {
            System.out.println("Medical Licence Numbers: ");

            //Iterate through Doctor List and list Licence Numbers of each doctor
            for(int i = 0; i < doctorList.size(); i++)
            {
                Doctor doctor1 = doctorList.get(i);
                String licence1 = doctor1.getMedLicenceNum();
                System.out.println(licence1);
            }

            //Take user input of Licence Number
            System.out.print("Select the Licence Number for Deletion: ");
            String inputLicenceNum = in.next();

            //iterate through Doctor arrayList and compare with input
            for(int i = 0; i < doctorList.size(); i++)
            {
                Doctor doctor2 = doctorList.get(i);
                String licence2 = doctor2.getMedLicenceNum();
                
                if (licence2.equals(inputLicenceNum))
                {
                    //If matches, remove Doctor object
                    System.out.println("Deleted");
                    System.out.println(doctor2);
                    doctorList.remove(i);
                    System.out.println("Doctors Remaining: " + doctorList.size());
                    licenceMatch = true;
                }
            }

            if (licenceMatch == false)
            {
                System.out.println("Medical Licence Number Not Found");
            }
        }
        else
        {
            System.out.println("Centre empty, no Doctors to delete");
        }
    }


    public void printList()
    {
        /** 
        * Method for printing list of Doctors registered to Centre, alphabetically by surname
        */  

        System.out.println("Print Doctor List");

        if(doctorList.size() != 0)
        {
            //bubble sort the doctor array list alphabetically
            for(int i = 0; i < doctorList.size(); i++)
            {
                for(int j = 0; j < doctorList.size(); j++)
                {
                    if (doctorList.get(i).getSurname().compareToIgnoreCase(doctorList.get(j).getSurname()) < 0)
                    {
                        Doctor temp = doctorList.get(j);
                        doctorList.set(j, doctorList.get(i));
                        doctorList.set(i, temp);
                    }
                }
            }

            //print alphabetical list of doctors by surname
            for(int i = 0; i < doctorList.size(); i++)
            {
                System.out.println(doctorList.get(i));
            }
        }
        else
        {
            System.out.println("No Doctors registered at Centre");
        }
    }


    public void saveList()
    {
        /** 
        * Method for saving list of Doctors to text file
        */  

        try
        {
            PrintWriter listFile = new PrintWriter("DoctorList.txt"); 

            for (int i = 0; i < doctorList.size(); i++)
            {
                Doctor doctor4 = doctorList.get(i);
                listFile.println(doctor4);
            }
            listFile.close();
            System.out.println("List Saved");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error when writing file, file not created " + e);
        }
    }


    public void loadList()
    {
        /** 
        * Method for loading list of Doctors from text file
        */  

        System.out.println("Load Doctor List");

        //clears the current list of Doctors before loading, prevents duplication of Doctors
        doctorList.clear();

        try
        {
            //reads in text file, iterates through line by line, splitting the Strings and creating new Doctor objects

            BufferedReader in = new BufferedReader(new FileReader("DoctorList.txt"));    
            
            for(int i = 0; i < maxDoctorCap; i++)
            {
                String line = in.readLine();

                if(line != null)
                {
                    Doctor loadDoctor = new Doctor();
                    String[] testSplit = line.split(", ");

                    for(int j = 0; j < testSplit.length; j++)
                    {   
                        String split = testSplit[j];

                        if(j == 0)
                        {
                            loadDoctor.setFirstName(split);
                        }
                        else if(j == 1)
                        {
                            loadDoctor.setSurname(split);
                        }
                        else if(j == 2)
                        {
                            loadDoctor.setDob(split);
                        }
                        else if(j == 3)
                        {
                            loadDoctor.setMobileNumber(split);
                        }
                        else if(j == 4)
                        {
                            loadDoctor.setMedLicenceNum(split);
                        }
                        else if(j == 5)
                        {
                            loadDoctor.setSpec(split);
                        }                                                                                                                  
                    }

                    doctorList.add(loadDoctor);

                }
            }
            in.close();

        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not Found " + e);
        }
        catch(IOException e)
        {
            System.out.println("IO Error " + e);
        }
    }


    public void launchGui()
    {
        /** 
        * Method for launching GUI
        */  

        GuiMenu GMenu = new GuiMenu();

        GMenu.setDoctorList(doctorList);
        GMenu.setTable(doctorList);
        GMenu.setSize(1200, 770);
        GMenu.setTitle("Westminster Skin Consultation Manager");
        GMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GMenu.setVisible(true);
    }

}
