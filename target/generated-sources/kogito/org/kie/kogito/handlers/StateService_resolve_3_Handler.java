package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@javax.enterprise.context.ApplicationScoped()
public class StateService_resolve_3_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    org.kie.kogito.flexible.example.service.StateService service;

    public StateService_resolve_3_Handler() {
        this(new org.kie.kogito.flexible.example.service.StateService());
    }

    @javax.inject.Inject()
    public StateService_resolve_3_Handler(org.kie.kogito.flexible.example.service.StateService service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        java.lang.Object result;
        result = service.resolve((org.kie.kogito.flexible.example.model.SupportCase) workItem.getParameter("supportCase"));
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.singletonMap("supportCase", result));
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "org.kie.kogito.flexible.example.service.StateService_resolve_3_Handler";
    }
}
