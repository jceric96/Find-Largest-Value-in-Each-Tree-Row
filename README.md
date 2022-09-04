## Find Largest Value in Each Tree Row

Example 1:

Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]

Example 2:

Input: root = [1,2,3]
Output: [1,3]

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,null,2]
Output: [1,2]

Example 5:

Input: root = []
Output: []


Input

A root node of a tree. 

2 --> two arrays (inorder tranversal array & preorder traversal array) will be used to construct tree

6 --> length of each array

5 3 3 1 2 9 --> 1st array : inorder traversal array

1 3 5 3 2 9 --> 2nd array : preorder traversal array