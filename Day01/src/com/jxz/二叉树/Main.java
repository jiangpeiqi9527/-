package com.jxz.二叉树;

import com.jxz.二叉树.BinaryTree.Visitor;
import com.jxz.二叉树.utils.BinaryTrees;

import java.util.Comparator;


@SuppressWarnings("unused")
public class Main {

	static void test1() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		
		bst.remove(7);
		
		BinaryTrees.println(bst);
	}
	
	static void test2() {
		Integer data[] = new Integer[] {
				// 7, 4
				// 7, 4, 9
				// 7, 4, 9, 5
				// 7, 4, 9, 2
				// 7, 4, 9, 2, 8
				7, 4, 9, 2, 1
		};

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		System.out.println("----------------------------------");
		System.out.println(bst.isComplete());
	}

	static void test3 () {
		BinarySearchTree<Integer> bst = new BinarySearchTree();
		Integer data[] = new Integer[] {
				// 7, 4
				// 7, 4, 9
				// 7, 4, 9, 5
				// 7, 4, 9, 2
				// 7, 4, 9, 2, 8
				7, 4, 9, 2, 1
		};
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		bst.preorder2(new Visitor<Integer>() {
			@Override
			boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
		System.out.println("=======");
		bst.preorder3();
	}
	
	public static void main(String[] args) {
		test3();
	}
}
