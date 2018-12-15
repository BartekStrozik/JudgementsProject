package Judgments.Algorithms;

import Judgments.Data.CommonData;
import Judgments.Judge;
import Judgments.Judgment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XJury extends Request{
    public HashMap<Integer, List<Judgment>> amountMap = new HashMap<>();

    public void initializeMap(List<Judgment> judgments){
        int max=0;
        for(Judgment judgment : judgments){
            if(max < judgment.judges.size()) max = judgment.judges.size();
        }

        for(int i=0; i<=max; i++){
            amountMap.put(i,new ArrayList<>());
        }
        for(Judgment judgment : judgments){
            Integer amount = judgment.judges.size();
            amountMap.get(amount).add(judgment);
        }
    }

    public void getAnswer(String amount){
        System.out.println("Liczba orzeczeń, dla " +
                        "których skład sędziowski liczył " +
                        amount + " sędziów");
        int x = 0;
        switch(amount){
            case "0": x=0;
                break;
            case "1": x=1;
                break;
            case "2": x=2;
                break;
            case "3": x=3;
                break;
            case "4": x=4;
                break;
            case "5": x=5;
                break;
            case "6": x=6;
                break;
            case "7": x=7;
                break;
            case "8": x=8;
                break;
            case "9": x=9;
                break;
            case "10": x=10;
                break;
            case "11": x=11;
                break;
            case "12": x=12;
                break;
            case "13": x=13;
                break;
            case "14": x=14;
                break;
            case "15": x=15;
                break;
            default: x=6;
                break;
        }
        System.out.println(amountMap.get(x).size());
    }

    @Override
    public void launchRequest(String[] args) {
        initializeMap(CommonData.judgmentList);
        for(int i=0; i<args.length; i++) {
            getAnswer(args[i]);
        }
    }
}
