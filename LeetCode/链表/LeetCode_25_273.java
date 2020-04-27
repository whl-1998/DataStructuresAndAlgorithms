//25. K个一组翻转链表

/**
 * 1. 递归
 * 思路：遍历链表到第K + 1个节点, 如果之前遍历的链表有K个节点就进行交换：
 * 交换时, head.next指向交换之后返回的第K个节点temp, head作为新的temp, head.next作为新的head继续进行交换k次
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：0ms
 * @param head
 * @param k
 * @return
 */
public ListNode reverseKGroup(ListNode head, int k) {
	if (head == null || head.next == null) {
		return head;
	}
	ListNode curr = head;
	int count = 0;
	while (curr != null && count != k) {
		curr = curr.next;
		count++;
	}
	if (count == k) {
		ListNode temp = reverseKGroup(curr, k);
		while (count-- != 0) {
			ListNode headNext = head.next;
			head.next = temp;
			temp = head;
			head = headNext;
		}
		head = temp;
	}
	return head;
}