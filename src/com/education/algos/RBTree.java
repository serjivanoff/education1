package com.education.algos;

public class RBTree {
    private Node root;

    public static void main(String[] args) {
        final RBTree rbTree = new RBTree();
        final int[] ints = {20, 25, 23, 30, 10, 4, 16, 2, 5, 14, 17, 3, 12, 15, 19, 11};
        for (final int i : ints)
            rbTree.insert(i);
        rbTree.delete(4);
        rbTree.delete(2);
        rbTree.delete(17);
        rbTree.delete(20);
        rbTree.delete(30);
        rbTree.delete(25);
        rbTree.delete(15);
    }

    private void validateNonNull(final Node n) {
        if (n == null) throw new IllegalArgumentException("No such element");
    }

    private void unLinkFromParent(final Node n) {
        final Node p = n.parent;
        if (p.left == n) p.left = null;
        else p.right = null;
    }

    private void delete(final int value) {
        Node x = root;
        int v;
        while ((v = x.value) != value) {
            if (value > v) {
                validateNonNull(x.right);
                x = x.right;
            } else {
                validateNonNull(x.left);
                x = x.left;
            }
        }
        if (x.isRed) {
            if (x.left == null) {
                unLinkFromParent(x);
            } else {
                deleteWith2Children(x);
            }
            return;
        }
        if (x.left == null && x.right == null) {
            deleteBWOC(x);
            return;
        }
        if (x.left != null && x.right != null) {
            deleteWith2Children(x);
        } else {
            if (x.left == null) {
                x.value = x.right.value;
                x.right = null;
            } else {
                x.value = x.left.value;
                x.left = null;
            }
        }
    }

    private void deleteWith2Children(final Node x) {
        Node n = x.right;
        while (n.left != null) n = n.left;
        x.value = n.value;
        if (n.isRed) {
            unLinkFromParent(n);
        } else {
            if (n.right != null) {
                n.value = n.right.value;
                n.right = null;
            } else {
                deleteBWOC(n);
            }
        }
    }
    
    private void deleteBWOC(Node x) {
        balanceBWOC(x);
        unLinkFromParent(x);
    }

    @SuppressWarnings("ConstantConditions")
    private void balanceBWOC(final Node x) {
        final Node p = x.parent;
        final boolean isRight = p.right == x;
        final Node b =  isRight? p.left : p.right;
        if (p.isRed) {
            if (b.left != null && b.left.isRed) {
                Node c = b.left;
                if (isRight) rRot(p); else lRot(p);
                changeColor(c, b, p);
                return;
            }
            if (b.right != null && b.right.isRed) {
                if (isRight) {
                    lRot(b);
                    rRot(p);
                }  else {
                    rRot(b);
                    lRot(p);
                }
                changeColor(p);
                return;
            }
            changeColor(b, p);
        } else {
            if (b.isRed) {
                if (isRight) {
                    if (b.right != null && b.right.left != null && b.right.left.isRed) {
                        changeColor(b.right.left);
                        lRot(b);
                        rRot(p);
                    } else if (b.left != null && hasNoRC(b.left) && hasNoRC(b.right)) {
                        changeColor(b.left, b.right, b);
                        rRot(p);
                    }
                } else {
                    if (b.left != null && b.left.right != null && b.left.right.isRed) {
                        changeColor(b.left.right);
                        rRot(b);
                        lRot(p);
                    } else if (b.right != null && hasNoRC(b.right) && hasNoRC(b.left)) {
                        changeColor(b.left, b.right, b);
                        lRot(p);
                    }
                }
                return;
            }
            if (hasNoRC(b) && p != root) {
                changeColor(b);
                balanceBWOC(p);
                return;
            }
            if (isRight) {
                if (b.left != null && b.left.isRed) {
                    changeColor(b.left);
                    lRot(p);
                } else if (b.right != null && b.right.isRed) {
                    changeColor(b.right);
                    lRot(b);
                    rRot(p);
                }
            } else {
                if (b.right != null && b.right.isRed) {
                    changeColor(b.right);
                    rRot(p);
                } else if (b.left != null && b.left.isRed) {
                    changeColor(b.left);
                    rRot(b);
                    lRot(p);
                }
            }
        }
    }

    private boolean hasNoRC(final Node n) {
        return (n.left == null || !n.left.isRed) && (n.right == null || !n.right.isRed);
    }

    private void insert(final int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node n = root, x;
        while (true) {
            Node l = n.left, r = n.right;
            if (!n.isRed && r != null && r.isRed && l != null && l.isRed) {
                repaint(n);
                fix(n);
            }
            if (value == n.value) return;
            if (value > n.value) {
                if (n.right == null) {
                    n.right = x = new Node(n, value);
                    break;
                }
                n = n.right;
            } else {
                if (n.left == null) {
                    n.left = x = new Node(n, value);
                    break;
                }
                n = n.left;
            }
        }
        fix(x);
        root.isRed = false;
    }

    private void fix(final Node x) {
        final Node p = x.parent;
        if (p != null && p.isRed) {
            final Node g = p.parent;
            if (isOuter(x, p, g)) {
                changeColor(p, g);
                if (g.left == p) rRot(g);
                else lRot(g);
            } else {
                changeColor(x, g);
                if (p.left == x) {
                    rRot(p);
                    lRot(g);
                } else {
                    lRot(p);
                    rRot(g);
                }
            }
        }
    }

    private boolean isOuter(final Node x, final Node p, final Node g) {
        return g.right == p && p.right == x || g.left == p && p.left == x;
    }

    private void changeColor(final Node... nodes) {
        for (Node n : nodes)
            if (n != null) n.isRed = !n.isRed;
    }

    private void repaint(final Node n) {
        n.isRed = true;
        n.left.isRed = false;
        n.right.isRed = false;
    }

    private void rRot(final Node n) {
        final Node p = n.parent, l = n.left;
        if (l != null) l.parent = p;
        if (p != null) {
            if (p.left == n) p.left = l;
            else p.right = l;
        }
        if (l != null) {
            if (l.right != null) l.right.parent = n;
            n.left = l.right;
        }
        n.parent = l;
        l.right = n;
        if (p == null) root = l;
    }

    private void lRot(final Node n) {
        final Node p = n.parent, r = n.right;
        if (r != null) r.parent = p;
        if (p != null) {
            if (p.left == n) p.left = r;
            else p.right = r;
        }
        if (r != null) {
            if (r.left != null) r.left.parent = n;
            n.right = r.left;
        }
        n.parent = r;
        r.left = n;
        if (p == null) root = r;
    }

    private static class Node {
        boolean isRed = true;
        Node parent, left, right;
        int value;

        public Node(Node parent, int value) {
            this.parent = parent;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
            this.isRed = false;
        }
    }
}
