
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
	
	public int strongPasswordChecker(String password) {
		//leetcode 420
		//need modification on repeating
		int count = 0;
		if(password.length()<6||password.length()>20) {
			count++;
		}
		
		int upperCaseCount = 0;
		int lowerCaseCount = 0;
		int digitCount = 0;
		
		for(int i=0; i<password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))==true) {
				upperCaseCount++;
			}
			
			if(Character.isLowerCase(password.charAt(i))==true) {
				lowerCaseCount++;
			}
			
			if(Character.isDigit(password.charAt(i))==true) {
				digitCount++;
			}
		}
		
		if(upperCaseCount==0) {
			count++;
		}
		if(lowerCaseCount==0) {
			count++;
		}
		if(digitCount==0) {
			count++;
		}
		
		boolean repeating = false;
		
		if(password.length()>2) {
			for(int i=0; i<password.length()-2; i++) {
				String s = password.substring(i, i+3);
				if(s.charAt(0)==s.charAt(1)&&s.charAt(0)==s.charAt(2)) {
					repeating = true;
					break;
				}
			}
		}
		
		if(repeating==true) {
			count++;
		}
		
		return count;
	}
	
	
	
}
