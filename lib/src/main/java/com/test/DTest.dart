import 'dart:convert';
void main() {
  print('test');
  String s = "12345";
  for(var i = 0; i < s.length; i++){
    int c = int.parse(s[i]);
    print(c);
  }
}

int compareVersion(String version1, String version2) {
        String v1 = version1.replaceAll("\\.", "");
        String v2 = version2.replaceAll("\\.", "");
        int len1 = v1.length;
        int len2 = v2.length;
        int l = (len1 - len2).abs();
        for (int i = 0; i < l; i++) {
            if (len1 > len2) {
                v2 += "0";
            } else {
                v1 += "0";
            }
        }
        for (int i = 0; i < v1.length; i++) {
            int c1 = int.parse(v1[i]);
            var c2 = int.parse(v2[i]);
            // char c1 = v1.charAt(i);
            // char c2 = v2.charAt(i);
            if (c1 == c2) {
                continue;
            } else if (c1 > c2) {
                return 1;
            } else if(c1 < c2) {
                return -1;
            }
        }
        return 0;
    }
