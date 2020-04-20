//49. 字母异位词

/**
 * 1. HashMap
 * 思路：使用HashMap, KEY存储经过排序后的异位词字符串, VALUE存储异位词List
 * 时间复杂度：(n * K*logK])
 * 空间复杂度：O(n)
 * 执行用时：12ms
 * @param strs
 * @return
 */
public List<List<String>> groupAnagrams(String[] strs) {
	HashMap<String, List<String>> map = new HashMap<>();
	for (String s : strs) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		String temp = String.valueOf(arr);
		if (!map.containsKey(temp)) {
			map.put(temp, new ArrayList<>());
		}
		map.get(temp).add(s);
	}
	return new ArrayList<>(map.values());
}