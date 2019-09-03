/**
 * Practice02_NQueen.java
 * Solution class for NQueens problem.
 * @author Wei Tian
 *
 */
public class NQueens {
    private static int n;
    private static int board[][];
    public NQueens(int n){
        // constructor
        this.n = n;
        this.board = new int[n][n];
    }
    boolean canPlaceQueen(int row, int col){
        // check Queen attack; we don't need to check lower left and right diagonal.
        for(int i = 0; i < n; i++){
            if(board[row][i] == 1||board[i][col] == 1) //vertical and horizontal check
                return false;
        }
        for(int i = row, j =col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) // upper left diagonal check
                return false;
        }
        for(int i = row, j =col; i >= 0 && j < n; i--, j++){
            if (board[i][j] == 1) // upper right diagonal check
                return false;
        }
        return true;
    }
    boolean placeNQueens(){
        // check n and execute placeQueen()
        if( n == 0)
            throw new IndexOutOfBoundsException();
        return placeQueen(0);
    }
    boolean placeQueen(int row){
        // recursive for place queen
        if(row == n){
            printToConsole();
            return true;
        }
        for(int col = 0; col < n; col++) {
            if (canPlaceQueen(row, col)) {
                board[row][col] = 1;
                if (placeQueen(row + 1))
                    return true;
                else
                    board[row][col] = 0;
            }
        }
        return false;
    }
    void printToConsole(){
        // print the board to console
        String output = "".format("The board for %d Queens\n", n);
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    output += "Q ";
                } else {
                    output += "_ ";
                }
            }
            output += "\n";
        }
        System.out.print(output);
    }
}
