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
        int count=0,low=0,high=n-1,mid=-1;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]==x){
                count++;
                break;
            }
            else if(arr[mid]>x) high=mid-1;
            else low=mid+1;
        }
        int i=mid-1,j=mid+1;
        while(i>=0&&j<n&&arr[i]==x&&arr[j]==x){
            count+=2;
            i--;j++;
        }
        while(i>=0&&arr[i]==x){
            count++;i--;
        }
        while(j<n&&arr[j]==x){
            count++;j++;
        }
        return count;
    }
}