package cn.zheteng123.bean;

import cn.zheteng123.bean.json.VideoInfo;

import java.util.List;

/**
 * Created on 2017/1/9.
 * 最后爬取完成后包含课程所有视频名称及下载地址的实体类
 */
public class Course {

    private String id;
    private List<VideoInfo> videoInfoList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<VideoInfo> getVideoInfoList() {
        return videoInfoList;
    }

    public void setVideoInfoList(List<VideoInfo> videoInfoList) {
        this.videoInfoList = videoInfoList;
    }
}
