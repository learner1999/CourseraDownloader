package cn.zheteng123.bean;

/**
 * 视频下载信息，包含下载应该保存的路径，以及视频的 id
 * Created on 2017/1/15.
 */
public class VideoDlInfo {

    private String path;  // 视频应该保存的路径
    private String id;  // 视频的 id

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
