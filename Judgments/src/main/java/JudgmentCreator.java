import Orzeczenia.Judgment;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JudgmentCreator {
    public List<Judgment> createJudgment(String jsons){
        //    ArrayList<Judgment> judgments= new ArrayList<Judgment>();
        Gson gson = new Gson();
        Type jsonListType = new TypeToken<List<Judgment>>(){}.getType();
        return gson.fromJson(jsons, jsonListType);
    }

    public List<Judgment> createAllJudgmentList(List<String> stringJudgementList){
        List<Judgment> judgments = new ArrayList<Judgment>();
        for(String json : stringJudgementList){
            List<Judgment> listToAdd = createJudgment(json);
            for(Judgment j : listToAdd){
                judgments.add(j);
            }
        }
        return judgments;
    }
}