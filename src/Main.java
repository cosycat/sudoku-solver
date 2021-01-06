public class Main {

    public static void main(String[] args) {
        int[][] field = {
                {0, 0, 0,  9, 0, 0,  6, 0, 0, },
                {0, 7, 0,  8, 1, 0,  5, 3, 0, },
                {5, 1, 4,  2, 0, 0,  8, 0, 0, },
                
                {0, 0, 0,  0, 9, 0,  4, 2, 8, },
                {0, 3, 0,  0, 0, 0,  0, 6, 0, },
                {9, 4, 2,  0, 7, 0,  0, 0, 0, },
                
                {0, 0, 6,  0, 0, 9,  3, 1, 5, },
                {0, 9, 8,  0, 6, 5,  0, 7, 0, },
                {0, 0, 7,  0, 0, 3,  0, 0, 0, },
                
        };
        SudokuField sudokuField = new SudokuField(field, true);
        System.out.println("START:");
        System.out.println(sudokuField);
        
        solveSudokuRecursive(sudokuField);
    
        System.out.println("END:");
        System.out.println(sudokuField);
    }
    
    private static boolean solved = false;
    public static SudokuField solveSudoku(SudokuField sudokuField) {
        solved = false;
        SudokuField copiedSudokuField = sudokuField.createCopy();
        solveSudokuRecursive(copiedSudokuField);
        return copiedSudokuField;
    }
    
    private static void solveSudokuRecursive(SudokuField sudokuField) {
        Position firstEmptyPosition = null;
        outerloop:
        for (int x = 0; x < sudokuField.getSize(); x++) {
            for (int y = 0; y < sudokuField.getSize(); y++) {
                if (sudokuField.getValue(x, y) == SudokuField.EMPTY_VALUE) {
                    firstEmptyPosition = new Position(x, y);
                    break outerloop;
                }
            }
        }
        if (firstEmptyPosition == null) {
            solved = true;
            System.out.println("SOLVED :D");
            return; // it's finished :D
        }
        
        for (int i = 1; i <= 9; i++) {
            if (!sudokuField.isValueValid(i, firstEmptyPosition.x, firstEmptyPosition.y, true)) {
                continue;
            }
            sudokuField.setValue(i, firstEmptyPosition);
            solveSudokuRecursive(sudokuField);
            if (solved) {
                //System.out.println("already solved");
                return;
            }
        }
        if (sudokuField.getValue(firstEmptyPosition) == SudokuField.EMPTY_VALUE) {
            //System.out.println("No Valid position found at Position " + firstEmptyPosition);
            //System.out.println(sudokuField);
        }
        sudokuField.setValue(SudokuField.EMPTY_VALUE, firstEmptyPosition);
    }
}
