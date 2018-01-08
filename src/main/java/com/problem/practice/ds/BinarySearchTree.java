package com.problem.practice.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.problem.practice.commons.TreeNode;

public class BinarySearchTree {

	private TreeNode root;
	
	public void recursiveInorder() {
		recursiveInorder(root);
		System.out.println();
	}

	private void recursiveInorder(TreeNode node) {
		if(node != null) {
			recursiveInorder(node.getlChild());
			System.out.print(node.getValue() + " ");
			recursiveInorder(node.getrChild());
		}
	}
	
	public void stackInorder() {
		if(root != null) {
			Stack<TreeNode> s = new Stack<TreeNode>();
			TreeNode temp = root;
			while(temp != null) {
				s.push(temp);
				temp = temp.getlChild();
			}
			while(!s.isEmpty()) {
				temp = s.pop();
				System.out.print(temp.getValue() + " ");
				if(temp.getrChild() != null) {
					temp = temp.getrChild();
					while(temp != null) {
						s.push(temp);
						temp = temp.getlChild();
					}
				}
				
			}
		}
		System.out.println();
	}
	
	public void morrisInorder() {
		if(root != null) {
			TreeNode current, prev;
			current = root;
			while(current != null) {
				if(current.getlChild() == null) {
					System.out.print(current.getValue() + " ");
					current = current.getrChild();
				} else {
					prev = current.getlChild();
					while(prev.getrChild() != null && !prev.getrChild().equals(current)) {
						prev = prev.getrChild();
					}
					if(prev.getrChild() == null) {
						prev.setrChild(current);
						current = current.getlChild();
					} else {
						prev.setrChild(null);
						System.out.print(current.getValue() + " ");
						current = current.getrChild();
					}
					
				}
			}
			System.out.println();
		}
	}
	
	public void recursivePreorder() {
		recursivePreorder(root);
		System.out.println();
	}

	private void recursivePreorder(TreeNode node) {
		if(node != null) {
			System.out.print(node.getValue() + " ");
			recursivePreorder(node.getlChild());
			recursivePreorder(node.getrChild());
		}
	}
	
	public void stackPreOrder() {
		if(root != null) {
			//System.out.println(root.getValue());
			TreeNode temp = root;
			Stack<TreeNode> s = new Stack<TreeNode>();
			/*if(root.getrChild() != null) {
				s.push(temp.getrChild());
			}
			while(temp.getlChild() != null) {
				temp = temp.getlChild();
				System.out.println(temp.getValue());
				if(temp.getrChild() != null) {
					s.push(temp.getrChild());
				}
			}*/
			s.push(temp);
			while(!s.isEmpty()) {
				temp = s.pop();
				System.out.print(temp.getValue() + " ");
				if(temp.getrChild() != null) {
					s.push(temp.getrChild());
				}
				while(temp.getlChild() != null) {
					temp = temp.getlChild();
					System.out.print(temp.getValue() + " ");
					if(temp.getrChild() != null) {
						s.push(temp.getrChild());
					}
				}
			}
		}
		System.out.println();
	}
	
	public void recursivePostorder() {
		recursivePostorder(root);
		System.out.println();
	}

	private void recursivePostorder(TreeNode node) {
		if(node != null) {
			recursivePostorder(node.getlChild());
			recursivePostorder(node.getrChild());
			System.out.print(node.getValue() + " ");
		}
	}
	
	public void stackPostOrder() {
		if(root != null) {
			TreeNode temp = root;
			Stack<TreeNode> s = new Stack<TreeNode>();
			s.push(temp);
			TreeNode prev = null;
			while(!s.isEmpty()) {
				TreeNode current = s.peek();
				if(prev == null || current.equals(prev.getlChild()) || current.equals(prev.getrChild())) {
					if(current.getlChild() != null) {
						s.push(current.getlChild());
					} else if(current.getrChild() != null) {
						s.push(current.getrChild());
					} else {
						s.pop();
						System.out.print(current.getValue() + " ");
					}
				} else if(prev.equals(current.getlChild())) {
					if(current.getrChild() != null) {
						s.push(current.getrChild());
					} else {
						s.pop();
						System.out.print(current.getValue() + " ");
					}
				} else if(prev.equals(current.getrChild())) {
					s.pop();
					System.out.print(current.getValue() + " ");
				}
				prev = current;
			}
			System.out.println();
		}
	}
	
	public void twoStackPostOrder() {
		if(root != null) {
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			TreeNode temp = root;
			s1.push(temp);
			while(!s1.isEmpty()) {
				temp = s1.pop();
				s2.push(temp);
				if(temp.getlChild() != null) {
					s1.push(temp.getlChild());
				}
				if(temp.getrChild() != null) {
					s1.push(temp.getrChild());
				}
			}
			while(!s2.isEmpty()) {
				temp = s2.pop();
				System.out.print(temp.getValue() + " ");
			}
		}
		System.out.println();
	}
	
	public void insert(int a) {
		if (root != null) {
			TreeNode node = new TreeNode(a);
			insert(node, root);
		} else {
			root = new TreeNode(a);
		}
	}

	private void insert(TreeNode node, TreeNode root2) {
		if(root2 == null) {
			root2 = new TreeNode(node.getValue());
		} else if(node.getValue() >= root2.getValue()) {
			if(root2.getrChild() != null) {
				insert(node, root2.getrChild());
			} else {
				root2.setrChild(node);
			}
		} else {
			if(root2.getlChild() != null) {
				insert(node, root2.getlChild());
			} else {
				root2.setlChild(node);
			}
		}
		
	}
	
	public int size() {
		if(root != null) {
			int count = 0;
			TreeNode temp = root;
			while(temp != null) {
				count++;
				temp = temp.getrChild();
			}
			return count;
		}
		return 0;
	}
	
	public int height() {
		if(root == null) {
			return 0;
		} else {
			TreeNode temp = root;
			return height(temp);
		}
	}
	
	private int height(TreeNode temp) {
		if(temp == null) {
			return 0;
		} else {
			return 1 + Math.max(height(temp.getlChild()), height(temp.getrChild()));
		}
	}

	public void zigZagOrderTraversal() {
		if(root != null) {
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			s1.push(root);
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			while(!s1.isEmpty() || !s2.isEmpty()) {
				while(!s1.isEmpty()) {
					TreeNode temp = s1.pop();
					System.out.print(temp.getValue() + " ");
					if(temp.getlChild() != null) {
						s2.push(temp.getlChild());
					}
					if(temp.getrChild() != null) {
						s2.push(temp.getrChild());
					}
					
				}
				while(!s2.isEmpty()) {
					TreeNode temp = s2.pop();
					System.out.print(temp.getValue() + " ");
					if(temp.getlChild() != null) {
						s1.push(temp.getlChild());
					}
					if(temp.getrChild() != null) {
						s1.push(temp.getrChild());
					}
				}
			}
		}
		System.out.println();
	}
	
	public void levelOrderTraversal() {
		int height = height();
		for(int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
		}
	}
	
	
	private void printGivenLevel(TreeNode temp, int i) {
		if (temp != null) {
			if (i == 1) {
				System.out.print(temp.getValue() + " ");
			} else {
				printGivenLevel(temp.getlChild(), i - 1);
				printGivenLevel(temp.getrChild(), i - 1);
			} 
		}
		
	}
	
	public void levelOrderQueue() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root != null) {
			TreeNode temp = root;
			queue.add(temp);
			while(!queue.isEmpty()) {
				temp = queue.poll();
				System.out.print(temp.getValue() + " ");
				if(temp.getlChild() != null) {
					queue.add(temp.getlChild());
				}
				if(temp.getrChild() != null) {
					queue.add(temp.getrChild());
				}
			}
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		for(int i = 6; i < 15; i++) {
			bst.insert(i);
		}
		for(int i = 5; i >= 0; i--) {
			bst.insert(i);
		}
		System.out.println("PreOrder:");
		bst.recursivePreorder();
		bst.stackPreOrder();
		System.out.println("PostOrder:");
		bst.recursivePostorder();
		bst.stackPostOrder();
		bst.twoStackPostOrder();
		System.out.println("InOrder:");
		bst.recursiveInorder();
		bst.stackInorder();
		bst.morrisInorder();
		
		System.out.println("Zigzag order:");
		bst.zigZagOrderTraversal();
		
		System.out.println("Height: " + bst.height());
		
		System.out.println("LevelOrder: " );
		bst.levelOrderTraversal();
		System.out.println();
		bst.levelOrderTraversal();
	}
}
