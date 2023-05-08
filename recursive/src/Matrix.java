import java.util.Scanner;
public class Matrix {

    double[][] mx = new double[3][3]; // This is the attribute that holds the 3x3 matrix

    /**
     * This method will ask the user for values to fill the matrix
     */
    void setMx(){
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            System.out.println("Input values for row " + i + ':');
            for(int j = 0; j < 3; j++){
                mx[i][j] = scan.nextDouble();
            }
        }
    }

    /**
     * This method will display the matrix
     */
    void displayMx(){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(j != 2)
                    System.out.print(mx[i][j] + " | ");
                else
                    System.out.print(mx[i][j]);
            }
                System.out.println();
        }
    }

    /**
     * This method will swap the two given rows of a matrix
     * @param a (Matrix row we are swapping)
     * @param b (Matrix row we are swapping)
     *
     * WARNING: IF ROW A AND B BOTH START WITH 0, THIS WON'T WORK
     */
    void swap(int a, int b){
        // Makes a temporary array to hold row 'a'
        double[] tmp = mx[a].clone();

        // Sets row 'a' equal to 'b' and row 'b' equal to 'tmp'
        for (int i = 0; i < 3; i++){
            mx[a][i] = mx[b][i];
            mx[b][i] = tmp[i];
        }
    }
    /**
     * This method will swap all the rows around
     * in case there are 0 values at mx[a][0] and mx[b][0] regarding Swap
     */
    void swapAround(){
        // Swaps all rows around
        double[] tmp = mx[0].clone();
        double[] tmp2 = mx[1].clone();
        double[] tmp3 = mx[2].clone();
        mx[1] = tmp3;
        mx[0] = tmp2;
        mx[2] = tmp;


    }
    /**
     * This method will subtract values of one row from another
     * @param a (Matrix row we are subtracting from)
     * @param b (Matrix row we are subtracting)
     * @param c (a - b * c)
     */
    void subtract(int a, int b, double c){
        // Sets row 'a' equal to 'b' and row 'b' equal to 'tmp'
        for (int i = 0; i < 3; i++){
            mx[a][i] -= mx[b][i] * c;
        }
    }

    /**
     * This method checks to see if the Matrix attribute equals a given matrix
     * @param check (Matrix that will be used to check if the matrix has the desired values)
     * @return boolean: whether the matrix equals check or not
     */
    boolean equals(double[][] check){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(mx[i][j] != check[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks to see if Matrix is in reduced form
     * @return true if it is, false if it is not
     */
    boolean reduced(){
        if(mx[0][0] == 1 && mx[1][0] == 0 && mx[1][1] == 1 && mx[2][0] == 0 && mx[2][1] == 0 && mx[2][2] == 1){
            return true;
        }
        return false;
    }

    /**
     * Reduces all pivot positions to 1, dividing their rows accordingly
     */
    void reduceToOne(){
        // Before we set values to 1, we need to make sure those values aren't extremely small and supposed to equal 0.
        reformat();
        // Reduces top left value to 1
        if(mx[0][0] != 1){
            mx[0][2] /= mx[0][0];
            mx[0][1] /= mx[0][0];
            mx[0][0] /= mx[0][0];
        }
        // Reduces middle value to 1
        if(mx[1][1] != 1){
            mx[1][2] /= mx[1][1];
            mx[1][0] /= mx[1][1];
            mx[1][1] /= mx[1][1];
        }
        // Reduces bottom right value to 1
        if(mx[2][2] != 1){
            mx[2][0] /= mx[2][2];
            mx[2][1] /= mx[2][2];
            mx[2][2] /= mx[2][2];
        }
    }

    /**
     * This method will reformat the matrix to eliminate errors
     * ex. Make -0.0 = 0, round numbers that should equal other numbers 2.00000005 = 2.
     */
    void reformat(){
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(mx[i][j] > 0 && mx[i][j] - (int) mx[i][j] < .000001){
                    mx[i][j] = Math.round(mx[i][j]);
                }
                else if(mx[i][j] < 0 && mx[i][j] + (int) mx[i][j] > .000001){
                    mx[i][j] = Math.round(mx[i][j]);
                }
                if(mx[i][j] == -0.0){
                    mx[i][j] = 0.0;
                }
            }
        }
    }
    boolean zeroRow(){
        if(mx[2][0] == 0 && mx[2][1] == 0 && mx[2][2] == 0){
            return true;
        }
        return false;
    }


}
