package com.rajcic.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReqSpecification {

    public static RequestSpecification requestNoAuthNoBody(String path){
        return new RequestSpecBuilder()
                .setBasePath(path)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestAuthBody(String path, Object body, String token){
        return new RequestSpecBuilder()
                .setBasePath(path)
                .setBody(body)
                .addCookie("token", token)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestNoAuthBody(String path, Object body){
        return new RequestSpecBuilder()
                .setBasePath(path)
                .setBody(body)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestAuthNoBody(String path, String token){
        return new RequestSpecBuilder()
                .setBasePath(path)
                .addCookie("token", token)
                .setContentType(ContentType.JSON)
                .build();
    }

}
