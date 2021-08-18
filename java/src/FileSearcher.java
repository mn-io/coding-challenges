import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileSearcher {
    public static void main(String[] args) {
        File root = new File("/");
        File result = findWideFirst(Collections.singletonList(root), "CV Mario Neises.pdf");
        System.out.println(result.getAbsolutePath());
    }

    public static File findDeptFirst(File file, String name) {
        if (name == null || name.length() == 0) {
            return null;
        }

        if (!file.isDirectory()) {
            return null;
        }

        System.out.println("Looking in: " + file.getAbsolutePath());

        File[] files = file.listFiles();
        if (files == null) {
            return null;
        }

        for (File f : files) {
            if (f.isFile() && f.getName().equals(name)) {
                return f;
            }
        }

        for (File f : files) {
            if (!f.isDirectory()) {
                continue;
            }

            File result = findDeptFirst(f, name);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    private static File findWideFirst(List<File> directories, String name) {
        if (name == null || name.length() == 0) {
            return null;
        }

        ArrayList<File> subDirectories = new ArrayList<>();

        for (File directory : directories) {
            System.out.println("Looking in: " + directory.getAbsolutePath());
            File[] files = directory.listFiles();
            if (files == null) {
                continue;
            }

            for (File file : files) {
                if (file.isFile() && file.getName().equals(name)) {
                    return file;
                }
                if (file.isDirectory()) {
                    subDirectories.add(file);
                }
            }
        }

        return findWideFirst(subDirectories, name);
    }
}
