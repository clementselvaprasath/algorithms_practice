package algorithms.other;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Note:

Assume that the total area is never beyond the maximum possible value of int.
 * @author qz
 *
 */
public class RectangleArea {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = (C - A) * (D - B), a2 = (G - E) * (H - F);
        if (G <= A || E >= C || H <= B || F >= D) return a1 + a2;
        int l = Math.min(C, G) - Math.max(A, E);
        int w = Math.min(H, D) - Math.max(B, F);
        
        return a1 + a2 - l * w;
    }
}
