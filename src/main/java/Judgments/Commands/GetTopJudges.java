package Judgments.Commands;

import Judgments.Data.CommonData;
import Judgments.Objects.Judge;
import Judgments.Objects.Judgment;

import java.util.*;

public class GetTopJudges extends AbstractCommand {
    private HashMap<Judge,Integer> judgeListHashMap = new LinkedHashMap<>();

    private void initializeMap(){
        for(Judgment judgment : CommonData.judgmentList){
            for(Judge judge : judgment.judges){
                judgeListHashMap.put(judge,0);
            }
        }

        for(Judgment judgment : CommonData.judgmentList){
            for(Judge judge : judgment.judges){
                Integer current = judgeListHashMap.get(judge);
                judgeListHashMap.put(judge,++current);
            }
        }
    }

    public List<Judge> topN(int topN){
        int N = judgeListHashMap.size();
        Judge array[] = new Judge[N];
        int i=0;
        for(Map.Entry<Judge,Integer> entry : this.judgeListHashMap.entrySet()){
            array[i] = new Judge();
            array[i].name = entry.getKey().name;
            array[i].amount = entry.getValue();
            i++;
        }
        quickSort(array,0,N-1);

        List<Judge> top = new ArrayList<>();
        for(int j=0; j < (topN<N ? topN : N); j++){
            top.add(array[N-1 - j]);
        }
        return top;
    }

    private void quickSort(Judge array[], int l, int r){
        if(l<r){
            int q = partition(array,l,r);
            quickSort(array,l,q-1);
            quickSort(array,q+1,r);
        }
    }

    private int partition(Judge array[],int low, int high){
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

    private void swap(Judge array[], int x, int y){
        Judge tmp = array[x];
        array[x]=array[y];
        array[y]=tmp;
    }

    @Override
    public Result solveResult(String[] args) {
        initializeMap();
        if(args.length==0){
            List<Judge> topList = topN(10);
            Result result = new Result(topList);
            return result;
        }
        else if(args.length==1){
            List<Judge> topList = topN(Integer.parseInt(args[0]));
            Result result = new Result(topList);
            return result;
        }
        else{
            throw new IllegalArgumentException("Only one argument demanded.");
        }
    }
}
