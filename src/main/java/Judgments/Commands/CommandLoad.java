package Judgments.Commands;

import Judgments.Load.CommonData;
import Judgments.Load.HTML.HTMLDocuments;
import Judgments.Load.JSON.LoadDirectory;
import Judgments.Objects.Judgment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandLoad extends AbstractCommand{

    @Override
    public Result solveResult(String[] args) {
        if(args.length==0){
            return new Result("This command demands one argument");
        }
        else if(args.length==1){
            if(args[0].equals("json")){
                LoadDirectory loadDirectory = new LoadDirectory();
                List<Judgment> list = new ArrayList<>();
                try {
                    list = loadDirectory.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                CommonData.judgmentList = list;
            }
            else if(args[0].equals("html")){
                HTMLDocuments docs = new HTMLDocuments();
                List<Judgment> list;
                list = docs.getJudgments();

                CommonData.judgmentList = list;
            }
        }
        return new Result("");
    }
}
