/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jbpm.util.JsonSchemaUtil;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.WorkItem;
import org.kie.kogito.process.ProcessService;
import org.kie.kogito.process.workitem.Attachment;
import org.kie.kogito.process.workitem.AttachmentInfo;
import org.kie.kogito.process.workitem.Comment;
import org.kie.kogito.process.workitem.Policies;
import org.kie.kogito.process.workitem.TaskModel;
import org.kie.kogito.auth.IdentityProvider;
import org.kie.kogito.auth.IdentityProviders;
import org.kie.kogito.auth.SecurityPolicy;

@Path("/simple2")
@org.eclipse.microprofile.openapi.annotations.tags.Tag(name = "simple2")
@javax.enterprise.context.ApplicationScoped()
public class Simple2Resource {

    @javax.inject.Inject()
    @javax.inject.Named("simple2")
    Process<Simple2Model> process;

    @Inject
    ProcessService processService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "simple2", description = "")
    public Response createResource_simple2(@Context HttpHeaders httpHeaders, @Context UriInfo uriInfo, @QueryParam("businessKey") @DefaultValue("") String businessKey, @javax.validation.Valid() @javax.validation.constraints.NotNull() Simple2ModelInput resource) {
        ProcessInstance<Simple2Model> pi = processService.createProcessInstance(process, businessKey, Optional.ofNullable(resource).orElse(new Simple2ModelInput()).toModel(), httpHeaders.getRequestHeaders(), httpHeaders.getHeaderString("X-KOGITO-StartFromNode"));
        return Response.created(uriInfo.getAbsolutePathBuilder().path(pi.id()).build()).entity(pi.checkError().variables().toModel()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "simple2", description = "")
    public List<Simple2ModelOutput> getResources_simple2() {
        return processService.getProcessInstanceOutput(process);
    }

    @GET
    @Path("schema")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "simple2", description = "")
    public Map<String, Object> getResourceSchema_simple2() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "simple2", description = "")
    public Simple2ModelOutput getResource_simple2(@PathParam("id") String id) {
        return processService.findById(process, id).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "simple2", description = "")
    public Simple2ModelOutput deleteResource_simple2(@PathParam("id") final String id) {
        return processService.delete(process, id).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "simple2", description = "")
    public Simple2ModelOutput updateModel_simple2(@PathParam("id") String id, @javax.validation.Valid() @javax.validation.constraints.NotNull() Simple2ModelInput resource) {
        return processService.update(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "simple2", description = "")
    public Simple2ModelOutput updateModelPartial_simple2(@PathParam("id") String id, @javax.validation.Valid() @javax.validation.constraints.NotNull() Simple2ModelInput resource) {
        return processService.updatePartial(process, id, resource.toModel()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/tasks")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "simple2", description = "")
    public List<TaskModel> getTasks_simple2(@PathParam("id") String id, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTasks(process, id, SecurityPolicy.of(IdentityProviders.of(user, groups))).orElseThrow(NotFoundException::new).stream().map(com.example.Simple2_TaskModelFactory::from).collect(Collectors.toList());
    }

    @POST
    @Path("/{id}/Review/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Simple2ModelOutput completeTask_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("complete") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Simple2_3_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Review/{taskId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public com.example.Simple2_3_TaskOutput saveTask_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Simple2_3_TaskOutput model) {
        return processService.saveTask(process, id, taskId, SecurityPolicy.of(user, groups), model, com.example.Simple2_3_TaskOutput::fromMap).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Review/{taskId}/phases/{phase}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Simple2ModelOutput taskTransition_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("phase") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, final com.example.Simple2_3_TaskOutput model) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), model).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Review/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.example.Simple2_3_TaskModel getTask_Review_0(@PathParam("id") String id, @PathParam("taskId") String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getTask(process, id, taskId, SecurityPolicy.of(user, groups), com.example.Simple2_3_TaskModel::from).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Review/{taskId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Simple2ModelOutput abortTask_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("phase") @DefaultValue("abort") final String phase, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.taskTransition(process, id, taskId, phase, SecurityPolicy.of(user, groups), null).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("Review/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchema_Review_0() {
        return JsonSchemaUtil.load(this.getClass().getClassLoader(), process.id(), "Review");
    }

    @GET
    @Path("/{id}/Review/{taskId}/schema")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getSchemaAndPhases_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getSchemaAndPhases(process, id, taskId, "Review", SecurityPolicy.of(user, groups));
    }

    @POST
    @Path("/{id}/Review/{taskId}/comments")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String commentInfo, @Context UriInfo uriInfo) {
        return processService.addComment(process, id, taskId, SecurityPolicy.of(user, groups), commentInfo).map(comment -> Response.created(uriInfo.getAbsolutePathBuilder().path(comment.getId().toString()).build()).entity(comment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Review/{taskId}/comments/{commentId}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment updateComment_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, String comment) {
        return processService.updateComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups), comment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Review/{taskId}/comments/{commentId}")
    public Response deleteComment_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @POST
    @Path("/{id}/Review/{taskId}/attachments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAttachment_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachmentInfo, @Context UriInfo uriInfo) {
        return processService.addAttachment(process, id, taskId, SecurityPolicy.of(user, groups), attachmentInfo).map(attachment -> Response.created(uriInfo.getAbsolutePathBuilder().path(attachment.getId().toString()).build()).entity(attachment).build()).orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}/Review/{taskId}/attachments/{attachmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment updateAttachment_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups, AttachmentInfo attachment) {
        return processService.updateAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups), attachment).orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}/Review/{taskId}/attachments/{attachmentId}")
    public Response deleteAttachment_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.deleteAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).map(removed -> (removed ? Response.ok() : Response.status(Status.NOT_FOUND)).build()).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Review/{taskId}/attachments/{attachmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Attachment getAttachment_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("attachmentId") final String attachmentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachment(process, id, taskId, attachmentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Attachment " + attachmentId + " not found"));
    }

    @GET
    @Path("/{id}/Review/{taskId}/attachments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Attachment> getAttachments_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getAttachments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }

    @GET
    @Path("/{id}/Review/{taskId}/comments/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @PathParam("commentId") final String commentId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComment(process, id, taskId, commentId, SecurityPolicy.of(user, groups)).orElseThrow(() -> new NotFoundException("Comment " + commentId + " not found"));
    }

    @GET
    @Path("/{id}/Review/{taskId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Comment> getComments_Review_0(@PathParam("id") final String id, @PathParam("taskId") final String taskId, @QueryParam("user") final String user, @QueryParam("group") final List<String> groups) {
        return processService.getComments(process, id, taskId, SecurityPolicy.of(user, groups)).orElseThrow(NotFoundException::new);
    }
}
