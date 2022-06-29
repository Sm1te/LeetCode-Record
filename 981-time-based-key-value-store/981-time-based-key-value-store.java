class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList());
        }
        
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        
        List<Pair<Integer, String>> tmp = map.get(key);
        
        
        int lo = -1, hi = tmp.size();
        while(lo + 1 != hi){
            int mid = lo + (hi - lo) / 2;
            if(tmp.get(mid).getKey() <= timestamp)
                lo = mid;
            else
                hi = mid;
        }
        if(lo == -1)
            return "";
        return tmp.get(lo).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */