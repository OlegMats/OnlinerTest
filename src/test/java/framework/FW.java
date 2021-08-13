package framework;

import com.google.gson.Gson;
import framework.logging.Logger;
import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class FW {
    public static String WORKSPACE_DIRECTORY = System.getProperty("user.dir");
    public static Path CurrentTestDirectory;
    private static Logger logger;
    public static FwConfig configuration;

    public static Logger Log() {
        if (logger != null)
            return logger;
        throw new NullPointerException("logger is null. SetLogger() first");
    }

    public static Path CreateTestDirectory() throws IOException {
        Path testDirectory = Paths.get(WORKSPACE_DIRECTORY + "\\TestResults");
        try {
            Files.deleteIfExists(testDirectory);
        } catch (DirectoryNotEmptyException e) {
            Files.walk(testDirectory)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
        return Files.createDirectory(testDirectory);
    }

    public static void SetLogger(String testName) throws IOException {
        String testResultDir = WORKSPACE_DIRECTORY + "\\TestResults";

        String fullPath = testResultDir + String.format("\\%s", testName);

        CurrentTestDirectory = Files.createDirectory(Paths.get(fullPath));
        logger = new Logger(CurrentTestDirectory + "\\log.txt");
    }

    public static FwConfig Config() {
        if (configuration != null)
            return configuration;
        throw new NullPointerException("Config is null. Call FW.SetConfig() first");
    }

    public static void SetConfig() {
        if (configuration == null) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader("framework-configuration.json"));
            } catch (FileNotFoundException e) {
                FW.Log().Error("Json file is absent in the project root directory");
                e.printStackTrace();
            }
            configuration = new Gson().fromJson(reader, FwConfig.class);
        }
    }
}
