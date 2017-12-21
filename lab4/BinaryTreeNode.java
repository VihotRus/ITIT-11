package com.company;

/**
 * Created by Andrii on 28.10.2017.
 */
public class BinaryTreeNode<E> {
	public E value;
	public BinaryTreeNode root;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	 public BinaryTreeNode(E value) {
	 	this.value = value;
	 }

	 public void setLeft(BinaryTreeNode<E> node) {
	 	left = node;
	 	left.root = this;
	 }

	public void setRight(BinaryTreeNode<E> node) {
		right = node;
		right.root = this;
	}

	public boolean isLeaf() {
	 	return left == null && right == null;
	}

	public boolean hasLeft() {
	 	return left != null;
	}

	public boolean hasRight() {
	 	return right != null;
	}

	public String toString() {
	 	return value.toString();
	}
}
