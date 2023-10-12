import com.cgvsu.models.Point;
import com.cgvsu.models.Sector;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void testSector(){
        List<Point> p = Sector.getSector(300, 300, 100, 600, 500, 500, 200);
        for(Point p1:p){
            System.out.println(p1.getX()+", "+ p1.getY()+ ", Color."+ p1.getC0().toString());
        }


    }
}
