package my.home.eLearn;
public class RandomNums{
    public static void main(String[] args) {
        
        if(args.length != 0){
            int n = Integer.valueOf(args[0]);
            for(int i = 0; i < n; i++){
                System.out.println((int) (Math.random() * 10));
            }

            for(int i = 0; i < n; i++){
                System.out.print((int) (Math.random() * 10) + ", ");
            }
        }
    }
}