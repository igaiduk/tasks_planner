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
import com.amazon.mentorship.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class UserService {

    @PersistenceContext(unitName = "book-pu")
    private EntityManager entityManager;

    public void addUser(User user)
    {
      entityManager.persist(user);
    }

    public void removeLabel(User user)
    {
        entityManager.remove(user);
    }

    public List<User> getAllUsers()
    {
        //NEED TO ADD USER FILTER (apps can be used by different people)
        CriteriaQuery<User> cq = entityManager.getCriteriaBuilder().createQuery(User.class);
        cq.select(cq.from(User.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
