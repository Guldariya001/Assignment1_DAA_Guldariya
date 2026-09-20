package daa;

public class Metrics {
    public long comparisons;
    public int maxDepth;
    public long timeNs;

    public void reset() {
        comparisons = 0;
        maxDepth = 0;
        timeNs = 0;
    }

    public void updateDepth(int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
        }
    }
}