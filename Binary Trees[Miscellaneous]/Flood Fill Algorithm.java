import java.util.*;
import java.io.*;

public class Solution {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Write your code here
        if (image[sr][sc] == newColor)
            return image;

        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color)
            return;

        image[sr][sc] = newColor;
        fill(image, sr - 1, sc, color, newColor); // Before to top
        fill(image, sr + 1, sc, color, newColor); // After to the bottom
        fill(image, sr, sc - 1, color, newColor); // Left - with col
        fill(image, sr, sc + 1, color, newColor); // Right - with col
    }
}
