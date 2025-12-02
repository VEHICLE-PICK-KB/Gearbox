package fi.msan.gearbox_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.msan.gearbox_api.model.Gearbox;
import fi.msan.gearbox_api.model.GearboxInterface;


@SpringBootApplication
public class GearboxApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GearboxApiApplication.class, args);
	}

	@Bean
public CommandLineRunner loadData(GearboxInterface GBI) {
    return args -> {


        GBI.save(new Gearbox(
                "8HP70",
                "Automatic",
                8,
                "ZF",
                2017
        ));

        GBI.save(new Gearbox(
                "DCT450",
                "Dual-clutch",
                6,
                "Getrag",
                2015
        ));

        GBI.save(new Gearbox(
                "A750F",
                "Automatic",
                5,
                "Aisin",
                2009
        ));

        GBI.save(new Gearbox(
                "TR-6060",
                "Manual",
                6,
                "Tremec",
                2008
        ));

    };
}

	

}