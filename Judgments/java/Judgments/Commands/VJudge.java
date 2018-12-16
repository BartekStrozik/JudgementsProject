package Judgments.Commands;

import Judgments.Data.CommonData;
import Judgments.Objects.Judge;
import Judgments.Objects.Judgment;

import java.util.List;

public class VJudge extends Request{
    public int amountOfJudgmentsForOneJudge(List<Judgment> judgmentList, String item){
        int result=0;
        for(Judgment judgment : judgmentList){
            for(Judge judge : judgment.judges){
                if(judge.name.equals(item))result++;
            }
        }
        return result;
    }

    public void getAnswer(String judge){
        System.out.println(amountOfJudgmentsForOneJudge(CommonData.judgmentList,judge));
    }

    @Override
    public void launchRequest(String[] args) {
        for(int i=0; i<args.length; i++) {
            getAnswer(args[i]);
        }
    }
}
