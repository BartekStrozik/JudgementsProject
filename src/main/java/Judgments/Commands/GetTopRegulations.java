package Judgments.Commands;

import Judgments.Load.CommonData;
import Judgments.Objects.Judgment;
import Judgments.Objects.ReferencedRegulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetTopRegulations extends AbstractCommand {
    private HashMap<String, Integer> regulationsMap = new HashMap<>();

    private void initializeMap(){
        for(Judgment judgment : CommonData.judgmentList){
            for(int i=0; i<judgment.referencedRegulations.size(); i++){
                regulationsMap.put(judgment.referencedRegulations.get(i).journalTitle,0);
            }
        }

        for(Judgment judgment : CommonData.judgmentList){
            for(int i=0; i<judgment.referencedRegulations.size(); i++){
                Integer current = regulationsMap.get(judgment.referencedRegulations.get(i).journalTitle);
                regulationsMap.put(judgment.referencedRegulations.get(i).journalTitle,++current);
            }
        }
    }

    private List<ReferencedRegulation> topN(int topN){
        int N = regulationsMap.size();
        ReferencedRegulation array[] = new ReferencedRegulation[N];
        int i=0;
        for(Map.Entry<String,Integer> entry : this.regulationsMap.entrySet()){
            array[i] = new ReferencedRegulation();
            array[i].journalTitle = entry.getKey();
            array[i].amount = entry.getValue();
            i++;
        }
        quickSort(array,0,N-1);

        List<ReferencedRegulation> top = new ArrayList<>();
        for(int j=0; j<(topN<N?topN:N); j++){
            top.add(array[N-1 - j]);
        }
        return top;
    }

    private void quickSort(ReferencedRegulation array[], int l, int r){
        if(l<r){
            int q = partition(array,l,r);
            quickSort(array,l,q-1);
            quickSort(array,q+1,r);
        }
    }

    private int partition(ReferencedRegulation array[],int low, int high){
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

    private void swap(ReferencedRegulation array[], int x, int y){
        ReferencedRegulation tmp = array[x];
        array[x]=array[y];
        array[y]=tmp;
    }

    @Override
    public Result solveResult(String[] args) {
        initializeMap();
        if(args.length==0){
            List<ReferencedRegulation> topList = topN(10);
            return new Result(topList);
        }
        else if(args.length==1){
            List<ReferencedRegulation> topList = topN(Integer.parseInt(args[0]));
            return new Result(topList);
        }
        else{
            throw new IllegalArgumentException("Only one argument demanded");
        }
    }
}
