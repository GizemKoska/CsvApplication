package com.example.csv.service;

import com.example.csv.dto.Log;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Service {

    private Log log;
    private ArrayList<Log> logs;


    public Service(){
        log = new Log();
        logs = new ArrayList<Log>();
    }

    public void readCsv() throws IOException, FileNotFoundException {
        String path = "/home/agm/IdeaProjects/CsvApp/src/main/java/com/example/csv/dto/log.csv";

        try(
                Reader reader = Files.newBufferedReader((Paths.get(path)));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());
                ){
            for(CSVRecord csvRecord : csvParser){
                String ipAddress = csvRecord.get("IPAddress");
                String visitedIpAddress = csvRecord.get("Visited IP Address");
                String date = csvRecord.get("Date");
                String time = csvRecord.get("Time");

                log.setIpAddress(ipAddress);
                log.setVisitedIpAddress(visitedIpAddress);
                log.setDate(date);
                log.setTime(time);
                log.setTime(time);

                logs.add(log);
            }
        }
    }

    public ArrayList<Log> getLogs(){
        return logs;
    }

    public String toString(){
        String result = "[\n\t";
        int counter = 1;
        for(Log l : logs){
            result = result + l.toString();
            if(counter < logs.size()){
                result = result + ",\n\t";
            }
            else{
                result = result + "\n]";
            }
            counter++;
        }
        return result;
    }
}
