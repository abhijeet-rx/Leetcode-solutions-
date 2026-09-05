// Problem: Course Schedule
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/course-schedule/
// Solved on: 2026-09-05T16:51:37.960Z

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the graph using an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Populate graph and indegree array
        // pair[0] is the course, pair[1] is the prerequisite
        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }
        
        // Queue for courses with 0 indegree (ready to be taken)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int coursesTaken = 0;
        
        // Process the graph
        while (!queue.isEmpty()) {
            int current = queue.poll();
            coursesTaken++;
            
            for (int neighbor : adj.get(current)) {
                indegree[neighbor]--;
                // If indegree becomes 0, all prerequisites are met
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If we processed all courses, then there is no cycle
        return coursesTaken == numCourses;
    }
}