import Judgments.Algorithms.*;
import Judgments.CourtType;
import Judgments.Data.CommonData;
import Judgments.Judge;
import Judgments.Judgment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        LoadDirectory loadDirectory = new LoadDirectory();
        List<Judgment> objects = loadDirectory.load();

        Requests requests = new Requests();
        requests.selectData();
    }
}