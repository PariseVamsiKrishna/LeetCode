class Solution {
    public int timeRequiredToBuy(int[] tickets, int t) {
        Queue<Integer> q=new LinkedList<>();
        int cnt=0;
        for(int i=0;i<tickets.length;i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            int k=q.poll();
            tickets[k]-=1;
            cnt++;
            if(k==t && tickets[k]==0)
            return cnt;
            if(tickets[k]!=0)
            q.add(k);
        }
        return cnt;
    }
}