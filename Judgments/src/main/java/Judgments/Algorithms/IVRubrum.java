package Judgments.Algorithms;

import Judgments.Judgment;

import java.util.ArrayList;
import java.util.List;

public class IVRubrum {
    public List<String> ManyRubrumsToString(List<Judgment> judgmentList){
        List<String> result = new ArrayList<>();
        for(Judgment j : judgmentList){
            result.add(j.toString());
        }
        return result;
    }
}
