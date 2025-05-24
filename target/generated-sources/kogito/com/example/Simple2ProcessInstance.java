package com.example;

import com.example.Simple2Model;

public class Simple2ProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<Simple2Model> {

    public Simple2ProcessInstance(com.example.Simple2Process process, Simple2Model value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public Simple2ProcessInstance(com.example.Simple2Process process, Simple2Model value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public Simple2ProcessInstance(com.example.Simple2Process process, Simple2Model value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public Simple2ProcessInstance(com.example.Simple2Process process, Simple2Model value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public Simple2ProcessInstance(com.example.Simple2Process process, Simple2Model value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(Simple2Model variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(Simple2Model variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
