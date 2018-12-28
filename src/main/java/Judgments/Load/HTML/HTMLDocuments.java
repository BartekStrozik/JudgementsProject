package Judgments.Load.HTML;

import Judgments.Objects.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class HTMLDocuments {
    public List<Judgment> getJudgments(){
        File file = new File("C:\\Users\\barte\\Desktop\\Semestr 3\\Obiektowe\\Judgments\\cbosa");
        List<Document> list = new ArrayList<>();
        try {
            pullJsoupDocuments(file, list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Judgment> judgments = new ArrayList<>();
        for(Document d : list){
            judgments.add(parseToObject(d));
        }

        return judgments;
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

    public Judgment parseToObject(Document document){
        Judgment newJudgment = new Judgment();
        setSignature(newJudgment, document);
        setTextContent(newJudgment, document);

        HashMap<String,String> map = getFields(document);
        newJudgment.judges = new ArrayList<>();
        setJudges(newJudgment, map);
        setDate(newJudgment, map);
        setCourtType(newJudgment, map);
        newJudgment.referencedRegulations = new ArrayList<>();
        setRegulations(newJudgment, map);

        //setParameters(newJudgment, getFields(document));

        //newJudgment.textContent = setTextContent(newJudgment, document);
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

    private void setTextContent(Judgment judgment, Document document){
        StringBuilder builder = new StringBuilder();
        Element table = document.select("table").get(3);
        Elements elements = table.getElementsByClass("info-list-label-uzasadnienie");
        for(Element element : elements) {
            builder.append(element.text());
        }
        judgment.textContent = builder.toString();
    }

    private HashMap<String,String> getFields(Document document) {
        HashMap<String, String> judgmentFields = new HashMap<>();
        Element table = document.select("table").get(3);
        Elements fields = table.select("tr");
        for (Element field : fields) {
            Elements keys = field.getElementsByClass("info-list-label");
            String key = null;
            for (Element key1 : keys) {
                Elements currentKey = key1.getElementsByClass("lista-label");
                key = currentKey.text();
            }
            Elements values = field.getElementsByClass("info-list-value");
            Element currentValue = values.first();
            String value = null;
            if (currentValue != null) value = currentValue.text().trim().replaceAll("orzeczenie.*", "");
            if (value != null && key != null) judgmentFields.put(key, value);
        }
        return judgmentFields;
    }

    private void setJudges(Judgment judgment, Map<String, String> map){
        if(map.containsKey("Sędziowie")) judgment.judges = parseJudges(map.get("Sędziowie"));
    }

    private void setDate(Judgment judgment, Map<String, String> map){
        if(map.containsKey("Data orzeczenia")) judgment.judgmentDate = map.get("Data orzeczenia");
    }

    private void setRegulations(Judgment judgment, Map<String, String> map){
        if(map.containsKey("Powołane przepisy")) judgment.referencedRegulations = parseReferencedRegulations(map.get("Powołane przepisy"));
    }

    private void setCourtType(Judgment judgment, Map<String, String> map){
        if(map.containsKey("Sąd")) judgment.courtType = parseCourtType(map.get("Sąd"));
    }

    private List<Judge> parseJudges(String line){
        List<Judge> resultJudges = new ArrayList<>();
        String[] array = line.split("\\\\");
        for (String cursor : array) {
            String name;
            List<SpecialRole> specialRoles = new ArrayList<>();
            if(cursor.contains("/")){
                int firstSlash = cursor.indexOf("/");
                int lastSlash = cursor.lastIndexOf("/");

                String specialRolesString = cursor.substring(firstSlash + 1, lastSlash).toLowerCase();
                if(specialRolesString.contains("sprawozdawca")) specialRoles.add(SpecialRole.REPORTING_JUDGE);
                if(specialRolesString.contains("przewodniczący")) specialRoles.add(SpecialRole.PRESIDING_JUDGE);
                if(specialRolesString.contains("autor uzasadnienia")) specialRoles.add(SpecialRole.REASONS_FOR_JUDGMENT_AUTHOR);

                name = cursor.substring(0, firstSlash - 1);
                resultJudges.add(new Judge(name,"",specialRoles));
            }
        }
        return resultJudges;
    }

    private CourtType parseCourtType(String name){
        if(name.contains("Wojewódzki")){
            return CourtType.PROVINCIAL_ADMINISTRATIVE;
        }
        if(name.contains("Naczelny")){
            return CourtType.SUPREME_ADMINISTRATIVE;
        }
        return CourtType.DEFAULT;
    }

    private List<ReferencedRegulation> parseReferencedRegulations(String regulations){
        List<ReferencedRegulation> list = new ArrayList<>();
        ReferencedRegulation regulation = new ReferencedRegulation();
        regulation.journalTitle = regulations;
        list.add(regulation);
        return list;
    }
}
