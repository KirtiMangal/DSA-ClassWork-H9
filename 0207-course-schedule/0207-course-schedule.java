class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            q.offer(i);
        }
    }

    int count=0;
    while(!q.isEmpty()){
        int course= q.poll();
        count++;

        for(int neighbour: graph.get(course)){
            indegree[neighbour]--;

            if(indegree[neighbour]==0){
                q.offer(neighbour);
            }
        }
    }

    return count==numCourses;
}
}