package elementaryAlgorithm;

/**
 * @功能职责 查找单链表的倒数第n个节点
 * @描述 首先定义p ，q 两个指针，q指针向后移动k-1次，此时p 和 q相距 k，
 *       此时p,q同时向后移动，而p，q的距离仍然为k, 当q指向尾结点时候，p刚好指向倒数第k个节点。
 *       平均时间复杂度 O(n), 最坏时间复杂度是O(n)
 *       空间复杂度是 O(1),仅需借助两个局部变量
 * @作者 郭辉
 * @创建时间 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
class LNode {
    private Object data; //数据域
    private LNode next; //指针域

    public LNode() {
        this.data=null;
        this.next=null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LNode getNext() {
        return next;
    }

    public void setNext(LNode next) {
        this.next = next;
    }

}

/**
 * @author guohui
 * 链表类
 * */
class LinkList {
    private LNode p;//链表的节点成员

    public LinkList() {
        this.p = new LNode();
    }
    public LNode getP() {
        return p;
    }
    public void setP(LNode p) {
        this.p = p;
    }
}

/**
 * @author guohui
 * 查找算法类
 * */
public class Find {
    /**
     * 查找链表中倒数第k个节点
     * @param linkList
     * @param k
     * @return LNode
     * @描述 首先定义p ，q 两个指针，q指针向后移动k-1次，此时p 和 q相距 k，
     * 此时p,q同时向后移动，而p，q的距离仍然为k, 当q指向尾结点时候，p刚好指向倒数第k个节点。
     * 平均时间复杂度 O(n), 最坏时间复杂度是O(n)
     * 空间复杂度是 O(1),仅需借助两个局部变量
     */
    public LNode findBackK(LinkList linkList, int k) {
        LNode p = linkList.getP(); //标记头节点
        LNode q = p; //标记下一个节点
        int count = 1;
        while (q.getNext() != null) {//统计链表中共有多少节点，避免k过大出现异常
            q = q.getNext();
            count++;
        }
        if(k < 1){ //校验k是否大于1
            throw new RuntimeException("k需要大于等于1");
        }
        if (count < k) { // 校验k 是否超出范围
            throw new RuntimeException("链表中共" + count + "个节点（包括头结点），无法找到倒数第" + k +"个节点");
        }
        if (count == k){
            throw new RuntimeException("倒数第"+ k +"个节点是头结点");
        }
        q = p;//q指针回到头结点
        for (int i = 1; i < k; i++) { //q指针向后移动k-1次
            q = q.getNext();
        }
        while (q.getNext() != null){//p,q同时向后移动，当q指向尾结点时候p刚好指向倒数第k个节点
            q = q.getNext();
            p = p.getNext();
        }
        return p;
    }

    /**
     * 控制台输出链表
     * @param linkList
     */
    public void show(LinkList linkList){
        LNode p = linkList.getP();
        System.out.print("头结点");
        while (p.getNext() != null){
            p = p.getNext();
            System.out.print("->" + p.getData());
        }
    }

    public static void main(String[] args) {
        //初始化一个11个节点的单链表（包含头结点）
        LinkList list = new LinkList();
        LNode t = list.getP();
        for (int i = 0; i < 10; i++) {
            LNode node = new LNode();
            node.setData(i);
            t.setNext(node);
            t=t.getNext();
        }
        Find find = new Find();
        //输出新建链表
        System.out.println("=================链表================");
        find.show(list);
        System.out.println("\n===============test start=====================");
        /**
         * 测试用例1: 倒数第0个节点
         * 期望结果: RuntimeException: k需要大于等于1
         * */
        LNode n0 = find.findBackK(list,0);
        System.out.println("倒数第0个节点data域："+n0.getData());
        /**
         * 测试用例2: 倒数第6个节点
         * 期望结果: 倒数第6个节点data域：6
         * */
        LNode n6 = find.findBackK(list, 6);
        System.out.println("倒数第6个节点data域："+n6.getData());
        /**
         * 测试用例3: 倒数第8个节点
         * 期望结果: 倒数第8个节点data域：8
         * */
        LNode n8 = find.findBackK(list, 8);
        System.out.println("倒数第8个节点data域："+n8.getData());
        /**
         * 测试用例4: 倒数第11个节点
         * 期望结果: 倒数第11个节点data域： null
         * */
        LNode n11 = find.findBackK(list, 11);
        System.out.println("倒数第11个节点data域："+n11.getData());
        /**
         * 测试用例4: 倒数第12个节点
         * 期望结果: 倒数第12个节点data域：12
         * */
        LNode n12 = find.findBackK(list, 12);
        System.out.println("倒数第12个节点data域："+n12.getData());
        System.out.println("===================test end==================");
    }
}


