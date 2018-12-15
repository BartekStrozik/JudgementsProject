package Judgments.Algorithms;

import Judgments.CourtType;
import Judgments.Judgment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class VIIICourts {
    public HashMap<CourtType, List<Judgment>> courtTypeMap = new HashMap<>();

    public void initializeHashMap(List<Judgment> judgments){
        courtTypeMap.put(CourtType.COMMON,new ArrayList<>());
        courtTypeMap.put(CourtType.SUPREME,new ArrayList<>());
        courtTypeMap.put(CourtType.ADMINISTRATIVE,new ArrayList<>());
        courtTypeMap.put(CourtType.CONSTITUTIONAL_TRIBUNAL,new ArrayList<>());
        courtTypeMap.put(CourtType.NATIONAL_APPEAL_CHAMBER,new ArrayList<>());
        courtTypeMap.put(CourtType.DEFAULT,new ArrayList<>());

        for(Judgment judgment : judgments){
            switch(judgment.courtType){
                case COMMON:
                    courtTypeMap.get(CourtType.COMMON).add(judgment);
                    break;
                case SUPREME:
                    courtTypeMap.get(CourtType.SUPREME).add(judgment);
                    break;
                case ADMINISTRATIVE:
                    courtTypeMap.get(CourtType.ADMINISTRATIVE).add(judgment);
                    break;
                case CONSTITUTIONAL_TRIBUNAL:
                    courtTypeMap.get(CourtType.CONSTITUTIONAL_TRIBUNAL).add(judgment);
                    break;
                case NATIONAL_APPEAL_CHAMBER:
                    courtTypeMap.get(CourtType.NATIONAL_APPEAL_CHAMBER).add(judgment);
                    break;
                case DEFAULT:
                    courtTypeMap.get(CourtType.DEFAULT).add(judgment);
                    break;
            }
        }
    }
}
