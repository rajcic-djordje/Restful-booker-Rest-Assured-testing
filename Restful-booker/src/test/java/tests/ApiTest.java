package tests;

import com.rajcic.builder.RequestBuilder;
import com.rajcic.classes.response.Booking;
import com.rajcic.classes.response.BookingDates;
import com.rajcic.classes.response.BookingResponse;
import constants.TestConstants;
import data.ApiTestData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class ApiTest extends BaseTest{

    BookingResponse created;
    int createdId;
    @BeforeClass
    public void testsSetUp(){

        BookingDates bd = new BookingDates(ApiTestData.BOOKING_CHECKIN, ApiTestData.BOOKING_CHECKOUT);

        Booking b = new Booking (ApiTestData.BOOKING_FIRST_NAME, ApiTestData.BOOKING_LAST_NAME,
                ApiTestData.BOOKING_TOTAL_PRICE, ApiTestData.BOOKING_DEPOSIT_PAID, bd,
                ApiTestData.BOOKING_ADDITIONAL_NEEDS);

        Response r = RequestBuilder.createBooking(TestConstants.CREATE_BOOKING_PATH, b,token);

        Assert.assertEquals(r.statusCode(), 200, r.asString());

        created = r.as(BookingResponse.class);
        Assert.assertNotNull(created);

        createdId = created.getBookingId();




    }

    @Test(priority = 6)
    public void getBookingIdsTest(){

        Response r = RequestBuilder.getBookingIds(TestConstants.GET_BOOKING_IDS_PATH);

        Assert.assertEquals(r.statusCode(), 200);

        List<Integer> bookingIds = r.jsonPath().getList("bookingid");

        Assert.assertFalse(bookingIds.isEmpty());
        Assert.assertNotNull(bookingIds.getFirst());

    }

    @Test(priority = 1)
    public void getBookingTest(){

        Response r = RequestBuilder.getBooking(TestConstants.GET_BOOKING_PATH+createdId);

        Assert.assertEquals(r.statusCode(), 200);
        Booking b = r.as(Booking.class);
        Assert.assertEquals(b.getFirstName(), ApiTestData.BOOKING_FIRST_NAME);
        Assert.assertEquals(b.getLastName(), ApiTestData.BOOKING_LAST_NAME);


    }

    @Test(priority = 2)
    public void createBookingTest(){

        BookingDates bd = new BookingDates(ApiTestData.createBookingTest_BOOKING_CHECKIN, ApiTestData.createBookingTest_BOOKING_CHECKOUT);

        Booking b = new Booking(ApiTestData.createBookingTest_BOOKING_FIRST_NAME, ApiTestData.createBookingTest_BOOKING_LAST_NAME,
                ApiTestData.createBookingTest_BOOKING_TOTAL_PRICE, ApiTestData.createBookingTest_BOOKING_DEPOSIT_PAID, bd,
                ApiTestData.createBookingTest_BOOKING_ADDITIONAL_NEEDS);

        Response r = RequestBuilder.createBooking(TestConstants.CREATE_BOOKING_PATH, b, token);


        Assert.assertEquals(r.statusCode(), 200);
        BookingResponse resBooking = r.as(BookingResponse.class);

        Assert.assertEquals(resBooking.getBooking().getFirstName(), ApiTestData.createBookingTest_BOOKING_FIRST_NAME);
        Assert.assertEquals(resBooking.getBooking().getLastName(), ApiTestData.createBookingTest_BOOKING_LAST_NAME);

    }

    @Test(priority = 3)
    public void updateBookingTest(){

        BookingDates bd = new BookingDates(ApiTestData.updateBookingTest_BOOKING_CHECKIN, ApiTestData.updateBookingTest_BOOKING_CHECKOUT);

        System.out.println(TestConstants.UPDATE_BOOKING_PATH + createdId);

        Booking b = new Booking(ApiTestData.updateBookingTest_BOOKING_FIRST_NAME, ApiTestData.updateBookingTest_BOOKING_LAST_NAME,
                ApiTestData.updateBookingTest_BOOKING_TOTAL_PRICE, ApiTestData.updateBookingTest_BOOKING_DEPOSIT_PAID, bd,
                ApiTestData.updateBookingTest_BOOKING_ADDITIONAL_NEEDS);
        Response r = RequestBuilder.updateBooking(TestConstants.UPDATE_BOOKING_PATH+createdId, b, token);


        Assert.assertEquals(r.statusCode(), 200);
        Booking resBooking = r.as(Booking.class);
        Assert.assertEquals(resBooking.getFirstName(), ApiTestData.updateBookingTest_BOOKING_FIRST_NAME);
        Assert.assertEquals(resBooking.getLastName(), ApiTestData.updateBookingTest_BOOKING_LAST_NAME);

    }

    @Test(priority = 4)
    public void partialUpdateBookingTest(){


        HashMap<String, Object> booking = new HashMap<>();

        booking.put("firstname", ApiTestData.partialUpdateBookingTest_BOOKING_FIRST_NAME);
        booking.put("lastname", ApiTestData.partialUpdateBookingTest_BOOKING_LAST_NAME);

        Response r = RequestBuilder.partialUpdateBooking(TestConstants.PARTIAL_UPDATE_BOOKING_PATH+createdId, booking, token);


        Assert.assertEquals(r.statusCode(), 200);
        Booking resBooking = r.as(Booking.class);
        Assert.assertEquals(resBooking.getFirstName(), ApiTestData.partialUpdateBookingTest_BOOKING_FIRST_NAME);
        Assert.assertEquals(resBooking.getLastName(), ApiTestData.partialUpdateBookingTest_BOOKING_LAST_NAME);


    }

    @Test(priority = 5)
    public void deleteBookingTest(){

        Response r = RequestBuilder.deleteBooking(TestConstants.DELETE_BOOKING_PATH+createdId, token);
        Assert.assertEquals(r.statusCode(), 201);
    }

}
