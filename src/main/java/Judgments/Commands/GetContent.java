package Judgments.Commands;

import Judgments.Objects.CourtCase;
import Judgments.Data.CommonData;
import Judgments.Objects.Judgment;

import java.util.ArrayList;
import java.util.List;

public class GetContent extends AbstractCommand {
    private String reasonsToString(Judgment judgment){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Uzasadnienie orzeczenia " + judgment.id + ":\n");
        stringBuilder.append(judgment.textContent + '\n');
        String result = stringBuilder.toString();
        return result;
    }

    public String searchForJudgment(String signature){
        String foundedJudgment = null;
        for (Judgment judgment : CommonData.judgmentList) {
            for(CourtCase courtCase : judgment.courtCases){
                if(courtCase.caseNumber.equals(signature)){
                    foundedJudgment = reasonsToString(judgment);
                }
            }
        }
        if(foundedJudgment!=null)return foundedJudgment;
        else throw new NullPointerException("No such case Number in a judgment database");
    }

    public Result solveResult(String[] args){
        List<String> solution = new ArrayList<>();
        if(args.length==0){
            throw new IllegalStateException("This command demands at least one argument");
        }
        else{
            for(int i=0; i<args.length; i++) {
                solution.add(searchForJudgment(args[i]));
            }
        }
        Result result = new Result(solution);
        return result;
    }
}
