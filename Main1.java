import java.util.*;

public class Main1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if (root == null) {
            return result;
        }
        while (!queue.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            int levelmax = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                TreeNode top = queue.poll();
                levelmax = Math.max(top.val, levelmax);
                if (top.left != null) {
                    queue2.offer(top.left);
                }
                if (top.right != null) {
                    queue2.offer(top.right);
                }
            }
            result.add(levelmax);
            queue = queue2;
        }
        return result;
    }

    static int preIndex = 0;

    private static TreeNode buildTree(int in[], int pre[], int inStrt, int inEnd) {
        if (inStrt > inEnd)
            return null;

        /*
         * Pick current node from Preorder traversal using preIndex
         * and increment preIndex
         */
        TreeNode tNode = new TreeNode(pre[preIndex++]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.val);

        /*
         * Using index in Inorder traversal, construct left and
         * right subtress
         */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    /* UTILITY FUNCTIONS */

    /*
     * Function to find index of value in arr[start...end]
     * The function assumes that value is present in in[]
     */
    private static int search(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> res;

        int _root_rows = 0;
        int _root_cols = 0;
        _root_rows = Integer.parseInt(in.nextLine().trim());
        _root_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _root = new int[_root_rows][_root_cols];
        for (int _root_i = 0; _root_i < _root_rows; _root_i++) {
            for (int _root_j = 0; _root_j < _root_cols; _root_j++) {
                _root[_root_i][_root_j] = in.nextInt();

            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        TreeNode root = buildTree(_root[0], _root[1], 0, _root_cols - 1);
        res = largestValues(root);
        StringBuilder s = new StringBuilder();
        for (int res_i = 0; res_i < res.size(); res_i++) {
            s.append(res.get(res_i) + " ");
        }
        System.out.println(s.toString());
    }
}
