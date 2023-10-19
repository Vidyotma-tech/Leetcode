//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Pair{
    int node,level;
    public Pair(int node,int level)
    {
        this.node=node;
        this.level=level;
    }
}
class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        int vis[]=new int[V];
        Queue<Pair>q = new LinkedList<>();
        if(X==0)
        return 0;
        else
        { 
        q.add(new Pair(0,0));
        }
        while(!q.isEmpty())
        {
            
            int curr=q.peek().node;
            int lev=q.peek().level;
            q.remove();
            if(vis[curr]==0)
            {

            if(curr==X)
            return lev;
            for(int v:adj.get(curr))
            {
                
                q.add(new Pair(v,lev+1));
                
                
            }
            vis[curr]=1;
            }
           
        }
        return -1;
    }
}