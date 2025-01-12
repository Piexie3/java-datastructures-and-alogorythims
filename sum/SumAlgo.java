package sum;

public class SumAlgo {
    public static void main(String[] args) {
    double now = System.currentTimeMillis();
        SumAlgo sum = new SumAlgo();
        System.out.println(sum.findSum(99999));
        System.out.println("Time taken  " +(System.currentTimeMillis() - now) + "  milliseconds");
    }
    // this takes 0 milliseconds
    public int findSum(int n){
        return n*(n+1)/2;
    }

    // this slgo takes long to compute
//    public int findSum(int n){
//        int sum = 0;
//        for (int i=0;i<= n;i++){
//            sum = sum+1;
//        }
//        return sum;
//    }
}
