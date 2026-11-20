class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree= new int[numCourses];

        for(int[] pair: prerequisites){
            int course= pair[0];
            int prereq= pair[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int course= q.poll();
            order[index++]= course;

            for(int next: graph.get(course)){
                indegree[next]--;

                if(indegree[next]==0)
                q.offer(next);
            }
        }

        if(index==numCourses)
        return order;

        return new int[0];
        
    }
}