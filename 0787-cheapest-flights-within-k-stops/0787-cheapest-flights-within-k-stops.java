class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph= new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] f: flights){
            graph.get(f[0]).add(new int[]{f[1],f[2]});
        }

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,src,0});

        int[][] best= new int[n][k+2];
        for(int[] row: best){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        while(!pq.isEmpty()){
            int[] curr= pq.poll();

            int cost= curr[0];
            int node= curr[1];
            int stops= curr[2];

            if(node==dst)
            return cost;

            if(stops==k+1)
            continue;

            for(int[] edge: graph.get(node)){
                int next= edge[0];
                int price= edge[1];

                int newCost= cost+ price;

                if(newCost<best[next][stops+1]){
                    best[next][stops+1]= newCost;
                    pq.add(new int[] {newCost,next,stops+1});
                }
            }
        }
        return -1;
    }
}