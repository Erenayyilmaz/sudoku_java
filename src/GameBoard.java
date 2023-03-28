import java.util.Random;

// GameBoard class
public class GameBoard {
    public final int SIZE = 9;
    private Cell[][] board;
    private Cell[][] gaming_board;
    
    public void initialize() {
        board = new Cell[9][9];
        gaming_board = new Cell[9][9];
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                board[i][j] = new Cell();
                gaming_board[i][j] = new Cell();
            }
        }
    }
    
    public void setCell(int row, int col, int value) {
        board[row][col].setValue(value);
    }
    
    public int getCell(int row, int col) {
        return (board[row][col].getValue());
    }

    // public boolean isValid(int row, int col, int value) {
    //     for (int i = 0; i < SIZE; i++) {
    //         if (getCell(row, i) == value) {
    //             return false;
    //         }
    //     }
    //     for (int i = 0; i < SIZE; i++) {
    //         if (getCell(i, col) == value) {
    //             return false;
    //         }
    //     }
    //     int startRow = row - row % 3;
    //     int startCol = col - col % 3;
    //     for (int i = 0; i < 3; i++) {
    //         for (int j = 0; j < 3; j++) {
    //             if (getCell(startRow + i, startCol + j) == value) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    // public boolean solve() {
    //     int row = -1;
    //     int col = -1;
    //     boolean isEmpty = true;
        
    //     // Find the first empty cell in the board
    //     for (int i = 0; i < SIZE; i++) {
    //         for (int j = 0; j < SIZE; j++) {
    //             if (getCell(i, j) == 0) {
    //                 row = i;
    //                 col = j;
    //                 isEmpty = false;
    //                 break;
    //             }
    //         }
    //         if (!isEmpty) {
    //             break;
    //         }
    //     }
        
    //     // If there are no empty cells, the board is solved
    //     if (isEmpty) {
    //         return true;
    //     }
        
    //     // Try different values for the empty cell
    //     for (int value = 1; value <= 9; value++) {
    //         if (isValid(row, col, value)) {
    //             setCell(row, col, value);
                
    //             // Recursively try to fill in the rest of the board
    //             if (solve()) {
    //                 return true;
    //             } else {
    //                 // If the value doesn't work, backtrack and try a different value
    //                 setCell(row, col, 0);
    //             }
    //         }
    //     }
        
    //     // If none of the values work, backtrack to the previous cell
    //     return false;
    // }
    
    // public void generateBoard(DifficultyLevel difficultyLevel) {
    //     Random rand = new Random();
    //     int numCells = 0;
        
    //     // Determine the number of cells to be hidden based on the difficulty level
    //     switch (difficultyLevel.getDifficulty()) {
    //         case "EASY":
    //             numCells = rand.nextInt(10) + 40; // hide between 40 and 49 cells
    //             break;
    //         case "MEDIUM":
    //             numCells = rand.nextInt(10) + 30; // hide between 30 and 39 cells
    //             break;
    //         case "HARD":
    //             numCells = rand.nextInt(10) + 20; // hide between 20 and 29 cells
    //             break;
    //     }
        
    //     for (int i = 0; i < SIZE; i++) {
    //         for (int j = 0; j < SIZE; j++) {
    //             if (rand.nextInt(100) < 50) {
    //                 // Randomly fill in this cell
    //                 int value = rand.nextInt(9) + 1;
    //                 if (isValid(i, j, value))
    //                 {
    //                     setCell(i, j, value);
    //                 }
    //                 else
    //                 {
    //                     // If the value is not valid, try again with a different value
    //                     j--;
    //                 }
    //             }
    //         }
    //     }
        
    //     // Use a backtracking algorithm to fill in the rest of the cells
    //     while(!solve()) {
    //         System.out.println("Backtracking...");
    //     };
    //     System.out.println("");
    //     printBoard();//temp
    //     System.out.println("");

    //     for (int i = 0; i < SIZE; i++) {
    //         for (int j = 0; j < SIZE; j++) {
    //             gaming_board[i][j].setValue(board[i][j].getValue());
    //         }
    //     }
    //     // Hide some cells based on the specified difficulty level
    //     // int cellsHidden = 0;
    //     // while (cellsHidden < numCells) {
    //     //     int row = rand.nextInt(SIZE);
    //     //     int col = rand.nextInt(SIZE);
    //     //     if (getCell(row, col) != 0) {
    //     //         setCell(row, col, 0);
    //     //         cellsHidden++;
    //     //     }
    //     // }
    // }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(getCell(i, j));
            }
            System.out.println("");
        }
    }
    
    public void printGamingBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(gaming_board[i][j]);
            }
            System.out.println("");
        }
    }
}