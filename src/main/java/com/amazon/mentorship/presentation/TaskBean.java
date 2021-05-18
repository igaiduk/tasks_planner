/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.amazon.mentorship.presentation;

import com.amazon.mentorship.application.TaskService;
import com.amazon.mentorship.entities.Label;
import com.amazon.mentorship.entities.Priority;
import com.amazon.mentorship.entities.Task;
import com.amazon.mentorship.entities.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TaskBean {

    @Inject
    private TaskService taskService;
    private List<Task> tasksList;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Task> tasksList) {
        this.tasksList = tasksList;
    }

    public String fetchAllTasks()
    {
        tasksList=taskService.getAllTasks();
        return "success";
    }

    public String fetchTasksByLabel(Label label)
    {
        tasksList=taskService.getTasksByLabel(label);
        return "success";
    }

    public String fetchTasksByPriority(Priority priority)
    {
        tasksList=taskService.getTasksByPriority(priority);
        return "success";
    }

    public String add()
    {
        //temporary variable, should be replaced by current app user
        User owner = new User("igaiduk", "Iryna Gaiduk");
        Task task = new Task(name, Priority.PRIORITY_2, owner);
        return "success";
    }
}
