# 用Java实现算法和数据结构

本项目主要用于自己在工作之余记录用Java实现的算法和数据结构的源码；同时还会记录自己刷leetcode的题解思路等；

# 经典排序算法

- [冒泡排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)  
- [选择排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)
- [插入排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)
- [归并排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md) 
- [快速排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)
- [希尔排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)
- [桶排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E6%A1%B6%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md) 
- [基数排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md)
- [堆排序](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/algorithms/%E5%A0%86%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95.md) 

## 排序算法总结

| 排序名  |  平均时间复杂度   |    空间复杂度     |  优势  |  劣势  |           适用场景            | 稳定性  |
| :--: | :------: | :----------: | :--: | :--: | :-----------------------: | :--: |
| 冒泡排序 |  O(n^2)  |     O(1)     |      |      |                           |  稳定  |
| 插入排序 |  O(n^2)  |     O(1)     |      |      |                           |  稳定  |
| 计数排序 |          |     O(M)     |      |      | 对于用例少的数据，比如对人的年龄排序或者身高排序。 |  稳定  |
| 基数排序 | O(d(n+r)) |     O(M)     |      |      |                           |  稳定  |
| 桶排序  |          |              |      |      |                           |  稳定  |
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
            
- 数组    
- 栈和队列
- 链表
- 二分搜索树
- 集合和映射
- [堆和优先队列](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/datastructures/%E5%A0%86%E5%92%8C%E4%BC%98%E5%85%88%E9%98%9F%E5%88%97.md) 【更新中】
- 线段树 
- Trie树
- 并查集
- [AVL树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/datastructures/AVL%E6%A0%91.md)【更新中】
- 红黑树 
- 哈希表

==================== 持续更新 ===================

# leetcode专区

## 1. 数组

题目名称 | 难度 | 地址 | 题解 
---|---|---|---
两数之和 | 简单 | [https://leetcode-cn.com/problems/two-sum/](https://leetcode-cn.com/problems/two-sum/) | a 
三数之和 | 中等 | [https://leetcode-cn.com/problems/3sum/](https://leetcode-cn.com/problems/3sum/) | a
乘积最大子数组 | 中等 | [https://leetcode-cn.com/problems/maximum-product-subarray/](https://leetcode-cn.com/problems/maximum-product-subarray/) | b
和为K的子数组 | 中等 | [https://leetcode-cn.com/problems/subarray-sum-equals-k/](https://leetcode-cn.com/problems/subarray-sum-equals-k/) | c

数组类总数：4

## 2. 堆栈

题目名称 | 难度 | 地址 | 题解
---|---|---|---
最小栈 | 简单 | [https://leetcode-cn.com/problems/min-stack/](https://leetcode-cn.com/problems/min-stack/) | a 

堆栈类总数：1

## 3. 链表

==================== 持续更新 ===================

# 支持

![二叉堆图](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/zan.jpg)
