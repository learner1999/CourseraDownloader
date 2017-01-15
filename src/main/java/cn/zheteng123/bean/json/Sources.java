package cn.zheteng123.bean.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 2017/1/15.
 */
public class Sources {

    public Playlists playlists;  // 播放列表，可以从这里面获得 m3u8 播放列表

    @SerializedName("byResolution")
    public VideoUrl videoUrl;  // 视频下载地址就在这里面
}
