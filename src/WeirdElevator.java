import java.io.*;
import java.util.*;


public class WeirdElevator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int X = Integer.parseInt(line[0]);
            int Y = Integer.parseInt(line[1]);
            int M = Integer.parseInt(line[2]);

            int[] out_ = elevator_sol(X, Y, M);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
                System.out.print(" " + out_[i_out_]);
            }

            System.out.println();

        }

        wr.close();
        br.close();
    }
    public static Set<Integer> primeFactors(int n,int m)
    {
        // Print the number of 2s that divide n
        Set<Integer> primeFactors = new HashSet<>();
        while (n%2==0)
        {
            System.out.print(2 + " ");
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                //System.out.print(i + " ");
                if(i<m){
                    primeFactors.add(i);
                }
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            primeFactors.add(n);
        return  primeFactors;
    }
    static int[] elevator_sol(int X, int Y, int M){
        // Write your code here
        int [] ans ={};

        Set<Integer> primeSetFirst = primeFactors(X,M);
        Set<Integer> primeSetSecond = primeFactors(Y,M);
        Object[] primeSetListFirst = primeSetFirst.toArray();
        Object[] primeSetListSecond = primeSetSecond.toArray();
        System.out.println(primeSetListFirst.toString());
        System.out.println(primeSetListSecond.toString());



        return ans;

    }
}