class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap();
        
        for(int[] pre : prerequisites){
            int from = pre[1];
            int to = pre[0];
            
            indegree[to]++;
            graph.putIfAbsent(from, new ArrayList());
            graph.get(from).add(to);
        }
            
        
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            count++;
            if(graph.get(tmp) == null)
                continue;
            for(int next : graph.get(tmp)){
                indegree[next]--;
                if(indegree[next] == 0)
                    queue.offer(next);
            }
            
            
        }
        
        return count == numCourses;
    }
}