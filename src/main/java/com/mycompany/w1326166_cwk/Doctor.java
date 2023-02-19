package com.mycompany.w1326166_cwk;

public class Doctor extends Person {
    
    protected String medLicenceNumber;
    protected String specialisation;

    //Constructor
    public Doctor()
    {
        firstName = "empty";
        surname = "empty";
        dob = "empty";
        mobileNumber = "0";
        medLicenceNumber = "0";
        specialisation = "empty";
    }

    public Doctor(String firstName, String surname, String dob, String mobileNumber, String medLicenceNumber, String specialisation)
    {
        this.firstName = firstName;
        this.surname = surname;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
        this.medLicenceNumber = medLicenceNumber;
        this.specialisation = specialisation;
    }

    //Methods
    public String getMedLicenceNum()
    {
        return medLicenceNumber;
    }

    public String getSpec()
    {
        return specialisation;
    }

    public void setMedLicenceNum(String medLicenceNumber)
    {
        this.medLicenceNumber = medLicenceNumber;
    }

    public void setSpec(String specialisation)
    {
        this.specialisation = specialisation;
    }

    @Override
    public String toString()
    {
        return firstName + ", " + surname + ", " + dob + ", " + mobileNumber + ", " + medLicenceNumber + ", " + specialisation;
    }
}
