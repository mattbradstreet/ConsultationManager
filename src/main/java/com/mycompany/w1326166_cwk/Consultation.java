package com.mycompany.w1326166_cwk;

import java.time.*;

public class Consultation {
    
    protected Doctor doctor;
    protected Patient patient;
    protected int day;
    protected int month;
    protected int year;
    protected LocalTime time;
    protected float cost;
    protected String notes;

    //Constructor
    public Consultation(Doctor doctor, Patient patient, int day, int month, int year, LocalTime time, float cost, String notes)
    {
        this.doctor = doctor;
        this.patient = patient;
        this.day = day;
        this.month = month;
        this.year = year;
        this.time = time;
        this.cost = cost;
        this.notes = notes;
    }    

    //Methods
    public Doctor getDoctorInfo()
    {
        return doctor;
    }

    public Patient getPatientInfo()
    {
        return patient;
    }    

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public float getCost()
    {
        return cost;
    }

    public String getNotes()
    {
        return notes;
    }

    public String getFullDate()
    {
        return day + "/" + month + "/" + year;
    }

    public void setDoctorInfo(Doctor doctor)
    {
        this.doctor = doctor;
    }

    public void setPatientInfo(Patient patient)
    {
        this.patient = patient;
    }

    public void setDay(int day)
    {
        if(day > 0 && day < 32)
        {
            this.day = day;
        }
    }

    public void setMonth(int month)
    {
        if(month > 0 && month < 13)
        {
            this.month = month;
        }
    }

    public void setYear(int year)
    {
        if(year > 2021 && year < 2050)
        {
            this.year = year;
        }
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    public void setCost(float cost)
    {
        this.cost = cost;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public void setFullDate(int day, int month, int year, LocalTime time)
    {   
        if(day > 0 && day < 31)
        {
            this.day = day;
        }

        if(month > 0 && month < 13)
        {
            this.month = month;
        }

        if(year > 2021 && year < 2050)
        {
            this.year = year;
        }
        
        this.time = time;
    }

    @Override
    public String toString()
    {
        return "Dr: " + doctor + ", Patient: " + patient + ", Date: " + day + "/" + month + "/" + year + " - " + time + " Cost: " + cost + " Any Notes: " + notes;
    }
}
