package cn.zheteng123.bean.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 2017/1/15.
 */
public class VideoUrl {

    @SerializedName("720p")
    public Resolution r720;  // 720p 视频相关 url

    @SerializedName("360p")
    public Resolution r360;  // 360p 视频相关 url

    @SerializedName("540p")
    public Resolution r540;  // 540p 视频相关 url
}
