package Judgments.Application.UserCommands;

import Judgments.Commands.Result;
import Judgments.Objects.CourtType;
import Judgments.Objects.Judgment;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Requests {
    LineToCommand lineToCommand = new LineToCommand();

    public void selectData(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            if(line.equals("exit"))break;
            Result result = lineToCommand.answer(line);
            System.out.println(result);
        }
    }
}
