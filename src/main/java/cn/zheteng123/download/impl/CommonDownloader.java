package cn.zheteng123.download.impl;

import cn.zheteng123.bean.Course;
import cn.zheteng123.bean.json.VideoInfo;
import cn.zheteng123.download.Downloader;

import java.util.List;

/**
 * 普通下载，仅导出下载地址
 * Created on 2017/1/14.
 */
public class CommonDownloader extends Downloader {

    @Override
    public String convertToDownloadList(Course course) {
        List<VideoInfo> videoInfoList = course.getVideoInfoList();

        String[] videoDownloadUrls = new String[videoInfoList.size()];
        for (int i = 0, length = videoInfoList.size(); i < length; i++) {
            videoDownloadUrls[i] = videoInfoList.get(i).linked.onDemandVideosV1s[0].sources.videoUrl.r720.mp4VideoUrl;
        }

        return String.join("\n", videoDownloadUrls);
    }
}
