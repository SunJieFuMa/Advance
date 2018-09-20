package com.example.knowledgepointsharelib.dataStructure.binaryTree;

/**
 * Created by sunjie on 2018/9/19.
 */

public class SearchBinaryTree {
    public class TreeNode {
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;
        private TreeNode parent;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public TreeNode root;

    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.leftChild);
            System.out.print(node.data + " ");
            inorder(node.rightChild);
        }
    }

    /**
     * ������
     */
    public void insert(int data) {
        TreeNode node = null;
        TreeNode parent = null;
//      ��һ���Ž�����ȷ��Ϊ���ڵ㣬Ȼ��֮��Ž����Ĳ���������ң�û�п��ܻ�������ڵ���������ͬ������
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        node = root;
//       �Ӹ��ڵ㿪ʼ�ң�������ھ�����С�ھ�����ѭ��֮������left����right���null��˵���½����Ľ�����������֮�µ�������ҽ��
        while (node != null) {
            parent = node;
            if (data > node.data) {
                node = node.rightChild;
            } else if (data < node.data) {
                node = node.leftChild;
            } else {
                return;
            }
        }
//        �����ý�㣬�����Ѿ�ȷ���˸��ڵ㣬����ֱ�ӹ��ڸ��ڵ��������ҾͿ�����
        node = new TreeNode(data);
        if (data < parent.data) {
            parent.leftChild = node;
        } else {
            parent.rightChild = node;
        }
        node.parent = parent;
        return;
    }


    /**
     * ���ҽ��
     */
    public TreeNode searchNode(int data) {
        TreeNode node = root;
        if (node != null) {
//            �Ӹ��ڵ㿪ʼ���������ھ����ң�С�ھ�����ֱ���ҵ��ý��
            while (node != null) {
                if (data < node.data) {
                    node = node.leftChild;
                } else if (data > node.data) {
                    node = node.rightChild;
                } else {
                    return node;
                }
            }
        }
        return null;
    }


    /**
     * ��ȡ��̽��
     * ��̽���������������С�Ľ�㣬Ҳ����������������ڵ�
     * û�����������Ҹ��ڵ㣬����Լ��Ǹ��ڵ���ҽ�㣬���Լ���Ϊ���ڵ㣬���ڵ���Ϊ���ڵ�ĸ��ڵ㣬ѭ���ң�ֱ���ҵ��Լ��Ǹ��ڵ����ڵ�Ϊֹ
     */
    public TreeNode getNextNode(TreeNode node) {
        if (node == null) {
            return null;
        } else {
            if (node.rightChild != null) {
//                ��ĳһ��������С���
                return getMinTreeNode(node.rightChild);
            } else {
                TreeNode parent = node.parent;
                while (parent != null && node == parent.rightChild) {
                    node = parent;
                    parent = parent.parent;
                }
                return parent;
            }

        }

    }

    /**
     * ��ȡ�ý����Ϊ���ڵ�֮�µ���С��㣬Ҳ����������
     */
    private TreeNode getMinTreeNode(TreeNode node) {
        if (node == null) {
            return null;
        } else {
            while (node.leftChild != null) {
                node = node.leftChild;
            }
        }
        return node;
    }


    public void deleteNode(int data) {
        TreeNode node = searchNode(data);
        if (node == null) {
            throw new NullPointerException("?????");
        } else {
            deleteNode(node);
        }
    }

    public void deleteNode(TreeNode node) {
        TreeNode parent = node.parent;
//       �������ң�ֱ��ɾ
        if (node.leftChild == null && node.rightChild == null) {
            if (parent.leftChild == node) {
                parent.leftChild = null;
            }
            if (parent.rightChild == node) {
                parent.rightChild = null;
            }
            return;
        }
//          �������ң����ڵ����Ӹý�����ڵ�
        if (node.leftChild != null && node.rightChild == null) {
            if (parent.leftChild == node) {
                parent.leftChild = node.leftChild;
            } else {
                parent.rightChild = node.leftChild;
            }
            return;
        }
//         �������󣬸��ڵ����Ӹý����ҽڵ�
        if (node.leftChild == null && node.rightChild != null) {
            if (parent.leftChild == node) {
                parent.leftChild = node.rightChild;
            } else {
                parent.rightChild = node.rightChild;
            }
            return;
        }
//        ���Ҷ��У��Һ�̽��<��̽��������������Сֵ��û�����������Ҹ��������Ϊүү�������������ڵģ���ôүү���Ǻ�̽��>��
//        ��̽��һ����Ҷ�ӽ�㣬ֱ�Ӱ������滻�Ϳ�����
        TreeNode next = getNextNode(node);
        deleteNode(next);
        node.data = next.data;
    }
  /*          11

      4               98

  3     5         66

              54     78

           22   34


    */

    public static void main(String[] args) {
        SearchBinaryTree binaryTree = new SearchBinaryTree();
        int[] ints = {11, 4, 5, 98, 66, 54, 78, 22, 34, 64, 3};
        for (int i : ints) {
            binaryTree.insert(i);
        }
        binaryTree.inorder(binaryTree.root);
        binaryTree.deleteNode(11);
        System.out.println();
        binaryTree.inorder(binaryTree.root);

    }
}
