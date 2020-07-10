package com.example.covid19india;

public class CovidCases
{
    private String active, death, recovered, date;

    public CovidCases(String active, String death, String recovered, String date)
    {
        this.active = active;
        this.death = death;
        this.recovered = recovered;
        this.date = date;
    }

    public String getActive() {
        return active;
    }

    public String getDeath() {
        return death;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getDate() {
        return date;
    }
}
