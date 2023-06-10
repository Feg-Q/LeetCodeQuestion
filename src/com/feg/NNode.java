package com.feg;

import java.util.List;

/**
 * @author Feg
 * @version 1.0
 * @Date 2023/6/9 21:11
 */
public class NNode {
    public int val;
    public List<NNode> children;

    public NNode() {}

    public NNode(int _val) {
        val = _val;
    }

    public NNode(int _val, List<NNode> _children) {
        val = _val;
        children = _children;
    }
}
