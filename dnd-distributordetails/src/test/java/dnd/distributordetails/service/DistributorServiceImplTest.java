package dnd.distributordetails.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dnd.distributordetails.Repo.DistributorRepo;
import dnd.distributordetails.model.DistributorEntity;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class DistributorServiceImplTest {
@Autowired
DistributorServiceImpl service;
@Autowired
DistributorRepo repo;

DistributorEntity distributor;
@BeforeAll
void testDistributor() {
	 distributor = new DistributorEntity(101,"pandu","sangareddy");
	if(!repo.existsById(101)) {
	service.addDistributorDetails(distributor);
}
}

	@Test
	void testAddDistributorDetails() {
		DistributorEntity distributor= new DistributorEntity(187,"pinky","secundrabad",null);
		DistributorEntity addDistributor=service.addDistributorDetails(distributor);
		// DistributorEntity addDistributor=service.getDistributorDetails(186);
		assertEquals(distributor,addDistributor); 
	}
	//DistributorEntity addDistributor=


	@Test
	void testGetDistributorDetails() {
		assertTrue(service.getDistributorDetails(1)!=null);
		
	}

	@Test
	void testGetAllDistributorDetails() {
		assertTrue(service.getAllDistributorDetails()!=null);
	}
}

