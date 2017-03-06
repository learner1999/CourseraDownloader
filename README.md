# CourseraDownloader
Coursera Video Downloader Helper（Coursera 课程视频下载工具）
自动生成 IDM 批量下载，课程按照模块放置在不同的文件夹中，同时支持下载字幕，当前默认下载中文字幕，没有中文字幕则下载英文字幕。
## 使用方法：
1. 运行程序后输入 cookie（cookie获取方式参考下文）和课程地址即可导出 IDM 下载命令。
2. 在 IDM 主程序目录下新建 .bat 批处理文件，将 CourseraDownloader 输出的命令粘贴进去，保存退出。
3. 双击 .bat 文件，即可弹出 IDM 下载窗口。

## cookie 获取方法
这里以 Chrome 举例，打开浏览器开发者工具，切换到 Network 标签，访问 Coursera 课程页面，随意选取一个请求，找到 Request Headers 中的 Cookie，将后面的一整串粘贴进程序中即可。
![开发者工具获取 cookie](http://i1.piimg.com/567571/46e37770245e1dca.png)
