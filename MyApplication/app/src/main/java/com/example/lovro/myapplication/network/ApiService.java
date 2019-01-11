package com.example.lovro.myapplication.network;

import com.example.lovro.myapplication.domain.Offer;
import com.example.lovro.myapplication.domain.Order;
import com.example.lovro.myapplication.domain.Story;
import com.example.lovro.myapplication.domain.User;
import com.example.lovro.myapplication.domain.UserProfile;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

import retrofit2.http.Query;


public interface ApiService {

    @POST("/auth/register")
    Call<GenericResponse<User>> registerUser(@Body User user);

    @POST("/auth/login")
    Call<User> loginUser(@Header("Authorization") String auth,@Body User user);

    @GET("/advertisement/all")
    Call<List<Offer>> getAllOffers(@Header("Authorization") String auth);


    @POST("/orders/add/{advertisementId}")
    Call<Order> orderOffer(@Path("advertisementId") String offerId, @Query("styleId") String styleId, @Query("dimensionId") String dimensionId, @Body User user);

    @GET("/user/{username}")
    Call<UserProfile> getUserByUsername(@Header("Authorization") String auth, @Path("username") String username);

    @POST("/user/update")
    Call<ResponseBody> updateUser(@Header("Authorization") String auth, @Body User user);

    @GET("/user/{username}")
    Call<User> getUserByUsername2(@Header("Authorization") String auth, @Path("username") String username);

    @GET("/stories/all")
    Call<List<Story>> getAllStories();

    @GET("/stories/evaluation")
    Call<List<Story>> getStoriesInEvaluation(@Header("Authorization") String auth);

    @POST("/orders/orderDecoration/{advertisementId}")
    Call<Order> order_style(@Header("Authorization") String auth,@Path("advertisementId") String offerId, @Query("styleId") String styleId,@Query("styleName") String styleName,@Body User user);

    @GET("/orders")
    Call<List<Order>> getAllOrders(@Header("Authorization") String auth);

    @POST("/orders/manage")
    Call<ResponseBody> manageOrder(@Header("Authorization") String auth,@Query("orderId") String orderId,@Query("isAllowed") String isAllowed,@Query("price") String price);

    @POST("/stories/manage")
    Call<ResponseBody> manageStory(@Header("Authorization") String auth,@Query("storyId") String storyId,@Query("isAllowed") String isAllowed);

    @POST("/stories/setseen/{storyId}")
    Call<ResponseBody> setStorySeen(@Header("Authorization") String auth,@Path("storyId") String storyId);

}
