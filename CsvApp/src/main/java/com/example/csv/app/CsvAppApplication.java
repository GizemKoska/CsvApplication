package com.example.csv.app;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


@SpringBootApplication
@RestController
public class CsvAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvAppApplication.class, args);
	}


	@PostMapping("/")
	public String readCsv() throws FileNotFoundException,IOException{
		String path = "/home/agm/IdeaProjects/CsvApp/src/main/java/com/example/CsvApp/log.csv";
		String csvData = "IP Address,Visited IPAddress,Date,Time\n";

		try (
				Reader reader = Files.newBufferedReader(Paths.get(path));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
						.withFirstRecordAsHeader()
						.withIgnoreHeaderCase()
						.withTrim());
		) {
			for (CSVRecord csvRecord : csvParser) {
				// Accessing values by Header names
				String IP = csvRecord.get("IPAddress");
				String visitedIP = csvRecord.get("Visited IPAddress");
				String date = csvRecord.get("Date");
				String time = csvRecord.get("Time");

				csvData = csvData + IP + "," + visitedIP + "," + date + "," + time + "\n";

			}
		}
		return csvData.substring(0,csvData.length()-1);
	}

}
