import Judgments.Algorithms.*;

import java.util.HashMap;
import java.util.Scanner;

public class Requests {
    HashMap<String, Judgments.Algorithms.Request> requestMap = new HashMap<>();

    public void initialiizeMap(){
        requestMap.put("content",new IIIContent());
        requestMap.put("rubrum",new IVRubrum());
        requestMap.put("judge",new VJudge());
        requestMap.put("judges",new VIJudges());
        requestMap.put("months",new VIIMonths());
        requestMap.put("courts",new VIIICourts());
        requestMap.put("jury",new XJury());
    }

    public void selectData(){
        initialiizeMap();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String request = scanner.nextLine();
            if(request.equals("exit"))break;
            printAnswer(request);
        }
    }

    public void printAnswer(String line){
        String[] splittedLine = commandParts(line);
        String command = splittedLine[0];
        String[] arguments = new String[splittedLine.length-1];
        for(int i=0; i<arguments.length; i++){
            arguments[i]=splittedLine[i+1];
        }
        Request request = requestMap.get(command);
        request.launchRequest(arguments);
    }

    public String[] commandParts(String line){
        String regex = "\\s+(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        String[] commandParts = line.split(regex);
        for(int i=0; i<commandParts.length; i++){
            commandParts[i] = commandParts[i].replace("\"","");
        }
        return commandParts;
    }
}
