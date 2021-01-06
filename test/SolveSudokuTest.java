import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolveSudokuTest {
    
    @Test
    void solveSudokuRecursiveTest1() {
        int[][] fieldStart = {
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
        int[][] fieldSolution = {
                {2, 8, 3,  9, 5, 7,  6, 4, 1, },
                {6, 7, 9,  8, 1, 4,  5, 3, 2, },
                {5, 1, 4,  2, 3, 6,  8, 9, 7, },
                
                {7, 6, 5,  3, 9, 1,  4, 2, 8, },
                {8, 3, 1,  5, 4, 2,  7, 6, 9, },
                {9, 4, 2,  6, 7, 8,  1, 5, 3, },
                
                {4, 2, 6,  7, 8, 9,  3, 1, 5, },
                {3, 9, 8,  1, 6, 5,  2, 7, 4, },
                {1, 5, 7,  4, 2, 3,  9, 8, 6, },
            
        };
        SudokuField sudokuFieldStart = new SudokuField(fieldStart, true);
        SudokuField sudokuFieldSolution = new SudokuField(fieldSolution, true);
        
        SudokuField sudokuFieldEnd = Main.solveSudoku(sudokuFieldStart);
        
        assertEquals(sudokuFieldSolution, sudokuFieldEnd);
    }
    
    @Test
    void solveSudokuRecursiveTest2() {
        int[][] fieldStart = {
                {9, 0, 0, 0, 8, 0, 0, 0, 1},
                {0, 0, 0, 4, 0, 6, 0, 0, 0},
                {0, 0, 5, 0, 7, 0, 3, 0, 0},
                {0, 6, 0, 0, 0, 0, 0, 4, 0},
                {4, 0, 1, 0, 6, 0, 5, 0, 8},
                {0, 9, 0, 0, 0, 0, 0, 2, 0},
                {0, 0, 7, 0, 3, 0, 2, 0, 0},
                {0, 0, 0, 7, 0, 5, 0, 0, 0},
                {1, 0, 0, 0, 4, 0, 0, 0, 7}
        };
        int[][] fieldSolution = {
                {9, 2, 6, 5, 8, 3, 4, 7, 1},
                {7, 1, 3, 4, 2, 6, 9, 8, 5},
                {8, 4, 5, 9, 7, 1, 3, 6, 2},
                {3, 6, 2, 8, 5, 7, 1, 4, 9},
                {4, 7, 1, 2, 6, 9, 5, 3, 8},
                {5, 9, 8, 3, 1, 4, 7, 2, 6},
                {6, 5, 7, 1, 3, 8, 2, 9, 4},
                {2, 8, 4, 7, 9, 5, 6, 1, 3},
                {1, 3, 9, 6, 4, 2, 8, 5, 7}
        };
        SudokuField sudokuFieldStart = new SudokuField(fieldStart, true);
        SudokuField sudokuFieldSolution = new SudokuField(fieldSolution, true);
    
        SudokuField sudokuFieldEnd = Main.solveSudoku(sudokuFieldStart);
    
        assertEquals(sudokuFieldSolution, sudokuFieldEnd);
    }
    
}