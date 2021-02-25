// To run this test in isolation from root folder:
//
// $ gradle test --tests
// com.williamfiset.algorithms.graphtheory.treealgorithms.TreeCenterTest

package com.niranjan.algorithms.graphtheory.treealgorithms;

import com.google.common.truth.Truth;

import static com.google.common.truth.Truth.assertThat;

import java.util.*;
import org.junit.*;

public class TreeCenterTest {

  @Test
  public void simpleTest1() {
    List<List<Integer>> graph = TreeCenter.createEmptyTree(9);
    TreeCenter.addUndirectedEdge(graph, 0, 1);
    TreeCenter.addUndirectedEdge(graph, 2, 1);
    TreeCenter.addUndirectedEdge(graph, 2, 3);
    TreeCenter.addUndirectedEdge(graph, 3, 4);
    TreeCenter.addUndirectedEdge(graph, 5, 3);
    TreeCenter.addUndirectedEdge(graph, 2, 6);
    TreeCenter.addUndirectedEdge(graph, 6, 7);
    TreeCenter.addUndirectedEdge(graph, 6, 8);
    Truth.assertThat(TreeCenter.findTreeCenters(graph)).containsExactly(2);
  }

  @Test
  public void singleton() {
    Truth.assertThat(TreeCenter.findTreeCenters(TreeCenter.createEmptyTree(1))).containsExactly(0);
  }

  @Test
  public void twoNodeTree() {
    List<List<Integer>> graph = TreeCenter.createEmptyTree(2);
    TreeCenter.addUndirectedEdge(graph, 0, 1);
    Truth.assertThat(TreeCenter.findTreeCenters(graph)).containsExactly(0, 1);
  }

  @Test
  public void simpleTest2() {
    List<List<Integer>> graph = TreeCenter.createEmptyTree(3);
    TreeCenter.addUndirectedEdge(graph, 0, 1);
    TreeCenter.addUndirectedEdge(graph, 1, 2);
    Truth.assertThat(TreeCenter.findTreeCenters(graph)).containsExactly(1);
  }

  @Test
  public void simpleTest3() {
    List<List<Integer>> graph = TreeCenter.createEmptyTree(4);
    TreeCenter.addUndirectedEdge(graph, 0, 1);
    TreeCenter.addUndirectedEdge(graph, 1, 2);
    TreeCenter.addUndirectedEdge(graph, 2, 3);
    Truth.assertThat(TreeCenter.findTreeCenters(graph)).containsExactly(1, 2);
  }

  @Test
  public void simpleTest4() {
    List<List<Integer>> graph = TreeCenter.createEmptyTree(7);
    TreeCenter.addUndirectedEdge(graph, 0, 1);
    TreeCenter.addUndirectedEdge(graph, 1, 2);
    TreeCenter.addUndirectedEdge(graph, 2, 3);
    TreeCenter.addUndirectedEdge(graph, 3, 4);
    TreeCenter.addUndirectedEdge(graph, 4, 5);
    TreeCenter.addUndirectedEdge(graph, 4, 6);
    Truth.assertThat(TreeCenter.findTreeCenters(graph)).containsExactly(2, 3);
  }

  @Test
  public void testTreeCenterVsOtherImpl() {
    for (int n = 1; n < 500; n++) {
      for (int loops = 0; loops < 100; loops++) {
        List<List<Integer>> tree = generateRandomTree(n);

        List<Integer> impl1 = TreeCenter.findTreeCenters(tree);
        List<Integer> impl2 =
            TreeCenterLongestPathImpl
                .findTreeCenters(tree);

        assertThat(impl1).containsExactlyElementsIn(impl2);
      }
    }
  }

  public static List<List<Integer>> generateRandomTree(int n) {
    List<Integer> nodes = new ArrayList<>();
    nodes.add(0);

    List<List<Integer>> g = TreeCenter.createEmptyTree(n);
    for (int nextNode = 1; nodes.size() != n; nextNode++) {
      int randomNode = nodes.get((int) (Math.random() * nodes.size()));
      TreeCenter.addUndirectedEdge(g, randomNode, nextNode);
      nodes.add(nextNode);
    }
    return g;
  }
}
