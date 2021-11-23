package elementaryAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @功能职责: 三分查找(未完成)
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class ThreePointSearch {
    public int search(List<Integer> pam, int target){
        int left = 0,  right = pam.size()-1;
        Collections.sort(pam);
        return this.threePointSearch(left,right,pam,target);
    }
    public int threePointSearch(int left, int right, List<Integer> pam, int target){
        if (target < pam.get(left) || target > pam.get(right)){
            return -1;
        }
        if (left > right){
            return -1;
        }

        int middleLeft = (pam.size()-1)/3, middleRight = (pam.size()-1)*2/3;
        if (pam.get(middleLeft) == target){
            return middleLeft;
        }
        if (pam.get(middleRight) == target){
            return middleRight;
        }
        if (target >= pam.get(left) && target < pam.get(middleLeft)){
            return this.threePointSearch(left,middleLeft,pam,target);
        }
        if (target >= pam.get(middleLeft) && target < pam.get(middleRight)){
            return this.threePointSearch(middleLeft,middleRight,pam,target);
        }
        if (target >= pam.get(middleRight) && target <= pam.get(right)){
            return this.threePointSearch(middleRight,right,pam,target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,7,3,9,4,6,85,2,4,63};
        List<Integer> pam = new ArrayList<>();
        Arrays.stream(arr).forEach(i->pam.add(i));
        ThreePointSearch threePointSearch = new ThreePointSearch();
        System.out.println(threePointSearch.search(pam, 85));
    }
}
