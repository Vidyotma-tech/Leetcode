//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int linx=binarySearch(arr,x,false);
        if(linx<0) return 0;
        int rinx=binarySearch(arr,x,true);
        return rinx-linx+1;
    }
    
    int binarySearch(int arr[],int target,boolean leftExit){
        int l=0,h=arr.length-1,inx=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]<target) l=mid+1;
            else if(arr[mid]>target) h=mid-1;
            else{
                inx=mid;
                if(leftExit) l=mid+1;
                else h=mid-1;
            }
        }
        return inx;
    }
}