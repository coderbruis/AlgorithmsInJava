# 用Java实现算法和数据结构

本项目主要用于自己在工作之余记录用Java实现的算法和数据结构的源码；同时还会记录自己刷leetcode的题解思路等；

> Tip：如果读者电脑无法浏览到github图片，则需要设置hosts配置文件, 解决办法：
[解决方案](https://zhuanlan.zhihu.com/p/107691233)

# 经典排序算法

✅  [冒泡排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)  

✅  [选择排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)

✅  [插入排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)

✅  [插入排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)

✅ [归并排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md) 

✅ [快速排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)

✅ [希尔排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)

✅ [桶排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E6%A1%B6%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md) 

✅ [基数排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)

✅ [堆排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%A0%86%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md) 

## 排序算法总结

| 排序名  |  平均时间复杂度   |    空间复杂度     |  优势  |  劣势  |           适用场景            | 稳定性  |
| :--: | :------: | :----------: | :--: | :--: | :-----------------------: | :--: |
| 冒泡排序 |  O(n^2)  |     O(1)     |      |      |                           |  稳定  |
| 插入排序 |  O(n^2)  |     O(1)     |      |      |                           |  稳定  |
| 计数排序 |  O(n + k) |     O(M)     |      |      | 对于用例少的数据，比如对人的年龄排序或者身高排序。 |  稳定  |
| 基数排序 | O(d(n+r)) |     O(M)     |      |      |                           |  稳定  |
| 桶排序  |  O(n+k) | O(n + k)  |      |      |                           |  稳定  |
| 选择排序 |  O(n^2)  |     O(1)     |      |      |                           | 不稳定  |
| 归并排序 | O(nlogn) |     O(N)     |      |      |                           |  稳定  |
| 快速排序 | O(nlogn) | O(logn)~O(n) |      |      |                           | 不稳定  |
| 希尔排序 | O(nlogn) |     O(1)     |      |      |                           | 不稳定  |
| 堆排序  | O(nlogn) |     O(1)     |      |      |                           | 不稳定  |

注意这里总结的都是平均时间复杂度。

例如插入排序，如果是有序的数组，则时间复杂度会退化成O(n)。而快速排序，对于每次选择的p位置都是末尾位置，则会退化成时间复杂度为O(n^2)（通过让p的位置随机来解决这个问题）。
对于归并排序、快速排序、堆排序这三个O(nlogn)的排序来说，时间复杂度是有常数级别的区别的，但是快速排序是相对更快的一种排序。

这里还需要注意的是，对于插入排序、快速排序、堆排序来说，都是原地排序的，即不需要额外的空间；而归并排序则是非原地排序，需要借助额外空间。

> 排序算法的稳定性：对于相等的元素，在排序后，原来靠前的元素依然靠前，相等元素的相对位置没有发生改变。

> 对于算法面试来说，除非面试题特别说明，否则认为要排序的数据范围是均匀分布的。

> 快速排序之所以叫快速排序，并不代表它比堆排序和归并排序优良。在最好情况下，它的渐进复杂度与 堆排序和归并排序是相同的。知识快速排序的常量系数比较小而已。

> 类库上提供的排序，并不是某一种算法的实现，而是综合了多种排序的综合排序。当数组比较小时，使用插入排序；当数组较大时，选择快速排序或其他的O(nlogn)的排序。

# 经典算法


KMP算法 
 
马拉车算法

Prim算法      

Krusk算法

Dijkstra算法 

Bellman-Ford算法 
            
# 经典数据结构    
            
数组    

栈和队列

链表

二分搜索树

集合和映射

✅ [堆和优先队列](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/datastructures/%E5%A0%86%E5%92%8C%E4%BC%98%E5%85%88%E9%98%9F%E5%88%97.md) 

线段树 

Trie树

并查集

✅ [AVL树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/datastructures/AVL%E6%A0%91.md)

红黑树 

哈希表

# 数据结构总结

线性结构和非线性结构数据结构的区别

> 线性结构

1. 线性结构作为最常用的数据结构，其特点是数据元素之间存在一对一的线性关系。
2. 线性结构拥有两种不同的存储结构，即顺序存储结构和链式存储结构。顺序存储的线性表称为顺序表，顺序表中的存储元素是连续的，链式存储的线性表称为链表，链表中的存储元素不一定是连续的，元素节点中存放数据元素以及相邻元素的地址信息。
3. 线性结构中存在两种操作受限的使用场景，即队列和栈。栈的操作只能在线性表的一端进行，就是我们常说的先进后出（FILO），队列的插入操作在线性表的一端进行而其他操作在线性表的另一端进行，先进先出（FIFO），由于线性结构存在两种存储结构，因 此队列和栈各存在两个实现方式。
4. 常见的线性结构包括：数组、链表、堆栈和队列等。

> 非线性结构

1. 树作为一种应用广泛的一对多非线性数据结构，不仅有数据间的指向关系，还有层级关系，常见的有二分搜索树（二叉树）、AVL树、B树以及红黑树等。



| 名称 | 类型 | 特性 | 常见应用 |
| :----: | :----: | :----: | :----: |
| 数组 | 线性结构 | 1. 基础数据机构；底层通过索引快速取得元素值；<br/> 2. 查询快O(1)，增删慢O(n); | JDK中的ArrayList | 
| 链表 | 线性结构 | 1. 以链表节点为元素，元素中包含指向下一节点的引用；<br/> 2. 链表分为单向链表和双向链表，区别在于双向链表有前驱节点和后继节点；<br/> 3. 查询慢O(n)，增删快O(1)；| JDK中的LinkedList、LinkedHashMap等 | 
| 栈 | 线性结构 | 1. 先进后出的数据结构；| JDK中的SynchronousQueue |
| 队列 | 线性结构 | 1. 先进先出的数据结构；| JDK中的线程池底层的队列，包括：LinkedBlockingQueue、SynchronousQueue、ArraysBlockingQueue、DelayQueue等 |
| 二分搜索树 | 非线性结构 | 1. 二分搜索树是一颗二叉树，每棵树节点都包含了节点值；<br/> 2. 每个节点值都大于左子树的所有节点的值，而小于右子树的所有节点的值；<br/>| x |
| AVL树 | 非线性结构 | 1. AVL树是一个平衡二叉树，平衡二叉树的特性就是指左右加点的差值不能大于一；<br/> 2. AVL树每次插入、删除都需要进行左旋、右旋来保持AVL树的平衡性，因而这种维护需要更多代价; <br/> 3. AVL树的高度平衡，查找节点效率高；<br/> 4. AVL树的高度为logN；| windows对进程地址空间的管理用到了AVL树 |
| 红黑树 | 非线性结构 | 1. ① 根节点为黑色；② 红黑树节点要么是红色，要么是黑色；③ 任意节点到叶子节点经过的黑色节点数量相同；④ 每个叶子节点（没有子节点的节点）都是黑色的；⑤ 如果一个节点是红色的，那么它的子节点都是黑色的; <br/> 2. 红黑树是"近似平衡"，因为红色节点的存在，让红黑树能够实现红色节点和其父亲节点进行融合，从而成为类似于2-3树这种"绝对平衡的树"；<br/> 3. 红黑树的高度近似于2logN；<br/> 4. 红黑树由于是近似平衡，所以维护成本比AVL树的要低，并且实践证明，红黑树的插入、查找和删除性能都比较稳定；| JDK中的TreeMap使用了红黑树；linux中的epoll底层，用红黑树来存储epoll_fd； | 
| B+树 | 非线性结构 | 1. 多节点，层数低；2. 时间复杂度为O(logn)；  | InnoDB底层使用的B+树 | 

# leetcode专区

## 1. 数组

题目名称 | 难度 | 地址 | 题解 
---|---|---|---
两数之和 | 简单 | [https://leetcode-cn.com/problems/two-sum/](https://leetcode-cn.com/problems/two-sum/) | [题解](https://github.com/coderbruis/AlgorithmsInJava/blob/master/src/main/java/com/bruis/algorithminjava/algorithm/array/TwoSum.java)
三数之和 | 中等 | [https://leetcode-cn.com/problems/3sum/](https://leetcode-cn.com/problems/3sum/) | [题解](https://github.com/coderbruis/AlgorithmsInJava/blob/master/src/main/java/com/bruis/algorithminjava/algorithm/array/ThreeSum.java)
乘积最大子数组 | 中等 | [https://leetcode-cn.com/problems/maximum-product-subarray/](https://leetcode-cn.com/problems/maximum-product-subarray/) | [题解](https://github.com/coderbruis/AlgorithmsInJava/blob/master/src/main/java/com/bruis/algorithminjava/algorithm/array/MaximumProductSubarray.java)
和为K的子数组 | 中等 | [https://leetcode-cn.com/problems/subarray-sum-equals-k/](https://leetcode-cn.com/problems/subarray-sum-equals-k/) | [题解](https://github.com/coderbruis/AlgorithmsInJava/blob/master/src/main/java/com/bruis/algorithminjava/algorithm/array/SubarraySumEqualsK.java)
逆序对 | 中等 | [https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/) | [题解](https://github.com/coderbruis/AlgorithmsInJava/blob/master/src/main/java/com/bruis/algorithminjava/algorithm/leetcode/ReversePairs.java)
颜色分类 | 中等 | [https://leetcode-cn.com/problems/sort-colors/](https://leetcode-cn.com/problems/sort-colors/) | [题解](https://github.com/coderbruis/AlgorithmsInJava/blob/master/src/main/java/com/bruis/algorithminjava/algorithm/leetcode/sort-colors.java)

## 2. 堆栈

题目名称 | 难度 | 地址 | 题解
---|---|---|---
最小栈 | 简单 | [https://leetcode-cn.com/problems/min-stack/](https://leetcode-cn.com/problems/min-stack/) | [题解](https://github.com/coderbruis/AlgorithmsInJava/blob/master/src/main/java/com/bruis/algorithminjava/algorithm/stack/MinStack.java)

## 3. 链表

==================== 持续更新 ===================

# 支持

![二叉堆图](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/zan.jpg)
