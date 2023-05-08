public class Main {
    /**
     * This function will take in a matrix return it in reduced form
     * @param mx (given matrix)
     * @return reduced matrix
     */
    public static Matrix rowReduce(Matrix mx){

        // Break statement, if the bottom row is all zeroes
        if(mx.zeroRow()){
            return mx;
        }
        // Break statement, if matrix is reduced
        if (mx.reduced()){
            return mx;
        }
        // If top left value is 0, swap with another row and call function again
        if(mx.mx[0][0] == 0){
            mx.swapAround();
            rowReduce(mx);
        }
        // Reduces all pivots to 1
        mx.reduceToOne();

        // Subtracts first row from second to eliminate mx[1][0]
        if(mx.mx[1][0] != 0){
            mx.subtract(1,0, mx.mx[1][0] / mx.mx[0][0]);
            rowReduce(mx);
        }
        // Subtracts first row from second to eliminate mx[1][0]
        if(mx.mx[2][0] != 0){
            mx.subtract(2,0, mx.mx[2][0] / mx.mx[0][0]);
            rowReduce(mx);
        }
        // Subtracts first row from second to eliminate mx[1][0]
        if(mx.mx[2][1] != 0){
            mx.subtract(2,1, mx.mx[2][1] / mx.mx[1][1]);
            rowReduce(mx);
        }
        return mx;


    }
    public static void main(String[] args) {
        Matrix mx = new Matrix();
        mx.setMx();
        mx.displayMx();
        rowReduce(mx);
        System.out.println();
        mx.displayMx();
    }
}