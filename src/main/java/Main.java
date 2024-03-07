import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws IOException {
        // TODO --> complete main function
        runMenu();
        //Actors actor = new Actors("",false);
        //System.out.println(actor.getDateOfDeathViaApi(actor.getActorData("Heath Ledger")));

    }
    public static void runMenu() throws IOException {
        // TODO
        boolean run = true;
            while(run) {
                System.out.print("Hello, Welcome to this program :)\n" +
                        "This app is for finding the profile of your favorite movie and actor\n" +
                        "1.Sreach Your Movie\n" + "2.Sreach Your Actor");
                Scanner input = new Scanner(System.in);
                int input1 = input.nextInt();
                System.out.print("\033[H\033[2J");
                System.out.flush();

                if (input1 == 1) {
                    System.out.print("Movie Name : ");
                    Scanner MovieName = new Scanner(System.in);
                    String NameM = MovieName.nextLine();
                    Movie movie = new Movie(new ArrayList<>(), "", 0);
                    String Check = movie.getMovieData(NameM);
                    while(Check.equals("Please check movies name !!!")){
                        System.out.println(Check);
                        NameM = input.next();
                        Check = movie.getMovieData(NameM);
                    }
                    System.out.println(NameM);
                    System.out.println(movie.getDataGenre(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataLanguage(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataCountry(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataDirector(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataYear(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataReleased(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataRuntime(movie.getMovieData(NameM)));
                    System.out.println(movie.getImdbVotesViaApi(movie.getMovieData(NameM)));
                    System.out.println(movie.getRatingViaApi(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataAwards(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataDirector(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataWriter(movie.getMovieData(NameM)));
                    System.out.println(movie.getActorListViaApi(movie.getMovieData(NameM)));
                    System.out.println(movie.getDataPlot(movie.getMovieData(NameM)));
                    System.out.println("*Press any key to back to menu !!!");
                    Scanner Menu = new Scanner(System.in);
                    run = false;

                }

                else if (input1 == 2) {
                    System.out.print("Actor Name : ");
                    Scanner ActorName = new Scanner(System.in);
                    String NameA = ActorName.nextLine();
                    Actors actor = new Actors("", false);
                    System.out.println(NameA);
                    System.out.println(actor.getDataGender(actor.getActorData(NameA)));
                    System.out.println(actor.getDataNationality(actor.getActorData(NameA)));
                    System.out.println(actor.getDataAge(actor.getActorData(NameA)));
                    System.out.println(actor.getDataBirthday(actor.getActorData(NameA)));
                    System.out.println(actor.getDataHeight(actor.getActorData(NameA)));
                    System.out.println(actor.getNetWorthViaApi(actor.getActorData(NameA)));
                    System.out.println(actor.isAlive(actor.getActorData(NameA)));
                    System.out.println(actor.getDateOfDeathViaApi(actor.getActorData(NameA)));
                    System.out.println("*Press any key to back to menu !!!");
                    Scanner Menu = new Scanner(System.in);
                    run = false;
                }
            }
        }
}
