## 1665139652. Minimum Absolute Difference In BST

- **Platform**: GeeksforGeeks
- **Problem ID**: 1665139652
- **Difficulty**: Easy
- **Language**: C++
- **Topics**: Binary Search Tree
- **Solved**: 2026-09-18T16:06:22.096Z

### Problem

*Problem statement not available.*

### Solution

```cpp
        left = null;
        right = null;
    }
}
*/
class Solution {
    int minDiff = Integer.MAX_VALUE;
    Node prev = null;

    public int absDiff(Node root) {
        inorder(root);
        return minDiff;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, root.data - prev.data);
        }

        prev = root;

        inorder(root.right);
    }
}
```
