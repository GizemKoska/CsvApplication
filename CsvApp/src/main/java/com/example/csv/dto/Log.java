package com.example.csv.dto;

public class Log {

    private String ipAddress;
    private String visitedIpAddress;
    private String date;
    private String time;

    public Log(){}

    public void setIpAddress(String ipAddress){
        this.ipAddress = ipAddress;
    }

    public String getIpAddress(){
        return ipAddress;
    }

    public void setVisitedIpAddress(String visitedIpAddress){
        this.visitedIpAddress = visitedIpAddress;
    }

    public String getVisitedIpAddress(){
        return visitedIpAddress;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }

    public String toString(){
        return "{\"IP Address\":\""+ipAddress+"\",\"Visited IP Address\":\""+visitedIpAddress+"\",\"Date\":\""+date
                +"\",\"Time\":\""+time+"\"}";
    }
}
