package com.wu.test.net.retrofit;

import com.wu.test.entity.DesignRes;
import com.wu.test.entity.FeedBack;
import com.wu.test.entity.User;
import com.wu.test.entity.response.Response;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    ////////////////////////////// 通用接口 //////////////////////////////
    // 登录用户
    @GET("/1/login")
    Flowable<Response<User>> login(
            @Query("username") String username,
            @Query("password") String password);

    // 注册用户
    @POST("/1/users")
    Flowable<User> register(
            @Body User user);

    // 修改用户详情(注意, 提交什么参数修改什么参数)
    @PUT("/1/users/{objectId}")
    Flowable<Object> updateUserById(
            @Path("objectId") String userId,
            @Body Map<String, Object> updateInfo);

    // 上传图片接口
    @POST("/1/files/{fileName}")
    Flowable<Object> fileUpload(
            @Path("fileName") String fileName,
            @Body RequestBody image);

    // 查询app更新信息
    @GET("/1/classes/AppUpdateInfo")
    Flowable<Object> getAppUpdateInfo();

    // 提交意见反馈
    @POST("/1/classes/FeedBack")
    Flowable<Object> addFeedBack(
            @Body FeedBack feedBack);


    ////////////////////////////// 业务接口 //////////////////////////////

    // 查询设计资源
    @GET("/1/classes/DesignRes")
    Flowable<DesignRes> getDesignRes(
            @Query("limit") int perPageCount,
            @Query("skip") int page);
}