class Solution {
    public int timeRequiredToBuy(int[] tickets, int t) {
        int cnt=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(new int[]{tickets[i],i});
        }
        while(!q.isEmpty()){
            int k[]=q.poll();
            k[0]-=1;
            if(k[1]==t && k[0]==0)
            return cnt+1;
            if(k[0]!=0)
            q.add(k);
            cnt++;
        }
        return cnt;
    }
}