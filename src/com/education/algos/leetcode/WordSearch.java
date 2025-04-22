package com.education.algos.leetcode;

public class WordSearch {
    boolean[][] used;

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{{'a', 'a', 'b', 'a', 'a', 'b'}, {'a', 'a', 'b', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a', 'b', 'a'},
                {'b', 'a', 'b', 'b', 'a', 'b'}, {'a', 'b', 'b', 'a', 'b', 'a'}, {'b', 'a', 'a', 'a', 'a', 'b'}}, "bbbaabbbbbab"));
        System.out.println(new WordSearch().exist(new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}}, "abcced"));
        System.out.println(new WordSearch().exist(new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}}, "see"));
        System.out.println(new WordSearch().exist(new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}}, "abcb"));
        System.out.println(new WordSearch().exist(new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'e', 's'}, {'a', 'd', 'e', 'e'}}, "abcefsadeese"));
        System.out.println(new WordSearch().exist(new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'e', 's'}, {'a', 'd', 'e', 'e'}}, "aaaaaaaaaaaaa"));
        System.out.println(new WordSearch().exist(new char[][]{{'a', 'b', 'e'}, {'b', 'c', 'd'}}, "abcdeb"));
        System.out.println(new WordSearch().exist(new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'e', 's'}, {'a', 'd', 'e', 'e'}}, "abceseeefs"));
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length, columns = board[0].length;
        char[] chars = word.toCharArray();
        char c = chars[0];
        used = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (c == board[i][j] && check(i, j, 0, board, chars)) return true;
            }
        }
        return false;
    }

    private boolean check(int i, int j, int pos, char[][] board, char[] word) {
        if (pos == word.length) return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] || word[pos] != board[i][j]) {
            return false;
        }
        used[i][j] = true;
        if (check(i + 1, j, pos + 1, board, word) || check(i - 1, j, pos + 1, board, word) || check(i, j + 1, pos + 1, board, word) || check(i, j - 1, pos + 1, board, word))
            return true;
        used[i][j] = false;
        return false;
    }
//    public boolean exist(char[][] board, String word) {
//        char[] chars = word.toCharArray();
//        if (chars.length > board.length * board[0].length) return false;
//        if (chars.length == 1) {
//            for (char[] row : board) {
//                for (char c : row) {
//                    if (c == word.charAt(0)) return true;
//                }
//            }
//            return false;
//        }
//        Map<Integer, Node> cache = buildGraph(board);
//        char start = chars[0];
//        for (int j = 0; j < board.length; j++) {
//            for (int k = 0; k < board[0].length; k++) {
//                char cur = board[j][k];
//                if (cur == start) {
//                    Node n = cache.get(getKey(j, k));
//                    boolean f = check(n, chars);
//                    if (f) return true;
//                    cache.values().forEach(v -> v.used = false);
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean check(Node start, char[] word) {
//        Stack<Node> stack = new Stack<>();
//        stack.push(start);
//        int i = 0;
//        boolean f = true;
//        do {
//            Node node = stack.pop();
//            node.used = true;
//            if (f && ++i == word.length) {
//                return true;
//            }
//            f = false;
//            for (Node n : node.neighbours) {
//                if (!n.used && n.value == word[i]) {
//                    n.prev = node;
//                    if (!stack.contains(n))stack.push(n);
//                    f = true;
//                }
//            }
//            if (!f && !stack.isEmpty()) {
//                Node n1 = stack.peek();
//                while (node != null && n1.prev.value != node.prev.value) {
//                    node.used = false;
//                    node = node.prev;
//                    i--;
//                }
//                if (node != null) node.used = false;
//            }
//        } while (!stack.isEmpty());
//        return false;
//    }
//
//    private Map<Integer, Node> buildGraph(char[][] board) {
//        int length = board.length, height = board[0].length;
//        Map<Integer, Node> cache = new HashMap<>();
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < height; j++) {
//                int key = getKey(i, j);
//                Node n = cache.get(key);
//                if (n == null) {
//                    n = new Node(board[i][j], i, j);
//                    cache.put(key, n);
//                }
//                List<Node> neighbours = n.neighbours;
//                int left = i - 1, up = j - 1, right = i + 1, down = j + 1;
//                boolean l = left >= 0, r = right < length, u = up >= 0, d = down < height;
//                if (l) {
//                    neighbours.add(getNode(board, left, j, cache));
//                }
//                if (r) {
//                    neighbours.add(getNode(board, right, j, cache));
//                }
//                if (d) {
//                    neighbours.add(getNode(board, i, down, cache));
//                }
//                if (u) {
//                    neighbours.add(getNode(board, i, up, cache));
//                }
//            }
//        }
//        return cache;
//    }
//
//    private Node getNode(char[][] board, int i, int j, Map<Integer, Node> map) {
//        int key = getKey(i, j);
//        Node node = map.get(key);
//        if (node == null) {
//            node = new Node(board[i][j], i, j);
//            map.put(key, node);
//        }
//        return node;
//    }
//
//    private int getKey(int i, int j) {
//        return Objects.hash(i, j);
//    }
//
//    static class Node {
//        boolean used;
//        char value;
//        int i, j;
//        Node prev;
//        List<Node> neighbours;
//
//        public Node(char value, int i, int j) {
//            this.used = false;
//            this.neighbours = new ArrayList<>();
//            this.value = value;
//            this.i = i;
//            this.j = j;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof Node)) return false;
//            Node node = (Node) o;
//            return i == node.i && j == node.j;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(i, j);
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "used=" + used +
//                    ", value=" + value +
//                    ", i=" + i +
//                    ", j=" + j +
//                    '}';
//        }
//    }
}
