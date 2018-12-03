package Orzeczenia;

import java.util.Date;
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

    public void printRubrum(){
        System.out.println("Sygnatura orzeczenia: " + this.id);
        System.out.println("Data wydania orzeczenia: " + this.judgmentDate);
        System.out.println("Rodzaj sądu: " + this.courtType);
        System.out.println("Sędziowie:");
        for(Judge j : judges){
            System.out.println("    Imię: " + j.name);
            System.out.println("    Funkcja: " + j.function);
            System.out.println("    Role:");
            for(SpecialRole role : j.specialRoles){
                System.out.println("        " + role);
            }
        }
    }
}
