package Judgments.Load.JSON;

import Judgments.Objects.Judgment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoadDirectory {
    public List<Judgment> load() throws IOException {
        File directory = new File("json");
        List<String> stringList= strings(directory);
        List<Judgment> objects = objects(stringList);
        return objects;
    }

    public List<String> strings(File directory) throws IOException {
        JsonFileToString toString = new JsonFileToString();
        return toString.getStringsFromJsonFiles(directory);
    }

    public List<Judgment> objects(List<String> string){
        StringToJsonObject toObject = new StringToJsonObject();
        return toObject.createJudgmentList(string);
    }
}
