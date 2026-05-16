class Solution {
    public boolean isHappy(int n) {
        return happyHelper(n) == 1;
    }

    public int happyHelper(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) return 2; // detected cycle
            set.add(n); //else add to the set to check in future

            String strVal = String.valueOf(n);
            int numLength = strVal.length();
            int[] nums = new int[numLength];
            int happy = 0;
            for (int i = 0; i < numLength; i++) {
                nums[i] = Character.getNumericValue(strVal.charAt(i));
                int digit = nums[i];
                happy += (int) Math.pow(digit, 2);
            }

            n = happy;
        }

        return 1; // if we reach 1, it's a happy number
    }
}
