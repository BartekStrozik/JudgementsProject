package Judgments.Application.Load.HTML;

import Judgments.Objects.CourtCase;
import Judgments.Objects.CourtType;
import Judgments.Objects.Judge;
import Judgments.Objects.Judgment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HTMLDocuments {
    public String getFileName(){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        return string;
    }

    public void pullJsoupDocuments(final File directory, List<Document> documents) throws IOException {
        for(File file : directory.listFiles()){
            String fileName = file.getName();
            if (fileName.endsWith(".html")) {
                Document document = Jsoup.parse(file, "UTF-8");
                document.select("br").append("\\");
                documents.add(document);
            }
            if (file.isDirectory()) {
                pullJsoupDocuments(file,documents);
            }
        }
    }

    public List<Judgment> parseToObjects(List<Document> documents){
        List<Judgment> judgments = new ArrayList<>();
        for(Document doc : documents) {
            Judgment newJudgment = new Judgment();
            setSignature(newJudgment, doc);


            judgments.add(newJudgment);
        }
        return judgments;
    }

    public Judgment parseToOneObject(Document document){
        Judgment newJudgment = new Judgment();
        setSignature(newJudgment, document);

        return newJudgment;
    }

    private void setSignature(Judgment judgment, Document document){
        Elements title = document.select("title");
        Element el = title.first();
        String signature = el.text();
        signature = signature.substring(0,signature.indexOf('-')-1);

        judgment.courtCases = new ArrayList<>();
        judgment.courtCases.add(new CourtCase());
        judgment.courtCases.get(0).caseNumber = signature;
    }
}
