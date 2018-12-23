package Judgments.Objects;

public enum CourtType {
    COMMON,
    SUPREME,
    ADMINISTRATIVE,
    CONSTITUTIONAL_TRIBUNAL,
    NATIONAL_APPEAL_CHAMBER,
    DEFAULT;

    public static CourtType[] stringParser(String[] array){
        CourtType[] equivalentArray = new CourtType[array.length];
        for(int i=0; i<array.length; i++){
            switch(array[i]){
                case "COMMON":
                    equivalentArray[i]=CourtType.COMMON;
                    break;
                case "SUPREME":
                    equivalentArray[i]=CourtType.SUPREME;
                    break;
                case "ADMINISTRATIVE":
                    equivalentArray[i]=CourtType.ADMINISTRATIVE;
                    break;
                case "CONSTITUTIONAL_TRIBUNAL":
                    equivalentArray[i]=CourtType.CONSTITUTIONAL_TRIBUNAL;
                    break;
                case "NATIONAL_APPEAL_CHAMBER":
                    equivalentArray[i]=CourtType.NATIONAL_APPEAL_CHAMBER;
                    break;
                case "DEFAULT":
                    equivalentArray[i]=CourtType.DEFAULT;
                    break;
                    default: throw new IllegalArgumentException(
                            "No such a courtType like " + array[i] + ".");

            }
        }
        return equivalentArray;
    }
}
