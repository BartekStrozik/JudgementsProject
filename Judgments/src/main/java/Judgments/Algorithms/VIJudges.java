package Judgments.Algorithms;

import Judgments.Judge;
import Judgments.Judgment;

import java.util.*;

public class VIJudges {
    public int amountOfJudgmentsForOneJudge(List<Judgment> judgmentList, Judge item){
        int result=0;
        for(Judgment judgment : judgmentList){
            for(Judge judge : judgment.judges){
                if(judge.equals(item))result++;
            }
        }
        return result;
    }

    public HashMap<Judge,List<Judgment>> judgeListHashMap = new LinkedHashMap<>();

    public void initializeMap(List<Judgment> judgments){
        for(Judgment judgment : judgments){
            for(Judge judge : judgment.judges){
                judgeListHashMap.put(judge,new ArrayList<>());
                //judgeListHashMap.get(judge).add(judgment);
            }
        }
    }
}
