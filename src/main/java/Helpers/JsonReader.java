package Helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonReader {
    public String getJson(String jsonPath) {
        Path path = Paths.get(jsonPath);
        try {

            return new String(Files.readAllBytes(path));
        }
        catch (IOException e)
        {
            return null;
        }
    }

    public String getUserList() {
        return getJson(new PathFinder().getPathToUsers());
    }

    public String getUserById() {
        return getJson(new PathFinder().getPathToUserById());
    }

    public String getBookInfoById1() {
        return getJson(new PathFinder().getPathToBookInfoById1());
    }

    public String getBookInfoList() {
        return getJson(new PathFinder().getPathToBookInfoList());
    }

    public String getBookInfoById2() {
        return getJson((new PathFinder().getPathToBookInfoById2()));
    }
}
