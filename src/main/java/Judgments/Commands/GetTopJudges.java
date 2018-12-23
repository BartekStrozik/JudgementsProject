package Judgments.Commands;

import Judgments.Data.CommonData;
import Judgments.Objects.Judge;
import Judgments.Objects.Judgment;

import java.util.*;

public class VIJudges extends Request{
    public int amountOfJudgmentsForOneJudge(List<Judgment> judgmentList, Judge item){
        int result=0;
        for(Judgment judgment : judgmentList){
            for(Judge judge : judgment.judges){
                if(judge.equals(item))result++;
            }
        }
        return result;
    }

    public HashMap<String,List<Judgment>> judgeListHashMap = new LinkedHashMap<>();

    public void initializeMap(List<Judgment> judgments){
        for(Judgment judgment : judgments){
            for(Judge judge : judgment.judges){
                judgeListHashMap.put(judge.name,new ArrayList<>());
            }
        }

        for(Judgment judgment : judgments){
            for(Judge judge : judgment.judges){
                judgeListHashMap.get(judge.name).add(judgment);
            }
        }
    }

    public List<Judge> top10(){
        int N = judgeListHashMap.size();
        Judge array[] = new Judge[N];
        int i=0;
        for(Map.Entry<String,List<Judgment>> entry : this.judgeListHashMap.entrySet()){
            array[i] = new Judge();
            array[i].name = entry.getKey();
            array[i].amount = entry.getValue().size();
            i++;
        }
        quickSort(array,0,N-1);

        List<Judge> topTen = new ArrayList<>();
        for(int j=0; j<10; j++){
            topTen.add(array[N-1 - j]);
        }

        return topTen;
    }

    public void quickSort(Judge array[], int l, int r){
        if(l<r){
            int q = partition(array,l,r);
            quickSort(array,l,q-1);
            quickSort(array,q+1,r);
        }
    }

    public int partition(Judge array[],int low, int high){
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

    public void swap(Judge array[], int x, int y){
        Judge tmp = array[x];
        array[x]=array[y];
        array[y]=tmp;
    }

    @Override
    public void launchRequest(String[] args) {
        if(args.length>0) {
            System.out.println("Polecenie bezargumentowe!");
        }
        else {
            initializeMap(CommonData.judgmentList);
            List<Judge> topTen = top10();
            int i=1;
            for(Judge judge : topTen){
                System.out.print("Sędzia ");
                System.out.print(i);
                System.out.println(": ");
                System.out.println(judge.name);
                System.out.print("Liczba orzeczeń: ");
                System.out.println(judge.amount);
                System.out.println('\n');
                i++;
            }
        }
    }
}
