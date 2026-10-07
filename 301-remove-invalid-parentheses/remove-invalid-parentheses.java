import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        
       
        if (isValid(s)) {
            result.add(s);
            return result;
        }

        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(s);
        visited.add(s);
        
        boolean found = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            
            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();

                
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                
                if (found) {
                    continue;
                }

                
                for (int j = 0; j < current.length(); j++) {
                    char c = current.charAt(j);
                    
                    
                    if (c != '(' && c != ')') {
                        continue;
                    }

                    
                    String nextState = current.substring(0, j) + current.substring(j + 1);

                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }
            
            
            if (found) {
                break;
            }
        }

        return result;
    }

    
    private boolean isValid(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false; 
                }
            }
        }
        return count == 0;
    }
}
