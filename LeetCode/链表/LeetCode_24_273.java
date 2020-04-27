//24. 两两交换链表中的节点

/**
 * 1. 递归
 * 思路：例如"1->2->3->4->NULL"这么个链表, 只需要将节点1指向swap(3), 此时结构为1->4->3->NULL + 2->4, 将节点2指向节点1即可
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 执行用时：1ms
 * @param head
 * @return
 */
public ListNode swapPairs(ListNode head) {
	if (head == null || head.next == null) return null;
	ListNode headNext = head.next;
	head.next = swapPairs(headNext);
	headNext.next = head;
	return headNext;
}