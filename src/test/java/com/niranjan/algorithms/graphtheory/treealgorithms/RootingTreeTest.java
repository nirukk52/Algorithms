package com.niranjan.algorithms.graphtheory.treealgorithms;

import static com.google.common.truth.Truth.assertThat;

import java.util.*;
import org.junit.*;

public class RootingTreeTest {

  // Create a graph as a adjacency list
  private static List<List<Integer>> createGraph(int n) {
    List<List<Integer>> graph = new ArrayList<>(n);
    for (int i = 0; i < n; i++) graph.add(new LinkedList<>());
    return graph;
  }

  private static void addUndirectedEdge(List<List<Integer>> graph, int from, int to) {
    graph.get(from).add(to);
    graph.get(to).add(from);
  }

  private static List<List<Integer>> getGraph1() {
    List<List<Integer>> graph = createGraph(9);
    addUndirectedEdge(graph, 0, 1);
    addUndirectedEdge(graph, 2, 1);
    addUndirectedEdge(graph, 2, 3);
    addUndirectedEdge(graph, 3, 4);
    addUndirectedEdge(graph, 5, 3);
    addUndirectedEdge(graph, 2, 6);
    addUndirectedEdge(graph, 6, 7);
    addUndirectedEdge(graph, 6, 8);
    return graph;
  }

  @Test
  public void testSimpleRooting1() {
    List<List<Integer>> graph1 = getGraph1();
    // Graph 1 rooted at 6 should look like:
    //           6
    //      2    7     8
    //    1   3
    //  0    4 5

    RootingTree.TreeNode node6 = RootingTree.rootTree(graph1, 6);

    // Layer 0: [6]
    assertThat(node6.id()).isEqualTo(6);
    assertThat(node6.parent()).isEqualTo(null);

    // Layer 1: [2, 7, 8]
    List<RootingTree.TreeNode> children = node6.children();
    RootingTree.TreeNode node2 = new RootingTree.TreeNode(2, node6);
    RootingTree.TreeNode node7 = new RootingTree.TreeNode(7, node6);
    RootingTree.TreeNode node8 = new RootingTree.TreeNode(8, node6);
    assertThat(children).containsExactly(node2, node7, node8);

    // Layer 2: [1, 3]
    RootingTree.TreeNode node1 = new RootingTree.TreeNode(1, node2);
    RootingTree.TreeNode node3 = new RootingTree.TreeNode(3, node2);
    assertThat(node6.children().get(0).children()).containsExactly(node1, node3);

    // Layer 3: [0], [4, 5]
    RootingTree.TreeNode node0 = new RootingTree.TreeNode(0, node1);
    RootingTree.TreeNode node4 = new RootingTree.TreeNode(4, node3);
    RootingTree.TreeNode node5 = new RootingTree.TreeNode(5, node3);
    assertThat(node6.children().get(0).children().get(0).children()).containsExactly(node0);
    assertThat(node6.children().get(0).children().get(1).children()).containsExactly(node4, node5);

    // TODO(williamfiset): also verify the parent pointers are pointing at the correct nodes.
  }
}
