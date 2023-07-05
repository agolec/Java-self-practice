package test.java.ticketredo;

import main.java.ticketredo.CarColor;
import main.java.ticketredo.ParkedCar;
import org.junit.Assert;
import org.junit.Test;

public class ParkedCarTests {
    @Test
    public void setColorMethodWithCarColorUpdatesParkedCarColor(){
        final String MAKE = "HONDA";
        final String MODEL = "CIVIC";
        final CarColor INITIALIZED_COLOR = CarColor.GREEN;
        final String LICENSE_PLATE = "XVN";
        final int MINUTES_PARKED = 120;

        final CarColor MODIFIED_CAR_COLOR = CarColor.BLUE;

        ParkedCar car = new ParkedCar(MAKE,MODEL,INITIALIZED_COLOR,LICENSE_PLATE,MINUTES_PARKED);
        Assert.assertNotEquals(MODIFIED_CAR_COLOR,car.getColor());

        car.setColor(MODIFIED_CAR_COLOR);


        Assert.assertEquals(MODIFIED_CAR_COLOR,car.getColor());

    }
    @Test
    public void SetColorMethodWithTextUpdatesCarColor(){
        final String MAKE = "HONDA";
        final String MODEL = "CIVIC";
        final CarColor INITIALIZED_COLOR = CarColor.GREEN;
        final String LICENSE_PLATE = "XVN";
        final int MINUTES_PARKED = 120;

        final CarColor MODIFIED_CAR_COLOR = CarColor.BLUE;
        final String CAR_COLOR_UPDATED_CHOICE = "blue";

        ParkedCar car = new ParkedCar(MAKE,MODEL,INITIALIZED_COLOR,LICENSE_PLATE,MINUTES_PARKED);
        car.setColor(CAR_COLOR_UPDATED_CHOICE);

        Assert.assertEquals(MODIFIED_CAR_COLOR,car.getColor());
        final String CAR_COLOR_RED_LOWERCASE = "red";
        car.setColor(CAR_COLOR_RED_LOWERCASE);
        Assert.assertEquals(CarColor.RED,car.getColor());

    }
}
