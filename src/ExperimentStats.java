import java.util.ArrayList;
/**
 * Class to keep track of Experiment Values
 */
public class ExperimentStats{
    int min;
    int max;
    int size;
    int sum;
    ArrayList<Integer> data;

    public ExperimentStats(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        size = 0;
        sum = 0;
        data = new ArrayList<>();
    }

    /**
     * Record a value
     * @param value the number to record
     */
    public void record(int value){
        min = min > value? value: min;
        max = max < value? value: max;
        sum+=value;
        size+=1;
        data.add(value);
    }

    /**
     * Get the average using the size and the cumulative sum
     * @return the average
     */
    public int getAverage(){
        return sum/size;
    }

    public String toString(){
        return String.format("Best Case = %d, Average Case = %d, Worst Case = %d",min,getAverage(), max);
    }
}
