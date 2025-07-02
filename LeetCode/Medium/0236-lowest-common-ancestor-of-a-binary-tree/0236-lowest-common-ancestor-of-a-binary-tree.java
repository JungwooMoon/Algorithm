import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.offer(root);
        
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val == p.val) {
                if (isancestor(cur.left, q) || isancestor(cur.right, q)) return cur;    
            }

            if (cur.val == q.val) {
                if (isancestor(cur.left, p) || isancestor(cur.right, p)) return cur; 
            }

            if (isancestor(cur.left, p) && isancestor(cur.right, q)) { return cur; }
            if (isancestor(cur.left, q) && isancestor(cur.right, p)) return cur;
            
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right); 
        }
        return root;
    }

    public boolean isancestor(TreeNode current, TreeNode to) {
        if (current == null) return false;

        if (current.val == to.val) return true;

        return (isancestor(current.left, to)) || (isancestor(current.right, to));
    }
}