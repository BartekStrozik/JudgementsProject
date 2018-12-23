package Judgments.Commands;

import Judgments.Data.CommonData;
import Judgments.Objects.Judgment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GetAmountOfJudgmentsForMonths extends AbstractCommand {
    private HashMap<String, Integer> months = new HashMap<>();

    private void initializeMap(){
        months.put("styczeń",0);
        months.put("luty",0);
        months.put("marzec",0);
        months.put("kwiecień",0);
        months.put("maj",0);
        months.put("czerwiec",0);
        months.put("lipiec",0);
        months.put("sierpień",0);
        months.put("wrzesień",0);
        months.put("październik",0);
        months.put("listopad",0);
        months.put("grudzień",0);
    }

    private void solveAllMonths(){
        for(Judgment judgment : CommonData.judgmentList){
            Integer current;
            switch(judgment.judgmentDate.substring(5,7)){
                case "01":
                    current = months.get("styczeń");
                    months.put("styczeń",++current);
                    break;
                case "02":
                    current = months.get("luty");
                    months.put("luty",++current);
                    break;
                case "03":
                    current = months.get("marzec");
                    months.put("marzec",++current);
                    break;
                case "04":
                    current = months.get("kwiecień");
                    months.put("kwiecień",++current);
                    break;
                case "05":
                    current = months.get("maj");
                    months.put("maj",++current);
                    break;
                case "06":
                    current = months.get("czerwiec");
                    months.put("czerwiec",++current);
                    break;
                case "07":
                    current = months.get("lipiec");
                    months.put("lipiec",++current);
                    break;
                case "08":
                    current = months.get("sierpień");
                    months.put("sierpień",++current);
                    break;
                case "09":
                    current = months.get("wrzesień");
                    months.put("wrzesień",++current);
                    break;
                case "10":
                    current = months.get("październik");
                    months.put("październik",++current);
                    break;
                case "11":
                    current = months.get("listopad");
                    months.put("listopad",++current);
                    break;
                case "12":
                    current = months.get("grudzień");
                    months.put("grudzień",++current);
                    break;
                default:break;
            }
        }
    }

    private void solveSpecificMonth(String month){
        for(Judgment judgment : CommonData.judgmentList) {
            String monthWord = MonthParser.parse(judgment.judgmentDate.substring(5,7));
            if(monthWord.equals(month)){
                Integer current = months.get(month);
                months.put(month,++current);
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
            for(int i=0; i<args.length; i++) {
                solveSpecificMonth(args[i]);
            }
        }
        return new Result(months);
    }
}
