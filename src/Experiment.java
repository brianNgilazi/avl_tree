import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class to run the Assignment 2 experiment and save the results in a text file
 */
public class Experiment {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= 20; i++) {
            String[] a = new String[1];
            a[0] = Integer.toString(i * 5);
            stringBuffer.append(String.format("Randomisation: %d%n", i*5));
            stringBuffer.append(AVLExperiment.run(i * 5));
        }

        try {
            File file = new File("experiment-results.txt");
            PrintWriter outputStream = new PrintWriter(file);
            outputStream.print(stringBuffer.toString());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
