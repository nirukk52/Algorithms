// To run this test in isolation from root folder:
//
// $ gradle test --tests
// com.williamfiset.algorithms.graphtheory.treealgorithms.TreeIsomorphismTest

package com.niranjan.algorithms.graphtheory.treealgorithms;

import com.google.common.truth.Truth;

import static com.google.common.truth.Truth.assertThat;

import java.util.*;
import org.junit.*;

public class TreeIsomorphismTest {

  @Test(expected = IllegalArgumentException.class)
  public void emptyTreeThrowsException() {
    TreeIsomorphism.treesAreIsomorphic(TreeIsomorphism.createEmptyGraph(0), TreeIsomorphism.createEmptyGraph(1));
  }

  @Test
  public void singletonTreesAreIsomorphic() {
    Truth.assertThat(TreeIsomorphism.treesAreIsomorphic(TreeIsomorphism.createEmptyGraph(1), TreeIsomorphism.createEmptyGraph(1))).isEqualTo(true);
  }

  @Test
  public void testTwoNodeTree() {
    List<List<Integer>> tree1 = TreeIsomorphism.createEmptyGraph(2);
    List<List<Integer>> tree2 = TreeIsomorphism.createEmptyGraph(2);
    TreeIsomorphism.addUndirectedEdge(tree1, 0, 1);
    TreeIsomorphism.addUndirectedEdge(tree2, 1, 0);
    Truth.assertThat(TreeIsomorphism.treesAreIsomorphic(tree1, tree2)).isEqualTo(true);
  }

  @Test
  public void testSmall() {
    List<List<Integer>> tree1 = TreeIsomorphism.createEmptyGraph(5);
    List<List<Integer>> tree2 = TreeIsomorphism.createEmptyGraph(5);

    TreeIsomorphism.addUndirectedEdge(tree1, 2, 0);
    TreeIsomorphism.addUndirectedEdge(tree1, 2, 1);
    TreeIsomorphism.addUndirectedEdge(tree1, 2, 3);
    TreeIsomorphism.addUndirectedEdge(tree1, 3, 4);

    TreeIsomorphism.addUndirectedEdge(tree2, 1, 3);
    TreeIsomorphism.addUndirectedEdge(tree2, 1, 0);
    TreeIsomorphism.addUndirectedEdge(tree2, 1, 2);
    TreeIsomorphism.addUndirectedEdge(tree2, 2, 4);

    Truth.assertThat(TreeIsomorphism.treesAreIsomorphic(tree1, tree2)).isEqualTo(true);
  }

  @Test
  public void testSimilarChains() {
    // Trees 1 and 3 are equal
    int n = 10;
    List<List<Integer>> tree1 = TreeIsomorphism.createEmptyGraph(n);
    List<List<Integer>> tree2 = TreeIsomorphism.createEmptyGraph(n);
    List<List<Integer>> tree3 = TreeIsomorphism.createEmptyGraph(n);

    TreeIsomorphism.addUndirectedEdge(tree1, 0, 1);
    TreeIsomorphism.addUndirectedEdge(tree1, 1, 3);
    TreeIsomorphism.addUndirectedEdge(tree1, 3, 5);
    TreeIsomorphism.addUndirectedEdge(tree1, 5, 7);
    TreeIsomorphism.addUndirectedEdge(tree1, 7, 8);
    TreeIsomorphism.addUndirectedEdge(tree1, 8, 9);
    TreeIsomorphism.addUndirectedEdge(tree1, 2, 1);
    TreeIsomorphism.addUndirectedEdge(tree1, 4, 3);
    TreeIsomorphism.addUndirectedEdge(tree1, 6, 5);

    TreeIsomorphism.addUndirectedEdge(tree2, 0, 1);
    TreeIsomorphism.addUndirectedEdge(tree2, 1, 3);
    TreeIsomorphism.addUndirectedEdge(tree2, 3, 5);
    TreeIsomorphism.addUndirectedEdge(tree2, 5, 6);
    TreeIsomorphism.addUndirectedEdge(tree2, 6, 8);
    TreeIsomorphism.addUndirectedEdge(tree2, 8, 9);
    TreeIsomorphism.addUndirectedEdge(tree2, 6, 7);
    TreeIsomorphism.addUndirectedEdge(tree2, 4, 3);
    TreeIsomorphism.addUndirectedEdge(tree2, 2, 1);

    TreeIsomorphism.addUndirectedEdge(tree3, 0, 1);
    TreeIsomorphism.addUndirectedEdge(tree3, 1, 8);
    TreeIsomorphism.addUndirectedEdge(tree3, 1, 6);
    TreeIsomorphism.addUndirectedEdge(tree3, 6, 4);
    TreeIsomorphism.addUndirectedEdge(tree3, 6, 5);
    TreeIsomorphism.addUndirectedEdge(tree3, 5, 3);
    TreeIsomorphism.addUndirectedEdge(tree3, 5, 7);
    TreeIsomorphism.addUndirectedEdge(tree3, 7, 2);
    TreeIsomorphism.addUndirectedEdge(tree3, 2, 9);

    Truth.assertThat(TreeIsomorphism.treesAreIsomorphic(tree1, tree2)).isEqualTo(false);
    Truth.assertThat(TreeIsomorphism.treesAreIsomorphic(tree1, tree3)).isEqualTo(true);
    Truth.assertThat(TreeIsomorphism.treesAreIsomorphic(tree2, tree3)).isEqualTo(false);
  }

  @Test
  public void simpleTest() {
    List<List<Integer>> tree1 = TreeIsomorphism.createEmptyGraph(5);
    List<List<Integer>> tree2 = TreeIsomorphism.createEmptyGraph(5);

    TreeIsomorphism.addUndirectedEdge(tree1, 2, 0);
    TreeIsomorphism.addUndirectedEdge(tree1, 3, 4);
    TreeIsomorphism.addUndirectedEdge(tree1, 2, 1);
    TreeIsomorphism.addUndirectedEdge(tree1, 2, 3);

    TreeIsomorphism.addUndirectedEdge(tree2, 1, 0);
    TreeIsomorphism.addUndirectedEdge(tree2, 2, 4);
    TreeIsomorphism.addUndirectedEdge(tree2, 1, 3);
    TreeIsomorphism.addUndirectedEdge(tree2, 1, 2);

    Truth.assertThat(TreeIsomorphism.treesAreIsomorphic(tree1, tree2)).isEqualTo(true);
  }

  @Test
  public void differentNumberOfNodes() {
    List<List<Integer>> tree1 = TreeIsomorphism.createEmptyGraph(2);
    List<List<Integer>> tree2 = TreeIsomorphism.createEmptyGraph(3);

    TreeIsomorphism.addUndirectedEdge(tree1, 0, 1);

    TreeIsomorphism.addUndirectedEdge(tree2, 0, 1);
    TreeIsomorphism.addUndirectedEdge(tree2, 1, 2);

    Truth.assertThat(TreeIsomorphism.treesAreIsomorphic(tree1, tree2)).isEqualTo(false);
  }

  @Test
  public void testIsomorphismEquivilanceAgainstOtherImpl() {
    for (int n = 1; n < 50; n++) {
      for (int loops = 0; loops < 1000; loops++) {
        List<List<Integer>> tree1 = generateRandomTree(n);
        List<List<Integer>> tree2 = generateRandomTree(n);

        boolean impl1 = TreeIsomorphism.treesAreIsomorphic(tree1, tree2);
        boolean impl2 =
            TreeIsomorphismWithBfs
                .treesAreIsomorphic(tree1, tree2);
        if (impl1 != impl2) {
          System.err.println("TreeIsomorphism algorithms disagree!");
          System.err.println(tree1);
          System.err.println(tree2);
        }
        assertThat(impl1).isEqualTo(impl2);
      }
    }
  }

  public static List<List<Integer>> generateRandomTree(int n) {
    List<Integer> nodes = new ArrayList<>();
    nodes.add(0);

    List<List<Integer>> g = TreeIsomorphism.createEmptyGraph(n);
    for (int nextNode = 1; nodes.size() != n; nextNode++) {
      int randomNode = nodes.get((int) (Math.random() * nodes.size()));
      TreeIsomorphism.addUndirectedEdge(g, randomNode, nextNode);
      nodes.add(nextNode);
    }
    return g;
  }
}
