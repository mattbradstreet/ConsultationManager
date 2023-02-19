package com.mycompany.w1326166_cwk;

public class Patient extends Person {
    
    protected String patientId;

    //Constructor
    public Patient()
    {
        firstName = "empty";
        surname = "empty";
        dob = "empty";
        mobileNumber = "0";
        patientId = "0";
    }

    public Patient(String firstName, String surname, String dob, String mobileNumber, String patientId)
    {
        this.firstName = firstName;
        this.surname = surname;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
        this.patientId = patientId;
    }

    //Methods
    public String getPatientId()
    {
        return patientId;
    }

    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }

    @Override
    public String toString()
    {
        return firstName + " " + surname + ", DOB: " + dob + ", MobileNo: " + mobileNumber + ", PatientID: " + patientId;
    }    
}
