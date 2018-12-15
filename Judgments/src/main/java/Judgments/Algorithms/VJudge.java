package Judgments.Algorithms;

import Judgments.Judge;
import Judgments.Judgment;

import java.util.List;

public class VJudge {
    public int amountOfJudgmentsForOneJudge(List<Judgment> judgmentList, Judge item){
        int result=0;
        for(Judgment judgment : judgmentList){
            for(Judge judge : judgment.judges){
                if(judge.equals(item))result++;
            }
        }
        return result;
    }
}
