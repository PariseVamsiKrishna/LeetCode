class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int dist[]=new int[n+1];
        int inf=Integer.MAX_VALUE;
        Arrays.fill(dist,inf);
        dist[k]=0;
        int min=-1;
        List<List<int[]>> l=new ArrayList<>();
        for(int i=0;i<=n;i++)
        l.add(new ArrayList<>());
        for(int i=0;i<times.length;i++){
            int from =times[i][0];
            int to=times[i][1];
            int wt=times[i][2];
            l.get(from).add(new int[]{to,wt});
        }
        PriorityQueue <int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int a[]=pq.poll();
            int from=a[1];
            int wt=a[0];
            if(dist[from]!=wt)
            continue;
            for(int i[]:l.get(from)){
                int to=i[0];
                int curr=wt+i[1];
                if(curr<dist[to]){
                    dist[to]=curr;
                    pq.add(new int[]{curr,to});
                }
            }
        }
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==inf)
            return -1;
            if(i!=k)
            min=Math.max(min,dist[i]);
        }
        return min;
        
    }
}