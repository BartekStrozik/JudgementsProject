package Judgments.Main;

import Judgments.Data.CommonData;
import Judgments.Objects.Judgment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoadDirectory {
    public String getDirectoryName(){
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        return fileName;
    }

    public List<Judgment> load() throws IOException {
        File directory = new File(getDirectoryName());
        List<String> stringList= strings(directory);
        List<Judgment> objects = objects(stringList);
        CommonData.judgmentList = objects;
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
