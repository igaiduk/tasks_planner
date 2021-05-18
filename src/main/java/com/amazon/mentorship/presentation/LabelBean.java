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

import com.amazon.mentorship.application.BookService;
import com.amazon.mentorship.application.LabelService;
import com.amazon.mentorship.entities.Book;
import com.amazon.mentorship.entities.Label;
import com.amazon.mentorship.entities.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class LabelBean {

    @Inject
    private LabelService labelService;
    private List<Label> labelsList;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Label> getLabelsList() {
        return labelsList;
    }

    public void setLabelsList(List<Label> labelsList) {
        this.labelsList = labelsList;
    }

    public String fetchAllLabels()
    {
        labelsList=labelService.getAllLabels();
        return "success";
    }

    public String add()
    {
        //temporary variable, should be replaced by current app user
        User owner = new User("igaiduk", "Iryna Gaiduk");

        Label label = new Label(name, owner);
        labelService.addLabel(label);
        return "success";
    }
}
