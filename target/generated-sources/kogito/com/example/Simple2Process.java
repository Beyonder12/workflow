package com.example;

import com.example.Simple2Model;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@javax.enterprise.context.ApplicationScoped()
@javax.inject.Named("simple2")
@io.quarkus.runtime.Startup()
public class Simple2Process extends org.kie.kogito.process.impl.AbstractProcess<com.example.Simple2Model> {

    @javax.inject.Inject()
    public Simple2Process(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        super(app, java.util.Arrays.asList(), correlations, factory);
        activate();
    }

    public Simple2Process() {
    }

    @Override()
    public com.example.Simple2ProcessInstance createInstance(com.example.Simple2Model value) {
        return new com.example.Simple2ProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.Simple2ProcessInstance createInstance(java.lang.String businessKey, com.example.Simple2Model value) {
        return new com.example.Simple2ProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.Simple2ProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.Simple2Model value) {
        return new com.example.Simple2ProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.Simple2Model createModel() {
        return new com.example.Simple2Model();
    }

    public com.example.Simple2ProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.Simple2Model) value);
    }

    public com.example.Simple2ProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.Simple2Model) value);
    }

    public com.example.Simple2ProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.Simple2ProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.Simple2ProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.Simple2ProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("simple2", true);
        factory.variable("param1", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.name("simple no 2");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("2.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode1 = factory.startNode(1);
        startNode1.name("Start");
        startNode1.interrupting(true);
        startNode1.metaData("UniqueId", "_8CD81EE3-1D92-477F-BBBE-F688F1197697");
        startNode1.metaData("x", 9);
        startNode1.metaData("width", 56);
        startNode1.metaData("y", 243);
        startNode1.metaData("height", 56);
        startNode1.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode2 = factory.endNode(2);
        endNode2.name("End");
        endNode2.terminate(false);
        endNode2.metaData("UniqueId", "_A5A4B163-8760-4CE1-931B-1AEAF13128DB");
        endNode2.metaData("x", 1151);
        endNode2.metaData("width", 56);
        endNode2.metaData("y", 243);
        endNode2.metaData("height", 56);
        endNode2.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode3 = factory.humanTaskNode(3);
        humanTaskNode3.name("Review");
        humanTaskNode3.workParameter("NodeName", "Review");
        humanTaskNode3.workParameter("TaskName", "Review");
        humanTaskNode3.workParameter("Skippable", "false");
        humanTaskNode3.workParameter("ActorId", "kurnia");
        humanTaskNode3.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_3CC19965-0BB6-420A-BE43-2A95C471FE98_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("970482f6-71a8-4f15-9a90-7cf102e35597", "EXPRESSION (Review)", "java.lang.Object", "Review"), new org.jbpm.workflow.core.impl.DataDefinition("_3CC19965-0BB6-420A-BE43-2A95C471FE98_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode3.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_3CC19965-0BB6-420A-BE43-2A95C471FE98_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("36db7c1f-c4a7-4d25-87d0-1cbb77902a98", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_3CC19965-0BB6-420A-BE43-2A95C471FE98_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode3.done();
        humanTaskNode3.metaData("UniqueId", "_3CC19965-0BB6-420A-BE43-2A95C471FE98");
        humanTaskNode3.metaData("elementname", "Review");
        humanTaskNode3.metaData("x", 876);
        humanTaskNode3.metaData("width", 154);
        humanTaskNode3.metaData("y", 220);
        humanTaskNode3.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode4 = factory.joinNode(4);
        joinNode4.name("Join");
        joinNode4.type(1);
        joinNode4.metaData("UniqueId", "_41CB3E40-D8CF-412E-BA36-F3FB69F53948");
        joinNode4.metaData("x", 769);
        joinNode4.metaData("width", 56);
        joinNode4.metaData("y", 243);
        joinNode4.metaData("height", 56);
        joinNode4.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode5 = factory.actionNode(5);
        actionNode5.name("Task C");
        actionNode5.action(kcontext -> {
            System.out.println("task 333");
        });
        actionNode5.metaData("UniqueId", "_FE1A7D03-FD1E-4127-8B40-5D0A1BA1AB35");
        actionNode5.metaData("elementname", "Task C");
        actionNode5.metaData("NodeType", "ScriptTask");
        actionNode5.metaData("x", 350);
        actionNode5.metaData("width", 154);
        actionNode5.metaData("y", 400);
        actionNode5.metaData("height", 102);
        actionNode5.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode6 = factory.actionNode(6);
        actionNode6.name("Task B");
        actionNode6.action(kcontext -> {
            System.out.println("task 1");
        });
        actionNode6.metaData("UniqueId", "_8B77B97E-1F6D-443A-B192-A734C6FF5AE2");
        actionNode6.metaData("elementname", "Task B");
        actionNode6.metaData("NodeType", "ScriptTask");
        actionNode6.metaData("x", 541);
        actionNode6.metaData("width", 154);
        actionNode6.metaData("y", 220);
        actionNode6.metaData("height", 102);
        actionNode6.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode7 = factory.splitNode(7);
        splitNode7.name("Split");
        splitNode7.type(1);
        splitNode7.metaData("UniqueId", "_6EFDCB63-9430-4DEB-BE42-DBD83C5B129F");
        splitNode7.metaData("x", 399);
        splitNode7.metaData("width", 56);
        splitNode7.metaData("y", 243);
        splitNode7.metaData("height", 56);
        splitNode7.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode8 = factory.actionNode(8);
        actionNode8.name("Task A");
        actionNode8.action(kcontext -> {
            System.out.println("task 111");
        });
        actionNode8.metaData("UniqueId", "_3FEADC15-12D6-4BCA-A5DF-40BDB862F115");
        actionNode8.metaData("elementname", "Task A");
        actionNode8.metaData("NodeType", "ScriptTask");
        actionNode8.metaData("x", 165);
        actionNode8.metaData("width", 154);
        actionNode8.metaData("y", 220);
        actionNode8.metaData("height", 102);
        actionNode8.done();
        factory.connection(3, 2, "_CC2BADA9-4CCE-41FF-A8D9-F52FC7E25E95");
        factory.connection(4, 3, "_232B4D4F-B06B-45E2-97B6-181A5DECC76E");
        factory.connection(5, 4, "_254AB4B3-3DAA-44BE-9B54-32968554F4DF");
        factory.connection(6, 4, "_938AE5B7-6B6D-4D41-8E7B-6F92242DC679");
        factory.connection(7, 5, "_7E48E6E0-A86A-4B72-9301-747DE8447AFB");
        factory.connection(7, 6, "_4B2A649A-4C3D-49AF-BB31-FA902C6DE753");
        factory.connection(8, 7, "_52550CBC-5BF2-4FDE-AFB3-F9EAA4BF6817");
        factory.connection(1, 8, "_C05AEB04-B019-408D-B762-74CF6E97A983");
        factory.validate();
        return factory.getProcess();
    }
}
