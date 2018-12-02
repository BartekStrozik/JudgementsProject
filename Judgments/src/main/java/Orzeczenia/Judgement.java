package Orzeczenia;

import java.util.Date;
import java.util.List;

public class Judgement {
    public Integer id;
    public CourtType courtType;
    public List<CourtCase> courtCases;
    public JudgmentType judgmentType;
    public List<Judge> judges;
    public Source source;
    public String courtReporters;
    public String decision;
    public String summary;
    public String textContent;
    public List<String> legalBases;
    public List<ReferencedRegulation> referencedRegulations;
    public List<String> keywords;
    public List<ReferencedCourtCase> referencedCourtCases;
    public Date receiptDate;
    public String meansOfAppeal;
    public String judgmentResult;
    public List<String> lowetCourtJudgments;
    public List<String> dissentingOpinions;
    public Date judgmentDate;
}
