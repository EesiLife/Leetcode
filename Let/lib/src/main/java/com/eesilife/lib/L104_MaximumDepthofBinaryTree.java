package com.eesilife.lib;

import com.eesilif.lib.entity.TreeNode;

import java.util.Stack;

/**
 * Created by siy on 18-5-23.
 */
public class L104_MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        int deep = 0;
        if(root != null)
        {
            int leftDeep = maxDepth(root.left);
            int rightDeep = maxDepth(root.right);
            deep = leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
        }
        return deep;
    }


}
