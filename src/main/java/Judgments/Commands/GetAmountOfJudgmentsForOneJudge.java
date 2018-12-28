package Judgments.Commands;

import Judgments.Load.CommonData;
import Judgments.Objects.Judge;
import Judgments.Objects.Judgment;

import java.util.HashMap;

public class GetAmountOfJudgmentsForOneJudge extends AbstractCommand {
    private HashMap<Judge, Integer> judgesMap = new HashMap<>();

    private void initializeMap(){
        for(Judgment judgment : CommonData.judgmentList){
            for(Judge judge : judgment.judges){
                judgesMap.put(judge, 0);
            }
        }
    }

    private void solveAllJudges(){
        for(Judgment judgment : CommonData.judgmentList){
            for(Judge judge : judgment.judges){
                Integer current = judgesMap.get(judge);
                judgesMap.put(judge,++current);
            }
        }
    }

    private void solveSpecificJudge(String judgeName){
        for(Judgment judgment : CommonData.judgmentList){
            for(Judge judge : judgment.judges){
                if(judge.name.equals(judgeName)){
                    Integer current = judgesMap.get(judge);
                    judgesMap.put(judge,++current);
                }
            }
        }
    }

    @Override
    public Result solveResult(String[] args) {
        initializeMap();
        if(args.length==0){
            solveAllJudges();
        }
        else{
            for(int i=0; i<args.length; i++){
                solveSpecificJudge(args[i]);
            }
        }
        return new Result(judgesMap);
    }
}