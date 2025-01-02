from typing import Optional

from TreeNode import TreeNode


def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
    if root is None:
        return root
    if root.val == key:
        if root.left is None and root.right is None:
            return None
        elif root.left is None:
            return root.right
        elif root.right is None:
            return root.left
        else:
            cur = root.right
            while cur.left is not None:
                cur = cur.left
            cur.left = root.left
            return root.right
    if root.val > key:
        root.left = self.deleteNode(root.left, key)
    if root.val < key:
        root.right = self.deleteNode(root.right, key)
    return root


# 错误写法
# def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
#     travelTree(self, root, None, key)
#
# def travelTree(selt, root: Optional[TreeNode], pre: Optional[TreeNode], key: int):
#     if root is None:
#         return
#
#     pre = root
#
#     if root.right is not None and root.val < key:
#         travelTree(root.right, pre, key)
#
#     if root.left is not None and root.val > key:
#         travelTree(root.left, pre, key)
#
#     if root.val == key:
#         if root.left is None and root.right is None:
#             if pre.val > key:
#                 pre.left = None
#             else:
#                 pre.right = None
#
#         left = root.left
#         right = root.right
#
#         if key < pre.val:
#             pre.left = right
#             while right is not None:
#                 if right.val < key:
#                     right = right.right
#                 if right.val > key:
#                     right = right.left
#             right = left
#         if key > pre.val:
#             pre.right = right
#             while left is not None:
#                 if left.val < key:
#                     left = left.left
#                 if left.val > key:
#                     left = left.right
#             left = right
