package Judgments.Main.UserCommands;

import Judgments.Main.Load.LoadDirectory;
import Judgments.Objects.Judgment;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Initializig...");

        LoadDirectory loadDirectory = new LoadDirectory();
        List<Judgment> objects = loadDirectory.load();

        Requests requests = new Requests();
        requests.selectData();
    }
}