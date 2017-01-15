package cn.zheteng123.download.impl;

import cn.zheteng123.bean.Course;
import cn.zheteng123.bean.VideoFullDlInfo;
import cn.zheteng123.bean.json.OnDemandVideosV1;
import cn.zheteng123.download.Downloader;

import java.util.List;

/**
 * Created on 2017/1/9.
 */
public class IdmDownloader extends Downloader {

    /**
     * 在针对 IDM 导出下载列表时，由于没有找到更好的方法使得视频下载时能保存为正确的文件名，
     * 因此在这里采取了一个比较奇葩的方式，使用 cmd 命令。
     * 因为 IDM 是支持命令行的，所以这里程序化导出下载命令。
     * 使用方式为：保存输出的文本为 .bat 扩展名的文本文件，拷贝至 IDM 程序目录下，然后双击执行即可。
     * @param course 课程信息
     * @return 命令行（.bat）
     */
    public String convertToDownloadList(Course course) {
        List<VideoFullDlInfo> videoFullDlInfoList = course.getVideoFullDlInfoList();

        StringBuilder sb = new StringBuilder();
        for (VideoFullDlInfo videoFullDlInfo : videoFullDlInfoList) {
            OnDemandVideosV1 onDemandVideosV1 = videoFullDlInfo.getVideoInfo().linked.onDemandVideosV1s[0];

            sb.append("IDMan.exe");
            sb.append(" /d ").append("\"").append(onDemandVideosV1.sources.videoUrl.r720.mp4VideoUrl).append("\"");
            sb.append(" /p ").append("D:\\CourseraDownloader");
            sb.append(" /f ").append(videoFullDlInfo.getPath());
            sb.append("\n");
        }

        return sb.toString();
    }
}
