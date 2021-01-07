
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
			result = ((double)(nums3[(nums3.length)/2]+nums3[(nums3.length)/2-1]))/2;
		}
		else {
			result = nums3[nums3.length/2];
		}
		
		return result;
    }
	
	public String longestPalindrome(String s) {
        //leetcode 5
		String result = "";
		int substringLength = 0;
		
		if(isPalindrome(s)==true) {
			return s;
		}
		else {
			for(int i=0; i<s.length(); i++) {
				for(int j=s.length(); j>i; j--) {
					String sub = s.substring(i, j);
					if(isPalindrome(sub)==true) {
						if(substringLength < sub.length()) {
							result = sub;
							substringLength = sub.length();
							break;
						}
					}
				}
			}
		}
		
		return result;
    }
	
	private boolean isPalindrome(String s) {
		boolean result = false;
		for(int i=0; i<(s.length()/2); i++) {
			if(s.charAt(i)==s.charAt(s.length()-1-i)) {
				result = true;
			}
			else {
				return false;
			}
		}
		return result;
	}
	
	public String convert(String s, int numRows) {
		//leetcode 6
		String result = "";
		char [] arrayOfS = s.toCharArray();
		
		int numOfChar = arrayOfS.length;
		int unit = 2*numRows-2;
		int numColumn = 0;
		
		if(numOfChar%(unit)<=numRows) {
			numColumn = (numOfChar/unit)*(numRows-1)+1;
		}
		else {
			numColumn = (numOfChar/unit)*(numRows-1)+1+numOfChar%(unit)-numRows;
		}
		
		char [][] twoDimensionArray = new char [numRows][numColumn];
		
		int rowPosition = 0;
		int columnPosition = 0;
		
		int charPosition = 0;
		while (charPosition<numOfChar) {
			twoDimensionArray[rowPosition][columnPosition] = s.charAt(charPosition);
			if((charPosition%unit)<numRows) {
				if(rowPosition<(numRows-1)) {
					rowPosition++;
				}
				else {
					rowPosition--;
					columnPosition++;
				}
			}
			else {
				rowPosition--;
				columnPosition++;
			}
			charPosition++;
		}
		
		for (int i=0; i<numRows; i++) {
			for(int j=0; j<numColumn; j++) {
				if(twoDimensionArray[i][j]==0) {
					twoDimensionArray[i][j]=' ';
				}
				result += twoDimensionArray[i][j];
			}
			result += "\n";
		}		
		return result;
    }
	
	public int reverse(int x) {
		//leetcode 7
		String indicator = "";
		if(x<0) {
			indicator = "-";
		}
		
		String s = indicator+reverseString(String.valueOf(Math.abs(x)));
		int result = Integer.parseInt(s);
		return result;
    }
	
	private String reverseString(String s) {
		String result = "";
		for (int i=s.length()-1; i>=0; i--) {
			result += s.charAt(i);
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
