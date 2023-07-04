//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        suffix[n-1] = arr[n-1];
        for(int i=1;i<n;i++){
            prefix[i] = Math.min(prefix[i-1],arr[i]);
            suffix[n-i-1] = Math.max(suffix[n-i],arr[n-i-1]);
        }
        int i=0,j=0,ans=0;
        while(j<n){
            if(prefix[i]<=suffix[j]){
                ans = Math.max(ans,j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return ans;
    }
}