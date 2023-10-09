//Demo Example for a label
// Your byte code goes here
package code;
import javafx.scene.control.Label;
//min imports required for a GUI Application
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
//for Label title
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Text;
import javafx.scene.layout.TilePane;
import javafx.geometry.Pos;
/**
 * @author Devin Thomeczek
 */
public class Demo extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    static double MathStuff(double num1, double num2, double num3, double num4,
    double num5, double num6, double num7, double num8) {
        // Assign points to an array
        double[] nums = new double[]{num1, num2, num3, num4, num5, 
            num6, num7, num8};
        // Arrays for x values and y values
        double[] x = new double[4];
        double[] y = new double[4];
        
        // j and k are counters
        int j = 0;
        int k = 0;
        for (int i = 0; i < 8; i++) {
            if ((i % 2) == 0) {
                x[j] = nums[i];
                j+= 1;
            }
            if ((i % 2) == 1) {
                y[k] = nums[i];
                k+= 1;
            }
        }

        // Sides of the quadrilateral
        double ab = Math.sqrt((x[1]-x[0])*(x[1]-x[0]) + (y[1]-y[0])*(y[1]-y[0]));
        double bc = Math.sqrt((x[2]-x[1])*(x[2]-x[1]) + (y[2]-y[1])*(y[2]-y[1]));
        double cd = Math.sqrt((x[3]-x[2])*(x[3]-x[2]) + (y[3]-y[2])*(y[3]-y[2]));
        double da = Math.sqrt((x[0]-x[3])*(x[0]-x[3]) + (y[0]-y[3])*(y[0]-y[3]));

        // Used Brahmagupta formula for calculation of variables, and cross
        // referenced my output with the same test inputs at
        // https://calculator.swiftutors.com/brahmagupta-formula-calculator.html
        double perimeter = ab + bc + cd + da;
        double semiperimeter = perimeter/2;
        double area = Math.sqrt((semiperimeter-ab)*(semiperimeter-bc)*(semiperimeter-cd)*(semiperimeter-da));

		return area;
	}

    Label input;
    Label val1;
    Label val2;
    Label val3;
    Label val4;
    Label val5;
    Label val6;
    Label val7;
    Label val8;
    Label point1;
    Label point2;
    Label point3;
    Label point4;
    Label area_val;

    TilePane tiles;
    
    @Override
    public void start(Stage stage) {
        createLabel();
        Scene scene = new Scene(tiles, 400, 400);
        // Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Demo by Devin Thomeczek");
    }
    /** declare Label and Text variables */
    
   
    /** Create label */
    public void createLabel ()
    {
        input = new Label();
        input.setText("Calculate the area of a quadrilateral using 8 values:");

        val1 = new Label();
        val1.setText("2.39");

        val2 = new Label();
        val2.setText("12.3");

        val3 = new Label();
        val3.setText("1.43");

        val4 = new Label();
        val4.setText("19.25");

        val5 = new Label();
        val5.setText("23.45");

        val6 = new Label();
        val6.setText("9.58");

        val7 = new Label();
        val7.setText("14.79");

        val8 = new Label();
        val8.setText("3.47");

        double num1= Double.parseDouble(val1.getText());
        double num2= Double.parseDouble(val2.getText());
        double num3= Double.parseDouble(val3.getText());
        double num4= Double.parseDouble(val4.getText());
        double num5= Double.parseDouble(val5.getText());
        double num6= Double.parseDouble(val6.getText());
        double num7= Double.parseDouble(val7.getText());
        double num8= Double.parseDouble(val8.getText());

        point1 = new Label();
        point1.setText("Point 1: (" + num1 + ", " + num2 + ")");

        point2 = new Label();
        point2.setText("Point 2: (" + num3 + ", " + num4 + ")");

        point3 = new Label();
        point3.setText("Point 3: (" + num5 + ", " + num6 + ")");

        point4 = new Label();
        point4.setText("Point 4: (" + num7 + ", " + num8 + ")");

        area_val = new Label();
        area_val.setText("The area of the given points is: " + MathStuff(num1, num2, num3, num4, num5, num6, num7, num8));

        tiles = new TilePane();
        tiles.setTileAlignment(Pos.TOP_LEFT);
        tiles.getChildren().add(input);
        tiles.getChildren().add(val1);
        tiles.getChildren().add(val2);
        tiles.getChildren().add(val3);
        tiles.getChildren().add(val4);
        tiles.getChildren().add(val5);
        tiles.getChildren().add(val6);
        tiles.getChildren().add(val7);
        tiles.getChildren().add(val8);
        tiles.getChildren().add(point1);
        tiles.getChildren().add(point2);
        tiles.getChildren().add(point3);
        tiles.getChildren().add(point4);
        tiles.getChildren().add(area_val);
    }
}
