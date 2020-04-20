//104. 二叉树最大深度

/**
 * 1：DFS递归
 * 思路：每drill down一次, 深度+1, 最后返回左右子树的最大深度即可
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：0ms
 * @param root
 * @return
 */
public int maxDepth1(TreeNode root) {
	if (root == null) return 0;
	int leftDep = maxDepth1(root.left);
	int rightDep = maxDepth1(root.right);
	return Math.max(leftDep, rightDep) + 1;
}

/**
 * 2. 迭代
 * 思路：通过维护一个栈记录每一层的节点, 若当前层节点还存在孩子节点, 下探到下一层, level + 1
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 执行用时：1ms
 * @param root
 * @return
 */
public int maxDepth2(TreeNode root) {
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	int res = 1;
	while (!queue.isEmpty()) {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			TreeNode curr = queue.poll();
			if (curr.left != null) {
				queue.offer(curr.left);
			}
			if (curr.right != null) {
				queue.offer(curr.right);
			}
		}
		res++;
	}
	return res;
}