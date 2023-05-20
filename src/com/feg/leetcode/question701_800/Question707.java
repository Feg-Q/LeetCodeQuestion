package leetcode.question701_800;

/**
 * @author Feg
 * @version 1.0
 */
public class Question707 {
    // 维护一些链表的属性，比如长度，头尾结点
    private int length;
    private Linked head;
    private Linked right;

    public Question707() {
        // 初始化，头尾指针都指向一个空节点，长度为0
        length = 0;
        head = new Linked();
        right = head;
    }
    public int get(int index) {
        // 如果下标不符合要求，返回-1
        if (index < 0 || index >= length){
            return -1;
        }
        // 指针，用来找到下标index的结点
        Linked temp = head;
        while (index > 0){ // 循环index次
            temp = temp.next;
            index--;
        }
        return temp.val;
    }
    public void addAtHead(int val) {
        // 如果是第一个元素，那就把初始化时候的空节点赋值，尾部添加同理
        if (length == 0){
            head.val = val;
        } else {
            // 先构建一个结点，然后让这个结点的下一个指向头结点，再更新头结点
            Linked temp = new Linked(val);
            temp.next = head;
            head = temp;
        }
        // 注意更新长度
        length++;
    }
    public void addAtTail(int val) {
        if (length == 0){
            head.val = val;
        } else {
            Linked temp = new Linked(val);
            right.next = temp;
            right = temp;
        }
        length++;
    }
    public void addAtIndex(int index, int val) {
        // 如果添加位置等于length，相当于添加到末尾
        if (index == length){
            addAtTail(val);
        } else if (index <= 0){ // 如果添加位置小于等于0，相当于添加到头部
            addAtHead(val);
        } else if (index < length){
            // index符合长度的情况，构建临时结点，循环找到要添加的位置的前一个结点
            Linked temp = head;
            while (index > 1){
                temp = temp.next;
                index--;
            }
            // 构建新节点，让上面找到的结点的下一个指向这个新节点，然后新节点指向下一个
            Linked mid = new Linked(val);
            mid.next = temp.next;
            temp.next = mid;
            // 注意更新长度
            length++;
        }
    }
    public void deleteAtIndex(int index) {
        // index不符合要求，不做任何改变
        if (index < 0 || index >= length){
            return;
        }
        // index为0，相当于删除第一个结点，那就直接让头结点往后移
        if (index == 0){
            head = head.next;
        } else {
            // 其他情况，找到要删除的结点的前一个结点，然后更新下一个指针
            Linked temp = head;
            while (index > 1){
                temp = temp.next;
                index--;
            }
            temp.next = temp.next.next;
            // 这竟然忘了，如果删除的这个结点是尾结点，要更新尾指针
            if (temp.next == null){
                right = temp;
            }
        }
        // 注意更新长度
        length--;
    }
    class Linked{
        public int val;
        public Linked next;
        public Linked(){}
        public Linked(int val){
            this.val = val;
        }
    }
}
