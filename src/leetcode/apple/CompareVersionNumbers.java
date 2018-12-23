package leetcode.apple;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		CompareVersionNumbers ins = new CompareVersionNumbers();
		System.out.println(ins.compareVersion("1.0", "1.1"));
	}

	public int compareVersion(String version1, String version2) {
        String[] v1 = null;
        if (version1.contains(".")) {
            v1 = version1.split("\\.");
        } else {
            v1 = new String[]{version1};
        }
        String[] v2 = null;
        if (version2.contains(".")) {
            v2 = version2.split("\\.");
        } else {
            v2 = new String[]{version2};
        }
        int i, j;
        for (i = 0, j = 0; i < v1.length && j < v2.length; i++, j++) {
            if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[j])) {
                return 1;
            } else if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[j])) {
                return -1;
            }
        }
        if (i < v1.length) {
            while (i < v1.length) {
                if (Integer.valueOf(v1[i++]) > 0) return 1;
            }
        } else if (j < v2.length) {
            while (j < v2.length) {
                if (Integer.valueOf(v2[j++]) > 0) return -1;
            }
        }
        return 0;
    }
}
