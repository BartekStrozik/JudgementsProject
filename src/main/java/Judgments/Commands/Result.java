package Judgments.Commands;

import Judgments.Objects.Judgment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Object result;

    public Result(Object result){
        this.result = result;
    }

    public Object getResult(){
        return result;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(this.result instanceof HashMap){
            for(Map.Entry entry : ((HashMap<Object, Object>) this.result).entrySet()){
                builder.append(entry.getKey())
                        .append('\n')
                        .append("Number of judgments: ")
                        .append(entry.getValue())
                        .append('\n');
            }
        }
        else if(this.result instanceof List){
            for(Object obj : (List) this.result){
                builder.append(obj.toString()).append('\n');
            }
        }
        return builder.toString();
    }
}
