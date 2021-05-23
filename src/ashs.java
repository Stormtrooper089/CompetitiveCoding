public class ashs {


    private static int countTheWater(int[] arrayOfWater, int i, int j) {
        int  sum = 0;
        for(int ind=i;ind <j;ind++){
            if( arrayOfWater[ind] < arrayOfWater[i]){
                sum  = sum +arrayOfWater[i] - arrayOfWater[ind];
            }
        }
        return sum;
    }
    public static void main(String[] args) throws InterruptedException{
        int[] arrayOfWater = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int sum =0 ;

//        System.out.println( arrayOfWater.toString());
        for(int i=0; i < arrayOfWater.length-1;i++){
            //System.out.println( i);
            if( arrayOfWater[i] != 0 ){
                if(arrayOfWater[i+1] > arrayOfWater[i] ){
                    continue;
                }
                int j =i+2;
                int found = 0;
                while( j< arrayOfWater.length){
                    if(arrayOfWater[j] > arrayOfWater[i]){
                        sum = countTheWater(arrayOfWater,i,j);
                        i=j;
                        found =1;

                    }else{
                        j++;
                    }
                }
                if(found ==0 ){
                    int swap =0;
                    for(int k =i; k<(arrayOfWater.length-i)/2;k++){
                        swap = arrayOfWater[k];
                        arrayOfWater[k]=arrayOfWater[arrayOfWater.length-1-(k-i)];
                        arrayOfWater[arrayOfWater.length-1-(k-i)]= swap;
                    }
                }
            }
        }
        System.out.println( "The amount of water stored in the array  " + sum);
    }

}
