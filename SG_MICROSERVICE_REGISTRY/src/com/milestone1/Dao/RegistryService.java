package com.milestone1.Dao;

import com.milestone1.DbService.DataService;
import com.milestone1.DbService.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by soumya on 9/24/16.
 */
@Path("/message")
public class RegistryService {
    DataService dataService = new DataService();
    String table = "Registry";

    @POST
    @Path("/saveData")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMsg(Message msg) throws SQLException, ClassNotFoundException {
        System.out.println(msg);
        System.out.println("UserId " + msg.getUserId());
        System.out.println("Ser I  = " + msg.getServiceId());
        System.out.println("ReqId " + msg.getReqId());
        System.out.println("Text  = " + msg.getText());
        String query = "INSERT INTO " + table + " VALUES (\"" + msg.getUserId() + "\"," + msg.getReqId() + ",\"" + msg.getServiceId() + "\",\"" + msg.getText() + "\");";
        System.out.println("Query is " + query);
        dataService.executeQuery(query);
        return Response.status(200).entity(msg).build();
    }

    @POST
    @Path("/getData")
    @Produces(MediaType.TEXT_PLAIN)
    public Response postReturn(Message msg) throws SQLException, ClassNotFoundException {
        String query = "SELECT * from " + table + ";";
        String someText = "";
        ResultSet rs = dataService.executeQueryAndGet(query);
        while (rs.next()) {
            String UserId = rs.getString(1);
            int RequestId = rs.getInt(2);
            String service = rs.getString(3);
            String text = rs.getString(4);
            someText = someText + UserId + " " + RequestId + " " + service + " " + text + "\n";
        }
        dataService.closeConnection();
        return Response.status(200).entity(someText).build();
    }
}
