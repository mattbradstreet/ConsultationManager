package com.mycompany.w1326166_cwk;

public abstract class Person {
    
    protected String firstName;
    protected String surname;
    protected String dob;
    protected String mobileNumber;

    //Constructors
    public Person()
    {
        firstName = "empty";
        surname = "empty";
        dob = "empty";
        mobileNumber = "0";
    }

    public Person(String firstName, String surname, String dob, String mobileNumber)
    {
        this.firstName = firstName;
        this.surname = surname;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
    }    

    //methods
    public String getFirstName()
    {
        return firstName;
    }

    public String getSurname()
    {
        return surname;
    }   

    public String getDob()
    {
        return dob;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }    

    public String getName()
    {
        return firstName + " " + surname;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }    

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString()
    {
        return firstName + " " + surname + ", DOB: " + dob + ", MobileNo: " + mobileNumber;
    }
}
