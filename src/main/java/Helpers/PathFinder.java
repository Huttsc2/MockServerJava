package Helpers;

public class PathFinder {

    private final String PathToData = "\\src\\main\\java\\ExpectationData\\";

    public String getRootDirectory() {
        return System.getProperty("user.dir");
    }

    public String getPathToUsers() {
        return getRootDirectory() + PathToData + "users.json";
    }

    public String getPathToUserById() {
        return  getRootDirectory() + PathToData + "user1.json";
    }

    public String getPathToBookInfoById1() {
        return  getRootDirectory() + PathToData + "BookInfoId1.json";
    }

    public String getPathToBookInfoList() {
        return  getRootDirectory() + PathToData + "BookInfoList.json";
    }

    public String getPathToBookInfoById2() {
        return  getRootDirectory() + PathToData + "BookInfoId2.json";
    }
}
