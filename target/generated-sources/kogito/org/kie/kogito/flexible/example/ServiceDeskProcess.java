package org.kie.kogito.flexible.example;

import org.kie.kogito.flexible.example.ServiceDeskModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;
import org.jbpm.process.core.datatype.impl.type.IntegerDataType;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("serviceDesk")
@io.quarkus.runtime.Startup()
public class ServiceDeskProcess extends org.kie.kogito.process.impl.AbstractProcess<org.kie.kogito.flexible.example.ServiceDeskModel> {

    public ServiceDeskProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        this(app, correlations, factory, new org.kie.kogito.handlers.CommentService_addCustomerComment_18_Handler(), new org.kie.kogito.handlers.StateService_resolve_3_Handler(), new org.kie.kogito.handlers.StateService_close_13_Handler(), new org.kie.kogito.handlers.TriageService_assignEngineer_10_Handler(), new org.kie.kogito.handlers.CommentService_addSupportComment_19_Handler(), new org.kie.kogito.handlers.TriageService_assignEngineer_7_Handler());
    }

    @javax.inject.Inject()
    public ServiceDeskProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory, org.kie.kogito.handlers.CommentService_addCustomerComment_18_Handler commentService_addCustomerComment_18_Handler, org.kie.kogito.handlers.StateService_resolve_3_Handler stateService_resolve_3_Handler, org.kie.kogito.handlers.StateService_close_13_Handler stateService_close_13_Handler, org.kie.kogito.handlers.TriageService_assignEngineer_10_Handler triageService_assignEngineer_10_Handler, org.kie.kogito.handlers.CommentService_addSupportComment_19_Handler commentService_addSupportComment_19_Handler, org.kie.kogito.handlers.TriageService_assignEngineer_7_Handler triageService_assignEngineer_7_Handler) {
        super(app, java.util.Arrays.asList(commentService_addCustomerComment_18_Handler, stateService_resolve_3_Handler, stateService_close_13_Handler, triageService_assignEngineer_10_Handler, commentService_addSupportComment_19_Handler, triageService_assignEngineer_7_Handler), correlations, factory);
        activate();
    }

    public ServiceDeskProcess() {
    }

    @Override()
    public org.kie.kogito.flexible.example.ServiceDeskProcessInstance createInstance(org.kie.kogito.flexible.example.ServiceDeskModel value) {
        return new org.kie.kogito.flexible.example.ServiceDeskProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.kie.kogito.flexible.example.ServiceDeskProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.flexible.example.ServiceDeskModel value) {
        return new org.kie.kogito.flexible.example.ServiceDeskProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.kie.kogito.flexible.example.ServiceDeskProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.kie.kogito.flexible.example.ServiceDeskModel value) {
        return new org.kie.kogito.flexible.example.ServiceDeskProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.kie.kogito.flexible.example.ServiceDeskModel createModel() {
        return new org.kie.kogito.flexible.example.ServiceDeskModel();
    }

    public org.kie.kogito.flexible.example.ServiceDeskProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.kie.kogito.flexible.example.ServiceDeskModel) value);
    }

    public org.kie.kogito.flexible.example.ServiceDeskProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.kie.kogito.flexible.example.ServiceDeskModel) value);
    }

    public org.kie.kogito.flexible.example.ServiceDeskProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.flexible.example.ServiceDeskProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.kie.kogito.flexible.example.ServiceDeskProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.flexible.example.ServiceDeskProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("serviceDesk", false);
        factory.variable("supportCase", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.kie.kogito.flexible.example.model.SupportCase.class), null, "customTags", null);
        factory.variable("supportGroup", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("evaluation", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Integer.class), null, "customTags", null);
        factory.variable("comment", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("author", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("text", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.name("service-desk");
        factory.packageName("org.kie.kogito.flexible.example");
        factory.dynamic(true);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode1 = factory.endNode(1);
        endNode1.name("End");
        endNode1.terminate(false);
        endNode1.action(new org.jbpm.process.instance.impl.actions.SignalProcessInstanceAction("CaseResolved", (java.lang.String) null, null, "processInstance"));
        endNode1.metaData("UniqueId", "_DDF2782E-04C8-4F37-84D0-E94F62EEF4A8");
        endNode1.metaData("Ref", "CaseResolved");
        endNode1.metaData("Variable", null);
        endNode1.metaData("EventType", "signal");
        endNode1.metaData("x", 1853);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 571);
        endNode1.metaData("customScope", "processInstance");
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.MilestoneNodeFactory<?> milestoneNode2 = factory.milestoneNode(2);
        milestoneNode2.name("CaseResolved");
        milestoneNode2.done();
        milestoneNode2.metaData("UniqueId", "_45AC4CEC-35E3-416D-B12D-FCD1E64B747F");
        milestoneNode2.metaData("elementname", "CaseResolved");
        milestoneNode2.metaData("x", 888);
        milestoneNode2.metaData("width", 154);
        milestoneNode2.metaData("y", 970);
        milestoneNode2.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode3 = factory.workItemNode(3);
        workItemNode3.name("Resolve Case");
        workItemNode3.workName("org.kie.kogito.flexible.example.service.StateService_resolve_3_Handler");
        workItemNode3.workParameter("NodeName", "Resolve Case");
        workItemNode3.workParameter("Interface", "org.kie.kogito.flexible.example.service.StateService");
        workItemNode3.workParameter("Operation", "resolve");
        workItemNode3.workParameter("interfaceImplementationRef", "org.kie.kogito.flexible.example.service.StateService");
        workItemNode3.workParameter("operationImplementationRef", "resolve");
        workItemNode3.workParameter("implementation", "Java");
        workItemNode3.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_5DCB19C5-63B3-4846-A8C7-9E383306E915_supportCaseInputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null), null, null));
        workItemNode3.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_5DCB19C5-63B3-4846-A8C7-9E383306E915_supportCaseOutputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null)), new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null), null, null));
        workItemNode3.done();
        workItemNode3.metaData("UniqueId", "_5DCB19C5-63B3-4846-A8C7-9E383306E915");
        workItemNode3.metaData("Implementation", "Java");
        workItemNode3.metaData("elementname", "Resolve Case");
        workItemNode3.metaData("Type", "Service Task");
        workItemNode3.metaData("OperationRef", "_5DCB19C5-63B3-4846-A8C7-9E383306E915_ServiceOperation");
        workItemNode3.metaData("x", 1617);
        workItemNode3.metaData("width", 154);
        workItemNode3.metaData("y", 548);
        workItemNode3.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode4 = factory.endNode(4);
        endNode4.name("End");
        endNode4.terminate(true);
        endNode4.metaData("UniqueId", "_55BF884C-7565-42E0-8E28-3C699445C752");
        endNode4.metaData("x", 1874);
        endNode4.metaData("width", 56);
        endNode4.metaData("y", 993);
        endNode4.metaData("height", 56);
        endNode4.done();
        org.jbpm.ruleflow.core.factory.DynamicNodeFactory<?> compositeContextNode5 = factory.dynamicNode(5);
        compositeContextNode5.name("Triage");
        compositeContextNode5.metaData("UniqueId", "_DEC5E181-1E30-4E1B-9D27-3883D254656A");
        compositeContextNode5.metaData("elementname", "Triage");
        compositeContextNode5.metaData("x", 867);
        compositeContextNode5.metaData("width", 1087);
        compositeContextNode5.metaData("y", 155);
        compositeContextNode5.metaData("customAutoStart", "true");
        compositeContextNode5.metaData("height", 250);
        compositeContextNode5.language(null);
        compositeContextNode5.autoComplete(true);
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory<?> ruleSetNode6 = compositeContextNode5.ruleSetNode(6);
        ruleSetNode6.name("Assign to support group");
        ruleSetNode6.decision("https://kiegroup.org/dmn/_F8C450CC-F8B7-4E1E-A0EC-93E78572E912", "triage", null, () -> {
            return app.get(org.kie.kogito.decision.DecisionModels.class).getDecisionModel("https://kiegroup.org/dmn/_F8C450CC-F8B7-4E1E-A0EC-93E78572E912", "triage");
        });
        ruleSetNode6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_D792ADC8-9414-4F1A-9A3C-6339788A4EA3_namespaceInputX", "namespace", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("8e11d80b-1a2f-4be6-9a3d-b83ba923751d", "EXPRESSION (https://kiegroup.org/dmn/_F8C450CC-F8B7-4E1E-A0EC-93E78572E912)", "java.lang.Object", "https://kiegroup.org/dmn/_F8C450CC-F8B7-4E1E-A0EC-93E78572E912"), new org.jbpm.workflow.core.impl.DataDefinition("_D792ADC8-9414-4F1A-9A3C-6339788A4EA3_namespaceInputX", "namespace", "java.lang.String", null))), null));
        ruleSetNode6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_D792ADC8-9414-4F1A-9A3C-6339788A4EA3_modelInputX", "model", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("e2bf981b-7d0b-44f8-9185-36dec776a1bd", "EXPRESSION (triage)", "java.lang.Object", "triage"), new org.jbpm.workflow.core.impl.DataDefinition("_D792ADC8-9414-4F1A-9A3C-6339788A4EA3_modelInputX", "model", "java.lang.String", null))), null));
        ruleSetNode6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_D792ADC8-9414-4F1A-9A3C-6339788A4EA3_ProductFamilyInputX", "ProductFamily", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("c7f447fc-da46-47ee-8b7a-22ec8f7e38e6", "EXPRESSION (#{supportCase.product.family})", "java.lang.Object", "#{supportCase.product.family}"), new org.jbpm.workflow.core.impl.DataDefinition("_D792ADC8-9414-4F1A-9A3C-6339788A4EA3_ProductFamilyInputX", "ProductFamily", "String", null))), null));
        ruleSetNode6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_D792ADC8-9414-4F1A-9A3C-6339788A4EA3_ProductNameInputX", "ProductName", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("2acaaad6-edde-41f7-8d1e-8b674bb87cc8", "EXPRESSION (#{supportCase.product.name})", "java.lang.Object", "#{supportCase.product.name}"), new org.jbpm.workflow.core.impl.DataDefinition("_D792ADC8-9414-4F1A-9A3C-6339788A4EA3_ProductNameInputX", "ProductName", "String", null))), null));
        ruleSetNode6.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_D792ADC8-9414-4F1A-9A3C-6339788A4EA3_SupportGroupOutputX", "SupportGroup", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("supportGroup", "supportGroup", "java.lang.Object", null), null, null));
        ruleSetNode6.metaData("UniqueId", "_D792ADC8-9414-4F1A-9A3C-6339788A4EA3");
        ruleSetNode6.metaData("elementname", "Assign to support group");
        ruleSetNode6.metaData("x", 41);
        ruleSetNode6.metaData("width", 154);
        ruleSetNode6.metaData("y", 27);
        ruleSetNode6.metaData("customAutoStart", "true");
        ruleSetNode6.metaData("height", 102);
        ruleSetNode6.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode7 = compositeContextNode5.workItemNode(7);
        workItemNode7.name("Assign engineer");
        workItemNode7.workName("org.kie.kogito.flexible.example.service.TriageService_assignEngineer_7_Handler");
        workItemNode7.workParameter("NodeName", "Assign engineer");
        workItemNode7.workParameter("Interface", "org.kie.kogito.flexible.example.service.TriageService");
        workItemNode7.workParameter("Operation", "assignEngineer");
        workItemNode7.workParameter("interfaceImplementationRef", "org.kie.kogito.flexible.example.service.TriageService");
        workItemNode7.workParameter("operationImplementationRef", "assignEngineer");
        workItemNode7.workParameter("implementation", "Java");
        workItemNode7.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_D17F5E0D-779E-4AF4-9E33-6E37D8F54DA7_supportCaseInputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null), null, null));
        workItemNode7.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("supportGroup", "supportGroup", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_D17F5E0D-779E-4AF4-9E33-6E37D8F54DA7_supportGroupInputX", "supportGroup", "String", null), null, null));
        workItemNode7.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_D17F5E0D-779E-4AF4-9E33-6E37D8F54DA7_supportCaseOutputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null)), new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null), null, null));
        workItemNode7.done();
        workItemNode7.metaData("UniqueId", "_D17F5E0D-779E-4AF4-9E33-6E37D8F54DA7");
        workItemNode7.metaData("Implementation", "Java");
        workItemNode7.metaData("elementname", "Assign engineer");
        workItemNode7.metaData("Type", "Service Task");
        workItemNode7.metaData("OperationRef", "_D17F5E0D-779E-4AF4-9E33-6E37D8F54DA7_ServiceOperation");
        workItemNode7.metaData("x", 284);
        workItemNode7.metaData("width", 154);
        workItemNode7.metaData("y", 26);
        workItemNode7.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode8 = compositeContextNode5.endNode(8);
        endNode8.name("End");
        endNode8.terminate(false);
        endNode8.metaData("UniqueId", "_9E5BEC56-F886-4DE9-B26B-97661106F95C");
        endNode8.metaData("x", 513);
        endNode8.metaData("width", 56);
        endNode8.metaData("y", 165);
        endNode8.metaData("height", 56);
        endNode8.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode9 = compositeContextNode5.splitNode(9);
        splitNode9.name("Split");
        splitNode9.type(2);
        splitNode9.metaData("UniqueId", "_85828EFE-2E3A-48EA-B405-1B9856643F70");
        splitNode9.metaData("x", 514);
        splitNode9.metaData("width", 56);
        splitNode9.metaData("y", 49);
        splitNode9.metaData("Default", "_28168759-AF8E-47D3-9FEA-8095507ABEB7");
        splitNode9.metaData("height", 56);
        splitNode9.constraint(11, "_6B10C12D-99D4-4758-B2D3-32D8E527A287", "DROOLS_DEFAULT", "java", kcontext -> {
            org.kie.kogito.flexible.example.model.SupportCase supportCase = (org.kie.kogito.flexible.example.model.SupportCase) kcontext.getVariable("supportCase");
            java.lang.String supportGroup = (java.lang.String) kcontext.getVariable("supportGroup");
            return supportCase.getEngineer() == null;
        }, 0, false);
        splitNode9.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode10 = compositeContextNode5.workItemNode(10);
        workItemNode10.name("Set assigned");
        workItemNode10.workName("org.kie.kogito.flexible.example.service.TriageService_assignEngineer_10_Handler");
        workItemNode10.workParameter("NodeName", "Set assigned");
        workItemNode10.workParameter("Interface", "org.kie.kogito.flexible.example.service.TriageService");
        workItemNode10.workParameter("Operation", "assignEngineer");
        workItemNode10.workParameter("interfaceImplementationRef", "org.kie.kogito.flexible.example.service.TriageService");
        workItemNode10.workParameter("operationImplementationRef", "assignEngineer");
        workItemNode10.workParameter("implementation", "Java");
        workItemNode10.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_26E99F98-8E2E-4321-98A7-BE7570FF0BD2_supportCaseInputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null), null, null));
        workItemNode10.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_26E99F98-8E2E-4321-98A7-BE7570FF0BD2_supportGroupInputX", "supportGroup", "String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("4ed54036-5980-4718-8155-a2904c141502", "EXPRESSION ()", "java.lang.Object", ""), new org.jbpm.workflow.core.impl.DataDefinition("_26E99F98-8E2E-4321-98A7-BE7570FF0BD2_supportGroupInputX", "supportGroup", "String", null))), null));
        workItemNode10.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_26E99F98-8E2E-4321-98A7-BE7570FF0BD2_supportCaseOutputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null)), new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null), null, null));
        workItemNode10.done();
        workItemNode10.metaData("UniqueId", "_26E99F98-8E2E-4321-98A7-BE7570FF0BD2");
        workItemNode10.metaData("Implementation", "Java");
        workItemNode10.metaData("elementname", "Set assigned");
        workItemNode10.metaData("Type", "Service Task");
        workItemNode10.metaData("OperationRef", "_26E99F98-8E2E-4321-98A7-BE7570FF0BD2_ServiceOperation");
        workItemNode10.metaData("x", 908);
        workItemNode10.metaData("width", 154);
        workItemNode10.metaData("y", 27);
        workItemNode10.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode11 = compositeContextNode5.humanTaskNode(11);
        humanTaskNode11.name("Manual assignment");
        humanTaskNode11.workParameter("NodeName", "Manual assignment");
        humanTaskNode11.workParameter("TaskName", "ManualAssignment");
        humanTaskNode11.workParameter("Skippable", "false");
        humanTaskNode11.workParameter("GroupId", "support");
        humanTaskNode11.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_BACB7C86-E7FA-4E2B-931A-CC02C812A698_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("5fba2851-747c-4e58-bb43-1121ffa31142", "EXPRESSION (ManualAssignment)", "java.lang.Object", "ManualAssignment"), new org.jbpm.workflow.core.impl.DataDefinition("_BACB7C86-E7FA-4E2B-931A-CC02C812A698_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode11.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_BACB7C86-E7FA-4E2B-931A-CC02C812A698_supportCaseInputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null), null, null));
        humanTaskNode11.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_BACB7C86-E7FA-4E2B-931A-CC02C812A698_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("b1419926-7ce8-4928-bc47-24e3a4c3a678", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_BACB7C86-E7FA-4E2B-931A-CC02C812A698_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode11.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_BACB7C86-E7FA-4E2B-931A-CC02C812A698_GroupIdInputX", "GroupId", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("3df7ce7e-72f4-4597-8334-826405a02b20", "EXPRESSION (support)", "java.lang.Object", "support"), new org.jbpm.workflow.core.impl.DataDefinition("_BACB7C86-E7FA-4E2B-931A-CC02C812A698_GroupIdInputX", "GroupId", "Object", null))), null));
        humanTaskNode11.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_BACB7C86-E7FA-4E2B-931A-CC02C812A698_supportCaseOutputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null)), new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null), null, null));
        humanTaskNode11.done();
        humanTaskNode11.metaData("UniqueId", "_BACB7C86-E7FA-4E2B-931A-CC02C812A698");
        humanTaskNode11.metaData("elementname", "Manual assignment");
        humanTaskNode11.metaData("x", 652);
        humanTaskNode11.metaData("width", 154);
        humanTaskNode11.metaData("y", 27);
        humanTaskNode11.metaData("height", 102);
        compositeContextNode5.connection(6, 7, "_4D493B33-AE13-464F-B7F5-4A7A9A9044BA");
        compositeContextNode5.connection(9, 8, "_28168759-AF8E-47D3-9FEA-8095507ABEB7");
        compositeContextNode5.connection(7, 9, "_5CF61231-028A-4E4A-AC50-01C1737FEC0A");
        compositeContextNode5.connection(11, 10, "_DBE81078-2C21-4128-ADDE-CA5E170F0792");
        compositeContextNode5.connection(9, 11, "_6B10C12D-99D4-4758-B2D3-32D8E527A287");
        compositeContextNode5.done();
        org.jbpm.ruleflow.core.factory.DynamicNodeFactory<?> compositeContextNode12 = factory.dynamicNode(12);
        compositeContextNode12.name("Close");
        compositeContextNode12.metaData("UniqueId", "_B52D0C0C-3C10-4E14-8D95-146FA1E686CD");
        compositeContextNode12.metaData("elementname", "Close");
        compositeContextNode12.metaData("x", 1190);
        compositeContextNode12.metaData("width", 542);
        compositeContextNode12.metaData("y", 899);
        compositeContextNode12.metaData("height", 242);
        compositeContextNode12.variable("evaluation", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Integer.class), null, "customTags", null);
        compositeContextNode12.variable("comment", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        compositeContextNode12.language(null);
        compositeContextNode12.autoComplete(true);
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode13 = compositeContextNode12.workItemNode(13);
        workItemNode13.name("Save questionnaire");
        workItemNode13.workName("org.kie.kogito.flexible.example.service.StateService_close_13_Handler");
        workItemNode13.workParameter("NodeName", "Save questionnaire");
        workItemNode13.workParameter("Interface", "org.kie.kogito.flexible.example.service.StateService");
        workItemNode13.workParameter("Operation", "close");
        workItemNode13.workParameter("interfaceImplementationRef", "org.kie.kogito.flexible.example.service.StateService");
        workItemNode13.workParameter("operationImplementationRef", "close");
        workItemNode13.workParameter("implementation", "Java");
        workItemNode13.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_BEAA2A42-CD36-4A08-BB42-4823EAA5C137_supportCaseInputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null), null, null));
        workItemNode13.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("evaluation", "evaluation", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_BEAA2A42-CD36-4A08-BB42-4823EAA5C137_evaluationInputX", "evaluation", "Integer", null), null, null));
        workItemNode13.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("comment", "comment", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_BEAA2A42-CD36-4A08-BB42-4823EAA5C137_commentInputX", "comment", "String", null), null, null));
        workItemNode13.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_BEAA2A42-CD36-4A08-BB42-4823EAA5C137_supportCaseOutputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null)), new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null), null, null));
        workItemNode13.done();
        workItemNode13.metaData("UniqueId", "_BEAA2A42-CD36-4A08-BB42-4823EAA5C137");
        workItemNode13.metaData("Implementation", "Java");
        workItemNode13.metaData("elementname", "Save questionnaire");
        workItemNode13.metaData("Type", "Service Task");
        workItemNode13.metaData("OperationRef", "_BEAA2A42-CD36-4A08-BB42-4823EAA5C137_ServiceOperation");
        workItemNode13.metaData("x", 310);
        workItemNode13.metaData("width", 154);
        workItemNode13.metaData("y", 69);
        workItemNode13.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode14 = compositeContextNode12.humanTaskNode(14);
        humanTaskNode14.name("Questionnaire");
        humanTaskNode14.workParameter("NodeName", "Questionnaire");
        humanTaskNode14.workParameter("TaskName", "Questionnaire");
        humanTaskNode14.workParameter("Skippable", "false");
        humanTaskNode14.workParameter("GroupId", "customer");
        humanTaskNode14.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_AD768963-CBF7-4269-9D43-51FE0D5D2556_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("41c3b453-2ec1-44cd-9499-085541ad5640", "EXPRESSION (Questionnaire)", "java.lang.Object", "Questionnaire"), new org.jbpm.workflow.core.impl.DataDefinition("_AD768963-CBF7-4269-9D43-51FE0D5D2556_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode14.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_AD768963-CBF7-4269-9D43-51FE0D5D2556_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("50d38791-0b00-451f-b370-d216cd3759f1", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_AD768963-CBF7-4269-9D43-51FE0D5D2556_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode14.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_AD768963-CBF7-4269-9D43-51FE0D5D2556_GroupIdInputX", "GroupId", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("1c102b68-8de8-4f1d-a295-20b39ebe3d23", "EXPRESSION (customer)", "java.lang.Object", "customer"), new org.jbpm.workflow.core.impl.DataDefinition("_AD768963-CBF7-4269-9D43-51FE0D5D2556_GroupIdInputX", "GroupId", "Object", null))), null));
        humanTaskNode14.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_AD768963-CBF7-4269-9D43-51FE0D5D2556_evaluationOutputX", "evaluation", "Integer", null)), new org.jbpm.workflow.core.impl.DataDefinition("evaluation", "evaluation", "java.lang.Object", null), null, null));
        humanTaskNode14.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_AD768963-CBF7-4269-9D43-51FE0D5D2556_commentOutputX", "comment", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("comment", "comment", "java.lang.Object", null), null, null));
        humanTaskNode14.done();
        humanTaskNode14.metaData("UniqueId", "_AD768963-CBF7-4269-9D43-51FE0D5D2556");
        humanTaskNode14.metaData("elementname", "Questionnaire");
        humanTaskNode14.metaData("x", 78);
        humanTaskNode14.metaData("width", 154);
        humanTaskNode14.metaData("y", 69);
        humanTaskNode14.metaData("customAutoStart", "true");
        humanTaskNode14.metaData("height", 102);
        compositeContextNode12.connection(14, 13, "_56AFC157-45AE-44E0-A94D-52AE95EFC74B");
        compositeContextNode12.done();
        org.jbpm.ruleflow.core.factory.DynamicNodeFactory<?> compositeContextNode15 = factory.dynamicNode(15);
        compositeContextNode15.name("Work case");
        compositeContextNode15.metaData("UniqueId", "_E4F379CC-67C5-4233-8E01-9CC3505592E3");
        compositeContextNode15.metaData("elementname", "Work case");
        compositeContextNode15.metaData("x", 834);
        compositeContextNode15.metaData("width", 489);
        compositeContextNode15.metaData("y", 527);
        compositeContextNode15.metaData("customAutoStart", "true");
        compositeContextNode15.metaData("height", 290);
        compositeContextNode15.variable("comment", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        compositeContextNode15.variable("author", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        compositeContextNode15.variable("text", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        compositeContextNode15.language(null);
        compositeContextNode15.completionExpression(kcontext -> {
            org.kie.kogito.flexible.example.model.SupportCase supportCase = (org.kie.kogito.flexible.example.model.SupportCase) kcontext.getVariable("supportCase");
            java.lang.String supportGroup = (java.lang.String) kcontext.getVariable("supportGroup");
            return (org.kie.kogito.flexible.example.model.State.CLOSED.equals(supportCase.getState()));
        });
        compositeContextNode15.autoComplete(false);
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode16 = compositeContextNode15.humanTaskNode(16);
        humanTaskNode16.name("Receive customer comment");
        humanTaskNode16.workParameter("NodeName", "Receive customer comment");
        humanTaskNode16.workParameter("TaskName", "ReceiveCustomerComment");
        humanTaskNode16.workParameter("Skippable", "false");
        humanTaskNode16.workParameter("GroupId", "customer");
        humanTaskNode16.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_A969C299-2D86-449A-A608-E24C8B48723B_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("b697c5ca-1174-4c13-87da-32ac14e676c9", "EXPRESSION (ReceiveCustomerComment)", "java.lang.Object", "ReceiveCustomerComment"), new org.jbpm.workflow.core.impl.DataDefinition("_A969C299-2D86-449A-A608-E24C8B48723B_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode16.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_A969C299-2D86-449A-A608-E24C8B48723B_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("71c46a03-51b8-41a6-ad4c-79600e074021", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_A969C299-2D86-449A-A608-E24C8B48723B_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode16.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_A969C299-2D86-449A-A608-E24C8B48723B_GroupIdInputX", "GroupId", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("1f0c9275-33d9-43aa-a14d-61a59d973461", "EXPRESSION (customer)", "java.lang.Object", "customer"), new org.jbpm.workflow.core.impl.DataDefinition("_A969C299-2D86-449A-A608-E24C8B48723B_GroupIdInputX", "GroupId", "Object", null))), null));
        humanTaskNode16.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_A969C299-2D86-449A-A608-E24C8B48723B_commentOutputX", "comment", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("text", "text", "java.lang.Object", null), null, null));
        humanTaskNode16.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_A969C299-2D86-449A-A608-E24C8B48723B_ActorIdOutputX", "ActorId", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("author", "author", "java.lang.Object", null), null, null));
        humanTaskNode16.done();
        humanTaskNode16.metaData("UniqueId", "_A969C299-2D86-449A-A608-E24C8B48723B");
        humanTaskNode16.metaData("elementname", "Receive customer comment");
        humanTaskNode16.metaData("x", 57);
        humanTaskNode16.metaData("width", 154);
        humanTaskNode16.metaData("y", 153);
        humanTaskNode16.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode17 = compositeContextNode15.humanTaskNode(17);
        humanTaskNode17.name("Receive support comment");
        humanTaskNode17.workParameter("NodeName", "Receive support comment");
        humanTaskNode17.workParameter("TaskName", "ReceiveSupportComment");
        humanTaskNode17.workParameter("Skippable", "false");
        humanTaskNode17.workParameter("GroupId", "support");
        humanTaskNode17.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_C5983E55-DC49-4839-AC3E-3E8344A29262_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("bb916496-616d-4d2f-8b1f-959bce99ecbc", "EXPRESSION (ReceiveSupportComment)", "java.lang.Object", "ReceiveSupportComment"), new org.jbpm.workflow.core.impl.DataDefinition("_C5983E55-DC49-4839-AC3E-3E8344A29262_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode17.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_C5983E55-DC49-4839-AC3E-3E8344A29262_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("e57afce7-c26e-49e0-b088-9ddcb3b431b3", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_C5983E55-DC49-4839-AC3E-3E8344A29262_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode17.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_C5983E55-DC49-4839-AC3E-3E8344A29262_GroupIdInputX", "GroupId", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("5f2b0169-9d83-49bd-811a-9fce965d35cf", "EXPRESSION (support)", "java.lang.Object", "support"), new org.jbpm.workflow.core.impl.DataDefinition("_C5983E55-DC49-4839-AC3E-3E8344A29262_GroupIdInputX", "GroupId", "Object", null))), null));
        humanTaskNode17.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_C5983E55-DC49-4839-AC3E-3E8344A29262_commentOutputX", "comment", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("text", "text", "java.lang.Object", null), null, null));
        humanTaskNode17.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_C5983E55-DC49-4839-AC3E-3E8344A29262_ActorIdOutputX", "ActorId", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("author", "author", "java.lang.Object", null), null, null));
        humanTaskNode17.done();
        humanTaskNode17.metaData("UniqueId", "_C5983E55-DC49-4839-AC3E-3E8344A29262");
        humanTaskNode17.metaData("elementname", "Receive support comment");
        humanTaskNode17.metaData("x", 58);
        humanTaskNode17.metaData("width", 154);
        humanTaskNode17.metaData("y", 27);
        humanTaskNode17.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode18 = compositeContextNode15.workItemNode(18);
        workItemNode18.name("Add customer comment");
        workItemNode18.workName("org.kie.kogito.flexible.example.service.CommentService_addCustomerComment_18_Handler");
        workItemNode18.workParameter("NodeName", "Add customer comment");
        workItemNode18.workParameter("Interface", "org.kie.kogito.flexible.example.service.CommentService");
        workItemNode18.workParameter("Operation", "addCustomerComment");
        workItemNode18.workParameter("interfaceImplementationRef", "org.kie.kogito.flexible.example.service.CommentService");
        workItemNode18.workParameter("operationImplementationRef", "addCustomerComment");
        workItemNode18.workParameter("implementation", "Java");
        workItemNode18.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_5B1A92B6-7044-4C8B-9011-62CD592F255F_supportCaseInputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null), null, null));
        workItemNode18.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("text", "text", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_5B1A92B6-7044-4C8B-9011-62CD592F255F_commentInputX", "comment", "String", null), null, null));
        workItemNode18.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("author", "author", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_5B1A92B6-7044-4C8B-9011-62CD592F255F_authorInputX", "author", "String", null), null, null));
        workItemNode18.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_5B1A92B6-7044-4C8B-9011-62CD592F255F_supportCaseOutputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null)), new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null), null, null));
        workItemNode18.done();
        workItemNode18.metaData("UniqueId", "_5B1A92B6-7044-4C8B-9011-62CD592F255F");
        workItemNode18.metaData("Implementation", "Java");
        workItemNode18.metaData("elementname", "Add customer comment");
        workItemNode18.metaData("Type", "Service Task");
        workItemNode18.metaData("OperationRef", "_5B1A92B6-7044-4C8B-9011-62CD592F255F_ServiceOperation");
        workItemNode18.metaData("x", 291);
        workItemNode18.metaData("width", 154);
        workItemNode18.metaData("y", 148);
        workItemNode18.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode19 = compositeContextNode15.workItemNode(19);
        workItemNode19.name("Add support comment");
        workItemNode19.workName("org.kie.kogito.flexible.example.service.CommentService_addSupportComment_19_Handler");
        workItemNode19.workParameter("NodeName", "Add support comment");
        workItemNode19.workParameter("Interface", "org.kie.kogito.flexible.example.service.CommentService");
        workItemNode19.workParameter("Operation", "addSupportComment");
        workItemNode19.workParameter("interfaceImplementationRef", "org.kie.kogito.flexible.example.service.CommentService");
        workItemNode19.workParameter("operationImplementationRef", "addSupportComment");
        workItemNode19.workParameter("implementation", "Java");
        workItemNode19.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_D514F716-3F06-468F-A487-892F6089C776_supportCaseInputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null), null, null));
        workItemNode19.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("text", "text", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_D514F716-3F06-468F-A487-892F6089C776_commentInputX", "comment", "String", null), null, null));
        workItemNode19.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("author", "author", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_D514F716-3F06-468F-A487-892F6089C776_authorInputX", "author", "String", null), null, null));
        workItemNode19.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_D514F716-3F06-468F-A487-892F6089C776_supportCaseOutputX", "supportCase", "org.kie.kogito.flexible.example.model.SupportCase", null)), new org.jbpm.workflow.core.impl.DataDefinition("supportCase", "supportCase", "java.lang.Object", null), null, null));
        workItemNode19.done();
        workItemNode19.metaData("UniqueId", "_D514F716-3F06-468F-A487-892F6089C776");
        workItemNode19.metaData("Implementation", "Java");
        workItemNode19.metaData("elementname", "Add support comment");
        workItemNode19.metaData("Type", "Service Task");
        workItemNode19.metaData("OperationRef", "_D514F716-3F06-468F-A487-892F6089C776_ServiceOperation");
        workItemNode19.metaData("x", 290);
        workItemNode19.metaData("width", 154);
        workItemNode19.metaData("y", 26);
        workItemNode19.metaData("height", 102);
        compositeContextNode15.connection(16, 18, "_D49DA468-8A7B-4688-A8DB-5B09D1AE22B1");
        compositeContextNode15.connection(17, 19, "_021482FA-6264-4060-B11B-ABD91159122A");
        compositeContextNode15.done();
        factory.connection(3, 1, "_C651F6F2-8C0D-4E9A-94B3-0BB337536F51");
        factory.connection(12, 4, "_5F0BDEDA-D879-463C-B6F8-5AA428868280");
        factory.connection(2, 12, "_2F6C0443-87BB-4ACB-BF06-16017E0C69A9");
        factory.validate();
        return factory.getProcess();
    }
}
