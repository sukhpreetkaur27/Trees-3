import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// LC 101
public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Check if left subtree and right subtree are symmetric.
     * <p>
     * TC: O(n)
     * SC: O(h) or O(n) for skewed tree
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_dfs(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            // compare left and right subtrees i.e. opposite trees of p and q
            return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }
        return false;
    }

    /**
     * BFS == Compare Pairs
     * <p>
     * TC: O(n)
     * SC: O(nodes in the last level)
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_bfs(TreeNode root) {
        // NOTE: doesn't work with ArrayDeque as Deque doesn't allow null values
        // So, use Queue with LinkedList
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            // compare pairs
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                // fine == symmetric
                continue;
            }
            if (p != null && q != null) {
                if (p.val != q.val) {
                    // not symmetric
                    return false;
                }
                // compare left and right subtrees i.e. opposite trees of p and q
                // add alternate pairs to compare
                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(p.right);
                queue.offer(q.left);
            } else {
                return false;
            }
        }
        return true;
    }
}
