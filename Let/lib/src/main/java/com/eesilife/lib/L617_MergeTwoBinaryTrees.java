package com.eesilife.lib;


import com.eesilif.lib.entity.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by siy on 18-5-23.
 */
public class L617_MergeTwoBinaryTrees {
    HashMap<Integer, List<TreeNode>> mLMap = new HashMap<>();

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        while (t1 != null || t2 != null) {
            t1.val += t2.val;
            if (t1.left != null) {
                t1 = t1.left;
            }
            if (t2.left != null) {
                t2 = t2.left;
            }
        }
        return null;
    }
}
