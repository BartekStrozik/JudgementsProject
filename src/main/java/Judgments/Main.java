package Judgments;

import Judgments.Application.Load.HTML.HTMLDocuments;
import Judgments.Application.Load.JSON.LoadDirectory;
import Judgments.Application.UserCommands.Requests;
import Judgments.Objects.Judgment;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        LoadDirectory loadDirectory = new LoadDirectory();
        List<Judgment> objects = loadDirectory.load();

        Requests requests = new Requests();
        requests.selectData();
    }
}