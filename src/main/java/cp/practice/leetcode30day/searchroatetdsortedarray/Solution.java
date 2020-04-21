package cp.practice.leetcode30day.searchroatetdsortedarray;

class Solution {

	public int search(int[] nums, int target) {
		return search(nums, 0, nums.length-1, target);
	}

	static int search(int nums[], int l, int h, int target) {
		if (l > h)
			return -1;

		int mid = (l + h) / 2;
		if (nums[mid] == target)
			return mid;

		if (nums[l] <= nums[mid]) {
			if (target >= nums[l] && target <= nums[mid])
				return search(nums, l, mid - 1, target);

			return search(nums, mid + 1, h, target);
		} else {

			if (target >= nums[mid] && target <= nums[h])
				return search(nums, mid + 1, h, target);

			return search(nums, l, mid - 1, target);
		}
	}
}