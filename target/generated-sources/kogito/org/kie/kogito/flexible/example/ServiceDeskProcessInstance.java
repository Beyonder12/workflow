package org.kie.kogito.flexible.example;

import org.kie.kogito.flexible.example.ServiceDeskModel;

public class ServiceDeskProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<ServiceDeskModel> {

    public ServiceDeskProcessInstance(org.kie.kogito.flexible.example.ServiceDeskProcess process, ServiceDeskModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public ServiceDeskProcessInstance(org.kie.kogito.flexible.example.ServiceDeskProcess process, ServiceDeskModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public ServiceDeskProcessInstance(org.kie.kogito.flexible.example.ServiceDeskProcess process, ServiceDeskModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public ServiceDeskProcessInstance(org.kie.kogito.flexible.example.ServiceDeskProcess process, ServiceDeskModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public ServiceDeskProcessInstance(org.kie.kogito.flexible.example.ServiceDeskProcess process, ServiceDeskModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(ServiceDeskModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(ServiceDeskModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
