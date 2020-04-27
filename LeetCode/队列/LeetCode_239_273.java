//239 滑动窗口最大值

/**
 * 2. 双端队列
 * 思路：维护一个双端队列, 保证队列头部一定是当前窗口中的最大值idx
 * 遍历到一个新的idx的时候, poll队列中不在窗口范围中的idx, 然后比较nums[idx]和deque.peekLast(), 如果队列末尾元素比当前idx对应的数小, 那么poll
 * 由于入队出队都是在O(1)的时间复杂度下完成, 因此算法时间复杂度是线性的
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 执行用时：15ms
 * @param nums
 * @param k
 * @return
 */
public int[] maxSlidingWindow2(int[] nums, int k) {
	if (nums.length == 0 || nums == null) return new int[0];
	Deque<Integer> deque = new ArrayDeque<>();
	int[] temp = new int[nums.length - k + 1];
	int n = 0;
	for (int i = 0; i < nums.length; i++) {
		while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
			deque.pollFirst();
		}
		while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
			deque.pollLast();
		}
		deque.offerLast(i);
		if (i >= k - 1) {
			temp[n++] = nums[deque.peekFirst()];
		}
	}
	return temp;
}