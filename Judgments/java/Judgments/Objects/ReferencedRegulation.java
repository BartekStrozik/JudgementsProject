package Judgments.Objects;

public class ReferencedRegulation {
    public String journalTitle;
    public Integer journalNo;
    public Integer journalYear;
    public Integer jounralEntry;
    public String text;
    public int amount;

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof ReferencedRegulation))
            return false;
        ReferencedRegulation that = (ReferencedRegulation) other;
        if(this.journalTitle.equals(that.journalTitle))
            return true;
        return false;
    }
}
