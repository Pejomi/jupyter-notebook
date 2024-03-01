package dk.pejomi.dbbackend.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Component
public class CSVReader {
    public CSVParser readCSV(String filePath) {
        try {
            Reader reader = new FileReader(filePath);

            return new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
