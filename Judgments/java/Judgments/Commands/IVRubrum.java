package Judgments.Commands;

import Judgments.Objects.CourtCase;
import Judgments.Data.CommonData;
import Judgments.Objects.Judgment;

public class IVRubrum extends Request{
    /*public List<String> ManyRubrumsToString(List<Judgment> judgmentList){
        List<String> result = new ArrayList<>();
        for(Judgment j : judgmentList){
            result.add(j.toString());
        }
        return result;
    }

    public List<String> getAnswer(String request, List<Judgment> set){
        List<Judgment> judgments = new ArrayList<>();
        for(Judgment judgment : set){
            for(int i=0; i<judgment.courtCases.size(); i++){
                if(request.equals(judgment.courtCases.get(i).caseNumber)){
                    judgments.add(judgment);
                }
            }
        }
        return ManyRubrumsToString(judgments);
    }*/

    public void getAnswer(String signature){
        for (Judgment judgment : CommonData.judgmentList) {
            for(CourtCase courtCase : judgment.courtCases){
                if(signature.equals(courtCase.caseNumber))
                    System.out.println(judgment);
            }
        }
    }

    @Override
    public void launchRequest(String[] args) {
        for(int i=0; i<args.length; i++) {
            getAnswer(args[i]);
        }
    }
}
