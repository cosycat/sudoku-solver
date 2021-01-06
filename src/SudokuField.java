import java.util.Arrays;

public class SudokuField {
    
    public static int EMPTY_VALUE = 0;
    
    private final int size = 9;
    
    private final int[][] field;
    
    public SudokuField() {
        field = new int[size][];
        for (int i = 0; i < size; i++) {
            field[i] = new int[size];
            for (int j = 0; j < size; j++) {
                this.field[i][j] = EMPTY_VALUE;
            }
        }
    }
    
    public SudokuField(int[][] otherField, boolean switchXY) {
        field = new int[size][];
        if (switchXY) {
            for (int x = 0; x < size; x++) {
                field[x] = new int[size];
                for (int y = 0; y < size; y++) {
                    field[x][y] = otherField[y][x];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                field[i] = new int[size];
                System.arraycopy(otherField[i], 0, this.field[i], 0, size);
            }
        }
    }
    
    public SudokuField createCopy() {
        return new SudokuField(this.field, false);
    }
    
    
    public boolean isValueValid(int value, int x, int y, boolean ignoreValuePresent) {
        if (getValue(x, y) != EMPTY_VALUE && !ignoreValuePresent) {
            //System.out.println(value + " invalid FULL at " + new Position(x, y));
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (
                    getValue(x, i) == value
                    || getValue(i, y) == value
            ) {
                //System.out.println(value + " invalid LINE at " + new Position(x, y));
                return false;
            }
        }
        Position fieldStart = getSmallFieldTopLeftPosition(new Position(x, y));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getValue(fieldStart.x + i, fieldStart.y + j) == value) {
                    //System.out.println(value + " invalid BOX  at " + new Position(x, y));
                    return false;
                }
            }
        }
        return true;
    }
    
    public Position getSmallFieldTopLeftPosition(Position position) {
        return new Position((position.x / 3) * 3, (position.y / 3) * 3);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuField that = (SudokuField) o;
        if (field == null || that.field == null || size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (!Arrays.equals(field[i], that.field[i])) return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int getValue(int x, int y) {
        return field[x][y];
    }
    
    public void setValue(int value, int x, int y) {
        field[x][y] = value;
    }
    
    public void setValue(int value, Position position) {
        setValue(value, position.x, position.y);
        //System.out.println(position + ":= " + value);
    }
    
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int y = 0; y < size; y++) {
            if (y % 3 == 0) {
                for (int i = 0; i < (size*3 + 4); i++) {
                    out.append("-");
                }
                out.append("\n");
            }
            for (int x = 0; x < size; x++) {
                if (x % 3 == 0) out.append("|");
                out.append(" " + (getValue(x, y) == EMPTY_VALUE ? " " : getValue(x, y)) + " ");
            }
            out.append("|\n");
        }
        for (int i = 0; i < (size*3 + 4); i++) {
            out.append("-");
        }
        return out.toString();
    }
    
    public int getValue(Position position) {
        return getValue(position.x, position.y);
    }
}
