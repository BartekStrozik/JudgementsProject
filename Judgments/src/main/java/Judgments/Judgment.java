package Judgments;

import java.util.List;

public class Judgment {
    public Integer id;
    public CourtType courtType;
    public List<CourtCase> courtCases;
    public JudgmentType judgmentType;
    public List<Judge> judges;
    public Source source;
    public List<String> courtReporters;
    public String decision;
    public String summary;
    public String textContent;
    public List<String> legalBases;
    public List<ReferencedRegulation> referencedRegulations;
    public List<String> keywords;
    public List<ReferencedCourtCase> referencedCourtCases;
    public String receiptDate;
    public String meansOfAppeal;
    public String judgmentResult;
    public List<String> lowetCourtJudgments;
    public List<DissentingOpinion> dissentingOpinions;
    public String judgmentDate;

    public String toString(){
        //nie wypisywać, zapisać do jednego obiektu
        StringBuilder stringBuilder = new StringBuilder();

        for(Integer i=0; i<this.courtCases.size(); i++) {
            Integer j = i+1;
            String number = j.toString();
            stringBuilder.append("Sygnatura orzeczenia numer "+j+": "+this.courtCases.get(i).caseNumber+'\n');
        }

        stringBuilder.append("Data wydania orzeczenia: " + this.judgmentDate+'\n');
        stringBuilder.append("Rodzaj sądu: " + this.courtType+'\n');
        stringBuilder.append("Sędziowie:"+'\n');
        for(Judge j : judges){
            stringBuilder.append("    Imię: " + j.name+'\n');
            stringBuilder.append("    Funkcja: " + j.function+'\n');
            stringBuilder.append("    Role:"+'\n');
            for(SpecialRole role : j.specialRoles){
                stringBuilder.append("        " + role+'\n');
            }
        }
        String result = stringBuilder.toString();
        return result;
    }
}
