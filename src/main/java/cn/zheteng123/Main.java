package cn.zheteng123;

import cn.zheteng123.bean.Course;
import cn.zheteng123.download.Downloader;
import cn.zheteng123.download.impl.CommonDownloader;
import cn.zheteng123.spider.Spider;

import java.util.Scanner;

/**
 * Created on 2017/1/9.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入cookie：");
        String strCookie = scanner.nextLine();

        System.out.println("请输入课程地址：");
        String strCourseUrl = scanner.nextLine();

        scanner.close();

        Spider spider = new Spider(strCookie);
        Course course = spider.fetchCourse(strCourseUrl);

        Downloader downloader = new CommonDownloader();
        String strDownloadList = downloader.convertToDownloadList(course);
        System.out.println(strDownloadList);
    }
}
