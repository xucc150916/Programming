/**
 * 给定一个二维数组，里面存放着字母，再给一个单词，判断从这个二维数组里的单词能否拼成这个单词
 * 这个词可以用相邻的字母来构造，相邻指的是水平的或垂直的单词。同一个字母不可以被多次使用
 */

public class WordSearch {

    public static void main(String[] args) {
        char[][] arr = {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'},
        };
        System.out.println(exist(arr, "AAB"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        if (word == null) {
            return true;
        }

        // visited二维数组标记哪一块走过了
        boolean[][] visited = new boolean[board.length][board[0].length];
        // boolean默认值为false，所以这里，不用对visited进行初始化
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                visited[i][j] = false;
//            }
//        }

        // 从board任意地点开始递归
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(existCore(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean existCore(char[][] board, String word, int rowIndx, int colIndex, int wordIndex, boolean[][] visited) {
        // word所有字母都匹配完成
        if(wordIndex >= word.length()) {
            return true;
        }

        // board越界或者该块走过
        if(rowIndx<0 || rowIndx>=board.length || colIndex<0 || colIndex>=board[0].length || visited[rowIndx][colIndex]==true) {
            return false;
        }

        // 标记该点走过
        visited[rowIndx][colIndex] = true;
        boolean result = false;
        // 本次字母匹配成功，递归相邻字符
        if(board[rowIndx][colIndex] == word.charAt(wordIndex)) {
            result =  existCore(board, word, rowIndx, colIndex+1, wordIndex+1, visited)
                    || existCore(board, word, rowIndx, colIndex-1, wordIndex+1, visited)
                    || existCore(board, word, rowIndx+1, colIndex, wordIndex+1, visited)
                    || existCore(board, word, rowIndx-1, colIndex, wordIndex+1, visited);
        }

        visited[rowIndx][colIndex] = false;
        return result;

    }
}
