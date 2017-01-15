package cn.zheteng123.bean;

import java.util.List;

/**
 * Created on 2017/1/9.
 * 最后爬取完成后包含课程所有视频名称及下载地址的实体类
 */
public class Course {

    private String id;
    private List<VideoFullDlInfo> videoFullDlInfoList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<VideoFullDlInfo> getVideoFullDlInfoList() {
        return videoFullDlInfoList;
    }

    public void setVideoFullDlInfoList(List<VideoFullDlInfo> videoFullDlInfoList) {
        this.videoFullDlInfoList = videoFullDlInfoList;
    }
}
