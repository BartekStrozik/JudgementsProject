package Judgments.Application.Load.JSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonFileToString {
    public List<String> getStringsFromJsonFiles(final File directory) throws IOException {
        List<String> jsonStrings = new ArrayList<>();

        for(File file : directory.listFiles()){
            String name = file.getName();
            if (name.endsWith(".json")) {
                Path p = file.toPath();
                BufferedReader reader = Files.newBufferedReader(p);
                jsonStrings.add(dropMetaData(reader.readLine()));
                reader.close();
            }
            if (file.isDirectory()) {
                getStringsFromJsonFiles(file);
            }
        }
        return jsonStrings;
    }

    private String dropMetaData(String json){
        int beg = json.indexOf("items") + 7;
        int end = json.indexOf("queryTemplate") - 2;
        return json.substring(beg,end);
    }
}
