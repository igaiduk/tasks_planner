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

import com.amazon.mentorship.application.CommentaryService;
import com.amazon.mentorship.application.TaskService;
import com.amazon.mentorship.entities.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CommentaryBean {

    @Inject
    private CommentaryService commentaryService;
    private List<Commentary> commentariesList;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Commentary> getCommentariesList() {
        return commentariesList;
    }

    public void setCommentariesList(List<Commentary> commentariesList) {
        this.commentariesList = commentariesList;
    }

    public String fetchAllCommentariesForTask()
    {
        commentariesList=commentaryService.getAllCommentariesForTask();
        return "success";
    }

    public String add()
    {
        //temporary variable, should be replaced by current app user
        User owner = new User("igaiduk", "Iryna Gaiduk");
        Commentary commentary = new Commentary(text, owner);
        commentaryService.addCommentary(commentary);
        //NEED TO ADD commentary to the list of commentaries for proper task
        return "success";
    }
}
