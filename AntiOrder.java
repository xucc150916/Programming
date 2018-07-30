/**
 * 求数组中逆数对的个数
 */

public class AntiOrder {

    Node root = null;

    public int count(int[] A, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += helper(A[i]);
        }
        return res;
    }

    public int helper(int n) {
        if (this.root == null) {
            root = new Node(n);
            return 0;
        } else {
            root.insert(n);
            return root.getRank(n);
        }
    }

}

/**
 * leftSize代表比value大的节点的个数
 */
class Node {

    int leftSize = 0;
    Node left, right;
    int value;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 将比自己大的节点放到前面，leftSize++，比自己小的，放到自己后面
     * @param val
     */
    public void insert(int val) {

        if (val > this.value) {
            if (left != null) {
                left.insert(val);
            } else {
                left = new Node(val);
            }
            leftSize++;
        } else {
            if (right != null) {
                // 调用后面的节点的排序，随时保持leftSize的更新
                right.insert(val);
            } else {
                right = new Node(val);
            }
        }
    }

    public int getRank(int val) {
        if (val == this.value) {
            return leftSize;
        } else if (val > this.value) {
            return left.getRank(val);
        } else {
            return leftSize + 1 + right.getRank(val);
        }
    }


}
package com.xucc.每日一题.七月三十日;

/**
 * 求数组中逆数对的个数
 */

public class AntiOrder {

    Node root = null;

    public int count(int[] A, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += helper(A[i]);
        }
        return res;
    }

    public int helper(int n) {
        if (this.root == null) {
            root = new Node(n);
            return 0;
        } else {
            root.insert(n);
            return root.getRank(n);
        }
    }

}

/**
 * leftSize代表比value大的节点的个数
 */
class Node {

    int leftSize = 0;
    Node left, right;
    int value;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 将比自己大的节点放到前面，leftSize++，比自己小的，放到自己后面
     * @param val
     */
    public void insert(int val) {

        if (val > this.value) {
            if (left != null) {
                left.insert(val);
            } else {
                left = new Node(val);
            }
            leftSize++;
        } else {
            if (right != null) {
                // 调用后面的节点的排序，随时保持leftSize的更新
                right.insert(val);
            } else {
                right = new Node(val);
            }
        }
    }

    public int getRank(int val) {
        if (val == this.value) {
            return leftSize;
        } else if (val > this.value) {
            return left.getRank(val);
        } else {
            return leftSize + 1 + right.getRank(val);
        }
    }


}
