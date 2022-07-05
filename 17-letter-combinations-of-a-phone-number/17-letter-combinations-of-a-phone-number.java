class Solution {
    Map<Character, List<Character>> map;
    List<String> res = new ArrayList();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == null)
            return new ArrayList();
        
        map = new HashMap();
        map.put('2', new ArrayList(Arrays.asList('a','b','c')));
        map.put('3', new ArrayList(Arrays.asList('d','e','f')));
        map.put('4', new ArrayList(Arrays.asList('g','h','i')));
        map.put('5', new ArrayList(Arrays.asList('j','k','l')));
        map.put('6', new ArrayList(Arrays.asList('m','n','o')));
        map.put('7', new ArrayList(Arrays.asList('p','q','r','s')));
        map.put('8', new ArrayList(Arrays.asList('t','u','v')));
        map.put('9', new ArrayList(Arrays.asList('w','x','y','z')));
        
        StringBuilder sb = new StringBuilder();
        char[] ch = digits.toCharArray();
        dfs(0, ch, sb);
        return res;
    }
    
    public void dfs(int start, char[] ch, StringBuilder sb){
        if(sb.length() == ch.length){
            res.add(sb.toString());
            return;
        }
            
        
        for(char c : map.get(ch[start])){
            sb.append(c);
            dfs(start + 1, ch, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}