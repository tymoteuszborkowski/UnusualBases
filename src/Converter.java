import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Converter {

    private static final String PREVIOUS_RESULTS_FILENAME = "previous_results.txt";

    String getBaseFibByDecimal(long n) {
        long bestNumber = 0;
        List<Long> allFibResults = readAllFibResults();
        List<Long> previousResults = new ArrayList<>();
        String pseudoBinaryOutput = "";


        if(previousResults.isEmpty()){
            for (Long allNumber : allFibResults) {
                if (allNumber <= n) {
                    bestNumber = allNumber;
                    previousResults.add(bestNumber);
                }
            }
        }


        long output = 0;

            for(int i = previousResults.size()-1; i >= 0; i--) {
                long actualNumber = previousResults.get(i);
                if (output + actualNumber <= n) {
                    output += actualNumber;
                    pseudoBinaryOutput += "1";
                }else{
                    pseudoBinaryOutput += "0";
                }
        }

        return pseudoBinaryOutput;
    }

    Long getDecimalByBaseFib(long n) {
        String reversedNumberStr = new StringBuilder(String.valueOf(n)).reverse().toString();
        char[] chars = reversedNumberStr.toCharArray();
        List<Long> fibResults = readAllFibResults();
        List<Long> outputNumbers = new ArrayList<>();
        long result = 0;

        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '1'){
                Long number = fibResults.get(i);
                outputNumbers.add(number);
            }
        }


            for(Long number : outputNumbers){
                result += number;
            }


        return result;
    }

    List<Long> generatePreviousFibResults(long n) {
        List<Long> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long fibonacci = fibonacci(i);
            numbers.add(fibonacci);
        }
        numbers.remove(0);

        saveResultsToFile(numbers);
        return numbers;
    }

    private long fibonacci(long n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private void saveResultsToFile(List<Long> numbers){

        try(  PrintWriter out = new PrintWriter(PREVIOUS_RESULTS_FILENAME)  ){
            numbers.forEach(out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Long> readAllFibResults(){
        List<Long> results = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(PREVIOUS_RESULTS_FILENAME))) {
            stream.forEach(number ->{
                long l = Long.parseLong(number);
                results.add(l);
            });
        } catch (IOException e) {
            generatePreviousFibResults(50);
            readAllFibResults();
        }

        return results;
    }


}
