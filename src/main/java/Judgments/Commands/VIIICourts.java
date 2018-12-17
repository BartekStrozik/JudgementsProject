package Judgments.Commands;

import Judgments.Objects.CourtType;
import Judgments.Data.CommonData;
import Judgments.Objects.Judgment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class VIIICourts extends Request{
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

    private void getAnswer(String courtType){
        initializeHashMap(CommonData.judgmentList);
        System.out.println("Liczba orzeczeń typu "+courtType+":");
        switch(courtType){
            case "COMMON":
                System.out.println(courtTypeMap.get(CourtType.COMMON).size());
                break;
            case "SUPREME":
                System.out.println(courtTypeMap.get(CourtType.SUPREME).size());
                break;
            case "ADMINISTRATIVE":
                System.out.println(courtTypeMap.get(CourtType.ADMINISTRATIVE).size());
                break;
            case "CONSTITUTIONAL_TRIBUNAL":
                System.out.println(courtTypeMap.get(CourtType.CONSTITUTIONAL_TRIBUNAL).size());
                break;
            case "NATIONAL_APPEAL_CHAMBER":
                System.out.println(courtTypeMap.get(CourtType.NATIONAL_APPEAL_CHAMBER).size());
                break;
            case "DEFAULT":
                System.out.println(courtTypeMap.get(CourtType.DEFAULT).size());
                break;
        }
    }

    @Override
    public void launchRequest(String[] args) {
        for(int i=0; i<args.length; i++) {
            getAnswer(args[i]);
        }
    }
}
