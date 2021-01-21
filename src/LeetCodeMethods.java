import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
	
	public int myAtoi(String s) {
        //leetcode 8
		int startAt = 0;
		int endWith = 0;
		boolean isDecimal = false;
		int result=0;
		for (int i=0; i<s.length(); i++) {
			if(startAt==0) {
				if(s.charAt(i)=='-'||s.charAt(i)=='+') {
					startAt = i;
				}
				else if(s.charAt(i)=='.') {
					
				}
//				else if() {
//					
//				}
				else {
					return 0;
				}
			}
			else {
				if(isDecimal==false) {
					
				}
				else {
					
				}
			}
			
		}
		
		return 0;
    }
	
	public int maxArea(int[] height) {
        //leetcode 11
		int area = 0;
		for(int i=1; i<height.length; i++) {
			int currentArea = 0;
			for(int j=0; j<i; j++) {
				if(height[i]<=height[j]) {
					currentArea = (i-j)*height[i];
				}
				else {
					currentArea = (i-j)*height[j];
				}
				
				if(currentArea>area) {
					area = currentArea;
				}
				
			}
		}
		
		return area;
    }
	
    public String intToRoman(int num) {
    	//leetcode 12
    	String result = "";
    	
    	
    	
    	return result;
    }
    
    public String longestCommonPrefix(String[] strs) {
    	//leetcode 14
    	String prefix = strs[0];
    	for(int i=1; i<strs.length; i++) {
    		if(prefix.length()>strs[i].length()) {
    			prefix = prefix.substring(0,strs[i].length());
    		}
    		String s = strs[i];
    		while(prefix.length()>0) {
    			if(s.substring(0,prefix.length()).equals(prefix)==false) {
    				prefix = prefix.substring(0, prefix.length()-1);
    			}
    			else {
    				break;
    			}
    		}
    	}
    	
    	return prefix;
    }
	
    public List<List<Integer>> threeSum(int[] nums) {
    	//leetcode 15
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	List<Integer> option = new ArrayList<Integer>();
    	
    	if(nums.length<3) {
    		return new ArrayList<List<Integer>>();
    	}
    	
    	for(int i=0; i<nums.length-2; i++) {
    		for(int j=i+1; j<nums.length-1; j++) {
    			for(int k=j+1; k<nums.length; k++) {
    				if(nums[i]+nums[j]+nums[k]==0) {
    					option.add(nums[i]);
    					option.add(nums[j]);
    					option.add(nums[k]);
    					results.add(option);
    				}
    				option=new ArrayList<Integer>();
    			}
    		}
    	}
    	
    	return results;
    }
    
    public int threeSumClosest(int[] nums, int target) {
    	//leetcode 16
    	int result = 0;
    	int df = Math.abs(nums[0]+nums[1]+nums[2]-target);
    	
    	for(int i=0; i<nums.length-2; i++) {
    		for(int j=i+1; j<nums.length-1; j++) {
    			for(int k=j+1; k<nums.length; k++) {
    				int sum = nums[i]+nums[j]+nums[k];
    				if(Math.abs(sum-target)<=df) {
    					df = Math.abs(sum-target);
    					result = sum;
    				}
    			}
    		}
    	}
    	return result;
    }
    
    public List<String> letterCombinations(String digits) {
        //leetcode 17
    	ArrayList<String> result = new ArrayList<String>();
    	
    	if(digits.length()==0) {
    		return new ArrayList<String>();
    	}
    	
    	if(digits.length()==1) {
    		for(int i=0; i<digits.length(); i++) {
    			result.add(String.valueOf(digits.charAt(i)));
    		}
    		return result;
    	}
    	
    	String[] phone = new String[digits.length()];
    	
    	ArrayList<String> combination = new ArrayList<String>();
    	ArrayList<String> tempList = new ArrayList<String>();
    	
    	for(int i=0; i<digits.length(); i++) {
    		phone[i] = retrieveLetterArray(digits.charAt(i));
    	}
    	
    	for(int i=0; i<phone[0].length(); i++) {
    		tempList.add(String.valueOf(phone[0].charAt(i)));
    	}
    	
    	int position = 1;
    	while(position<phone.length) {
	    	for(int i=0; i<tempList.size(); i++) {
	    		for(int j=0; j<phone[position].length(); j++) {
	    			String s = tempList.get(i)+String.valueOf(phone[position].charAt(j));
	    			combination.add(s);
	    		}
	    	}
	    	tempList = combination;
	    	combination = new ArrayList<String>();
	    	position++;
    	}

    	result = tempList;
    	return result;
    }
    
    public String retrieveLetterArray(char c){
    	String result="";
    	
    	switch(c) {
    	case '2':
    		result = "abc";
    		break;
    	case '3':
    		result = "def";
    		break;
    	case '4':
    		result = "ghi";
    		break;
    	case '5':
    		result = "jkl";
    		break;
    	case '6':
    		result = "mno";
    		break;
    	case '7':
    		result = "pqrs";
    		break;
    	case '8':
    		result = "tuv";
    		break;
    	case '9':
    		result = "wxyz";
    		break;
    	}
    	return result;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //leetcode 18
    	List<List<Integer>> result = new ArrayList();
    	List<Integer> option = new ArrayList<Integer>();
    	for(int i=0; i<nums.length-3; i++) {
    		for(int j=i+1; j<nums.length-2; j++) {
    			for(int k=j+1; k<nums.length-1; k++) {
    				for(int l=k+1; l<nums.length; l++) {
    					int sum = nums[i]+nums[j]+nums[k]+nums[l];
    					if(sum==target) {
        					option.add(nums[i]);
        					option.add(nums[j]);
        					option.add(nums[k]);
        					option.add(nums[l]);
        					result.add(option);
        					option = new ArrayList<Integer>();
        				}
    				}
    			}
    		}
    	}
    	return result;
    }
    
    public boolean isValid(String s) {
    	//leetcode 20
    	
    	int numOfParentheses = 0;
    	int numOfBrackets = 0;
    	int numOfBraces = 0;
    	Stack<String> stack = new Stack<String>();
    	
    	for(int i=0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		String str = String.valueOf(c);
    		
    		if(c=='(') {
    			numOfParentheses++;
    			stack.push(str);
    		}
    		else if(c==')') {
    			numOfParentheses--;
    			if(stack.empty()==true) {
    	    		return false;
    	    	}
    			if(stack.peek().equals("(")) {
    				stack.pop();
    			}
    			else {
    				stack.clear();
    				return false;
    			}
    		}
			else if(c=='[') {
				numOfBrackets++;
				stack.push(str);
			}
			else if(c==']') {
				numOfBrackets--;
				if(stack.empty()==true) {
		    		return false;
		    	}
				if(stack.peek().equals("[")) {
    				stack.pop();
    			}
    			else {
    				stack.clear();
    				return false;
    			}
			}
			else if(c=='{') {
				numOfBraces++;
				stack.push(str);
			}
			else if(c=='}') {
				numOfBraces--;
				
				if(stack.empty()==true) {
					return false;
				}
				
				if(stack.peek().equals("{")) {
    				stack.pop();
    			}
    			else {
    				stack.clear();
    				return false;
    			}
			}
    	}
    	
    	if(stack.empty()==false) {
    		return false;
    	}
    	
    	if(numOfParentheses == 0 && numOfBrackets == 0 && numOfBraces == 0) {
    		return true;
    	}
    	else { 
    		return false;
    	}
    }
    
    public int removeDuplicates(int[] nums) {
        //leetcode 26
    	Set<Integer> set = new HashSet<Integer>();
        
        if(nums.length==0) {
        	return 0;
        }
        
    	for(int i=0; i<nums.length; i++) {
    		set.add(nums[i]);
    	}
    	
    	//System.out.println(set.toArray());
        
        return set.size();
    }
    
    public int removeElement(int[] nums, int val) {
        //leetcode 27
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	for(int i: nums) {
    		if(i!=val) {
    			list.add(i);
    		}
    	}
    	
    	return list.size();
    }
    
    public int strStr(String haystack, String needle) {
        //leetcode 28
    	if(needle.length()>haystack.length()) {
    		return -1;
    	}
    	
    	if(needle.isEmpty()) {
    		return 0;
    	}
    	
    	int needleLength = needle.length();
    	
    	for(int i=0; i<haystack.length()-needleLength; i++) {
    		String str = haystack.substring(i, i+needleLength);
    		if(str.equals(needle)) {
    			return i;
    		}
    	}
    	
    	return -1;
    }
    
    public int divide(int dividend, int divisor) {
        //leetcode 29
    	int result = 0;
    	boolean pOrN = true;//true means result is a positive value
    	if(divisor==0) {
    		return 0;
    	}
    	if((dividend>=0&&divisor<0)||(dividend<0&&divisor>0)) {
    		pOrN = false;
    	}
    	
    	dividend = Math.abs(dividend);
    	divisor = Math.abs(divisor);
    	
    	int add = 0;
    	while(add<=dividend) {
    		add+=divisor;
    		result++;
    	}
    	
    	if(pOrN==false) {
    		result = Math.negateExact(result);
    	}
    	return result;
    }
    
    Set<String> leetcode30 = new HashSet<String>();
    public List<Integer> findSubstring(String s, String[] words) {
    	//leetcode 30
    	List<Integer> result = new ArrayList<Integer>();
    	List<String> combination = permutation(s);
    	
    	
    	
    	
    	return result;
    }
    public ArrayList<String> permutation(String str) { 
	    return permutation("", str); 
	}
	public ArrayList<String> permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	leetcode30.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++) {
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	    ArrayList<String> result = new ArrayList<String>();
	    
	    for(String s: leetcode30) {
	    	result.add(s);
	    }
	    Collections.sort(result);
	    return result;
	}
    
//    public ArrayList<String> randomizedAlgorithmForPermutation(String s){
//    	Set<String> comb = new HashSet<String>();
//    	ArrayList<String> result = new ArrayList<String>();
//    	
//    	int length = s.length();
//    	long number = 1;
//    	for(int i=2; i<=length; i++) {
//    		number*=i;
//    	}
//    	
//    	while(comb.size()<number) {
//    		comb.add(s);
//    		s=swap(s);
//    	}
//    	
//    	for(String str: comb) {
//    		result.add(str);
//    	}
//    	Collections.sort(result);
//    	return result;
//    }
    
    public String swap(String s) {
    	int l = (int)(Math.random()*(s.length()));
    	int r = (int)(Math.random()*(s.length()));
    	while(l==r) {
    		r = (int)(Math.random()*(s.length()));
    	}
    	char [] charArray = s.toCharArray();
    	char temp = charArray[l];
    	charArray[l] = charArray[r];
    	charArray[r] = temp;
    	
    	s = String.valueOf(charArray);
    	return s;
    }
    
    public boolean isValidSudoku(char[][] board) {
    	//leetcode 36
    	if(checkHorizontalSudoku(board)&&checkVerticalSudoku(board)&&checkSquareSudoku(board)) {
    		return true;
    	}
    	
    	return false;
    }
    
    private boolean checkHorizontalSudoku(char[][]board) {
    	for(int i=0; i<9; i++) {
    		Set<String> horizontalLine = new HashSet<String>();
    		for(int j=0; j<9; j++) {
    			horizontalLine.add(String.valueOf(board[i][j]));
    		}
    		if(horizontalLine.size()!=9) {
    			return false;
    		}
    	}
    	return true;
    }
    private boolean checkVerticalSudoku(char[][]board){
    	for(int i=0; i<9; i++) {
    		Set<String> verticalLine = new HashSet<String>();
    		for(int j=0; j<9; j++) {
    			verticalLine.add(String.valueOf(board[j][i]));
    		}
    		if(verticalLine.size()!=9) {
    			return false;
    		}
    	}
    	return true;
    }
    private boolean checkSquareSudoku(char[][]board){
    	for(int i=0; i<9; i+=3) {
    		for(int j=0; j<9; j+=3) {
    			Set<String> square = new HashSet<String>();
        		for(int k=j; k<j+3; k++) {
        			square.add(String.valueOf(board[i][k]));
        			square.add(String.valueOf(board[i+1][k]));
        			square.add(String.valueOf(board[i+2][k]));
        		}
        		if(square.size()!=9) {
        			return false;
        		}
    		}
    	}
    	return true;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        for(int i=0; i<candidates.length; i++) {
        	
        }
        return result;
    }
    
    public int firstMissingPositive(int[] nums) {
        //leetcode 41
    	Arrays.sort(nums);
    	int missing = 1;
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i]==missing) {
    			missing++;
    		}
    	}
    	
    	return missing;
    }
    
    public void rotate(int[][] matrix) {
    	//leetcode 48
    	
    	
    }
    
    public double myPow(double x, int n) {
    	//leetcode 50
    	double result = 1;
    	boolean pOrN = true; //true means positive
    	if(n>0) {
    		pOrN = true;
    	}
    	else if(n==0) {
    		return 1;
    	}
    	else {
    		pOrN = false;
    	}
    	
    	for(int i=0; i<n; i++) {
    		result*=x;
    	}
    	
    	if(pOrN==false) {
    		result = 1/result;
    	}
    	return result;
    }
    
    public int maxSubArray(int[] nums) {
        //leetcode 53
    	int result = 0;
    	int positiveNum = 0;
    	int largestNegative = 0;
    	
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i]>=0) {
    			result+=nums[i];
    			positiveNum++;
    		}
    	}
    	
    	if(positiveNum == 0) {
    		largestNegative = nums[0];
    		for(int i=1; i<nums.length; i++) {
    			if(nums[i]>largestNegative) {
    				largestNegative = nums[i];
    			}
    		}
    		return largestNegative;
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
