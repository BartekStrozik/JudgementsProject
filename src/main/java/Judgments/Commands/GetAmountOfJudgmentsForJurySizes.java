package Judgments.Commands;

import Judgments.Data.CommonData;
import Judgments.Objects.Judgment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetAmountOfJudgmentsForJurySizes extends AbstractCommand {
    private HashMap<Integer, Integer> amountMap = new HashMap<>();

    private void initializeMap(){
        for(Judgment judgment : CommonData.judgmentList){
            amountMap.put(judgment.judges.size(),0);
        }
    }

    private void solveAllNumbers(){
        for(Judgment judgment : CommonData.judgmentList){
            Integer current = amountMap.get(judgment.judges.size());
            amountMap.put(judgment.judges.size(),++current);
        }
    }

    private void solveSpecificNumber(Integer number){
        for(Judgment judgment : CommonData.judgmentList){
            if(judgment.judges.size() == number){
                Integer current = amountMap.get(number);
                amountMap.put(number,++current);
            }
        }
    }

    @Override
    public Result solveResult(String[] args) {
        initializeMap();
        if(args.length==0){
            solveAllNumbers();
        }
        else{
            for(int i=0; i<args.length; i++) {
                solveSpecificNumber(Integer.parseInt(args[i]));
            }
        }
        Result result = new Result(amountMap);
        return result;
    }
}
