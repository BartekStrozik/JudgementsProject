package Judgments.Commands;

import java.util.HashMap;

public class FunctionSolver {
    HashMap<String, AbstractCommand> requestMap = new HashMap<>();

    public FunctionSolver(){
        requestMap.put("content",new GetContent());
        requestMap.put("rubrum",new GetMetrics());
        requestMap.put("judge",new GetAmountOfJudgmentsForOneJudge());
        requestMap.put("judges",new GetTopJudges());
        requestMap.put("months",new GetAmountOfJudgmentsForMonths());
        requestMap.put("courts",new GetAmountOfJudgmentsForCourtTypes());
        requestMap.put("regulations",new GetTopRegulations());
        requestMap.put("jury",new GetAmountOfJudgmentsForJurySizes());
    }

    public Result solve(String command, String[] arguments){
        AbstractCommand abstractCommand = requestMap.get(command);
        Result result = abstractCommand.solveResult(arguments);
        return result;
    }
}
