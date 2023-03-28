public class App {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.initialize();
        DifficultyLevel difficultyLevel = new DifficultyLevel("Easy");
        gameBoard.generateBoard(difficultyLevel);
        gameBoard.printBoard();
        gameBoard.printGamingBoard();
    }
}
