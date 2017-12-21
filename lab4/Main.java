package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
	System.out.println(PolandNotationGenerator.toReversePolandNotation("((a*b)-(c/d))*((c-a)/(e-b))"));
    System.out.println(PolandNotationCalculator.calculateSimplePolandNotation("* - * 4 3 / 8 2 / - 8 4 - 5 3"));
    System.out.println(PolandNotationCalculator.calculateReversePolandNotation("4 3 * 8 2 / - 8 4 - 5 3 - / *"));

    BinaryTreeNode<String> root = generateTree();
    System.out.println("Left to Right");
    printLeftToRigth(root);
    System.out.println();

    System.out.println("Up to down ");
    printUpToDown(root);
	System.out.println();

	System.out.println("Down to Up ");
	printDownToUp(root);
	System.out.println();
    }

	private static void printLeftToRigth(BinaryTreeNode node) {
		if (node.hasLeft()) {
			printLeftToRigth(node.left);
		}

		System.out.print(node + " ");

		if (node.hasRight()) {
			printLeftToRigth(node.right);
		}
	}

	private static void printUpToDown(BinaryTreeNode node) {
		System.out.print(node + " ");

		if (node.hasLeft()) {
			printUpToDown(node.left);
		}

		if (node.hasRight()) {
			printUpToDown(node.right);
		}
	}

	private static void printDownToUp(BinaryTreeNode node) {
		if (node.hasLeft()) {
			printDownToUp(node.left);
		}

		if (node.hasRight()) {
			printDownToUp(node.right);
		}

		System.out.print(node + " ");
	}

	public static BinaryTreeNode<String> generateTree() {
    	BinaryTreeNode<String> root = new BinaryTreeNode<>("a");
    	BinaryTreeNode<String> b = new BinaryTreeNode<>("b");
    	BinaryTreeNode<String> c = new BinaryTreeNode<>("c");
    	BinaryTreeNode<String> d = new BinaryTreeNode<>("d");
    	BinaryTreeNode<String> e = new BinaryTreeNode<>("e");
    	BinaryTreeNode<String> f = new BinaryTreeNode<>("f");
    	BinaryTreeNode<String> g = new BinaryTreeNode<>("g");
    	BinaryTreeNode<String> h = new BinaryTreeNode<>("h");
    	BinaryTreeNode<String> i = new BinaryTreeNode<>("i");
    	BinaryTreeNode<String> j = new BinaryTreeNode<>("j");
    	BinaryTreeNode<String> k = new BinaryTreeNode<>("k");
    	BinaryTreeNode<String> l = new BinaryTreeNode<>("l");
    	BinaryTreeNode<String> m = new BinaryTreeNode<>("m");
    	BinaryTreeNode<String> n = new BinaryTreeNode<>("n");
    	BinaryTreeNode<String> o = new BinaryTreeNode<>("o");

    	root.setLeft(b);
    	root.setRight(c);

    	b.setLeft(e);

    	e.setLeft(d);
    	e.setRight(j);

    	d.setLeft(h);
    	d.setRight(i);

    	j.setLeft(m);
    	j.setRight(n);

    	c.setLeft(f);
    	c.setRight(g);

    	g.setLeft(k);
    	g.setRight(l);

    	l.setLeft(o);

    	return root;

	}
}
