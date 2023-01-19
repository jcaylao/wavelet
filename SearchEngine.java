import java.io.IOException;
import java.net.URI;

class SearchEngine implements URLHandler{
    String word = null;

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                word = (parameters[1]);
                return String.format("Word added");
            }
        }
        else if (url.getPath().contains("/search")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("app")) {
                word = (parameters[1]);
                return String.format("Words: ", parameters[1], word);
            }
        }
        return "404 Not Found!";
    }

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
}
