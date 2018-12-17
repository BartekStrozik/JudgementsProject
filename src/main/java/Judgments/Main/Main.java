package Judgments.Main;

import Judgments.Commands.VIJudges;
import Judgments.Data.CommonData;
import Judgments.Objects.CourtCase;
import Judgments.Objects.Judgment;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Initializig...");


        LoadDirectory loadDirectory = new LoadDirectory();
        List<Judgment> objects = loadDirectory.load();

        Requests requests = new Requests();
        requests.selectData();

        System.out.println("Closing...");
    }
}