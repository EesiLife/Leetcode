package com.eesilife.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L811_Subdomain_Visit_Count {

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++){
            String[] s = cpdomains[i].split(" ");
            int index = Integer.parseInt(s[0]);
            int a1 = index;
            if (null != map.get(s[1])) {
                a1 += map.get(s[1]);
            }
            map.put(s[1], a1);
            String[] ss = s[1].split("\\.");
            if (ss.length == 2) {
                int a2= index;
                if (null != map.get(ss[1])) {
                    a2 += map.get(ss[1]);
                }
                map.put(ss[1], a2);
            } else {
                int a3= index;
                String b = String.format("%s.%s",ss[1], ss[2]);
                if (null != map.get(b)) {
                    a3 += map.get(b);
                }
                map.put(b, a3);
                int a4 = index;
                if (null != map.get(ss[2])) {
                    a4 += map.get(ss[2]);
                }
                map.put(ss[2], a4);
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            int index = map.get(key);
            result.add( index+ " " + key);
        }

        return result;
    }
    public static void main(String[] args){
        L811_Subdomain_Visit_Count c = new L811_Subdomain_Visit_Count();
        String[] s = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> result = c.subdomainVisits(s);
        System.out.println(result.size());
        for (String ss :result)
            System.out.print(ss);
    }
}
