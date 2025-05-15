public class Pattern{
    public static void main(String[] args){
        int n = 5;
        // Pattern 1 -> Right triangle 
        // for (int i = 1 ;i<=n;i++){
        //     for (int j = 1;j<=i;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //  Pattern 2 -> Pyramid
        for (int i=1;i<=n;i++){
            // Printing the spaces 
            for(int j=n-i;j>0;j--){
                System.out.print(" ");
            }
            // Printing the stars
            for (int k=1;k<=(2*i-1);k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}