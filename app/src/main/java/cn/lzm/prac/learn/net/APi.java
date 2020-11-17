package cn.lzm.prac.learn.net;

import cn.lzm.prac.learn.model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APi {

    @GET("/TouTiao/Query")
    Call<News> getNews(@Query("key") String key, @Query("type") String type);

}
