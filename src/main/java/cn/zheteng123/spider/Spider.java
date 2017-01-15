package cn.zheteng123.spider;

import cn.zheteng123.bean.Course;
import cn.zheteng123.bean.json.ContentSummary;
import cn.zheteng123.bean.json.CourseStore;
import cn.zheteng123.bean.json.Element;
import cn.zheteng123.bean.json.VideoInfo;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/1/9.
 */
public class Spider {

    private final String LECTURE = "lecture";

    private String strCookie;

    private OkHttpClient client;

    private List<String> videoIdList = new ArrayList<>();
    private List<VideoInfo> videoInfoList = new ArrayList<>();

    public Spider(String strCookie) {
        this.strCookie = strCookie;
        client = new OkHttpClient();
    }

    /**
     * 爬取课程信息
     * @param url 课程地址（课程主页或者章节地址均可）
     * @return 课程信息
     */
    public Course fetchCourse(String url) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("cookie", strCookie)
                .build();

        String str = null;
        try {
            Response response = client.newCall(request).execute();
            str = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonData = str.split("\"CourseStore\":")[1].split(",\"SessionStore\"")[0].trim();

        CourseStore courseStore = new Gson().fromJson(jsonData, CourseStore.class);

        traverseElement(courseStore.rawCourseMaterials.courseMaterialsData.elements);

        for (String videoId : videoIdList) {
            VideoInfo videoInfo = fetchVideoInfo(courseStore.courseId, videoId);
            videoInfoList.add(videoInfo);
        }

        Course course = new Course();
        course.setId(courseStore.courseId);
        course.setVideoInfoList(videoInfoList);

        return course;
    }

    /**
     * 获取课程视频信息，包括视频下载地址、字幕等
     * @param courseId 课程 id
     * @param elementId 节点 id（也就是视频 id）
     */
    public VideoInfo fetchVideoInfo(String courseId, String elementId) {
        String url = String.format(
                "https://www.coursera.org/api/onDemandLectureVideos.v1/%s~%s?includes=video&fields=onDemandVideos.v1(sources%%2Csubtitles%%2CsubtitlesVtt%%2CsubtitlesTxt)",
                courseId,
                elementId
        );

        Request reqGetVideoInfo = new Request.Builder()
                .url(url)
                .build();
        String jsonDataVideo = null;
        try {
            Response resGetVideoInfo = client.newCall(reqGetVideoInfo).execute();
            jsonDataVideo = resGetVideoInfo.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        VideoInfo videoInfo = null;
        if (jsonDataVideo != null) {
            videoInfo = new Gson().fromJson(jsonDataVideo, VideoInfo.class);
        }
        return videoInfo;
    }

    /**
     * 递归遍历课程节点 element
     * @param elements 课程节点
     */
    private void traverseElement(Element[] elements) {
        if (elements == null) {
            return;
        }

        for (Element element : elements) {
            ContentSummary contentSummary = element.contentSummary;

            if (contentSummary != null && LECTURE.equals(contentSummary.typeName)) {
                videoIdList.add(element.id);
                continue;
            }
            traverseElement(element.elements);
        }
    }
}
