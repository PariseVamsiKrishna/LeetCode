class Solution {
    List<List<int[]>> l=new ArrayList<>();
    int threshold;
    int n;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        this.n=n;
        for(int i=0;i<n;i++)
        l.add(new ArrayList<>());
        threshold=distanceThreshold;
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            l.get(u).add(new int[]{v,wt});
            l.get(v).add(new int[]{u,wt});
        }
        int min=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++){
            int res=dijkstra(i);
            if(res<=min){
                min=res;
                ans=i;
            }
        }
        return ans;
    }
    public int dijkstra(int root){
        int dist[]=new int[n];
        int inf=Integer.MAX_VALUE;
        Arrays.fill(dist,inf);
        dist[root]=0;
        int cnt=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,root});
        while(!pq.isEmpty()){
            int k[]=pq.poll();
            int from=k[1];
            int cost=k[0];
            if(dist[from]!=cost)
            continue;
            for(int i[]:l.get(from)){
                int to=i[0];
                int curr=i[1]+cost;
                if(curr<dist[to]){
                    dist[to]=curr;
                    if(curr<=threshold)
                    pq.add(new int[]{curr,to});
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]<=threshold)
            cnt++;
        }
        return cnt-1;
    }
}