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
    public boolean isSymmetric(TreeNode root) {
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
}
