package com.teambition.kafka.admin.rest;

import com.teambition.kafka.model.Model;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/consumers")
public class ConsumerAPI {
  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<String> getConsumerGroups() {
    return Model.getInstance().getZookeeperChildren("/consumers");
  }

  @GET
  @Path("/{group}")
  @Produces(MediaType.APPLICATION_JSON)
  public Collection<String> getConsumerGroupTopics(@PathParam("group") String group) {
    return Model.getInstance().getZkTopicsByConsumerGroup(group);
  }
}