import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemsSolved {
    /* Question 1 out of 10
    Write a function that reverses a string. The input string is given as an array of characters char[].

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    You may assume all the characters consist of printable ascii characters.
     */
    public void reverseString(char[] s) {
        int left=0, right=s.length-1;
        while(left<right){
            char tmp=s[left];
            s[left++]=s[right];
            s[right--]=tmp;
        }

    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    /* Question 2 out of 10
    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Note: A leaf is a node with no children.
     */
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        else{
            int lDepth=maxDepth(root.left);
            int rDepth=maxDepth(root.right);
            if(lDepth>rDepth)
                return (lDepth+1);
            else
                return (rDepth+1);
        }

    }
    /* Question 3 out of 10
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1
     */
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null || num.length==0) return null;
        return buildTree(num, 0, num.length-1);
    }
    public TreeNode buildTree(int[] num, int start, int end) {
        int middle = (start+end)/2;
        int rootval = num[middle];
        TreeNode root = new TreeNode(rootval);
        if(start<middle) root.left=buildTree(num, start, middle-1);
        if(middle<end) root.right=buildTree(num,middle+1,end);
        return root;
    }
    /* Question 4 out of 10
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     */
    public int singleNumber(int[] nums) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        for(int i: nums){
            if(!a.contains(i)){
                a.add(i);
            }else{
                a.remove(new Integer(i));
            }
        }
        return a.get(0);

    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /* Question 5 out of 10
    Write a function to delete a node (except the tail) in a singly linked list, given only access to that node
     */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;

    }
    /* Question 6 out of 10
    Reverse a singly linked list
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;

    }

    /* Question 7 out of 10
    Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
     */
    public List<String> fizzBuzz(int n) {
        // ans list
        List<String> ans = new ArrayList<String>();

        for (int num = 1; num <= n; num++) {

            boolean divisibleBy3 = (num % 3 == 0);
            boolean divisibleBy5 = (num % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                // Divides by both 3 and 5, add FizzBuzz
                ans.add("FizzBuzz");
            } else if (divisibleBy3) {
                // Divides by 3, add Fizz
                ans.add("Fizz");
            } else if (divisibleBy5) {
                // Divides by 5, add Buzz
                ans.add("Buzz");
            } else {
                // Not divisible by 3 or 5, add the number
                ans.add(Integer.toString(num));
            }
        }

        return ans;
    }
    /* Question 8 out of 10
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    /* Question 9 out of 10
        Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     */
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }





    }
    /* Question 10 out of 10
    Say you have an array prices for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
     */
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;


    }



}
