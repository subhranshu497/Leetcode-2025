package com.design;

import java.util.*;

public class TodoList {
    Map<Integer, TreeSet<Task>> userAndTaskDetailMap;
    private static int taskId=1;
    public TodoList() {
        userAndTaskDetailMap = new HashMap<>();
    }

    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        taskId++;
        if(!userAndTaskDetailMap.containsKey(userId)){
            userAndTaskDetailMap.put(userId, new TreeSet<>((a,b)->a.dueDate-b.dueDate));
        }
        Task t = new Task(taskId, taskDescription, dueDate, tags);
        userAndTaskDetailMap.get(userId).add(t);
        return taskId;
    }

    public List<String> getAllTasks(int userId) {
        List<String> allTasks = new ArrayList<>();
        if(userAndTaskDetailMap.containsKey(userId)){
            for(Task t:userAndTaskDetailMap.get(userId)){
                allTasks.add(t.taskDescription);
            }
        }
        return allTasks;
    }

    public List<String> getTasksForTag(int userId, String tag) {
        List<String> taskFoTag = new ArrayList<>();
        if(userAndTaskDetailMap.containsKey(userId)){
            for(Task t:userAndTaskDetailMap.get(userId)){
                if(t.tags.contains(tag))
                    taskFoTag.add(t.taskDescription);
            }
        }
        return taskFoTag;
    }

    public void completeTask(int userId, int taskId) {
        if(userAndTaskDetailMap.containsKey(userId)){
            Task task = null;
            for(Task t:userAndTaskDetailMap.get(userId)){
                if(t.taskId==taskId){
                    task = t;
                    break;
                }
            }
            if(task !=null){
                userAndTaskDetailMap.get(userId).remove(task);
            }
        }
    }
}
class Task{
    public int taskId;
    public String taskDescription;
    public int dueDate;
    public Set<String> tags;
    public Task(int taskId, String taskDescription, int dueDate, List<String> tags){
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.tags = Set.copyOf(tags);
    }



}

