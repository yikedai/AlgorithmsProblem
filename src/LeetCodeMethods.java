
public class LeetCodeMethods {
	
	public int[] twoSum(int[] nums, int target) {
		//leetcode 1
		int [] result = new int [2];
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i]+nums[j]==target) {
					result[0]=i;
					result[1]=j;
				}
			}
		}
		return result;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//leetcode 2
		ListNode result = new ListNode();
		int firstNum = 0;
		int secondNum = 0;
		
		int count=1;
		while (l1.next!=null) {
			firstNum+=(l1.val)*count*10;
			count++;
			l1=l1.next;
		}
		
		count=1;
		while (l2.next!=null) {
			secondNum+=(l2.val)*count*10;
			count++;
			l1=l1.next;
		}
		
		int num = firstNum+secondNum;
		ListNode tempNode = new ListNode();
		if(num==0) {
			result.val=0;
		}
		else {
			while (num!=0) {
				result.val=num%10;
				result.next=tempNode;
				tempNode.val=num%10;
				num=num/10;
			}
		}
		return result;
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //leetcode 4
		double result = 0;
		int[] nums3 = new int[nums1.length+nums2.length];
		
		int num1position = 0;
		int num2position = 0;
		int num3position = 0;
		
		while(num1position<nums1.length&&num2position<nums2.length) {
			
			if(nums1[num1position]<nums2[num2position]) {
				nums3[num3position]=nums1[num1position];
				num3position++;
				num1position++;
			}
			else {
				nums3[num3position]=nums2[num2position];
				num3position++;
				num2position++;
			}
		}
		
		while(num1position<nums1.length) {
			nums3[num3position]=nums1[num1position];
			num3position++;
			num1position++;
		}
		
		while(num2position<nums2.length) {
			nums3[num3position]=nums2[num2position];
			num3position++;
			num2position++;
		}
		
		if(nums3.length%2==0) {
			result = ((double)(nums3[(nums3.length)/2]+nums3[(nums3.length)/2+1]))/2;
		}
		else {
			result = nums3[nums3.length/2];
		}
		
		return result;
    }
	
	public int strongPasswordChecker(String password) {
		//leetcode 420
		//need modification on repeating
		int count = 0;
		
		return count;
	}
	
	
	
}
