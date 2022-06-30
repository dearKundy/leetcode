import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 1. 为什么要使用双向链表
 * 2. 为什么node节点还要存储key
 */
public class LRUCache {

    static class DLinkedNode {
        private int key;
        private int value;
        private DLinkedNode pre;
        private DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    /**
     * 缓存
     */
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head = new DLinkedNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
    private DLinkedNode tail = new DLinkedNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        DLinkedNode dLinkedNode = cache.get(key);
        // 移到表头
        this.moveToHead(dLinkedNode);

        return dLinkedNode.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            DLinkedNode dLinkedNode = cache.get(key);
            dLinkedNode.value = value;
            // 移到表头
            this.moveToHead(dLinkedNode);
        } else {
            // 插入缓存
            DLinkedNode tmpNode = new DLinkedNode(key, value);
            cache.put(key, tmpNode);

            // 插入表头
            this.insertHead(tmpNode);

            // 如果满了，清除表尾
            if (cache.size() > capacity) {
                this.delTail();
            }
        }

    }

    private void moveToHead(DLinkedNode dLinkedNode) {

        // 删除节点
        this.delNode(dLinkedNode);
        // 表头插入节点
        this.insertHead(dLinkedNode);

    }

    private void delNode(DLinkedNode dLinkedNode) {
        dLinkedNode.pre.next = dLinkedNode.next;
        dLinkedNode.next.pre = dLinkedNode.pre;
    }

    private void delTail() {
        DLinkedNode tmpTailPre = tail.pre;

        this.delNode(tmpTailPre);

        int key = tmpTailPre.key;

        cache.remove(key);
    }

    private void insertHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void printAsc() {
        DLinkedNode tmpHead = head;

        while (tmpHead != null) {
            System.out.println(tmpHead.key);
            tmpHead = tmpHead.next;
        }
    }

    private void printDesc() {
        DLinkedNode tmpTail = tail;
        while (tmpTail != null) {
            System.out.println(tmpTail.key);
            tmpTail = tmpTail.pre;
        }
    }

    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.get(1);    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.get(2);    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.get(1);    // 返回 -1 (未找到)
//        lRUCache.get(3);    // 返回 3
//        lRUCache.get(4);    // 返回 4

        LRUCache lRUCache = new LRUCache(2);


        DLinkedNode insertNode = new DLinkedNode(1, 1);
        lRUCache.insertHead(insertNode);

        DLinkedNode insertNode2 = new DLinkedNode(2, 2);
        lRUCache.insertHead(insertNode2);

        DLinkedNode insertNode3 = new DLinkedNode(3, 2);
        lRUCache.insertHead(insertNode3);

        lRUCache.delTail();

        lRUCache.printAsc();
    }

}