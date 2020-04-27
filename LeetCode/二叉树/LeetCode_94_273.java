//94 二叉树的中序遍历

/**
 * 1. DFS递归
 * 思路：左 根 右
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：0ms
 * @param root
 * @return
 */
List<Integer> res = new ArrayList<>();
public List<Integer> inorderTraversal(TreeNode root) {
	if (root != null) {
		res.add(root.val);
		inorderTraversal(root.left);
		inorderTraversal(root.right);
	}
	return res;
}

/**
 * 2. 迭代
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 执行用时：1ms
 * @param root
 * @return
 */
public List<Integer> inorderTraversal2(TreeNode root) {
	List<Integer> res = new ArrayList<>();
	Stack<TreeNode> stack = new Stack<>();
	while (!stack.isEmpty() || root != null) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		TreeNode curr = stack.pop();
		res.add(curr.val);
		root = curr.right;
	}
	return res;
}