package com.niranjan.algorithms.graphtheory.treealgorithms;

import static com.google.common.truth.Truth.assertThat;

import java.util.*;
import org.junit.*;

public class LowestCommonAncestorTest {

  private LowestCommonAncestor.TreeNode createFirstTreeFromSlides() {
    int n = 17;
    List<List<Integer>> tree = LowestCommonAncestor.createEmptyGraph(n);

    LowestCommonAncestor.addUndirectedEdge(tree, 0, 1);
    LowestCommonAncestor.addUndirectedEdge(tree, 0, 2);
    LowestCommonAncestor.addUndirectedEdge(tree, 1, 3);
    LowestCommonAncestor.addUndirectedEdge(tree, 1, 4);
    LowestCommonAncestor.addUndirectedEdge(tree, 2, 5);
    LowestCommonAncestor.addUndirectedEdge(tree, 2, 6);
    LowestCommonAncestor.addUndirectedEdge(tree, 2, 7);
    LowestCommonAncestor.addUndirectedEdge(tree, 3, 8);
    LowestCommonAncestor.addUndirectedEdge(tree, 3, 9);
    LowestCommonAncestor.addUndirectedEdge(tree, 5, 10);
    LowestCommonAncestor.addUndirectedEdge(tree, 5, 11);
    LowestCommonAncestor.addUndirectedEdge(tree, 7, 12);
    LowestCommonAncestor.addUndirectedEdge(tree, 7, 13);
    LowestCommonAncestor.addUndirectedEdge(tree, 11, 14);
    LowestCommonAncestor.addUndirectedEdge(tree, 11, 15);
    LowestCommonAncestor.addUndirectedEdge(tree, 11, 16);

    return LowestCommonAncestor.TreeNode.rootTree(tree, 0);
  }

  @Test
  public void testLcaTreeFromSlides1() {
    LowestCommonAncestor.TreeNode root = createFirstTreeFromSlides();
    LowestCommonAncestor solver = new LowestCommonAncestor(root);
    assertThat(solver.lca(14, 13).id()).isEqualTo(2);
    assertThat(solver.lca(10, 16).id()).isEqualTo(5);
    assertThat(solver.lca(9, 11).id()).isEqualTo(0);
  }

  @Test
  public void testLcaTreeFromSlides2() {
    LowestCommonAncestor.TreeNode root = createFirstTreeFromSlides();
    LowestCommonAncestor solver = new LowestCommonAncestor(root);
    assertThat(solver.lca(8, 9).id()).isEqualTo(3);
    assertThat(solver.lca(4, 8).id()).isEqualTo(1);
    assertThat(solver.lca(6, 13).id()).isEqualTo(2);
    assertThat(solver.lca(7, 13).id()).isEqualTo(7);
    assertThat(solver.lca(10, 5).id()).isEqualTo(5);
    assertThat(solver.lca(2, 16).id()).isEqualTo(2);
  }

  @Test
  public void testLcaOfTheSameNodeIsItself() {
    LowestCommonAncestor.TreeNode root = createFirstTreeFromSlides();
    LowestCommonAncestor solver = new LowestCommonAncestor(root);
    // Try all nodes
    for (int id = 0; id < root.size(); id++) {
      assertThat(solver.lca(id, id).id()).isEqualTo(id);
    }
  }
}
