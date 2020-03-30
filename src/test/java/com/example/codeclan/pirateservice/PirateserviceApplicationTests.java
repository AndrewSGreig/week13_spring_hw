package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raids;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidsRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidsRepository raidsRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void createPirateShipAndRaid(){
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(jack);

		Raids raids = new Raids("Edinburgh", 2);
		raidsRepository.save(raids);

		jack.addRaidToPirate(raids);

		raids.addPirateToRaid(jack);

		pirateRepository.save(jack);
		raidsRepository.save(raids);
	}

}
