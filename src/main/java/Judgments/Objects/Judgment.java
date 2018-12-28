package Judgments.Objects;

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
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<this.courtCases.size(); i++) {
            //Parsowanie zliczania kolejnych sygnatur na stringi numerów
            Integer j = i+1;
            String number = j.toString();
            stringBuilder.append("Sygnatura orzeczenia numer ")
                    .append(number)
                    .append(": ")
                    .append(this.courtCases.get(i).caseNumber)
                    .append('\n');
        }

        stringBuilder.append("Data wydania orzeczenia: ")
                .append(this.judgmentDate)
                .append("\n")
                .append("Rodzaj sądu: ")
                .append(this.courtType)
                .append("\n");

        stringBuilder.append("Sędziowie:"+'\n');
        for(Judge j : judges){
            stringBuilder.append("    Imię: ")
                    .append(j.name)
                    .append('\n')
                    .append("    Funkcja: ")
                    .append(j.function)
                    .append('\n')
                    .append("    Role:")
                    .append('\n');

            for(SpecialRole role : j.specialRoles){
                stringBuilder.append("        ")
                        .append(role)
                        .append('\n');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
