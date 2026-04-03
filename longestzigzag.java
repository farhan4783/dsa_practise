
import java.io.*; 
import java.util.*; 
class GFG { 
    

static int lenOfLongZigZagArr(int a[], int n) 
{
   
    int max = 1, 

    
    len = 1; 

    
    for (int i = 0; i < n - 1; i++) 
    { 
        if (i % 2 == 0 && (a[i] < a[i + 1])) 
            len++; 
    
        else if (i % 2 == 1 && (a[i] > a[i + 1])) 
            len++; 
    
        else 
        { 
            
            if (max < len) 
                max = len; 
    
            
            len = 1; 
        } 
    } 

    if (max < len) 
        max = len; 
    
    
    return max; 
}


public static void main(String[] args) 
{ 
    int arr[] = { 1, 2, 3, 4, 5 }; 
    int n = arr.length; 

    System.out.println(lenOfLongZigZagArr(arr, n));
} 
}
