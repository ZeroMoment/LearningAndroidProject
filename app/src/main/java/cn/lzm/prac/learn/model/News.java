package cn.lzm.prac.learn.model;

import java.util.ArrayList;
import java.util.List;

import cn.lzm.prac.learn.listener.LoadListener;
import cn.lzm.prac.learn.net.APi;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class News {

    private ResultBean result;
    private int error_code;
    private String reason;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean {
        private List<NewsItem> data;

        public List<NewsItem> getData() {
            return data;
        }

        public void setData(List<NewsItem> data) {
            this.data = data;
        }
    }

    // 通过传进来的url，利用retrofit获取网络数据，回调给viewModel
    public void loadData(final LoadListener<NewsItem> loadListener) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.avatardata.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APi aPi = retrofit.create(APi.class);
        Call<News> newsCall = aPi.getNews("907f854aff2d450bbf89e9b73bb733bf", "top");
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                // 获取成功
                if(response.body().getResult() == null || response.body().getResult().getData() == null || response.body().getResult().getData().size() < 1) {
                    return;
                }
                loadListener.loadSuccess(response.body().getResult().getData());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                // 获取失败
                loadListener.loadFailure(t.getMessage());
            }
        });
    }
}
