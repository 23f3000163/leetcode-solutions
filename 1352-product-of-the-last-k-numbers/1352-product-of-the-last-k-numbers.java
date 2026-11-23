class ProductOfNumbers {
    private List<Integer> nums;
    private int n;

    public ProductOfNumbers() {
        nums = new ArrayList<>();
        int n = 0;        
    }
    
    public void add(int num) {
        nums.add(num);  
    }
    
    public int getProduct(int k) {
        int product = 1;
        n = nums.size();
        for (int i = n - k; i < n; i++) {
            int x = nums.get(i);
            product = product * x; 
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */