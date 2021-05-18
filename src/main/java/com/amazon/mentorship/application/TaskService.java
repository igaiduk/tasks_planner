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
package com.amazon.mentorship.application;

import com.amazon.mentorship.entities.Label;
import com.amazon.mentorship.entities.Priority;
import com.amazon.mentorship.entities.Task;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TaskService {

    @PersistenceContext(unitName = "book-pu")
    private EntityManager entityManager;

    public void addTask(Task task)
    {
      entityManager.persist(task);
    }

    public void removeTask(Task task)
    {
        entityManager.remove(task);
    }

    public List<Task> getAllTasks()
    {
        //NEED TO ADD USER FILTER (apps can be used by different people)
        CriteriaQuery<Task> cq = entityManager.getCriteriaBuilder().createQuery(Task.class);
        cq.select(cq.from(Task.class));
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Task> getTasksByLabel (Label label){
        //NEED TO ADD LOGIC
        return new ArrayList<Task>();

    }

    public List<Task> getTasksByPriority (Priority priority){
        //NEED TO ADD LOGIC
        return new ArrayList<Task>();

    }
}
