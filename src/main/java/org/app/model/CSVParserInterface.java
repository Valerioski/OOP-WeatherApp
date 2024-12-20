package org.app.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.opencsv.exceptions.CsvException;

public interface CSVParserInterface {

    List<Map<String, String>> readCSVToMap() throws IOException, CsvException;

}
