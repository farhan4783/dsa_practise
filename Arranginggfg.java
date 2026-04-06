class Solution {
    
    public void Rearrange(int[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }
    
    private void mergeSort(int[] arr, int left, int right) {
        
        if (left >= right) return;
        
        int mid = (left + right) / 2;
        
        mergeSort(arr, left, mid);
        
        mergeSort(arr, mid + 1, right);
        
        merge(arr, left, mid, right);
    }
    
    private void merge(int[] arr, int left, int mid, int right) {
        
        int[] temp = new int[right - left + 1];
        
        int k = 0;
        
        
        
        for (int i = left; i <= mid; i++) {
            
            
            if (arr[i] < 0) temp[k++] = arr[i];
            
        }
        
        
        for (int i = mid + 1; i <= right; i++) {
            
            
            if (arr[i] < 0) temp[k++] = arr[i];
            
            
        }
        
        
        for (int i = left; i <= mid; i++) {
            
            if (arr[i] >= 0) temp[k++] = arr[i];
            
            
        }
        
       
        for (int i = mid + 1; i <= right; i++) {
            
            
            if (arr[i] >= 0) temp[k++] = arr[i];
            
            
        }
        
       
        for (int i = 0; i < temp.length; i++) {
            
            
            arr[left + i] = temp[i];
        }
    }
}
