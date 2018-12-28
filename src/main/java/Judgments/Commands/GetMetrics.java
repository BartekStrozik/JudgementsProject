package Judgments.Commands;

import Judgments.Objects.CourtCase;
import Judgments.Load.CommonData;
import Judgments.Objects.Judgment;

import java.util.ArrayList;
import java.util.List;

public class GetMetrics extends AbstractCommand {
    private String searchForJudgment(String signature){
        String foundedJudgment = null;
        for (Judgment judgment : CommonData.judgmentList) {
            for(CourtCase courtCase : judgment.courtCases){
                if(courtCase.caseNumber.equals(signature)){
                    foundedJudgment = judgment.toString();
                }
            }
        }
        if(foundedJudgment!=null)return foundedJudgment;
        else throw new NullPointerException("No such case number in a judgment database");
    }

    @Override
    public Result solveResult(String[] args) {
        List<String> solution = new ArrayList<>();
        if(args.length==0){
            throw new NullPointerException("This command demands at least one argument");
        }
        else{
            for(int i=0; i<args.length; i++) {
                solution.add(searchForJudgment(args[i]));
            }
        }
        return new Result(solution);
    }
}
