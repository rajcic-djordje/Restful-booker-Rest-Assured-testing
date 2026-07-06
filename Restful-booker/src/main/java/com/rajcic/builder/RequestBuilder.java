package com.rajcic.builder;

import com.rajcic.specification.ReqSpecification;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RequestBuilder {

    public static Response auth( String path, Object body){
        return given()
                .spec(ReqSpecification.requestNoAuthBody(path,body))
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response getBookingIds( String path){
        return given()
                .spec(ReqSpecification.requestNoAuthNoBody(path))
                .log().all()
                .when()
                .get()
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response getBooking(String path){
        return given()
                .spec(ReqSpecification.requestNoAuthNoBody(path))
                .log().all()
                .when()
                .get()
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response createBooking(String path, Object body, String token){
        return given()
                .spec(ReqSpecification.requestAuthBody(path,body,token))
                .log().all()
                .when()
                .post()
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response updateBooking(String path, Object body, String token){
        return given()
                .spec(ReqSpecification.requestAuthBody(path, body, token))
                .log().all()
                .when()
                .put()
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response partialUpdateBooking(String path, Object body, String token){
        return given()
                .spec(ReqSpecification.requestAuthBody(path, body, token))
                .log().all()
                .when()
                .patch()
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response deleteBooking(String path, String token){
        return given()
                .spec(ReqSpecification.requestAuthNoBody(path,token))
                .log().all()
                .when()
                .delete()
                .then()
                .log().all()
                .extract()
                .response();
    }

}
