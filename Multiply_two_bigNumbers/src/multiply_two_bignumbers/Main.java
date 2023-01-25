
package multiply_two_bignumbers;

import javax.swing.JOptionPane;

public class Main {
    public int stringToInt(String s) {
	int num = 0;
	num = Integer.valueOf(s);
	return num;
    }
    public String intToString(int num) {
	String s = null;
	s = String.valueOf(num);
	return s;
    }
    public String removePrezero(String s) {
	if (s.length() == 1){
            return s;
        }
	int k = 0;
	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == '0'){
                    k++;
                }
		else break;
	}
	if (k == s.length()){
            s = "0";
        }
	else{
            s = s.substring(k);
        }
        return s;
    }
    public int charToInt(char ch){
        int nnnn;
//        try
//        {
          nnnn = Integer.parseInt(String.valueOf(ch));
//        }
//        catch(Exception ex){
//            nnnn=0;
//        }
        return nnnn;
    }
    public String add(String s1, String s2) {
	String s = "";
	s1 = removePrezero(s1);
	s2 = removePrezero(s2);
	int c = 0, t = 0;
        int m = Math.max(s1.length(), s2.length());
        if (s1.length() > s2.length()) {
            s2 = addPrezero(s2, s1.length()-s2.length());
        }
        else if (s2.length() > s1.length()) {
            s1 = addPrezero(s1, s2.length()-s1.length());
        }
	for (int i = m-1;c !=0 || i >= 0; i--) {
                t = c;
		if (i < s1.length() && i>=0){
                    t += charToInt(s1.charAt(i));
                }
		if (i < s2.length() && i>=0){
                    t += charToInt(s2.charAt(i));
                }
		int d = t % 10;
                String ttt=intToString(d);
		s =ttt+s ;
		c = t / 10;
	}
	return s;	
    }
    public String subtra(String s1, String s2) {
	String s = "";
	String flag = "";
	removePrezero(s1);
	removePrezero(s2);
         if (s1.length() > s2.length()) {
            s2 = addPrezero(s2, s1.length()-s2.length());
        }
        else if (s2.length() > s1.length()) {
            s1 = addPrezero(s1, s2.length()-s1.length());
        }
	int len1 = s1.length();
	int len2 = s2.length();
	int len = len1>len2 ? len1 : len2;	
	if (len1 < len2){
            flag = "-";
        }
	else if (len1 > len2){
            flag = "+";
        }
	else {
		int i;
		for (i = 0; i < len1; i++) {
			if (charToInt(s1.charAt(i)) > charToInt(s2.charAt(i))) {
				flag = "+";	 break;
			}
			else if (charToInt(s1.charAt(i)) < charToInt(s2.charAt(i))) {
				flag = "-"; break;
			}
		}
		if (i == len1){
                    s = "0";
                }
	}
        int[] num = new int[len*4];
	int c = 0;
	for (int j = len-1; j >= 0; j--) {
		int n1 = charToInt(s1.charAt(j));
//                if (j < len1) {
//                    int n25 = s1.charAt(j) - '0';
//                }
//                else{
//                    int n25 = 0;
//                }
//		int n2 = j < len2 ? charToInt(s2.charAt(j)) : 0;
                int n2 = charToInt(s2.charAt(j));
		if (flag.equals("+")){
                    num[c++] = n1 - n2;
                }
		else {
                    num[c++] = n2 - n1;
                }
	}
	for (int j = 0; j < c; j++) {
		if (num[j] < 0) {
			num[j] += 10; num[j + 1] -= 1;
		}
	}
	c--;
//	while (num[c] == 0  && c>0)c--;
	for (int j = 0; j <=c; j++){
		s = intToString(num[j])+s;
	}
	if (flag.equals("-")){
            return flag + s;
        }
	else return s;
    }
    public String addPrezero(String s, int L) {
	for (int i = 0; i < L; i++){
            s = "0" + s;
        }
        return s;
    }
    public String addLastzero(String s, int L) {
	String s1 = s;
	for (int i = 0; i < L; i++){
            s1 += "0";
        }
	return s1;
    }
    public String multi(String s1, String s2) {
	int L = 4;
	if (s1.length() > 2 || s2.length() > 2) {
		if (s1.length() >= s2.length()) {
			while (L < s1.length()){
                            L *= 2;
                        }
			if (L != s1.length()){
                            s1 = addPrezero(s1, L - s1.length());
                        }
			s2 = addPrezero(s2, L - s2.length());				          
		}else {
			while (L < s2.length()){
                            L*=2;
                        }
			if (L != s2.length()){
                            s2 = addPrezero(s2, L - s2.length());
                        }
			s1 = addPrezero(s1, L - s1.length());
		}
	}
		if (s1.length() == 1){
                    s1 = addPrezero(s1, 1);
                }
		if (s2.length() == 1){
                    s2 = addPrezero(s2, 1);
                }
 
	int n = s1.length();
        String result, a0 = null, a1 = null, b0 = null, b1 = null;
	if (n > 1) {
            a1 = s1.substring(0, n / 2);
            a0 = s1.substring(n / 2, n);
            b1 = s2.substring(0, n / 2);
            b0 = s2.substring(n / 2, n);
	}
	if (n == 2) {
		int x1 = stringToInt(a1);
		int x2 = stringToInt(a0);
		int y1 = stringToInt(b1);
		int y2 = stringToInt(b0);
		int num = (x1 * 10 + x2)*(y1 * 10 + y2);
		result = intToString(num);
	}else {
            
		String c2 = multi(a1, b1);
		String c0 = multi(a0, b0);
		String temp1 = add(a0, a1);
		String temp2 = add(b1, b0);
		String temp3 = add(c2, c0);
		String temp_c1 = multi(temp1, temp2);
		String c1 = subtra(temp_c1, temp3);
		String s11 = addLastzero(c1, n / 2);
		String s22 =addLastzero(c2, n);
		result = add(add(s11, s22), c0);
	}
	return result;
    }
    public static void main(String[] args) {
        Main main = new Main();
        String s1 = JOptionPane.showInputDialog("enter first number");
        String s2 = JOptionPane.showInputDialog("enter second number");
        String strFinal = main.multi(s1, s2);
        JOptionPane.showMessageDialog(null, strFinal);
    }
}
