class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size();
        HashMap<String,List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            if(!mp.containsKey(tickets.get(i).get(0))){
                mp.put(tickets.get(i).get(0), new ArrayList<>());
            }
            mp.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }

        for(Map.Entry<String,List<String>> entry : mp.entrySet()){
            Collections.sort(entry.getValue());
        }

        return dfs("JFK", new ArrayList<>(), mp, n);
    }

    public List<String> dfs(String start, List<String> path, HashMap<String,List<String>> mp, int n){
        path.add(start);

        if(path.size() == n + 1){
            return path;
        }

        List<String> travel = mp.get(start);
        if(travel != null){
            for(int i = 0; i<travel.size(); i++){
                String visit = travel.get(i);
                travel.remove(visit);
                List<String> result = dfs(visit,path,mp,n);
                if(result != null) return result;
                travel.add(i,visit);
            }
        }

        path.remove(path.size() - 1);

        return null;
    }
}
