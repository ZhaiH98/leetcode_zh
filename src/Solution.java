import java.util.Arrays;

class Solution {
    /**
     *[9]回文数（AC）
     */
    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int length = number.length();
        for (int i = 0; i < length; i++) {
            if (number.charAt(i) != number.charAt(length - (i + 1))) {
                return false;
            }
        }
        return true;
    }
    /**
     *[20]有效的括号
     */
    public static boolean isValid(String s) {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == '('){
                num1++;
            }else if(s.charAt(i) == ')'){
                num1--;
            }else if(s.charAt(i) == '{'){
                num2++;
            }else if(s.charAt(i) == '}'){
                num2--;
            }else if(s.charAt(i) == '['){
                num3++;
            }else if(s.charAt(i) == ']'){
                num3--;
            }
        }
        if(num1 != 0){
            return false;
        }
        if(num2 != 0){
            return false;
        }
        if(num3 != 0){
            return false;
        }
        return true;
    }

    /**
     *[35]搜索插入位置（AC）
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if(target <= nums[0]){
            return 0;
        }
        if(target == nums[length - 1]){
            return length -1;
        }
        if(target > nums[length - 1]){
            return length;
        }
        int number = 0;
        for (int i = 0; i < length-1; i++) {
            if(target > nums[i] && target <= nums[i + 1]){
                number = i + 1;
                break;
            }
        }
        return number;
    }
    /**
     * [66]加一(AC)
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        //最后以为不是9，不会发生进位的情况
        if(digits[length - 1] != 9){
            digits[length - 1]++;
            return digits;
        }
        //全部都是9，需要数组增加以为
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            if(digits[i] != 9){
                flag = false;
            }
        }
        if(flag){
            int[] arr=new int[length + 1];
            arr[0] = 1;
            for (int i = 1; i < length + 1; i++) {
                arr[i] = 0;
            }
            return arr;
        }
        //中间会发生进位的情况
        int[] num=new int[length];
        for (int i = 0; i < length; i++) {
            num[i] = 0;
        }
        num[length - 1] = 1;
        for (int i = length - 1 ; i >= 0 ; i--){
            if(digits[i] == 9 && num[i] ==1){
                digits[i] = 0;
                num[i - 1] = 1;
            }else{
                digits[i] = digits[i] + num[i];
            }
        }
        return digits;
    }

    /**
     * [88]合并两个有序数组（AC）
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m ;i < m+n ;i++){
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    /**
     * [202]快乐数（AC）
     */
    public boolean isHappyCheck(int n) {
        String str = String.valueOf(n);
        int length = str.length();
        boolean flag = true;
        for (int i = 1; i < length; i++) {
            if(str.charAt(i) != '0'){
                flag = false;
                break;
            }
        }
        if(str.charAt(0) == '1' && flag){
            return true;
        }
        return false;
    }
    public int change(int n){
        int sum = 0;
        while(n != 0){
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int a = 100;
        while(a != 0){
            if(isHappyCheck(n)){
                return true;
            }else{
                n = change(n);
            }
            a--;
        }
        return false;
    }

    /**
     * main()
     */
    public static void main(String[] args) {
//        isPalindrome(100);
//        isValid("()()()");
    }
}