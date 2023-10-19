import com.cgvsu.models.Point;
import com.cgvsu.models.Sector;

import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void testSector(){
        List<Point> c = Sector.getSector(300, 300, 100, 600, 500, 500, 200);
        for(Point c1:c){
            System.out.println(c1.x+", "+ c1.y);
        }


    }
}
