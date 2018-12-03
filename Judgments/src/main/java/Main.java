import Orzeczenia.Judgment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        JsonFileToString jsonFileToString = new JsonFileToString();
        File directory = new File("json");
        List<String> jsons = jsonFileToString.getStringsFromJsonFiles(directory);
        for(String string : jsons){
            System.out.println(string);
        }

        StringToJsonObject parser = new StringToJsonObject();
        List<Judgment> judgments = new ArrayList<>();
        judgments = parser.createJudgmentList(jsons);
    }
}