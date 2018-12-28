package Judgments.Commands;

import Judgments.Load.CommonData;
import Judgments.Objects.Judgment;

import java.util.HashMap;

public class GetAmountOfJudgmentsForMonths extends AbstractCommand {
    private HashMap<String, Integer> months = new HashMap<>();

    private void initializeMap(){
        months.put("01",0);
        months.put("02",0);
        months.put("03",0);
        months.put("04",0);
        months.put("05",0);
        months.put("06",0);
        months.put("07",0);
        months.put("08",0);
        months.put("09",0);
        months.put("10",0);
        months.put("11",0);
        months.put("12",0);
    }

    private void solveAllMonths(){
        for(Judgment judgment : CommonData.judgmentList){
            Integer current = months.get(judgment.judgmentDate.substring(5,7));
            months.put(judgment.judgmentDate.substring(5,7),++current);
        }
    }

    private void solveSpecificMonth(String monthNumber){
        for(Judgment judgment : CommonData.judgmentList) {
            if(judgment.judgmentDate.substring(5,7).equals(monthNumber)){
                Integer current = months.get(monthNumber);
                months.put(monthNumber,++current);
            }
        }
    }

    @Override
    public Result solveResult(String[] args) {
        initializeMap();
        if(args.length==0){
            solveAllMonths();
        }
        else{
            String[] monthsNumbers = MonthParser.monthsParser(args);
            for(int i=0; i<args.length; i++) {
                solveSpecificMonth(monthsNumbers[i]);
            }
        }
        return new Result(months);
    }
}
