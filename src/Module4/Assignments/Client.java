import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Movie movie = (Movie) context.getBean("movie");

        System.out.println("Movie ID: " + movie.getMovieId());
        System.out.println("Movie Name: " + movie.getMovieName());
        System.out.println("Movie Actor: " + movie.getMovieActor());
    }
}
