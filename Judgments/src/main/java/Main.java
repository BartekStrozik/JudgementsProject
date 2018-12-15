import Judgments.Algorithms.*;
import Judgments.CourtType;
import Judgments.Judge;
import Judgments.Judgment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonFileToString jsonFileToString = new JsonFileToString();
        File directory = new File("json");
        List<String> jsons = jsonFileToString.getStringsFromJsonFiles(directory);

        StringToJsonObject parser = new StringToJsonObject();
        List<Judgment> judgments = parser.createJudgmentList(jsons);

        /////////////////////////////////////////////////////////////

        XJury jury = new XJury();
        jury.initializeMap(judgments);

        for(Map.Entry<Integer,List<Judgment>> entry : jury.amountMap.entrySet()){
            System.out.print("Liczba sędziów: ");
            System.out.println(entry.getKey());
            System.out.print("Rozkład orzeczeń: ");
            System.out.println(entry.getValue().size());
            System.out.println("");
        }
    }
}