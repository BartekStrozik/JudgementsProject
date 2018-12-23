package Judgments.Application.UserCommands;

import Judgments.Commands.*;

public class LineToCommand {
    public FunctionSolver functionSolver = new FunctionSolver();

    public Result answer(String line){
        String[] splittedLine = parse(line);

        String command = getCommand(splittedLine);
        String[] arguments = getArguments(splittedLine);

        return functionSolver.solve(command,arguments);
    }

    public String[] parse(String line){
        String regex = "\\s+(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        String[] commandParts = line.split(regex);
        for(int i=0; i<commandParts.length; i++){
            commandParts[i] = commandParts[i].replace("\"","");
        }
        return commandParts;
    }

    public String getCommand(String[] splittedLine){
        return splittedLine[0];
    }

    public String[] getArguments(String[] splittedLine){
        String[] arguments = new String[splittedLine.length-1];
        for(int i=0; i<arguments.length; i++){
            arguments[i]=splittedLine[i+1];
        }
        return arguments;
    }
}
