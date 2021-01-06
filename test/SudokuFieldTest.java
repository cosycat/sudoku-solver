import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuFieldTest {
    
    @Test
    void testEqualsForEmptyFields() {
        SudokuField s1 = new SudokuField();
        SudokuField s2 = new SudokuField();
    
        assertEquals(s2, s1);
    }
}