// To run this test in isolation from root folder:
//
// $ gradle test --tests
// com.williamfiset.algorithms.graphtheory.treealgorithms.TreeIsomorphismWithBfsTest

package com.niranjan.algorithms.graphtheory.treealgorithms;

import com.google.common.truth.Truth;

import static com.google.common.truth.Truth.assertThat;

import java.util.*;
import org.junit.*;

public class TreeIsomorphismWithBfsTest {

  @Test
  public void testSingleton() {
    List<List<Integer>> tree1 = TreeIsomorphismWithBfs.createEmptyTree(1);
    List<List<Integer>> tree2 = TreeIsomorphismWithBfs.createEmptyTree(1);
    Truth.assertThat(TreeIsomorphismWithBfs.treesAreIsomorphic(tree1, tree2)).isEqualTo(true);
  }

  @Test
  public void testTwoNodeTree() {
    List<List<Integer>> tree1 = TreeIsomorphismWithBfs.createEmptyTree(2);
    List<List<Integer>> tree2 = TreeIsomorphismWithBfs.createEmptyTree(2);

    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 0, 1);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 1, 0);

    Truth.assertThat(TreeIsomorphismWithBfs.treesAreIsomorphic(tree1, tree2)).isEqualTo(true);
  }

  @Test
  public void testSmall() {
    List<List<Integer>> tree1 = TreeIsomorphismWithBfs.createEmptyTree(5);
    List<List<Integer>> tree2 = TreeIsomorphismWithBfs.createEmptyTree(5);

    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 2, 0);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 2, 1);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 2, 3);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 3, 4);

    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 1, 3);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 1, 0);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 1, 2);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 2, 4);

    Truth.assertThat(TreeIsomorphismWithBfs.treesAreIsomorphic(tree1, tree2)).isEqualTo(true);
  }

  @Test
  public void testSimilarChains() {
    // Trees 1 and 3 are equal
    int n = 10;
    List<List<Integer>> tree1 = TreeIsomorphismWithBfs.createEmptyTree(n);
    List<List<Integer>> tree2 = TreeIsomorphismWithBfs.createEmptyTree(n);
    List<List<Integer>> tree3 = TreeIsomorphismWithBfs.createEmptyTree(n);

    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 0, 1);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 1, 3);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 3, 5);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 5, 7);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 7, 8);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 8, 9);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 2, 1);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 4, 3);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree1, 6, 5);

    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 0, 1);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 1, 3);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 3, 5);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 5, 6);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 6, 8);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 8, 9);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 6, 7);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 4, 3);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree2, 2, 1);

    TreeIsomorphismWithBfs.addUndirectedEdge(tree3, 0, 1);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree3, 1, 8);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree3, 1, 6);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree3, 6, 4);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree3, 6, 5);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree3, 5, 3);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree3, 5, 7);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree3, 7, 2);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree3, 2, 9);

    Truth.assertThat(TreeIsomorphismWithBfs.treesAreIsomorphic(tree1, tree2)).isEqualTo(false);
    Truth.assertThat(TreeIsomorphismWithBfs.treesAreIsomorphic(tree1, tree3)).isEqualTo(true);
    Truth.assertThat(TreeIsomorphismWithBfs.treesAreIsomorphic(tree2, tree3)).isEqualTo(false);
  }

  @Test
  public void testSlidesExample() {
    // Setup tree structure from:
    // http://webhome.cs.uvic.ca/~wendym/courses/582/16/notes/582_12_tree_can_form.pdf
    List<List<Integer>> tree = TreeIsomorphismWithBfs.createEmptyTree(19);

    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 6, 2);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 6, 7);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 6, 11);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 7, 8);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 7, 9);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 7, 10);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 11, 12);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 11, 13);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 11, 16);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 13, 14);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 13, 15);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 16, 17);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 16, 18);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 2, 0);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 2, 1);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 2, 3);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 2, 4);
    TreeIsomorphismWithBfs.addUndirectedEdge(tree, 4, 5);

    String treeEncoding = TreeIsomorphismWithBfs.encodeTree(tree);
    String expectedEncoding = "(((()())(()())())((())()()())(()()()))";
    assertThat(treeEncoding).isEqualTo(expectedEncoding);
  }

  @Test
  public void t() {
    List<List<Integer>> tree = TreeIsomorphismWithBfs.createEmptyTree(10);

    TreeIsomorphism.TreeNode node0 = new TreeIsomorphism.TreeNode(0);
    TreeIsomorphism.TreeNode node1 = new TreeIsomorphism.TreeNode(1);
    TreeIsomorphism.TreeNode node2 = new TreeIsomorphism.TreeNode(2);
    TreeIsomorphism.TreeNode node3 = new TreeIsomorphism.TreeNode(3);
    TreeIsomorphism.TreeNode node4 = new TreeIsomorphism.TreeNode(4);
    TreeIsomorphism.TreeNode node5 = new TreeIsomorphism.TreeNode(5);
    TreeIsomorphism.TreeNode node6 = new TreeIsomorphism.TreeNode(6);
    TreeIsomorphism.TreeNode node7 = new TreeIsomorphism.TreeNode(7);
    TreeIsomorphism.TreeNode node8 = new TreeIsomorphism.TreeNode(8);
    TreeIsomorphism.TreeNode node9 = new TreeIsomorphism.TreeNode(9);

    node0.addChildren(node1, node2, node3);
    node1.addChildren(node4, node5);
    node5.addChildren(node9);
    node2.addChildren(node6, node7);
    node3.addChildren(node8);

    // TODO(william): finish this test to check for "(((())())(()())(()))" encoding
    // System.out.println(
    // com.williamfiset.algorithms.graphtheory.treealgorithms.TreeIsomorphism.encode(node0));

    // (((())())(()())(()))
    //  ((())())
    //          (()())
    //                (())
    //

    // (()())
    // (())
    // (())

    // ((()())(()))
    // ((())())
    //
    // ((()())(()))((())())

    // (((()())(()))((())()))
    //   (()())
    //         (())
    //
    //             ((())())
    //
  }
}
