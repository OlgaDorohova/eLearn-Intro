package my.home.eLearn;



public class ReverseArgs {
    public static void main(String[] args) {
        System.out.println("This is reverseArgs programm");
        if(args.length != 0){
            for(int i = args.length - 1; i >= 0; i--){
                System.out.println(args[i]);
            }
        }
        else System.out.println("Array args[] is empty");
    }
    
}
