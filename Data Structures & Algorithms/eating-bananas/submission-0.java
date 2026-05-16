class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Lower bound: minimum speed she could eat is 1 banana/hour
        int l = 1;
        // Upper bound: max speed needed is the largest pile (eat a whole pile in 1 hour if needed)
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r; // Default answer: worst case she eats at max speed

        // Binary search loop
        while (l <= r) {
            int m = (l + r) / 2; // Midpoint: current guess for eating speed (bananas/hour)

            long totalTime = 0; // Total hours Koko needs at this speed
            for (int p : piles) {
                // Calculate hours for each pile 
                totalTime += Math.ceil((double) p / m);
            }

            if (totalTime <= h) {
                // She finishes in time, try a slower speed (minimize speed)
                res = m;
                r = m - 1;
            } else {
                // She’s too slow, need to eat faster
                l = m + 1;
            }
        }

        return res; // Minimum valid eating speed found
    }
}
