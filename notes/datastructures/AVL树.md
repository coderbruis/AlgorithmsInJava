## 前言

AVL树本质上还是一颗二叉树，它的特点是：

1. 自身是一颗二叉树；
2. 满足平衡二叉树条件，即对于任意一个左子树和右子树，其二者高度不能超过一，并且左右两棵子树都是一棵平衡二叉树；

## 正文

### 1. 基础准备

在学习AVL树之前，先了解一下相关基础知识:

- 二叉树
    
    啥是二叉树？二叉树就是树形结构的一个重要类型。

- 平衡二叉树
    
    定义：平衡二叉树，对于任意一个左子树和右子树，其二者高度差不能超过一；并且左右两棵子树都是一棵平衡二叉树。
    如下图：
    ![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl01.png)
    
    对于平衡二叉树，这里定义两个概念：
    1. 树的高度；
    2. 平衡因子；
    
    **树的高度**
    
    对于平衡二叉树的高度，计算公式：当前节点树高度 = 左右子树最大高度 + 1。
    ![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl02.png)
    
    **平衡因子**
    
    对于平衡二叉树的平衡因子为左右子树高度的差。
    
    如下图红色数字：
    ![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl03.png)
    
    另外，可以通过判断一棵树的平衡因子是否大于1来判断该树是否为平衡二叉树，是的话，就不是平衡二叉树，所以很明显上面这棵树不是平衡二叉树。
    
- 满二叉树

    定义：一棵二叉树的结点要么是叶子结点，要么它有两个子结点，这样的树就是满二叉树。
    
    下图这个图，就是一棵满二叉树：
    ![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl04.png)
    
- 完全二叉树
    
    定义：
    
      （1）所有的叶结点都出现在第k层或k-l层（层次最大的两层）。
      （2）对任一结点，如果其右子树的最大层次为L，则其左子树的最大层次为L或L+l。
      
    ![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl05.png)
     
      
 > 平衡二叉树的高度和节点数量之间的关系

h = O(logn)



### 2. 计算树高度和平衡因子

```
//在定义的内部类-Node节点中，定义一个height作为树的高度
private class Node{
        public K key;
        public V value;
        public Node left, right;
        //定义
        public int height;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
}

// 获得节点node的高度
private int getHeight(Node node){
        if(node == null)
            return 0;
        return node.height;
}

// 获得节点node的平衡因子
private int getBalanceFactor(Node node){
        if(node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
}
```

### 3. 判断是否为二叉树

因为对二叉树中序遍历之后，遍历后的元素是有序的，所以可以以这个性质来判断一棵树是否为二叉树

```
// 判断该二叉树是否是一棵二分搜索树
public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for(int i = 1 ; i < keys.size() ; i ++)
            if(keys.get(i - 1).compareTo(keys.get(i)) > 0)
                return false;
        return true;
}
```

### 4. 判断是否为平衡二叉树

```
// 判断该二叉树是否是一棵平衡二叉树
public boolean isBalanced(){
        return isBalanced(root);
}
// 判断以Node为根的二叉树是否是一棵平衡二叉树，递归算法
private boolean isBalanced(Node node){
        if(node == null)
            return true;
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
}
```

### 5. 旋转操作的基本原理

旋转（左旋转、右旋转）节点是为了维持树的平衡，那么在什么时候需要维护树的平衡呢？

添加一个节点的时候，如下图：

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl06.png)

添加完以后是这样的：

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl07.png)

此时就已经不满足平衡二叉树的定义了，就需要进行旋转操作。所以，平衡的时机，就是在加入节点以后，沿着节点向上维护（回溯）平衡性。


### 6. 右旋

有两种情况，需要进行右旋操作。

（1）

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl08.png)

（2）

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl09.png)


下面，来进行右旋操作，为了不失去一般性，每个节点用变量来表示：

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl10.png)

右旋操作：

```
x.right = y;
y.left = T3;
```

```
// 对节点y进行向右旋转操作，返回旋转后新的根节点x
//        y                              x
//       / \                           /   \
//      x   T4     向右旋转 (y)        z     y
//     / \       - - - - - - - ->    / \   / \
//    z   T3                       T1  T2 T3 T4
//   / \
// T1   T2
private Node rightRotate(Node y) {
  Node x = y.left;
  Node T3 = x.right;
  
  //向右旋转
  x.right = y;
  y.left = T3;
  
  //旋转过后，需要重新维护树的高度，并且需要先计算y的高度，再计算x的高度，因为此时y已经为x的子节点了
  y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
  x.heigt = Math.max(getHeight(x.left), getiHeight(x.right)) + 1;
  return x;
}

private int getHeight(Node node) {
  if(node == null) {
    return 0;
  }
  return node.height;
}
```



![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl11.png)

下面，通过分析一下树的高度，来判断，到底合不合理，旋转之后是否真的是平衡二叉树？

**旋转前：**

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl12.png)

**旋转后：**

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl13.png)

可以观察高度是完全合理的，所以，旋转之后的高度完全合理。


### 7. 左旋

有两种情况，需要进行左旋操作。

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl15.png)

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl16.png)

左旋操作：

```
x.left = y;
y.right = T2;
```

```
// 对节点y进行向左旋转操作，返回旋转后新的根节点x
//    y                             x
//  /  \                          /   \
// T1   x      向左旋转 (y)       y     z
//     / \   - - - - - - - ->   / \   / \
//   T2  z                     T1 T2 T3 T4
//      / \
//     T3 T4
private Node leftRotate(Node y) {
  Node x = y.right;
  Node T2 = x.left;
  
  //向左旋转
  x.left = y;
  y.right = T2;
  
  //旋转过后，需要重新维护树的高度，并且需要先计算y的高度，再计算x的高度，因为此时y已经为x的子节点了
  y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
  x.heigt = Math.max(getHeight(x.left), getiHeight(x.right)) + 1;
  return x;
}
private int getHeight(Node node) {
  if(node == null) {
    return 0;
  }
  return node.height;
}

```

### 8. LR和RL

普通的左旋和右旋，可以称作为LL和RR。怎么理解呢？下面来看看LL和LR、RR和RL的区别吧。

> LL和LR

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl15.png)

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl16.png)

> RR和RL

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl17.png)

![平衡二叉树](https://github.com/coderbruis/AlgorithmsInJava/blob/master/notes/pictures/avl18.png)

对于RL和LR，是不能通过普通的旋转操作，来维持树的平衡性的。

**对于RL：**

```
      y                            y                                                   
     /  \                         / \                                      z      
   T1    x                       T1  z                                   /   \           
        / \        对x进行右旋       / \        然后对z进行左旋           y     x  
       z  T4    -------------->    T2  x     ---------------->        /  \   / \     
      / \                             / \                            T1  T2 T3            
     T2  T3                          T3 T4                                    
```

```
//当node为y节点的时候，此时的平衡因子是小于-1的，对x节点进行右旋操作，然后再进行左旋操作。
if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
  node.right = rightRotate(node.right);
  return leftRotate(node);
}
```

**对于LR：**

```
       y                          y                              z    
      / \                        / \                           /   \      
     x   T4    对x进行左旋       z   T4   对z进行右旋操作        x     y                 
    / \      --------------->  / \      ----------------->   / \   / \  
   T1  z                      x   T3                        T1 T2 T3  T4    
      / \                    / \                                    
     T2  T3                 T1  T2                      
```

```
//当node为y节点的时候，此时的平衡因子是大于1的，对x节点进行左旋操作，然后再进行右旋操作。
if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
  node.left = leftRotate(node.left);
  return rightRotate(node);
}
```

至此，对于所有的情况，都已经分析完了。

### 9. 删除节点

删除的节点，分为两种：

**叶子节点**

**非叶子结点**

这里需要注意的一点就是，在删除非叶子节点的时候，需要选取找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点，用这个节点顶替待删除节点的位置。然后才能进行旋转操作。

```
//从二分搜索树种删除键为key的节点
public V remove(K key) {
  Node node = getNode(root, key);
  if(node != null) {
    root = remove(root, key);
    return node.value;
  }
  return null;
}
private Node remove(Node node, K key) {
  if(node == null) {
    return null;
  }
  Node retNode;
  if(key.compareTo(node.key) < 0) {
    node.left = remove(node.left, key);
    retNode = node;
  } else if(key.compareTo(node.key) > 0) {
    node.right = remove(node.right, key);
    retNode = node;
  } else {
  	if(node.left == null) {//待删除节点左子树为空的情况
      Node rightNode = node.right;
      size --;
      retNode = rightNode;
  	} else if(node.right == null) {//待删除节点右子树为空的情况
      Node leftNode = node.left;
      size --;
      retNode = leftNode;
  	} else {//待删除的节点的左右子节点都不为空
      // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
      // 用这个节点顶替待删除节点的位置
      Node successor = minimum(node.right);
      //重新维护以successor为根节点的这个子树
      succesor.right = remove(node.right, successor.key);
      succesor.left = node.left;
      node.left = node.right = null;
      retNode = successor;
  	}
  }
  
  if(retNode == null) {
    return null;
  }
  
   // 更新height
   retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

   // 计算平衡因子
   int balanceFactor = getBalanceFactor(retNode);

   // 平衡维护
   // LL
   if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
        return rightRotate(retNode);

   // RR
   if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
        return leftRotate(retNode);

   // LR
   if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
        retNode.left = leftRotate(retNode.left);
        return rightRotate(retNode);
    }

    // RL
    if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
        retNode.right = rightRotate(retNode.right);
        return leftRotate(retNode);
    }

    return retNode;
}
//返回以node为根的二分搜索树的最小值所在的节点
private Node minimum(Node node) {
  if(node.left == null) {
    return node;
  }
  return minimum(node.left);
}
```





```
public class AVLTree<K extends Comparable<K>,V> {//
  private class Node {
    public K key;
    public V value;
    public Node left, right;
    public int height;
    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      left = null;
      right = null;
      height = 1;//初始高度都为1
    }
  }
  private Node root;
  private int size;
  public AVLTree() {
    root = null;
    size = 0;
  }
  //向二分搜索树种添加一个新的元素(key, value)
  public void add(K key, V value) {
    root = add(root, key, value);
  }
  //使用递归算法来添加新元素
  private Node add(Node node, K key, V valu) {
    if(node == null) {
      size ++;
      return Node(key, value);
    }
    if(key.compareTo(node.key) < 0) {
      node.left = add(node.left, key, value);
    } else if(key.compareTo(node.key) > 0) {
      node.right = add(node.right, key, value);
    } else {
      node.value = value;
    }
    //更新height
    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    //计算平衡因子
    int balanceFactor = getBalanceFactor(node);
    //维护树的平衡
    if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
      return rightRotate(node);
    }
    if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
      return leftRotate(node);
    }
    if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }
  }
}
```

