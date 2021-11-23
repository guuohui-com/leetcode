package elementaryAlgorithm;

/**
 * @功能职责:
 * @描述：
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class IntegerInversion {
    public int reverse(int x) {
        String str = String.valueOf(x);
        char[] pam = str.toCharArray();
        String result = "";
        long res = 0 ;
        if (x>=0){
            for (int i = str.length()-1; i>=0 ; i--){
                result += pam[i];
            }
            res = Long.valueOf(result);
            if (res > (Math.pow(2,31)) - 1 ){
                return 0;
            }
        }else {
            for (int i = str.length()-1; i>=1; i--){
                result += pam[i];
            }
            res = (0 - Long.valueOf(result));
            if (res < (0 - Math.pow(2,31))){
                return 0;
            }
            result = "-"+result;
        }
        return Integer.valueOf(result);
    }

    public static void main(String[] args) {
        IntegerInversion integerInversion = new IntegerInversion();
        System.out.println(integerInversion.reverse(-2147483412));
    }
}
