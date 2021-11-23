package elementaryAlgorithm;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @功能职责:
 * @描述：
 * 1985. 找出数组中的第 K 大整数 显示英文描述
 * 通过的用户数2590
 * 尝试过的用户数3144
 * 用户总通过次数2636
 * 用户总提交次数7517
 * 题目难度Medium
 * 给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
 *
 * 返回 nums 中表示第 k 大整数的字符串。
 *
 * 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = ["3","6","7","10"], k = 4
 * 输出："3"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
 * 其中第 4 大整数是 "3"
 * 示例 2：
 *
 * 输入：nums = ["2","21","12","1"], k = 3
 * 输出："2"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["1","2","12","21"]
 * 其中第 3 大整数是 "2"
 * 示例 3：
 *
 * 输入：nums = ["0","0"], k = 2
 * 输出："0"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["0","0"]
 * 其中第 2 大整数是 "0"
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * 1 <= nums[i].length <= 100
 * nums[i] 仅由数字组成
 * nums[i] 不含任何前导零
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class FindKthLargestInt {
    public String kthLargestNumber(String[] nums, int k) {
        BigDecimal[] arr = new BigDecimal[nums.length];
        for (int i = 0; i < nums.length; i++) {
//            arr[i] = BigDecimal.valueOf(nums[i]);
            arr[i] = new BigDecimal(nums[i]);
        }
        Arrays.sort(arr);
        BigDecimal[] tem = new BigDecimal[nums.length];
        for (int i = arr.length-1; i >= 0 ; i-- ) {
            tem[i] = arr[arr.length-1-i];
        }
        return String.valueOf(tem[k-1]);
    }

    public static void main(String[] args) {
        String[] pam = {"683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"};
        FindKthLargestInt findKthLargestInt = new FindKthLargestInt();
        String result = findKthLargestInt.kthLargestNumber(pam, 3);
        System.out.println(result);
    }
}
