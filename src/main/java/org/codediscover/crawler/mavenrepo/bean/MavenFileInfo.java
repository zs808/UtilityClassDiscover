package org.codediscover.crawler.mavenrepo.bean;

/**
 * Maven仓库文件信息，用于记录到数据库执行一些统计
 * @author ZhangShuai　at 2018-01-10 22:27
 * @version 1.0
 */
public class MavenFileInfo {

    private String groupId;
    private String artifactId;
    private String version;
    private long lastModifiedTimestamp;
    private long fileSize;
    private String fileType;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

}
