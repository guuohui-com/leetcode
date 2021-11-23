package elementaryAlgorithm;

/**
 * @功能职责:
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        return  this.plusOne(digits,digits.length-1);
    }

    public int[] plusOne(int[] digits,int bit){
        if (digits[bit] == 9 && 0 != bit){
            digits[bit] = 0;
            return plusOne(digits,bit-1);
        }else if(digits[bit] == 9 && 0 == bit){
            int [] tem = new int[digits.length+1];
            tem[0] = 1;
            return tem;
        }
        else {
            digits[bit] += 1;
            return digits;
        }
    }

    public static void main(String[] args) {
        int [] pam = {1,9};
        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(pam);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}

