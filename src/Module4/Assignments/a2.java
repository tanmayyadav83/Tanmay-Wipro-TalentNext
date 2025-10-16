import org.springframework.stereotype.Component;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class a2 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(a2.class, args);
        Laptop laptop = context.getBean(Laptop.class);
        laptop.displaySpecs();
    }
}

@Component
public class Battery {
    public String getBatteryInfo() {
        return "Battery: 5000mAh";
    }
}



@Component
public class HardDisk {
    public String getDiskInfo() {
        return "Hard Disk: 1TB SSD";
    }
}


@Component
public class Laptop {

    @Autowired
    private Battery battery;

    @Autowired
    private HardDisk hardDisk;

    public void displaySpecs() {
        System.out.println("Laptop Configuration:");
        System.out.println(battery.getBatteryInfo());
        System.out.println(hardDisk.getDiskInfo());
    }
}





