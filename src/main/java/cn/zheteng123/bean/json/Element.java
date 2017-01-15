package cn.zheteng123.bean.json;

/**
 * 课程信息节点，根据 contentSummary 中的内容判断是否是视频
 * Created on 2017/1/14.
 */
public class Element {

    public String id;
    public String name;
    public String slug;
    public String description;
    public long timeCommitment;
    public ContentSummary contentSummary;
    public Element[] elements;
}
