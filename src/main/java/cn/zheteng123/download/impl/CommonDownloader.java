package cn.zheteng123.download.impl;

import cn.zheteng123.bean.Course;
import cn.zheteng123.bean.VideoFullDlInfo;
import cn.zheteng123.download.Downloader;

import java.util.List;

/**
 * 普通下载，仅导出下载地址
 * Created on 2017/1/14.
 */
public class CommonDownloader extends Downloader {

    @Override
    public String convertToDownloadList(Course course) {
        List<VideoFullDlInfo> videoFullDlInfoList = course.getVideoFullDlInfoList();

        String[] videoDownloadUrls = new String[videoFullDlInfoList.size()];
        for (int i = 0, length = videoFullDlInfoList.size(); i < length; i++) {
            videoDownloadUrls[i] = videoFullDlInfoList.get(i).getVideoInfo().linked.onDemandVideosV1s[0].sources.videoUrl.r720.mp4VideoUrl;
        }

        return String.join("\n", videoDownloadUrls);
    }
}
