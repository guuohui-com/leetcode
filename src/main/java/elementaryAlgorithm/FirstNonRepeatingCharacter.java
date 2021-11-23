package elementaryAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @功能职责:
 * @描述：
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class FirstNonRepeatingCharacter {
    private List<Map<Integer,Integer>> list;
    private int result = Integer.MAX_VALUE;
    public int firstUniqChar(String s) {
        list = new ArrayList<>(26);
        for (int i = 0; i < 26; i++){
            Map<Integer,Integer> map = new HashMap<>();
            map.put(Integer.MAX_VALUE,0);
            list.add(map);
        }
        char[] pam = s.toCharArray();
        int[] array = new int[26];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        for (int i = 0; i < pam.length; i++) {
            Map<Integer,Integer> map = new HashMap<>();
//            System.out.println(pam[i]%'a');
            if (null == list.get(pam[i]%'a').get(array[pam[i]%'a'])){
                map.put(i,1);
            }else{
                map.put(i,list.get(pam[i]%'a').get(array[pam[i]%'a'])+1);
            }
            list.set(pam[i]%'a',map);
            array[pam[i]%'a'] = i;
        }
        List<Map<Integer,Integer>> resList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (Integer key:list.get(i).keySet()) {
                if (list.get(i).get(key) == 1 && key<result){
                   result = key;
                }
            }
        }
        if (result == Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        System.out.println("结果"+firstNonRepeatingCharacter.firstUniqChar("loveleetcode"));
    }
}
