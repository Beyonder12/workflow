/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "simple2", name = "Simple2", hidden = true)
public class Simple2ModelOutput implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<Simple2Model> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "param1")
    @javax.validation.Valid()
    private java.lang.String param1;

    public java.lang.String getParam1() {
        return param1;
    }

    public void setParam1(java.lang.String param1) {
        this.param1 = param1;
    }

    @Override()
    public Simple2Model toModel() {
        Simple2Model result = new Simple2Model();
        result.setId(getId());
        result.setParam1(getParam1());
        return result;
    }
}
