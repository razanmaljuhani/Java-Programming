package bar_1806065_p5_bookbanksystem;

public class MaterialNotFoundException extends Exception {

    public MaterialNotFoundException(String title) {
        super("Error: The material titled " + title + " was not found in this Book Bank .");
    }
}

