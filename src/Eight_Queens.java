import java.util.Vector;

/**
 * Created by Bimurto on 15-May-15.
 */
public class Eight_Queens {
    int count = 0;
    Vector<Result> resultset = new Vector<>();
    public Eight_Queens(){

    }

    class Result{
        int x[];
        int n;
        Result(int n){
            x = new int[n];
            this.n = n;
        }
    }

    public void placeNQueensAndFCandMRV(int X[] ){
        int N = X.length;

        if( noMoreRow(X) ){
            count++;
            Result r = new Result(N);
            System.out.print(count+" : ");
            for(int i=0;i<N;i++){
                System.out.print(X[i] +" ");
                r.x[i] = X[i];
            }
            resultset.add(r);
            System.out.println();
            return;
        }

        int mrvrow = selectMRVRow(X);

        int board[][] = new int [N][N];
        for(int i =0;i<N;i++){
            if(X[i] != 0){
                int row = i;
                int column = X[i]-1;
                board[row][column] = 1;

                for(int j = 0;j<N;j++){
                    board[row][j] = 1;
                }
                for(int j = 0;j<N;j++){
                    board[j][column] = 1;
                }
                for(int j = 1; j<= row && (column-j >= 0 || column+j < N); j++){
                    if(column-j >= 0)
                        board[row - j][column - j] = 1;
                    if(column+j < N)
                        board[row - j][column + j] = 1;
                }
                for(int j = 1; row + j < N && (column-j >= 0 || column+j < N); j++){
                    if(column-j >= 0)
                        board[row + j][column - j] = 1;
                    if(column+j < N)
                        board[row + j][column + j] = 1;
                }

            }
        }

        for(int j =0;j<N;j++){
            if(board[mrvrow][j] == 0){
                X[mrvrow] = j+1;
                if(forwardCheck(X)) {
                    X[mrvrow] = 0;
                    continue;

                }
                placeNQueensAndFCandMRV(X);
                X[mrvrow] = 0;
            }
        }

    }

    private boolean forwardCheck(int X[]) {
        int N = X.length;
        int board[][] = new int [N][N];
        for(int i =0;i<N;i++){
            if(X[i] != 0){
                int row = i;
                int column = X[i]-1;
                board[row][column] = 1;

                for(int j = 0;j<N;j++){
                    board[row][j] = 1;
                }
                for(int j = 0;j<N;j++){
                    board[j][column] = 1;
                }
                for(int j = 1; j<= row && (column-j >= 0 || column+j < N); j++){
                    if(column-j >= 0)
                        board[row - j][column - j] = 1;
                    if(column+j < N)
                        board[row - j][column + j] = 1;
                }
                for(int j = 1; row + j < N && (column-j >= 0 || column+j < N); j++){
                    if(column-j >= 0)
                        board[row + j][column - j] = 1;
                    if(column+j < N)
                        board[row + j][column + j] = 1;
                }

            }
        }

//        for (int i =0;i<N;i++){
//            for(int j=0;j<N;j++)
//                System.out.print(board[i][j]+" ");
//            System.out.println();
//        }

        for(int i=0;i<N;i++){
            int count =0;
            for(int j=0;j<N;j++){
                if(board[i][j] == 0)
                    count++;
            }
//            System.out.println(i + " "+ count);
            if(count == 0 && X[i] == 0){
                return true;
            }
        }

        return false;
    }



    private boolean noMoreRow(int X[]) {
        int N = X.length;
        for(int i=0;i<N;i++){
            if(X[i] == 0)
                return false;
        }
        return true;
    }

    public int selectMRVRow(int X[]) {
        int N = X.length;
        int board[][] = new int [N][N];
        for(int i =0;i<N;i++){
            if(X[i] != 0){
                int row = i;
                int column = X[i]-1;
                board[row][column] = 1;

                for(int j = 0;j<N;j++){
                    board[row][j] = 1;
                }
                for(int j = 0;j<N;j++){
                    board[j][column] = 1;
                }
                for(int j = 1; j<= row && (column-j >= 0 || column+j < N); j++){
                    if(column-j >= 0)
                        board[row - j][column - j] = 1;
                    if(column+j < N)
                        board[row - j][column + j] = 1;
                }
                for(int j = 1; row + j < N && (column-j >= 0 || column+j < N); j++){
                    if(column-j >= 0)
                        board[row + j][column - j] = 1;
                    if(column+j < N)
                        board[row + j][column + j] = 1;
                }

            }
        }

//        for (int i =0;i<N;i++){
//            for(int j=0;j<N;j++)
//                System.out.print(board[i][j]+" ");
//            System.out.println();
//        }

        int min = 100;
        int row = -1;

        for(int i=0;i<N;i++){
            int count =0;
            for(int j=0;j<N;j++){
                if(board[i][j] == 0)
                    count++;
            }
//            System.out.println(i + " "+ count);
            if(count < min && count != 0){
                min = count;
                row = i;
            }
        }
//        System.out.println("Row: " + row);
        return row;
    }

    public static void main(String args[]){
        int x[] = new int [11];
//        x[4] = 4;
//        x[0] = 1;
//        x[1] = 3;
//        x[2] = 7;
//        x[3] = 2;
//        new Eight_Queens(8).selectMRVRow(x, 8);
        new Eight_Queens().placeNQueensAndFCandMRV(x);
    }


}
