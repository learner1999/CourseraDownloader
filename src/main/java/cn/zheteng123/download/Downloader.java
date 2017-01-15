package cn.zheteng123.download;

import cn.zheteng123.bean.Course;

/**
 * Created on 2017/1/9.
 */
public abstract class Downloader {

    public abstract String convertToDownloadList(Course course);
}
