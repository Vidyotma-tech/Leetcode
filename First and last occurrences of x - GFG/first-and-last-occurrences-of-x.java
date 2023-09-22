//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    int fo=-1,lo=-1;
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int f = 0,l=n-1;
        firstOcc(arr,x,f,l);
        f = 0;l=n-1;
        lastOcc(arr,x,f,l);
        ans.add(fo);
        ans.add(lo);
        return ans;
    }
    void firstOcc(int arr[],int x,int f,int l){
        while(f<=l){
            int mid = (f+l)/2;
            if(arr[mid]==x){
                fo = mid;
                l=mid-1;
            }
            else if(arr[mid]>x){
                l = mid-1;
            }
            else {
                f = mid+1;
            }
        }
    }
    void lastOcc(int arr[],int x,int f,int l){
        while(f<=l){
            int mid = (f+l)/2;
            if(arr[mid]==x){
                lo = mid;
                f=mid+1;
            }
            else if(arr[mid]>x){
                l = mid-1;
            }
            else {
                f = mid+1;
            }
        }
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends