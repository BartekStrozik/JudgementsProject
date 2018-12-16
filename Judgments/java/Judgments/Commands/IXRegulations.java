package Judgments.Commands;

import Judgments.Data.CommonData;
import Judgments.Objects.Judge;
import Judgments.Objects.Judgment;
import Judgments.Objects.ReferencedRegulation;

import javax.print.attribute.HashAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IXRegulations extends Request{
    public HashMap<String, List<Judgment>> regulationsMap = new HashMap<>();

    public void initializeMap(){
        for(Judgment judgment : CommonData.judgmentList){
            for(int i=0; i<judgment.referencedRegulations.size(); i++){
                regulationsMap.put(judgment.referencedRegulations.get(i).journalTitle,new ArrayList<>());
            }
        }

        for(Judgment judgment : CommonData.judgmentList){
            for(int i=0; i<judgment.referencedRegulations.size(); i++){
                regulationsMap.get(judgment.referencedRegulations.get(i).journalTitle).add(judgment);
            }
        }
    }
    @Override
    public void launchRequest(String[] args) {
        initializeMap();
        List<ReferencedRegulation> result = top10();
        int i=1;
        for(ReferencedRegulation regulation : result){
            System.out.print("Przywoływany przepis nr ");
            System.out.print(i);
            System.out.println(":");
            System.out.println(regulation.journalTitle);
            System.out.print("Był przywoływany razy: ");
            System.out.println(regulation.amount);
            System.out.println("");
            i++;
        }
    }

    public List<ReferencedRegulation> top10(){
        int N = regulationsMap.size();
        ReferencedRegulation array[] = new ReferencedRegulation[N];
        int i=0;
        for(Map.Entry<String,List<Judgment>> entry : this.regulationsMap.entrySet()){
            array[i] = new ReferencedRegulation();
            array[i].journalTitle = entry.getKey();
            array[i].amount = entry.getValue().size();
            i++;
        }
        quickSort(array,0,N-1);

        List<ReferencedRegulation> topTen = new ArrayList<>();
        for(int j=0; j<10; j++){
            topTen.add(array[N-1 - j]);
        }

        return topTen;
    }

    public void quickSort(ReferencedRegulation array[], int l, int r){
        if(l<r){
            int q = partition(array,l,r);
            quickSort(array,l,q-1);
            quickSort(array,q+1,r);
        }
    }

    public int partition(ReferencedRegulation array[],int low, int high){
        int j=low-1;
        for(int i=low; i<high;i++){
            if(array[i].amount < array[high].amount){
                j++;
                swap(array,j,i);
            }
        }
        swap(array,j+1,high);
        return j+1;
    }

    public void swap(ReferencedRegulation array[], int x, int y){
        ReferencedRegulation tmp = array[x];
        array[x]=array[y];
        array[y]=tmp;
    }
}
