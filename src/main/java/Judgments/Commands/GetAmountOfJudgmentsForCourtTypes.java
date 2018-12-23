package Judgments.Commands;

import Judgments.Objects.CourtType;
import Judgments.Data.CommonData;
import Judgments.Objects.Judgment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GetAmountOfJudgmentsForCourtTypes extends AbstractCommand{
    private HashMap<CourtType, Integer> courtTypeMap = new HashMap<>();

    private void initializeMap(){
        courtTypeMap.put(CourtType.COMMON,0);
        courtTypeMap.put(CourtType.SUPREME,0);
        courtTypeMap.put(CourtType.ADMINISTRATIVE,0);
        courtTypeMap.put(CourtType.CONSTITUTIONAL_TRIBUNAL,0);
        courtTypeMap.put(CourtType.NATIONAL_APPEAL_CHAMBER,0);
        courtTypeMap.put(CourtType.DEFAULT,0);
    }

    private void solveAllTypes(){
        for(Judgment judgment : CommonData.judgmentList){
            Integer current;
            switch(judgment.courtType){
                case COMMON:
                    current = courtTypeMap.get(CourtType.COMMON);
                    courtTypeMap.put(CourtType.COMMON,++current);
                    break;
                case SUPREME:
                    current = courtTypeMap.get(CourtType.SUPREME);
                    courtTypeMap.put(CourtType.SUPREME,++current);
                    break;
                case ADMINISTRATIVE:
                    current = courtTypeMap.get(CourtType.ADMINISTRATIVE);
                    courtTypeMap.put(CourtType.ADMINISTRATIVE,++current);
                    break;
                case CONSTITUTIONAL_TRIBUNAL:
                    current = courtTypeMap.get(CourtType.CONSTITUTIONAL_TRIBUNAL);
                    courtTypeMap.put(CourtType.CONSTITUTIONAL_TRIBUNAL,++current);
                    break;
                case NATIONAL_APPEAL_CHAMBER:
                    current = courtTypeMap.get(CourtType.NATIONAL_APPEAL_CHAMBER);
                    courtTypeMap.put(CourtType.NATIONAL_APPEAL_CHAMBER,++current);
                    break;
                case DEFAULT:
                    current = courtTypeMap.get(CourtType.DEFAULT);
                    courtTypeMap.put(CourtType.DEFAULT,++current);
                    break;
            }
        }
    }

    private void solveSpecificType(CourtType courtType){
        for(Judgment judgment : CommonData.judgmentList){
            if(judgment.courtType.equals(courtType)){
                Integer current = courtTypeMap.get(courtType);
                courtTypeMap.put(courtType,++current);
            }
        }
    }

    public Result solveResult(String[] args) {
        initializeMap();
        if(args.length==0){
            solveAllTypes();
        }
        else{
            CourtType[] courtTypes = CourtType.stringParser(args);
            for(int i=0; i<courtTypes.length; i++) {
                solveSpecificType(courtTypes[i]);
            }
        }
        Result result = new Result(courtTypeMap);
        return result;
    }
}
