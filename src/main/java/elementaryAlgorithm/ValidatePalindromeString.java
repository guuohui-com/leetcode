package elementaryAlgorithm;

/**
 * @功能职责:
 * @描述：
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class ValidatePalindromeString {
    public boolean isPalindrome(String s) {
        String res1 = s.toLowerCase();
        char[] pam = res1.toCharArray();
        String pamStr = "";
        for (int i = 0; i < pam.length; i++) {
            if ((pam[i] >= 97 && pam[i] <= 122) || (pam[i] >= 48 && pam[i] <= 57)){
                pamStr += pam[i];
            }
        }
        String dao = "";
        char[] chars = pamStr.toCharArray();
        for (int i = chars.length-1; i >= 0; i--){
            dao += chars[i];
        }
        if (dao.equals(pamStr)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidatePalindromeString validatePalindromeString = new ValidatePalindromeString();
        System.out.println(validatePalindromeString.isPalindrome("0p"));
    }
}
