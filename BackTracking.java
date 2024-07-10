//1.backtracking on Array:

public class BackTracking {
    public static void changeArr(int arr[], int i, int val) {

        if (i == arr.length) {
            printArr(arr);
            return;
        }

        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);

    }
}

// 2.Find Subsets

public class BackTracking {
    public static void findSubset(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        findSubset(str, ans + str.charAt(i), i + 1);
        findSubset(str, ans, i + 1);

    }

    public static void main(String args[]) {
        String str = "shit";
        findSubset(str, "", 0);
    }

}

// 3.Find Permutations

public class BackTracking {
    public static void FindPermutaions(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String NewStr = str.substring(0, i) + str.substring(i + 1);
            FindPermutaions(NewStr, ans + curr);
        }

    }

    public static void main(String args[]) {
        String str = "abc";
        FindPermutaions(str, "");

    }
}

// 4.N-queens

public class BackTracking {

    public static boolean isSafe(char board[][], int row, int col) {
        // Check vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void Nqueens(char board[][], int row) {

        if (row == board.length) {
            // printBoard(board);
            count++;
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                Nqueens(board, row + 1);
                board[row][j] = '.';
            }

        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("--------ChessBoard--------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }

    }

    static int count = 0;

    public static void main(String args[]) {
        int n = 5;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        Nqueens(board, 0);
        System.out.println("Total No. of Ways to solve the problem = " + count);

    }
}

// 5.Grid Ways

public class BackTracking {

    public static int GridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == n) {
            return 0;
        }

        int w1 = GridWays(i + 1, j, n, m);
        int w2 = GridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static void main(String args[]) {
        int n = 3, m = 3;
        System.out.println(GridWays(0, 0, n, m));
    }
}

// 6.Sudoku Solver:

public class BackTracking {

    public static boolean isSafe(int Sudoku[][], int row, int col, int digit) {
        // column
        for (int i = 0; i <= 8; i++) {
            if (Sudoku[i][col] == digit) {
                return false;
            }
        }
        // row
        for (int j = 0; j <= 8; j++) {
            if (Sudoku[row][j] == digit) {
                return false;
            }
        }

        // grid=3*3
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (Sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean SudokuSolver(int Sudoku[][], int row, int col) {
        // base case

        if (row == 9 && col == 0) {
            return true;
        }

        // Recursion
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (Sudoku[row][col] != 0) {
            return SudokuSolver(Sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(Sudoku, row, col, digit)) {
                Sudoku[row][col] = digit;
                if (SudokuSolver(Sudoku, nextRow, nextCol)) {
                    return true;
                }
                Sudoku[row][col] = 0;
            }
        }
        return false;

    }

    public static void printSudoku(int Sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int Sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 },

        };

        if (SudokuSolver(Sudoku, 0, 0)) {
            System.out.println("Solution exist");
            printSudoku(Sudoku);
        } else {
            System.out.println("Solution not exist");
        }
    }
}
