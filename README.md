# 稀疏矩阵
## 基本介绍
当一个数组中大部分元素为0，或者同一个值的数组时，可以使用稀疏数组来保存该数组。

稀疏数组的处理方法：
1. 记录数组一共有几行几列，有多少不同的值
2. 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模。

### [代码实现](./spare_array/SparseArray.java)


# 队列
队列的操作包含：出队，入队

### [简单队列的代码实现--数组版](./queque/ArrayQueue.java)
### [环形队列的代码实现--数组版](./queque/LoopArrayQueue.java)