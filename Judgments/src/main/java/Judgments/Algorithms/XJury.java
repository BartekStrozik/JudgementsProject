package Judgments.Algorithms;

import Judgments.Judge;
import Judgments.Judgment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XJury {
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
}
