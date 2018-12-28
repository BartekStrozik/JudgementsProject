package Judgments.Commands;

public class MonthParser {
    private static String parse(String monthWord){
        switch(monthWord){
            case "styczeń":
                return "01";
            case "luty":
                return "02";
            case "marzec":
                return "03";
            case "kwiecień":
                return "04";
            case "maj":
                return "05";
            case "czerwiec":
                return "06";
            case "lipiec":
                return "07";
            case "sierpień":
                return "08";
            case "wrzesień":
                return "09";
            case "paźdzernik":
                return "10";
            case "listopad":
                return "11";
            case "grudzień":
                return "12";
            default:
                return "";
        }
    }

    public static String[] monthsParser(String[] monthsWords){
        String[] monthsNumbers = new String[monthsWords.length];
        for(int i=0; i<monthsWords.length; i++){
            monthsNumbers[i] = parse(monthsWords[i]);
        }
        return monthsNumbers;
    }
}
