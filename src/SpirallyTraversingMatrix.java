// { Driver Code Starts
import java.io.*;
import java.util.*;
class SpirallyTraversingatrix
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                    matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans)
                System.out.print(val+" ");
            System.out.println();
        }
    }
}// } Driver Code Ends



class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        int hstart = 0;
        int hend = r;
        int lstart = 0;
        int lend = c;



        return null;
    }
}
