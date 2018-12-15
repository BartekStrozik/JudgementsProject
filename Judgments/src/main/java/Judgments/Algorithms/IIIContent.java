package Judgments.Algorithms;

import Judgments.Judgment;
import Judgments.ReferencedRegulation;

public class IIIContent {
    public String reasonsToString(Judgment judgment){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Uzasadnienie orzeczenia " + judgment.id + ":\n");

        stringBuilder.append(judgment.textContent + '\n');
        /*for(ReferencedRegulation r : judgment.referencedRegulations){
            /*stringBuilder.append(r.journalNo);
            stringBuilder.append('\n');
            stringBuilder.append(r.jounralEntry);
            stringBuilder.append('\n');
            stringBuilder.append(r.journalTitle);
            stringBuilder.append('\n');
            stringBuilder.append(r.journalYear);
            stringBuilder.append('\n');*/
            /*stringBuilder.append(r.text);
            stringBuilder.append('\n');
        }*/
        String result = stringBuilder.toString();
        return result;
    }
}
