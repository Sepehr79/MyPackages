package MyPackages.matrix.classes;

/**
 * working with matrix
 * @author Sepehr79
 */
public class Matrix {

    public int[][] table;

    private final int xLength;
    private final int yLength;

    //Constructors
    public Matrix(int size){
        table = new int[size][size];
        this.xLength = size;
        this.yLength = size;
    }
    public Matrix(int xLength, int yLength){
        table = new int[xLength][yLength];
        this.xLength = xLength;
        this.yLength = yLength;
    }
    public Matrix(int[][] matrix) throws Exception{
        if(isMatrix(matrix)){
            this.table = matrix;

            this.xLength = matrix.length;
            this.yLength = matrix[0].length;
        }else{
            throw new Exception("input array is not a matrix.");
        }
    }

    //static methods
    public static boolean isMatrix(int[][] matrix){

        for(int i = 0; i < matrix.length ; i++)
            for(int j = i + 1 ; j < matrix.length; j++){

                if(matrix[i].length != matrix[j].length)
                    return false;
            }
        return true;
    }

    public static int getDetermine(Matrix matrix) throws Exception{
        int det = 0;

        if(matrix.xLength == 2 && matrix.yLength == 2){
            det = matrix.table[0][0] * matrix.table[1][1] - matrix.table[0][1] * matrix.table[1][0];
            return det;
        }
        else if(matrix.xLength == 3 && matrix.yLength == 3){
            for(int i=0;i<3;i++)
                det = det + (matrix.table[0][i]*(matrix.table[1][(i+1)%3]*matrix.table[2][(i+2)%3] - matrix.table[1][(i+2)%3]*matrix.table[2][(i+1)%3]));

            return det;
        }
        throw new Exception("cant calculate determine of big matrix");
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) throws Exception{
        if(matrix1.yLength != matrix2.xLength)
            throw new Exception("cant multiply two matrixes");

        Matrix ans = new Matrix(matrix1.xLength, matrix2.yLength);

        //algorithm for multiply matrices.............
        for(int i=0;i<ans.getXLength();i++){
            for(int j=0;j<ans.getYLength();j++){
                ans.table[i][j]=0;
                for(int k=0;k<matrix1.yLength;k++){
                    ans.table[i][j]+=matrix1.table[i][k]*matrix2.table[k][j];
                }
            }
        }

        return ans;
    }

    //getters
    public int getXLength() {
        return xLength;
    }

    public int getYLength() {
        return yLength;
    }

    //override methods
    public String toString(){
        StringBuilder matrix = new StringBuilder();

        for(int i = 0 ; i < this.getXLength(); i++){
            for(int j = 0; j < this.getYLength(); j++){
                matrix.append(this.table[i][j]).append(" ");
            }
            matrix.append("\n");
        }

        return matrix.toString();
    }
}
