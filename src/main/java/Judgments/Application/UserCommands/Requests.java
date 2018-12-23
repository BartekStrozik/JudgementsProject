package Judgments.Main.UserCommands;

import Judgments.Commands.*;

import java.util.HashMap;
import java.util.Scanner;

public class Requests {
    LineToCommand lineToCommand = new LineToCommand();

    public void selectData(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            if(line.equals("exit"))break;
            lineToCommand.printAnswer(line);
        }
    }
}
