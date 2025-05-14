/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

public class Codec {
    String dfs(TreeNode root) {
    if (root == null) return "N";
    // no leading/trailing spaces on individual tokens
    String left  = dfs(root.left);
    String right = dfs(root.right);
    return root.val + " " + left + " " + right;
}

    TreeNode ddfs(String[] tok, int[] i) {
    if (i[0] >= tok.length) return null;

    // MUST use equals(), not ==
    if (tok[i[0]].equals("N")) {
        i[0]++;
        return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(tok[i[0]++]));
    root.left  = ddfs(tok, i);
    root.right = ddfs(tok, i);
    return root;
}

public String serialize(TreeNode root) {
    String ser = dfs(root);
    return ser;
}

public TreeNode deserialize(String data) {
    if (data.isEmpty()) return null;
    String[] tok = data.split(" ");
    int[] idx = {0};
    TreeNode root = ddfs(tok, idx);
    // optional: verify by serializing again
    //System.out.println(dfs(root));
    return root;
}

}

/*
 * Your Codec object will be instantiated and called as such:
 * Codec ser = new Codec();
 * Codec deser = new Codec();
 * String tree = ser.serialize(root);
 * TreeNode ans = deser.deserialize(tree);
 * return ans;
 */