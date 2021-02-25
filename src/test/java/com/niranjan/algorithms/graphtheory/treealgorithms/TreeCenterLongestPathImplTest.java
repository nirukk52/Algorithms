// To run this test in isolation from root folder:
//
// $ gradle test --tests
// com.williamfiset.algorithms.graphtheory.treealgorithms.TreeCenterLongestPathImplTest

package com.niranjan.algorithms.graphtheory.treealgorithms;

import com.google.common.truth.Truth;

import static com.google.common.truth.Truth.assertThat;

import java.util.*;
import org.junit.*;

public class TreeCenterLongestPathImplTest {

  @Test
  public void simpleTest1() {
    List<List<Integer>> graph = TreeCenterLongestPathImpl.createEmptyTree(9);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 0, 1);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 2, 1);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 2, 3);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 3, 4);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 5, 3);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 2, 6);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 6, 7);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 6, 8);
    Truth.assertThat(TreeCenterLongestPathImpl.findTreeCenters(graph)).containsExactly(2);
  }

  @Test
  public void singleton() {
    Truth.assertThat(TreeCenterLongestPathImpl.findTreeCenters(TreeCenterLongestPathImpl.createEmptyTree(1))).containsExactly(0);
  }

  @Test
  public void twoNodeTree() {
    List<List<Integer>> graph = TreeCenterLongestPathImpl.createEmptyTree(2);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 0, 1);
    Truth.assertThat(TreeCenterLongestPathImpl.findTreeCenters(graph)).containsExactly(0, 1);
  }

  @Test
  public void simpleTest2() {
    List<List<Integer>> graph = TreeCenterLongestPathImpl.createEmptyTree(3);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 0, 1);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 1, 2);
    Truth.assertThat(TreeCenterLongestPathImpl.findTreeCenters(graph)).containsExactly(1);
  }

  @Test
  public void simpleTest3() {
    List<List<Integer>> graph = TreeCenterLongestPathImpl.createEmptyTree(4);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 0, 1);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 1, 2);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 2, 3);
    Truth.assertThat(TreeCenterLongestPathImpl.findTreeCenters(graph)).containsExactly(1, 2);
  }

  @Test
  public void simpleTest4() {
    List<List<Integer>> graph = TreeCenterLongestPathImpl.createEmptyTree(7);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 0, 1);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 1, 2);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 2, 3);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 3, 4);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 4, 5);
    TreeCenterLongestPathImpl.addUndirectedEdge(graph, 4, 6);
    Truth.assertThat(TreeCenterLongestPathImpl.findTreeCenters(graph)).containsExactly(2, 3);
  }
}
