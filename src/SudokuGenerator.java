import java.util.*;

public class SudokuGenerator {

    private static final int BOARD_SIZE = 9;
    private static final int BOX_SIZE = 3;
    private static final Random random = new Random();

    public static int[][] generate() {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        fillBoard(board, 0, 0);
        removeNumbers(board);
        return board;
    }

    private static boolean fillBoard(int[][] board, int row, int col) {
        if (col == BOARD_SIZE) {
            col = 0;
            row++;
            if (row == BOARD_SIZE) {
                return true;
            }
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= BOARD_SIZE; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers, random);

        for (int number : numbers) {
            if (isValid(board, row, col, number)) {
                board[row][col] = number;
                if (fillBoard(board, row, col + 1)) {
                    return true;
                }
            }
        }

        board[row][col] = 0;
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col, int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == number) {
                return false;
            }
            if (board[i][col] == number) {
                return false;
            }
        }

        int boxRow = row - row % BOX_SIZE;
        int boxCol = col - col % BOX_SIZE;
        for (int i = boxRow; i < boxRow + BOX_SIZE; i++) {
            for (int j = boxCol; j < boxCol + BOX_SIZE; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void removeNumbers(int[][] board) {
        int numbersToRemove = (int) (BOARD_SIZE * BOARD_SIZE * 0.5); // remove half of the numbers
        while (numbersToRemove > 0) {
            int row = random.nextInt(BOARD_SIZE);
            int col = random.nextInt(BOARD_SIZE);
            if (board[row][col] != 0) {
                int temp = board[row][col];
                board[row][col] = 0;
                if (!hasUniqueSolution(board)) {
                    board[row][col] = temp;
                } else {
                    numbersToRemove--;
                }
            }
        }
    }

    private static boolean hasUniqueSolution(int[][] board) {
        int[][] copy = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return solve(copy);
    }

    private static boolean solve(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
    
        // find the first empty cell in the board
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
    
        // if there is no empty cell, the board is solved
        if (isEmpty) {
            return true;
        }
    
        // try each number from 1 to 9 in the empty cell
        for (int num = 1; num <= BOARD_SIZE; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board)) {
                    return true;
                }
                board[row][col] = 0; // undo the assignment
            }
        }
    
        return false; // backtrack
    }
}    