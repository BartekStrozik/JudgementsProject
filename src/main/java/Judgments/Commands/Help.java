package Judgments.Commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Help extends AbstractCommand {
    private String abstractHelp() throws IOException {
        File file = new File("Help.txt");
        Path path = file.toPath();
        BufferedReader reader = Files.newBufferedReader(path);
        Stream<String> stringStream = reader.lines();
        Object[] objects =  stringStream.toArray();
        StringBuilder builder = new StringBuilder();
        for(Object o : objects){
            builder.append(o.toString())
                    .append('\n');
        }
        return builder.toString();
    }

    @Override
    public Result solveResult(String[] args) {
        if(args.length == 0){
            try {
                return new Result(abstractHelp());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(args.length == 1){
            return new Result("");
        }
        else{
            throw new IllegalArgumentException("Too many arguments");
        }
        return null;
    }
}
