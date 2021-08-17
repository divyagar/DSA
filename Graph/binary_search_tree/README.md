# Binary search tree

- Binary search tree is a type of tree where all elements of left subtree are smaller than root element, and all value of right subtree are larger than root element.
- **Searching -** Start from root. If the root element has the same value. Return root. If value is smaller than root, recurse left or recurse right. 
- **Insertion -** A new elements is always inserted at leaf. 
- **Deletion -** Three cases are considered while deleting an element : 
  
  1. 0 child - When the node to be deleted has 0 child, then it can be deleted directly.
  2. 1 child - When the node to be deleted has 1 child, then it can be replaced with other child. For eg. If node to be deleted doesn't have left child, then the node can be replaced by right child, or vice versa.
  3. 2 child - When the node to be deleted has 2 child, then we replace it with inorder predecessor or inorder successor.

- **Time complexity -** For all 3 operations - `O(h)`, where `h` is height of tree.
- AVL and red black trees