package Judgments.Algorithms;

import Judgments.Data.CommonData;
import Judgments.Judgment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class VIIMonths extends Request{
    public HashMap<String, List<Judgment>> months = new HashMap<>();

    public void initializeMap(List<Judgment> judgments){
        months.put("styczeń",new LinkedList<>());
        months.put("luty",new LinkedList<>());
        months.put("marzec",new LinkedList<>());
        months.put("kwiecień",new LinkedList<>());
        months.put("maj",new LinkedList<>());
        months.put("czerwiec",new LinkedList<>());
        months.put("lipiec",new LinkedList<>());
        months.put("sierpień",new LinkedList<>());
        months.put("wrzesień",new LinkedList<>());
        months.put("październik",new LinkedList<>());
        months.put("listopad",new LinkedList<>());
        months.put("grudzień",new LinkedList<>());

        for(Judgment j : judgments){
            switch(j.judgmentDate.substring(5,7)){
                case "01":
                    months.get("styczeń").add(j);
                    break;
                case "02":
                    months.get("luty").add(j);
                    break;
                case "03":
                    months.get("marzec").add(j);
                    break;
                case "04":
                    months.get("kwiecień").add(j);
                    break;
                case "05":
                    months.get("maj").add(j);
                    break;
                case "06":
                    months.get("czerwiec").add(j);
                    break;
                case "07":
                    months.get("lipiec").add(j);
                    break;
                case "08":
                    months.get("sierpień").add(j);
                    break;
                case "09":
                    months.get("wrzesień").add(j);
                    break;
                case "10":
                    months.get("październik").add(j);
                    break;
                case "11":
                    months.get("listopad").add(j);
                    break;
                case "12":
                    months.get("grudzień").add(j);
                    break;
                default: break;
            }
        }
    }

    public void getAnswer(String month){
        initializeMap(CommonData.judgmentList);
        System.out.println("Liczba orzeczeń wydanych w miesiącu "+month+":");
        System.out.println(months.get(month).size());
    }

    @Override
    public void launchRequest(String[] args) {
        for(int i=0; i<args.length; i++) {
            getAnswer(args[i]);
        }
    }
}
