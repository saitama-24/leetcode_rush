## 链表

### 链表（Linked List）是最简单的线性的、动态数据结构。理解它是理解树结构、图结构的基础。

### 区别于数组，链表中的元素不是存储在内存中连续的一片区域，链表中的数据存储在每一个称之为「结点」复合区域里，在每一个结点除了存储数据以外，还保存了到下一个节点的指针（Pointer）。

### 由于不必按顺序存储，链表在插入数据的时候可以达到 O(1) 的复杂度，但是查找一个节点或者访问特定编号的节点则需要 O(n) 的时间。

### 使用链表结构可以克服数组链表需要预先知道数据大小的缺点，链表结构可以充分利用计算机内存空间，实现灵活的内存动态管理。但是链表失去了数组随机读取的优点，同时链表由于增加了结点的指针域，空间开销比较大。

### 在计算机科学中，链表作为一种基础的数据结构可以用来生成其它类型的数据结构。链表通常由一连串节点组成，每个节点包含任意的实例数据（data fields）和一或两个用来指向上一个/或下一个节点的位置的链接（links）。链表最明显的好处就是，常规数组排列关联项目的方式可能不同于这些数据项目在记忆体或磁盘上顺序，数据的访问往往要在不同的排列顺序中转换。而链表是一种自我指示数据类型，因为它包含指向另一个相同类型的数据的指针（链接）。

### 链表允许插入和移除表上任意位置上的节点，但是不允许随机存取。链表有很多种不同的类型：单向链表，双向链表以及循环链表。

### 链表通常可以衍生出循环链表，静态链表，双链表等。对于链表使用，灵活使用虚拟头结点可以简化问题。