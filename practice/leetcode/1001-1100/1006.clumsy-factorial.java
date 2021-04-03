/**
 * https://leetcode-cn.com/problems/clumsy-factorial/submissions/
 */
public class Solution {
  public int clumsy(int N) {
    if (N <= 0) return 0;

    int segments = N / 4;
    int left = N % 4;
    int ans = 0;

    // 打表算最后一段元素的值
    int lastBlock;
    if (left == 3) {
      lastBlock = 6;
    } else if (left == 2) {
      lastBlock = 2;
    } else if (left == 1) {
      lastBlock = 1;
    } else {
      lastBlock = 0;
    }

    // 算前面的分段
    if (segments >= 1) {
      lastBlock = -lastBlock;
      for (int i = 0; i < segments; i++) {
        int index = N - 4 * i;
        if (i == 0) {
          ans = ans + index * (index - 1) / (index - 2) + (index - 3);
        } else {
          ans = ans - index * (index - 1) / (index - 2) + (index - 3);
        }
      }
    }

    return ans + lastBlock;
  }
}
