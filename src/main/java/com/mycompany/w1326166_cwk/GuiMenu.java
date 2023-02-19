package com.mycompany.w1326166_cwk;

import java.util.*;
import java.lang.*;
import java.time.LocalTime;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.plaf.DimensionUIResource;


public class GuiMenu extends JFrame {
    
    private JButton sortButton;
    private JTable docViewTable;
    private JScrollPane docPane;
    private TableModel tableModel;
    private JTable consultViewTable;

    private JTextField doctorField;
    private JButton viewConsultButton;
    private JTextField doctorConsultField;
    private JButton bookButton;
    private JCheckBox costCheck;
    private JTextField costField;
    private JTextField dateText;
    private JComboBox timeConsult;
    private JComboBox lengthConsult;
    private JTextField patFirstNameText;
    private JTextField patSurnameText;
    private JTextField patDobText;
    private JTextField patMobText;
    private JTextField patIdText;        
    private JTextField notesText;
    private JLabel doctorBusyLabel;
    private JLabel consultBookedLabel;

    private JTextField viewDateText;
    private JTextField viewTimeConsult;
    private JTextField viewPatFirstNameText;
    private JTextField viewPatSurnameText;
    private JTextField viewPatDobText;
    private JTextField viewPatMobText;
    private JTextField viewPatIdText;
    private JTextField viewCostField;
    private JTextField viewNotesText;  

    private Doctor doctorConsult;
    private Patient patient;
    private String medLicenceNumber;
    private ArrayList<Doctor> doctorList;
    private String[] doctorColumn = {"First Name","Surname","DOB","Mobile","Medical Num","Specialisation"};
    private String[][] doctorTable = new String[10][doctorColumn.length];
    private String[] consultColumn = {"Day", "Month", "Year", "Time"};
    private String[] openingTimes = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00"};
    private String[] lengthTimes = {"1","2","3","4"};
    private ArrayList<Consultation> consultMasterArray = new ArrayList<Consultation>();
    private String[][] consultTable = new String[10][consultColumn.length];
    private Consultation[] indivConsultArray = new Consultation[10];


    public GuiMenu()
    {
        // window container
        Container window = getContentPane();
        window.setLayout(new GridLayout(2, 2, 1, 3)); 
        

        //Top-Left Panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel label = new JLabel("Doctor List");
        sortButton = new JButton("Sort Alphabetically");

        docViewTable = new JTable();
        docViewTable.setGridColor(Color.BLACK);
        docViewTable.setPreferredScrollableViewportSize(new DimensionUIResource(500, 160));
        docViewTable.setFillsViewportHeight(true);
        docViewTable.setName("docViewTable");
        docViewTable.setEnabled(false);
        docPane = new JScrollPane(docViewTable);

        topPanel.add(label);
        topPanel.add(sortButton);
        topPanel.add(docPane);
        add(topPanel);


        //Top-Right Panel
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel2.setBorder(BorderFactory.createEtchedBorder());

        JLabel doctorLabel = new JLabel("Doctor:");
        doctorField = new JTextField();
        doctorField.setColumns(10);
        doctorField.setEditable(false);

        viewConsultButton = new JButton("View Consultations");

        // Table for viewing Consultations
        consultViewTable = new JTable();
        consultViewTable.setGridColor(Color.BLACK);
        consultViewTable.setPreferredScrollableViewportSize(new DimensionUIResource(500, 160));
        consultViewTable.setFillsViewportHeight(true);       
        consultViewTable.setName("consultViewTable"); 
        consultViewTable.setEnabled(false);
        JScrollPane consultPane = new JScrollPane(consultViewTable);

        panel2.add(doctorLabel);
        panel2.add(doctorField);
        panel2.add(viewConsultButton);
        panel2.add(consultPane);

        add(panel2);


        //Bottom-Left Panel
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(17, 2, 5, 3));
        panel3.setBorder(BorderFactory.createEtchedBorder());
        
        JLabel consultLabel = new JLabel("Book New Consultation: ");  
        JLabel blankLabel1 = new JLabel("");     

        JLabel doctorLabel2 = new JLabel("Doctor:");
        doctorConsultField = new JTextField();
        doctorConsultField.setEditable(false);        
        
        JLabel dateLabel = new JLabel("Date (dd/mm/yyyy): ");
        dateText = new JTextField();

        JLabel timeLabel = new JLabel("Start Time: ");
        timeConsult = new JComboBox(openingTimes);

        JLabel lengthLabel = new JLabel("Length of Consultation (p/h): ");
        lengthConsult = new JComboBox(lengthTimes);

        JLabel patientLabel = new JLabel("Add Patient: ");  
        JLabel blankLabel2 = new JLabel("");   

        JLabel patFirstNameLabel = new JLabel("First Name: ");
        patFirstNameText = new JTextField();

        JLabel patSurnameLabel = new JLabel("Surname: ");
        patSurnameText = new JTextField();

        JLabel patDobLabel = new JLabel("Date of Birth: ");
        patDobText = new JTextField();

        JLabel patMobLabel = new JLabel("Mobile Number: ");
        patMobText = new JTextField();

        JLabel patIdLabel = new JLabel("Patient ID: ");
        patIdText = new JTextField();

        JLabel summaryLabel = new JLabel("Summary: ");  
        JLabel blankLabel3 = new JLabel("");   

        costCheck = new JCheckBox("First Consultation?");
        JLabel blankLabel4 = new JLabel("");

        JLabel totalLabel = new JLabel("Total Cost: ");
        costField = new JTextField("£25.00");
        costField.setEditable(false);

        JLabel notesLabel = new JLabel("Notes: ");
        notesText = new JTextField();

        bookButton = new JButton("Book Consultation");
        consultBookedLabel = new JLabel("Consultation Booked Successfully");
        consultBookedLabel.setVisible(false);

        JLabel blankLabel8 = new JLabel("");
        doctorBusyLabel = new JLabel("Doctor Busy, reassigned to New Doctor");
        doctorBusyLabel.setVisible(false);

        panel3.add(consultLabel);
        panel3.add(blankLabel1);
        panel3.add(doctorLabel2);
        panel3.add(doctorConsultField);
        panel3.add(dateLabel);
        panel3.add(dateText);
        panel3.add(timeLabel);
        panel3.add(timeConsult);
        panel3.add(lengthLabel);
        panel3.add(lengthConsult);
        
        panel3.add(patientLabel);
        panel3.add(blankLabel2);
        panel3.add(patFirstNameLabel);
        panel3.add(patFirstNameText);
        panel3.add(patSurnameLabel);
        panel3.add(patSurnameText);
        panel3.add(patDobLabel);
        panel3.add(patDobText);
        panel3.add(patMobLabel);
        panel3.add(patMobText);
        panel3.add(patIdLabel);
        panel3.add(patIdText);
        
        panel3.add(summaryLabel);
        panel3.add(blankLabel3);
        panel3.add(totalLabel);
        panel3.add(costField);
        panel3.add(blankLabel4);
        panel3.add(costCheck);
        panel3.add(notesLabel);
        panel3.add(notesText);
        panel3.add(bookButton);
        panel3.add(consultBookedLabel);
        panel3.add(blankLabel8);
        panel3.add(doctorBusyLabel);

        add(panel3);


        //Bottom-Right Panel
        //for viewing Consultation details
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(14, 2, 0, 3));
        panel4.setBorder(BorderFactory.createEtchedBorder());

        JLabel viewConsultLabel = new JLabel("View Consultation: ");
        JLabel blankLabel5 = new JLabel("");

        JLabel viewDateLabel = new JLabel("Date (dd/mm/yyyy): ");
        viewDateText = new JTextField();
        viewDateText.setEditable(false);

        JLabel viewTimeLabel = new JLabel("Start Time: ");
        viewTimeConsult = new JTextField();
        viewTimeConsult.setEditable(false);

        JLabel viewPatientLabel = new JLabel("Patient: ");  
        JLabel blankLabel6 = new JLabel("");   

        JLabel viewPatFirstNameLabel = new JLabel("First Name: ");
        viewPatFirstNameText = new JTextField();
        viewPatFirstNameText.setEditable(false);

        JLabel viewPatSurnameLabel = new JLabel("Surname: ");
        viewPatSurnameText = new JTextField();
        viewPatSurnameText.setEditable(false);

        JLabel viewPatDobLabel = new JLabel("Date of Birth: ");
        viewPatDobText = new JTextField();
        viewPatDobText.setEditable(false);

        JLabel viewPatMobLabel = new JLabel("Mobile Number: ");
        viewPatMobText = new JTextField();
        viewPatMobText.setEditable(false);

        JLabel viewPatIdLabel = new JLabel("Patient ID: ");
        viewPatIdText = new JTextField();
        viewPatIdText.setEditable(false);

        JLabel viewSummaryLabel = new JLabel("Summary: ");  
        JLabel blankLabel7 = new JLabel("");   

        JLabel viewTotalLabel = new JLabel("Total Cost: ");
        viewCostField = new JTextField();
        viewCostField.setEditable(false);

        JLabel viewNotesLabel = new JLabel("Notes: ");
        viewNotesText = new JTextField();   
        viewNotesText.setEditable(false);     

        panel4.add(viewConsultLabel);
        panel4.add(blankLabel5);
        panel4.add(viewDateLabel);
        panel4.add(viewDateText);
        panel4.add(viewTimeLabel);
        panel4.add(viewTimeConsult);
        panel4.add(viewPatientLabel);
        panel4.add(blankLabel6);
        panel4.add(viewPatFirstNameLabel);
        panel4.add(viewPatFirstNameText);
        panel4.add(viewPatSurnameLabel);
        panel4.add(viewPatSurnameText);
        panel4.add(viewPatDobLabel);
        panel4.add(viewPatDobText);
        panel4.add(viewPatMobLabel);
        panel4.add(viewPatMobText);
        panel4.add(viewPatIdLabel);
        panel4.add(viewPatIdText);
        panel4.add(viewSummaryLabel);
        panel4.add(blankLabel7);
        panel4.add(viewTotalLabel);
        panel4.add(viewCostField);
        panel4.add(viewNotesLabel);
        panel4.add(viewNotesText);
       
        add(panel4);
        

        //GUI colours
        window.setBackground(new Color(180,210,250));
        topPanel.setBackground(new Color(180,210,250));
        panel2.setBackground(new Color(180,210,250));
        panel3.setBackground(new Color(180,210,250));
        panel4.setBackground(new Color(180,210,250));


        //Event Listeners
        ButtonListener handler = new ButtonListener();
        sortButton.addActionListener(handler);
        bookButton.addActionListener(handler);
        viewConsultButton.addActionListener(handler);

        ClickListener clickHand = new ClickListener();
        docViewTable.addMouseListener(clickHand);
        consultViewTable.addMouseListener(clickHand);

        CheckListener checkHand = new CheckListener();
        costCheck.addItemListener(checkHand);
        lengthConsult.addItemListener(checkHand);
    }


    public void setDoctorList(ArrayList<Doctor> doctorList)
    {
        /** 
        * Method for importing DoctorList into GUI
        * @param doctorList ArrayList of Doctor objects
        */  

        this.doctorList = doctorList;
    }


    public void setTable(ArrayList<Doctor> doctorList)
    {
        /** 
        * Method for setting up the Doctor Table of Doctors
        * @param doctorList ArrayList of Doctor objects
        */  

        for(int i = 0; i < doctorList.size(); i++)
        {
            doctorTable[i][0] = doctorList.get(i).getFirstName();
            doctorTable[i][1] = doctorList.get(i).getSurname();
            doctorTable[i][2] = doctorList.get(i).getDob();
            doctorTable[i][3] = doctorList.get(i).getMobileNumber();
            doctorTable[i][4] = doctorList.get(i).getMedLicenceNum();
            doctorTable[i][5] = doctorList.get(i).getSpec();
        }

        tableModel = new DefaultTableModel(doctorTable,doctorColumn);
        docViewTable.setModel(tableModel);
    }


    private class ButtonListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            // event for 'Sort Alphabetically' Button
            if(event.getSource() == sortButton)
            {
                consultBookedLabel.setVisible(false);
                doctorBusyLabel.setVisible(false);

                // bubble sort the doctor list
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

                // repopulate the doctor table with new alphabetical doctor list
                for(int i = 0; i < doctorList.size(); i++)
                {
                    doctorTable[i][0] = doctorList.get(i).getFirstName();
                    doctorTable[i][1] = doctorList.get(i).getSurname();
                    doctorTable[i][2] = doctorList.get(i).getDob();
                    doctorTable[i][3] = doctorList.get(i).getMobileNumber();
                    doctorTable[i][4] = doctorList.get(i).getMedLicenceNum();
                    doctorTable[i][5] = doctorList.get(i).getSpec();
                }

                tableModel = new DefaultTableModel(doctorTable,doctorColumn);
                docViewTable.setModel(tableModel);
            }
            else if(event.getSource() == bookButton)
            {
                //event for 'Book Consultation' button

                boolean inputError = false;
                int day = 0;
                int month = 0;
                int year = 0;

                // create Patient object from user input
                String fname = patFirstNameText.getText();
                String sname = patSurnameText.getText();
                String dob = patDobText.getText();
                String mob = patMobText.getText();
                String id = patIdText.getText(); 
                
                //if Patient user input is incomplete
                if(fname.equals("") || sname.equals("") || dob.equals("") || mob.equals("") || id.equals(""))
                {
                    inputError = true;
                    consultBookedLabel.setText("Booking Failed - Incomplete Patient Details");
                }
                else
                {
                    patient = new Patient(fname, sname, dob, mob, id);
                }

                // check if user input date is correct
                if(dateText.getText().length() < 11)
                {
                    try
                    {
                        day = Integer.parseInt(dateText.getText().substring(0,2));
                        month = Integer.parseInt(dateText.getText().substring(3,5));
                        year = Integer.parseInt(dateText.getText().substring(6,10));
                    }      
                    catch(NumberFormatException error)
                    {
                        inputError = true;
                        consultBookedLabel.setText("Booking Failed - Incorrect Date Format");
                        System.out.println("Number Format Exception - " + error);
                    }
                    catch(IndexOutOfBoundsException error)
                    {
                        inputError = true;
                        consultBookedLabel.setText("Booking Failed - Incorrect Date Format");
                        System.out.println("Index Out Of Bounds - " + error);
                    }                                
                }
                else
                {
                    consultBookedLabel.setText("Booking Failed - Incorrect Date Format");
                }

                LocalTime time = LocalTime.parse(timeConsult.getSelectedItem().toString());
                float cost = Float.parseFloat(costField.getText().substring(1));
                String notes = notesText.getText();

                try
                {
                    //pulls Doctor Object from doctorList ArrayList
                    for(int i = 0; i < doctorList.size(); i++)
                    {
                        if(medLicenceNumber.equals(doctorList.get(i).getMedLicenceNum()) == true)
                        {
                            doctorConsult = doctorList.get(i);
                        }
                    }
                }
                catch(NullPointerException error)
                {
                    inputError = true;
                    consultBookedLabel.setText("Booking Failed - Please Select Doctor");
                    System.out.println("Null Pointer Exception - " + error);                    
                }

                // if chosen Doctor already has a Consultation at the same time, randomly assign a new Doctor
                if(consultMasterArray.size() != 0 && inputError == false)
                {
                    for(int i = 0; i < consultMasterArray.size(); i++)
                    {
                        while(doctorConsult == consultMasterArray.get(i).getDoctorInfo() && day == consultMasterArray.get(i).getDay() && month == consultMasterArray.get(i).getMonth() && year == consultMasterArray.get(i).getYear() && time == consultMasterArray.get(i).getTime())
                        {
                            Random random = new Random();
                            int randomNumber = random.nextInt(0, doctorList.size());
                            doctorConsult = doctorList.get(randomNumber);
                            
                            doctorBusyLabel.setVisible(true);
                        }    
                    }
                }

                // if all user input is correct, create consultation object and add to Consultation Array
                if(inputError == false)
                {
                    Consultation consultation = new Consultation(doctorConsult, patient, day, month, year, time, cost, notes);
                    consultMasterArray.add(consultation);
                    consultBookedLabel.setText("Consultation Booked Successfully");
                }

                //clear Text Fields
                patFirstNameText.setText("");
                patSurnameText.setText("");
                patDobText.setText("");
                patMobText.setText("");
                patIdText.setText("");
                dateText.setText("");
                notesText.setText("");

                consultBookedLabel.setVisible(true);
            }
            else if(event.getSource() == viewConsultButton)
            {
                //event for 'View Consultation' Button

                consultBookedLabel.setVisible(false);
                doctorBusyLabel.setVisible(false);

                for(int i = 0; i < consultMasterArray.size(); i++)
                {       
                    for(int j = 0; j < consultColumn.length; j++)
                    {
                        consultTable[i][j] = "";
                    }
                }

                // sorts the Consultation Master Array, and populates the Consultation Viewer with the selected Doctors Consultations
                int count = 0;

                for(int i = 0; i < consultMasterArray.size(); i++)
                {
                    if(medLicenceNumber.equals(consultMasterArray.get(i).getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        indivConsultArray[count] = consultMasterArray.get(i);

                        consultTable[count][0] = Integer.toString(consultMasterArray.get(i).getDay());
                        consultTable[count][1] = Integer.toString(consultMasterArray.get(i).getMonth());
                        consultTable[count][2] = Integer.toString(consultMasterArray.get(i).getYear());
                        consultTable[count][3] = (consultMasterArray.get(i).getTime()).toString();

                        count++;
                    }
                }    

                //updates the Consultation Table in GUI
                TableModel consultTableModel = new DefaultTableModel(consultTable, consultColumn);
                consultViewTable.setModel(consultTableModel);
            }
        }
    }

    private class ClickListener extends MouseAdapter
    {
        public void mouseClicked(MouseEvent event)
        {
            //event for selecting a Doctor from the Doctor Table in the GUI

            consultBookedLabel.setVisible(false);
            doctorBusyLabel.setVisible(false);

            // finds the location of the mouse click from the MouseEvent object
            String test = event.toString();
            int first = test.indexOf("(");
            int second = test.indexOf(")");
            String location = test.substring(first + 1,second);
            int comma = location.indexOf(",");
            int vertLoc = Integer.parseInt(location.substring(comma + 1));

            // sends the doctors name, that corresponds to the location of the mouse click, to the text field
            try
            {
                if(event.getComponent().getName().equals("docViewTable") == true)
                {
                    if(vertLoc < 16)
                    {
                        doctorField.setText(doctorList.get(0).getName());
                        doctorConsultField.setText(doctorList.get(0).getName());
                        medLicenceNumber = doctorList.get(0).getMedLicenceNum();  
                    }
                    else if(vertLoc < 32)
                    {
                        doctorField.setText(doctorList.get(1).getName());
                        doctorConsultField.setText(doctorList.get(1).getName());
                        medLicenceNumber = doctorList.get(1).getMedLicenceNum();
                    }
                    else if(vertLoc < 48)
                    {
                        doctorField.setText(doctorList.get(2).getName());
                        doctorConsultField.setText(doctorList.get(2).getName());
                        medLicenceNumber = doctorList.get(2).getMedLicenceNum();
                    }            
                    else if(vertLoc < 64)
                    {
                        doctorField.setText(doctorList.get(3).getName());
                        doctorConsultField.setText(doctorList.get(3).getName());
                        medLicenceNumber = doctorList.get(3).getMedLicenceNum();
                    }
                    else if(vertLoc < 80)
                    {
                        doctorField.setText(doctorList.get(4).getName());
                        doctorConsultField.setText(doctorList.get(4).getName());
                        medLicenceNumber = doctorList.get(4).getMedLicenceNum();
                    }   
                    else if(vertLoc < 96)
                    {
                        doctorField.setText(doctorList.get(5).getName());
                        doctorConsultField.setText(doctorList.get(5).getName());
                        medLicenceNumber = doctorList.get(5).getMedLicenceNum();
                    }
                    else if(vertLoc < 112)
                    {
                        doctorField.setText(doctorList.get(6).getName());
                        doctorConsultField.setText(doctorList.get(6).getName());
                        medLicenceNumber = doctorList.get(6).getMedLicenceNum();
                    }      
                    else if(vertLoc < 128)
                    {
                        doctorField.setText(doctorList.get(7).getName());
                        doctorConsultField.setText(doctorList.get(7).getName());
                        medLicenceNumber = doctorList.get(7).getMedLicenceNum();
                    }   
                    else if(vertLoc < 144)
                    {
                        doctorField.setText(doctorList.get(8).getName());
                        doctorConsultField.setText(doctorList.get(8).getName());
                        medLicenceNumber = doctorList.get(8).getMedLicenceNum();
                    }
                    else if(vertLoc < 160)
                    {
                        doctorField.setText(doctorList.get(9).getName());
                        doctorConsultField.setText(doctorList.get(9).getName());
                        medLicenceNumber = doctorList.get(9).getMedLicenceNum();
                    }
                }
            }
            catch (IndexOutOfBoundsException error)
            {
                doctorField.setText("");
            }


            // clicker for Consultation Viewer
            // sends the Consultation details, that correspond to the location of the mouse click, to the Consultation view section of the GUI
            try
            {
                if(event.getComponent().getName().equals("consultViewTable") == true)
                {
                    Consultation selection = indivConsultArray[0];

                    if(vertLoc < 16 && medLicenceNumber.equals(indivConsultArray[0].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[0];
                    }
                    else if(vertLoc < 32 && medLicenceNumber.equals(indivConsultArray[1].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[1];
                    }
                    else if(vertLoc < 48 && medLicenceNumber.equals(indivConsultArray[2].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[2];
                    }            
                    else if(vertLoc < 64 && medLicenceNumber.equals(indivConsultArray[3].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[3];
                    }
                    else if(vertLoc < 80 && medLicenceNumber.equals(indivConsultArray[4].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[4];
                    }   
                    else if(vertLoc < 96 && medLicenceNumber.equals(indivConsultArray[5].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[5];
                    }
                    else if(vertLoc < 112 && medLicenceNumber.equals(indivConsultArray[6].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[6];
                    }      
                    else if(vertLoc < 128 && medLicenceNumber.equals(indivConsultArray[7].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[7];
                    }   
                    else if(vertLoc < 144 && medLicenceNumber.equals(indivConsultArray[8].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[8];
                    }
                    else if(vertLoc < 160 && medLicenceNumber.equals(indivConsultArray[9].getDoctorInfo().getMedLicenceNum()) == true)
                    {
                        selection = indivConsultArray[9];
                    }  
                    
                    viewDateText.setText(selection.getFullDate());
                    viewTimeConsult.setText((selection.getTime()).toString());
                    viewCostField.setText(Float.toString(selection.getCost()));
                    viewNotesText.setText(selection.getNotes());
                    
                    viewPatFirstNameText.setText(selection.getPatientInfo().getFirstName());
                    viewPatSurnameText.setText(selection.getPatientInfo().getSurname());
                    viewPatDobText.setText(selection.getPatientInfo().getDob());
                    viewPatMobText.setText(selection.getPatientInfo().getMobileNumber());
                    viewPatIdText.setText(selection.getPatientInfo().getPatientId());
                }
                else
                {
                    viewDateText.setText("");
                    viewTimeConsult.setText("");
                    viewCostField.setText("");
                    viewNotesText.setText("");
                    
                    viewPatFirstNameText.setText("");
                    viewPatSurnameText.setText("");
                    viewPatDobText.setText("");
                    viewPatMobText.setText("");
                    viewPatIdText.setText("");                    
                }
            }
            catch(IndexOutOfBoundsException error)
            {
                viewDateText.setText("");
                viewTimeConsult.setText("");
                viewCostField.setText("");
                viewNotesText.setText("");
                
                viewPatFirstNameText.setText("");
                viewPatSurnameText.setText("");
                viewPatDobText.setText("");
                viewPatMobText.setText("");
                viewPatIdText.setText("");
            }
            catch(NullPointerException error)
            {
                viewDateText.setText("");
                viewTimeConsult.setText("");
                viewCostField.setText("");
                viewNotesText.setText("");
                
                viewPatFirstNameText.setText("");
                viewPatSurnameText.setText("");
                viewPatDobText.setText("");
                viewPatMobText.setText("");
                viewPatIdText.setText("");               
            }
        }
    }

    private class CheckListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent event)
        {
            //event for updating the cost field

            float priceChange = 25;

            // £15 if clicked, else £25
            if(costCheck.isSelected() == true)
            {
                costField.setText("£15.00");
                priceChange = 15;
            }
            else
            {
                costField.setText("£25.00");
            }

            float selectedLength = Float.parseFloat(lengthConsult.getSelectedItem().toString());
            costField.setText("£" + (Float.toString(selectedLength * priceChange)) + "0");
        }
    }
}
