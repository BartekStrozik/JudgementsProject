package Judgments.Commands;

import Judgments.Objects.CourtCase;
import Judgments.Data.CommonData;
import Judgments.Objects.Judgment;

public class IIIContent extends Request{
    private String reasonsToString(Judgment judgment){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Uzasadnienie orzeczenia " + judgment.id + ":\n");
        stringBuilder.append(judgment.textContent + '\n');
        String result = stringBuilder.toString();
        return result;
    }

    public void launchRequest(String[] args){
        for(int i=0; i<args.length; i++) {
            for (Judgment judgment : CommonData.judgmentList) {
                for(CourtCase courtCase : judgment.courtCases){
                    if(args[i].equals(courtCase.caseNumber))
                        System.out.println(reasonsToString(judgment));
                }
            }
        }
    }
}
