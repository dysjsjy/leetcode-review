from typing import Optional

from TreeNode import TreeNode


def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
    if root is None:
        node = TreeNode(val)
        return node

    if root.val > val:
        root.left = self.insertIntoBST(root.left, val)
    if root.val < val:
        root.right = self.insertIntoBST(root.right, val)

    return root
