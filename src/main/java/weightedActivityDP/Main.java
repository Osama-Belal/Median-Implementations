package weightedActivityDP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar activity_<id>.jar absolute_path_to_input_file");
            System.exit(1);
        }

        String inputFilePath = args[0];
        WeightedActivitySelection w = new WeightedActivitySelection();
        long answer = w.solve(inputFilePath);

        String id = "output";
        String outputFilePath = inputFilePath.replace(".in", "_" + id + ".out");

        try {
            File file = new File(outputFilePath);
            file.createNewFile();
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write("Maximum Weight: " + answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
