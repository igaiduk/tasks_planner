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
import com.amazon.mentorship.application.UserService;
import com.amazon.mentorship.entities.Label;
import com.amazon.mentorship.entities.Priority;
import com.amazon.mentorship.entities.Task;
import com.amazon.mentorship.entities.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserBean {

    @Inject
    private UserService userService;
    private List<User> usersList;
    private String login;
    private String fullName;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public String fetchAllUsers()
    {
        usersList=userService.getAllUsers();
        return "success";
    }

    public String add()
    {
        User user = new User(login, fullName);
        userService.addUser(user);
        return "success";
    }
}
