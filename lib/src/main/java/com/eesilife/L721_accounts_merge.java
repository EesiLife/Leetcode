package com.eesilife;

import java.util.*;

public class L721_accounts_merge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailIndex = new HashMap<>();
        Map<String, String> emailName = new HashMap<>();
        int emailCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailName.containsKey(account.get(0))) {
                    emailIndex.put(email, emailCount++);
                    emailName.put(email, name);
                }
            }
        }

        UnionFind unionFind = new UnionFind(emailCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailIndex.get(firstEmail);
            for (int i = 2; i < account.size(); i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailIndex.get(nextEmail);
                unionFind.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailIndex.keySet()) {
            int index = unionFind.find(emailIndex.get(email));
            List<String>account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }


    class UnionFind {
        int[] parent;
        int[] rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n;i ++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

//        public void union(int x, int y) {
//            int rootX = parent[x];
//            int rootY = parent[y];
//            if (rootX == rootY) return;
//            if (rank[rootX] > rank[rootY])  {
//                parent[rootY] = rootX;
//            } else if (rank[rootX] < rank[rootY]) {
//                parent[rootY] = rootX;
//            } else {
//                parent[rootX] = rootY;
//                rank[rootY]++;
//            }
//        }
    }
}



