class Solution {
    Map<String, List<String>> map;
    Set<String> visited;
    List<List<String>> res;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {        
        map = new HashMap();
        res = new ArrayList();
        visited = new HashSet();
        buildGraph(accounts);
        addItems(accounts);
        return res;
    }
    public void dfs(String first, List<String> list){
        if(visited.contains(first))
            return;
        
        visited.add(first);
        list.add(first);
        for(String next : map.get(first))
            dfs(next, list);
    }
    public void addItems(List<List<String>> accounts){
        
        for(List<String> account : accounts){
            String name = account.get(0);
            String first = account.get(1);
            
            if(!visited.contains(first)){
                List<String> mergedAccount = new ArrayList();
                mergedAccount.add(name);
                
                dfs(first, mergedAccount);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                res.add(mergedAccount);
            }
        }
    }
    
    public void buildGraph(List<List<String>> accounts){

        for(List<String> account : accounts){
            String first = account.get(1);
            map.putIfAbsent(first, new ArrayList());
            
            // Undirected graph
            for(int i = 1; i < account.size(); i++){
                String second = account.get(i);
                map.get(first).add(second);
                map.putIfAbsent(second, new ArrayList());
                map.get(second).add(first);
            }
        }
        
        
    }
}