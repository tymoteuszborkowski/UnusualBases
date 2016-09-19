import java.util.ArrayList;
import java.util.List;

public class Converter {


    Long getBinary(int n, List<Long> allNumbers) {
        long bestNumber = 0;
        List<Long> previousNumbers = new ArrayList<>();
        String pseudoBinaryOutput = "";


        for (Long allNumber : allNumbers) {
            if (allNumber <= n) {
                bestNumber = allNumber;
                previousNumbers.add(bestNumber);
            }
        }

        long output = 0;

            for(int i = previousNumbers.size()-1; i >= 0; i--) {
                long actualNumber = previousNumbers.get(i);
                if (output + actualNumber <= n) {
                    output += actualNumber;
                    pseudoBinaryOutput += "1";
                }else{
                    pseudoBinaryOutput += "0";
                }
        }

        System.out.println(pseudoBinaryOutput);

        return bestNumber;
    }
    List<Long> generate(long n) {
        List<Long> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long fibonacci = fibonacci(i);
            numbers.add(fibonacci);
        }
        numbers.remove(0);

        return numbers;
    }

    private long fibonacci(long n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


    public static void main(String[] args) {
        Converter converter = new Converter();
        List<Long> list = converter.generate(16);
        converter.getBinary(32, list);


    }

}
