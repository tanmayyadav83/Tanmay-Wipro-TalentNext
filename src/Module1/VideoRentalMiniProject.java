package Module1;
import java.util.Scanner;

public class VideoRentalMiniProject {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            VideoStore vs = new VideoStore();

            int choice = 0;
            do {
                System.out.println("\nMAIN MENU");
                System.out.println("==========");
                System.out.println("1. Add Video");
                System.out.println("2. Check Out Video");
                System.out.println("3. Return Video");
                System.out.println("4. Receive Rating");
                System.out.println("5. List Inventory");
                System.out.println("6. Exit");
                System.out.print("Enter your choice (1..6): ");

                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter the name of the video you want to add: ");
                        String addName = sc.nextLine();
                        vs.addVideo(addName);
                        break;

                    case 2:
                        System.out.print("Enter the name of the video you want to check out: ");
                        String checkoutName = sc.nextLine();
                        vs.doCheckout(checkoutName);
                        break;

                    case 3:
                        System.out.print("Enter the name of the video you want to return: ");
                        String returnName = sc.nextLine();
                        vs.doReturn(returnName);
                        break;

                    case 4:
                        System.out.print("Enter the name of the video you want to rate: ");
                        String rateName = sc.nextLine();
                        System.out.print("Enter the rating for this video: ");
                        int rating = sc.nextInt();
                        vs.receiveRating(rateName, rating);
                        break;

                    case 5:
                        vs.listInventory();
                        break;

                    case 6:
                        System.out.println("Exiting...! Thanks for using the application.");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                }

            } while (choice != 6);

            sc.close();
        }
    }



class Video {
    private String videoName;
    private boolean checkout;
    private int rating;

    // Constructor
    public Video(String name) {
        this.videoName = name;
        this.checkout = false;
        this.rating = 0;
    }

    // Member functions
    public String getName() {
        return videoName;
    }

    public void doCheckout() {
        checkout = true;
    }

    public void doReturn() {
        checkout = false;
    }

    public void receiveRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public boolean getCheckout() {
        return checkout;
    }

    // To print video info
    @Override
    public String toString() {
        return videoName + " | " + checkout + " | " + rating;
    }
}

class VideoStore {
    private Video[] store;

    // Constructor
    public VideoStore() {
        store = new Video[10]; // store can hold up to 10 videos
    }

    // Add video
    public void addVideo(String name) {
        for (int i = 0; i < store.length; i++) {
            if (store[i] == null) {
                store[i] = new Video(name);
                System.out.println("Video \"" + name + "\" added successfully.");
                return;
            }
        }
        System.out.println("Store is full. Cannot add more videos.");
    }

    // Checkout video
    public void doCheckout(String name) {
        for (Video video : store) {
            if (video != null && video.getName().equalsIgnoreCase(name)) {
                video.doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    // Return video
    public void doReturn(String name) {
        for (Video video : store) {
            if (video != null && video.getName().equalsIgnoreCase(name)) {
                video.doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    // Receive rating
    public void receiveRating(String name, int rating) {
        for (Video video : store) {
            if (video != null && video.getName().equalsIgnoreCase(name)) {
                video.receiveRating(rating);
                System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    // List all videos
    public void listInventory() {
        System.out.println("-----------------------------------------------");
        System.out.println("Video Name | Checkout Status | Rating");
        for (Video video : store) {
            if (video != null) {
                System.out.println(video);
            }
        }
        System.out.println("-----------------------------------------------");
    }
}

