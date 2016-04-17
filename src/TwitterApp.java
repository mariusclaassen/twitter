/*
 * Marius Claassen
 * 17 April 2016
 *
 * AllanGray Assignment:
 * Simulate a twitter feed
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TwitterApp {
    public static void main(String[] args) throws IOException {

        // Create 3 user objects
        User allan = new User();
        User martin = new User();
        User ward = new User();

        // Read and display tweets of each user
        readTextFilesUserAllan("C:/Users/mariuscn/IdeaProjects/twitter/src/user.txt",
                "C:/Users/mariuscn/IdeaProjects/twitter/src/tweet.txt",
                allan);

        readTextFilesUserMartin("C:/Users/mariuscn/IdeaProjects/twitter/src/user.txt",
                "C:/Users/mariuscn/IdeaProjects/twitter/src/tweet.txt",
                martin);

        readTextFilesUserWard("C:/Users/mariuscn/IdeaProjects/twitter/src/user.txt",
                "C:/Users/mariuscn/IdeaProjects/twitter/src/tweet.txt",
                ward);
    }

    private static void readTextFilesUserAllan(String userFile, String tweetFile, User user) {
        Path tweetFilePath = Paths.get(tweetFile);
        List<String> tweets;

        try (BufferedReader bufferedReader = Files.newBufferedReader(tweetFilePath)) {
            tweets = bufferedReader.lines().sorted().limit(2).collect(Collectors.toList());
            System.out.println("Allan\n");
            tweets.forEach(message -> System.out.printf("\t@%s\n\n", message));
        } catch (IOException e) {
            System.out.println("File not found: " + tweetFile);
        }
    }

    private static void readTextFilesUserMartin(String userFile, String tweetFile, User user) {
        Path tweetFilePath = Paths.get(tweetFile);
        List<String> tweets;

        try (BufferedReader bufferedReader = Files.newBufferedReader(tweetFilePath)) {
            tweets = bufferedReader.lines().sorted().limit(2).collect(Collectors.toList());
            System.out.println("Martin\n");
        } catch (IOException e) {
            System.out.println("File not found: " + tweetFile);
        }
    }

    private static void readTextFilesUserWard(String userFile, String tweetFile, User user) {
        Path tweetFilePath = Paths.get(tweetFile);
        List<String> tweets;

        try (BufferedReader bufferedReader = Files.newBufferedReader(tweetFilePath)) {
            tweets = bufferedReader.lines().limit(3).collect(Collectors.toList());
            System.out.println("Ward\n");
            tweets.forEach(message -> System.out.printf("\t@%s\n\n", message));
        } catch (IOException e) {
            System.out.println("File not found: " + tweetFile);
        }
    }

}
