from typing import Optional

from TreeNode import TreeNode

# 需要节点在一个区间，直接让不在这个区间的不返回就行了
def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
    if root is None:
        return None

    if root.val < low:
        return self.trimBST(root.right, low, high)

    if root.val > high:
        return self.trimBST(root.left, low, high)

    root.left = self.trimBST(root.left, low, high)
    root.right = self.trimBST(root.right, low, high)

    return root



# 错误写法
# def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
#     if root is None:
#         return root
#
#     if root.val < low and root.val > high:
#         cur = root.right
#         while cur.left is not None:
#             cur = cur.left
#         cur.left = root.left
#         return root.right
#
#     root.right = self.trimBST(root.right, low, high)
#     root.left = self.trimBST(root.left, low, high)
#
#     return root
