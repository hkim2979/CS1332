public class Main {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(50);

        root.setLeft(new TreeNode<>(25));
        root.getLeft().setLeft(new TreeNode<>(10));

        root.setRight(new TreeNode<>(100));
        root.getRight().setLeft(new TreeNode<>(75));
        root.getRight().setRight(new TreeNode<>(125));
        root.getRight().getRight().setLeft(new TreeNode<>(110));

        Traversals<Integer> travs = new Traversals<>();
        System.out.println(travs.preorder(root));
        System.out.println(travs.inorder(root));
        System.out.println(travs.postorder(root));
    }
}