package BridgePattern;

/**
 * @author hsw
 * @create 2018-10-10  19:08
 */

interface VideoFile{
    void decode(String osType, String fileName);
}

class MPEGFile implements VideoFile {

    @Override
    public void decode(String osType, String fileName) {
        System.out.println("this is a mpeg video named " + fileName + " that played on " + osType + "operation system!");
    }
}

class RMVBFile implements VideoFile {

    @Override
    public void decode(String osType, String fileName) {
        System.out.println("this is a rmvb video named " + fileName + " that played on " + osType + "operation system!");
    }
}

class AVIFile implements VideoFile {

    @Override
    public void decode(String osType, String fileName) {
        System.out.println("this is a avi video named " + fileName + " that played on " + osType + "operation system!");
    }
}

class WMVFile implements VideoFile {

    @Override
    public void decode(String osType, String fileName) {
        System.out.println("this is a wmv video named " + fileName + " that played on " + osType + "operation system!");
    }
}


abstract class OperationSystemVersion{
    protected VideoFile videoFile;

    public void setVideoFile(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    abstract public void play(String fileName);
}

class WindowsVersion extends OperationSystemVersion {

    @Override
    public void play(String fileName) {
        videoFile.decode("windows", fileName);
    }
}

class LinuxVersion extends OperationSystemVersion {

    @Override
    public void play(String fileName) {
        videoFile.decode("linux", fileName);

    }
}

class MacVersion extends OperationSystemVersion {

    @Override
    public void play(String fileName) {
        videoFile.decode("macOS", fileName);
    }
}



public class VideoPlayer {

    public static void main(String[] args) {
        MacVersion macVersion = new MacVersion();
        VideoFile videoFile = new AVIFile();
        macVersion.setVideoFile(videoFile);
        macVersion.play("video-10");
    }

}
