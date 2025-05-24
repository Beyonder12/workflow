package com.example;

import com.example.SimpleModel;

public class SimpleProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<SimpleModel> {

    public SimpleProcessInstance(com.example.SimpleProcess process, SimpleModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public SimpleProcessInstance(com.example.SimpleProcess process, SimpleModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public SimpleProcessInstance(com.example.SimpleProcess process, SimpleModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public SimpleProcessInstance(com.example.SimpleProcess process, SimpleModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public SimpleProcessInstance(com.example.SimpleProcess process, SimpleModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(SimpleModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(SimpleModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
