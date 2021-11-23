package elementaryAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @功能职责:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class MovZeroes {
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int tem= 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 ){
                tem++;
                list.add(nums[i]);
            }
        }
        tem = nums.length-tem;
        for (int i = 0; i < tem; i++) {
            list.add(0);
        }
        for (int i = 0;i < nums.length;i++){
            nums[i] = list.get(i);
        }

    }

    public static void main(String[] args) {
        int [] pam = {0};
        MovZeroes movZeroes = new MovZeroes();
        movZeroes.moveZeroes(pam);

    }
}
