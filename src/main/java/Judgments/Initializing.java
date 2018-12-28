package Judgments;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Initializing {
    public static String initialMessage() throws IOException {
        File file = new File("Beginning Message.txt");
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
}
