package Problems.Leetcode.Strings;

import Problems.Problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BoggleBoard extends Problem {
    @Override
    public void run() {
        System.out.println("Running Boggle");
        char[][][] grids = {{{'c', 'a', 't'}, {'r', 'r', 'e'}, {'t', 'o', 'n'}},
                {{'o', 'a', 'a'}, {'e', 't', 'a'}, {'i', 'h', 'k'}},
                {{'a', 'b', 'i'}, {'e', 'g', 'a'}, {'r', 'r', 'o'}},
                {{'m', 'o', 'q'}, {'e', 'l', 'z'}, {'z', 'r', 'o'}}};

        String[][] dictionaries =
                {{"cat", "cater", "cartoon", "toon", "moon", "not", "tone", "apple", "ton", "art"},
                        {"oath", "pea", "ate", "the", "iot"},
                        {"ago", "ego", "bear", "gear", "rear", "big", "roar", "rig", "bar"},
                        {"zoo", "zoom", "zoz"}};
        this.execute(grids, dictionaries);
    }

    private void execute(char[][][] grids, String[][] dictionaries) {
        for (int i = 0; i < grids.length; i++) {
            char[][] grid = grids[i];
            HashSet<String> dictionary = new HashSet<String>(Arrays.asList(dictionaries[i]));
            System.out.print("Grid of characters: ");
            StringUtils.gridPrint(grid);
            System.out.println("Dictionary: ");
            StringUtils.arrPrint(dictionary);
            System.out.println("Words: ");
            StringUtils.arrPrint(this.findWords(grid, dictionary));
            System.out.println("Words (Alt): ");
            StringUtils.arrPrint(this.findWordsAlt(grid, dictionary));
        }
    }

    private HashSet<String> findWords(char[][] grid, HashSet<String> dict) {
        HashSet<String> result = new HashSet<>();
        // init the state data
        boolean[][] state = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                this.findWords(grid, dict, state, new StringBuilder(), result, i, j);
            }
        }
        return result;
    }

    private void findWords(char[][] grid, HashSet<String> dict, boolean[][] state, StringBuilder curr,
                           HashSet<String> result, int i, int j) {
        if (dict.contains(curr.toString())) result.add(curr.toString());
        if (!state[i][j]) {
            curr.append(grid[i][j]);
            state[i][j] = true;
            int min_row = Math.max(0, i-1);
            int max_row = Math.min(i+1, grid.length-1);
            int min_col = Math.max(0, j-1);
            int max_col = Math.min(j+1, grid.length-1);
            for (int r = min_row; r <= max_row; r++) {
                for (int c = min_col; c <= max_col; c++) {
                    this.findWords(grid, dict, state, curr, result, r, c);
                }
            }
            state[i][j] = false;
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    class BoggleData {
        char[][] board;
        Set<String> dict;
        boolean[][] state;
        int boardHeight;
        int boardWidth;
        public BoggleData(char[][] board, HashSet<String> dict) {
            this.board = board;
            this.dict = dict;
            this.boardHeight = board.length;
            this.boardWidth = board[0].length;
            this.state = new boolean[boardHeight][boardWidth];
        }
    }

    private HashSet<String> findWordsAlt(char[][] board, HashSet<String> dict) {
        BoggleData boggleData = new BoggleData(board, dict);
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < boggleData.boardHeight; i++) {
            for (int j = 0; j < boggleData.boardWidth; j++) {
                this.findWordsAlt(boggleData, new StringBuilder(), result, i, j);
            }
        }
        return result;
    }

    private void findWordsAlt(BoggleData boggleData, StringBuilder curr, HashSet<String> result, int i, int j) {
        if (boggleData.dict.contains(curr.toString())) result.add(curr.toString());
        if (!boggleData.state[i][j]) {
            curr.append(boggleData.board[i][j]);
            boggleData.state[i][j] = true;
            int min_row = Math.max(0, i-1);
            int max_row = Math.min(i+1, boggleData.boardHeight-1);
            int min_col = Math.max(0, j-1);
            int max_col = Math.min(j+1, boggleData.boardWidth-1);
            for (int r = min_row; r <= max_row; r++) {
                for (int c = min_col; c <= max_col; c++) {
                    this.findWordsAlt(boggleData, curr, result, r, c);
                }
            }
            boggleData.state[i][j] = false;
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
