import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type: \"10 decimal_to_convert\" if you want to convert decimal number to base fib");
        System.out.println("or type \" F base_fib_to_convert\" if you want to convert base fib value to decimal value.");

        String next = scanner.nextLine();
        if (next.substring(0, 2).equals("10")) {
            String substring = next.substring(3, next.length());
            long l = Long.parseLong(substring);
            System.out.println(converter.getBaseFibByDecimal(l));
        } else if (next.substring(0, 1).equals("F")){
            String substring = next.substring(2, next.length());
            Long l = Long.parseLong(substring);
            System.out.println(converter.getDecimalByBaseFib(l));
        }else{
            System.out.println("Please, type correct command.");
    }


}
}
