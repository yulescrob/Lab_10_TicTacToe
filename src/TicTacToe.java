import java.util.Scanner;
public class TicTacToe {

    //board
    private static final int ROW =3;
    private static final int COL=3;
    private static String board [][] = new String[ROW][COL];
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String player1 = " X ";
        String player2 = " O ";
        int game=0;
        int moves=0;
        int row;
        int col;
        String currentPlayer=player1;
        String currentPlayerString;
        String P1 ="Player 1";
        String P2 ="Player 2";

        do {
            game++;
            moves=0;
            clearBoard();
            showBoard();
            for (int x=0; x<9; x++){
                if (x % 2 == 0) {
                    currentPlayer = player1;
                    currentPlayerString = P1;
                } else {
                    currentPlayer = player2;
                    currentPlayerString = P2;
                }
                System.out.println("Your turn " + currentPlayerString);
                do {
                    row = SafeInput.getRangedInt(in, "Enter row coordinate", 1,3)-1;
                    col = SafeInput.getRangedInt(in, "Enter column coordinate", 1,3)-1;
                }while (!isValidMove(row,col));
                moves += 1;
                board[row][col]= currentPlayer;
                showBoard();
                if (moves>=5){ //can have tie or win until 5th move
                    if (isWin(currentPlayer)){
                        System.out.println(currentPlayerString + " wins!");
                        break;
                    } else if (moves>=7) { //checking if tie after 7th move
                        if (isTie()){
                            System.out.println("It's a tie!");
                            break;
                        }
                    }
                }
            }
            //toggle
            if (player1.equals(" X ")){
                player1 = " O ";
                player2 = " X ";
            }
            else {
                player1 = " X ";
                player2 = " O ";
            }
        }while (SafeInput.getYNConfirm(in, "Do you want to play again"));
    }

    //clear board method
    private static void clearBoard() //sets all the board elements to a space
    {
        for(int row=0; row<ROW; row++)
        {
            for (int col=0; col<COL; col++)
            {
                board[row][col]=""; //makes the cell a space
            }
        }
    }

    //show the board
    private static void showBoard()
    {
        String showBoard = "";
        for (int row=0; row<ROW; row++)
        {
            for (int col=0; col<COL; col++)
            {
                if (col==COL-1)
                {
                    showBoard += board[row][col];
                }
                else {
                    showBoard += board[row][col] + "|"; //adds divider after columns
                }
            }
        }
        System.out.println(showBoard);
    }

    //valid move method
    private static boolean isValidMove(int row, int col)
    {
        boolean retVal=false;
        if (board[row][col].equals(" ")) //true if there is a space
            retVal = true;
        return retVal;
    }

    //column win method
    private static boolean isColWin(String player)
    {
        for (int col=0; col<COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false; //no column win
    }

    //row win method
    private static boolean isRowWin(String player)
    {
        for (int row=0; row<ROW; row++)
        {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false; //no row wim
    }

    //diagonal win method
    private static boolean isDiagonalWin(String player)
    {
        if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))) {
            return true;
        }
        else {
            return false; //no diagonal win
        }
    }

    // Win method
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true; //true if either col, row, or diagonal win
        }
        return false;
    }

    //ties row method
    private static boolean isTieRows()
    {
        int X=0;
        int O=0;
        int noWin=0;
        for(int x=0; x<ROW; x++)
        {
            X=0;
            O=0;
            for (int y=0; y<COL; y++) {
                if (board[x][y].equals(" X ")) {
                    X++;
                }
                else if (board[x][y].equals(" O ")) {
                    O++;
                }
                if (X>=1 && O>=1) { //there is at least an X and O in rows
                    noWin++;
                }
            }
        }
        if (noWin>=3) {
            return true;
        }
        else {
            return false;
        }
    }

    // ties columns method
    public static boolean isTieCol(){
        int X=0;
        int O=0;
        int noWin=0;
        for (int x=0; x<ROW; x++){
            X=0;
            O=0;
            for (int y=0; y<COL; y++){
                if (board[y][x].equals(" X ")){
                    X++;
                } else if (board[y][x].equals(" O ")) {
                    O++;
                }
                if (X>=1 && O>=1){
                    noWin++;
                }
            }
        }
        if (noWin >=3){
            return true;
        }
        else {
            return false;
        }
    }

    // true if there's an X and O in diagonal up
    private static boolean isTieDiagonalUp(){
        int X=0;
        int O=0;
        if (board[0][2].equals(" X ")){
            X++;
        } else if (board[0][2].equals(" O ")) {
            O++;
        }
        if (board[1][1].equals(" X ")){
            X++;
        } else if (board[1][1].equals(" O ")) {
            O++;
        }
        if (board[2][0].equals(" X ")){
            X++;
        } else if (board[2][0].equals(" O ")) {
            O++;
        }
        if (X>=1 && O>=1){
            return true;
        }
        else{
            return false;
        }
    }

    //ture if there's an X and O diagonal downward
    private static boolean isTieDiagonalDown(){
        int X=0;
        int O=0;
        for (int x=0; x<ROW; x++){
            if (board[x][x].equals(" X ")){
                X++;
            } else if (board[x][x].equals(" O ")) {
                O++;
            }
        }
        if (X>=1 && O>=1){
            return true;
        }
        else {
            return false;
        }
    }

    //true if tie
    private static boolean isTie(){
        int count = 0;
        if (isTieRows()){
            count++;
        }
        if (isTieCol()){
            count++;
        }
        if (isTieDiagonalUp()){
            count++;
        }
        if (isTieDiagonalDown()){
            count++;
        }
        if (count>=3){
            return true;
        }
        return false;
    }

}