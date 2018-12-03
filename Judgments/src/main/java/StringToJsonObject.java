import Orzeczenia.Judgment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StringToJsonObject {
    public List<Judgment> parse(String jsons){
        Gson gson = new Gson();
        Type jsonListType = new TypeToken<List<Judgment>>(){}.getType();
        return gson.fromJson(jsons, jsonListType);
    }

    public List<Judgment> createJudgmentList(List<String> stringFiles){
        List<Judgment> result = new ArrayList<>();
        for(String jsonFile : stringFiles){
            List<Judgment> judgmentObjects = parse(jsonFile);
            for(Judgment judgment : judgmentObjects){
                result.add(judgment);
            }
        }
        return result;
    }
}
