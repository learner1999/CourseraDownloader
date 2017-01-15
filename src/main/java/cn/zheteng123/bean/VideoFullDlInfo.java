package cn.zheteng123.bean;

import cn.zheteng123.bean.json.VideoInfo;

/**
 * 包含完整视频下载信息，包括视频文件应该保存的路径，以及视频下载地址
 * Created on 2017/1/15.
 */
public class VideoFullDlInfo {

    private String path;  // 视频应该保存的路径（第一课\第一节\递归\……）
    private VideoInfo videoInfo;  // 包含视频下载地址等信息

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public VideoInfo getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.videoInfo = videoInfo;
    }
}
