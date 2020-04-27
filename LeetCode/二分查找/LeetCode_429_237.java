//429 N叉树的层序遍历

/**
 * 1. BFS
 * 思路：按层遍历N叉树, 将每一层的节点值添加到res对应该层的数组中
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：4ms
 * @param root
 * @return
 */
public List<List<Integer>> levelOrder1(Node root) {
	List<List<Integer>> res = new ArrayList<>();
	if (root == null) return res;
	Queue<Node> queue = new LinkedList<>();
	queue.offer(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		List<Integer> list = new ArrayList<>();
		while (size-- > 0) {
			Node currNode = queue.poll();
			list.add(currNode.val);
			for (Node n : currNode.children) {
				if (n != null) {
					queue.offer(n);
				}
			}
		}
		res.add(list);
	}
	return res;
}

/**
 * 2. DFS
 * 思路：深度优先遍历N叉树, 将所有节点按照level添加到res对应下标的数组中
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：0ms
 * @param root
 * @return
 */
public List<List<Integer>> levelOrder2(Node root) {
	List<List<Integer>> res = new ArrayList<>();
	dfs(root, res, 0);
	return res;
}

private void dfs(Node root, List<List<Integer>> res, int level) {
	if (root == null) return;
	if (res.size() == level) {
		res.add(new ArrayList<>());
	}
	res.get(level).add(root.val);
	if (root.children == null) return;
	for (Node n : root.children) {
		dfs(n, res, level + 1);
	}
}
