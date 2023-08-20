package my.home.eLearn;


public class MathCons{
    public static void main(String[] args) {
        if(args.length != 0){
            int sum = 0;
            int mult = 1;
            for(int i = 0; i < args.length; i++){
                sum += Integer.valueOf(args[i]);
                mult *= Integer.valueOf(args[i]);
            }
            System.out.println("Sum = " + sum + "\n" + "Multiply = " + mult);
        }
    }
}