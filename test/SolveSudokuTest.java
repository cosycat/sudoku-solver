import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolveSudokuTest {
    
    @Test
    void solveSudokuRecursiveTest() {
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
        int[][] fieldEnd = {
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
        SudokuField sudokuFieldEnd = new SudokuField(fieldEnd, true);
        
        Main.solveSudokuRecursive(sudokuFieldStart);
        
        assertEquals(sudokuFieldStart, sudokuFieldEnd);
    }
}