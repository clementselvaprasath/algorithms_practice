package leetcode.google;

/*
 * Given a boolean expression with following symbols.

Symbols
    'T' ---> true 
    'F' ---> false 
And following operators filled between symbols

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR 
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Let the input be in form of two arrays one contains the symbols (T and F) in order and other contains operators (&, | and ^}

Example
Given symbol = ['T', 'F', 'T'], operator = ['^', '&']
return 2
The given expression is "T ^ F & T", it evaluates true, in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

given symbol = ['T', 'F', 'F'], operator = ['^', '|']
return 2
The given expression is "T ^ F | F", it evaluates true, in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )".

 */
public class BooleanParenthesization {

	public static void main(String[] args) {
		boolean t1 = true;
		boolean t2 = false;
		System.out.println(t1&t2);
		System.out.println(t1&t1);
	}

	public int countParenth(char[] symb, char[] oper) {
        if (symb == null || symb.length <= 1 || oper == null || oper.length == 0) return 0;

        int m = symb.length;
        boolean[] table = new boolean[m];
        for (int i = 0; i < m; i++) {
        	table[i] = (symb[i] == 'T');
        }

        // 0: false, 1: true
        int[][][] f = new int[m][m][2];
        for (int i = 0; i < m; i++) {
        	if (table[i]) {
        		f[i][i][1] = 1;
        	} else {
        		f[i][i][0] = 1;
        	}
        }

        for (int l = 2; l <= m; l++) {
        	for (int i = 0; i < m - l + 1; i++) {
        		int j = i + l - 1;
        		for (int k = i; k < j; k++) {
        			if (oper[k] == '&') {
        				f[i][j][1] += f[i][k][1] * f[k + 1][j][1];
        				f[i][j][0] += f[i][k][1] * f[k + 1][j][0] + f[i][k][0] * f[k + 1][j][1] + f[i][k][0] * f[k + 1][j][0];
        			}
        			if (oper[k] == '|') {
        				f[i][j][1] += f[i][k][1] * f[k + 1][j][1] + f[i][k][1] * f[k + 1][j][0] + f[i][k][0] * f[k + 1][j][1];
        				f[i][j][0] += f[i][k][0] * f[k + 1][j][0];
        			}
        			if (oper[k] == '^') {
        				f[i][j][1] += f[i][k][1] * f[k + 1][j][0] + f[i][k][0] * f[k + 1][j][1];
        				f[i][j][0] += f[i][k][1] * f[k + 1][j][1] + f[i][k][0] * f[k + 1][j][0];
        			}
        		}
        	}
        }

        return f[0][m - 1][1];
    }
}
