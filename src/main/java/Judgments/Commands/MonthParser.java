package Judgments.Commands;

public class MonthParser {
    public static String parse(String monthNumber){
        switch(monthNumber){
            case "01":
                return "styczeń";
            case "02":
                return "luty";
            case "03":
                return "marzec";
            case "04":
                return "kwiecień";
            case "05":
                return "maj";
            case "06":
                return "czerwiec";
            case "07":
                return "lipiec";
            case "08":
                return "sierpień";
            case "09":
                return "wrzesień";
            case "10":
                return "październik";
            case "11":
                return "listopad";
            case "12":
                return "grudzień";
            default:
                return "";
        }
    }
}
