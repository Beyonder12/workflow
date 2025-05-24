package org.kie.kogito.handlers;

import org.kie.kogito.process.workitem.WorkItemExecutionException;

@javax.enterprise.context.ApplicationScoped()
public class CommentService_addCustomerComment_18_Handler implements org.kie.kogito.internal.process.runtime.KogitoWorkItemHandler {

    org.kie.kogito.flexible.example.service.CommentService service;

    public CommentService_addCustomerComment_18_Handler() {
        this(new org.kie.kogito.flexible.example.service.CommentService());
    }

    @javax.inject.Inject()
    public CommentService_addCustomerComment_18_Handler(org.kie.kogito.flexible.example.service.CommentService service) {
        this.service = service;
    }

    public void executeWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
        java.lang.Object result;
        result = service.addCustomerComment((org.kie.kogito.flexible.example.model.SupportCase) workItem.getParameter("supportCase"), (java.lang.String) workItem.getParameter("comment"), (java.lang.String) workItem.getParameter("author"));
        workItemManager.completeWorkItem(workItem.getStringId(), java.util.Collections.singletonMap("supportCase", result));
    }

    public void abortWorkItem(org.kie.kogito.internal.process.runtime.KogitoWorkItem workItem, org.kie.kogito.internal.process.runtime.KogitoWorkItemManager workItemManager) {
    }

    public String getName() {
        return "org.kie.kogito.flexible.example.service.CommentService_addCustomerComment_18_Handler";
    }
}
