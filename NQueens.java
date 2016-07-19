

public class NQueens {

    int[] x;

    public NQueens(int N) {
        x = new int[N];
    }

    public boolean canPlaceQueen(int r, int c) {
        /**
         * Returns TRUE if a queen can be placed in row r and column c.
         * Otherwise it returns FALSE. x[] is a global array whose first (r-1)
         * values have been set.
         */
        for (int i = 0; i < r; i++) {
            if (x[i] == c || (i - r) == (x[i] - c) ||(i - r) == (c - x[i])) 
            {
                return false;
            }
        }
        return true;
    }

    public void printQueens(int[] x) {
        int N = x.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void placeNqueens(int row, int n) {
        /**
         * Using backtracking this method prints all possible placements of n
         * queens on an n x n chessboard so that they are non-attacking.
         */
        for (int column = 0; column < n; column++) {
            if (canPlaceQueen(row, column)) {
                x[row] = column;
                if (row == n - 1) {
                    printQueens(x);
                } else {
                    placeNqueens(row + 1, n);
                }
            }
        }
    }

    public void callplaceNqueens() {
        placeNqueens(0, x.length);
    }

    public static void main(String args[]) {
        NQueens Q = new NQueens(4);
        Q.callplaceNqueens();
     
    }
}

