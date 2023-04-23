package medikus.test;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response.Status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import medikus.rs.model.Patient;
import medikus.rs.model.RegisterPatientRequest;
import medikus.rs.model.RegisterVisitRequest;
import medikus.rs.model.UpdateVisitRequest;
import medikus.rs.model.Visit;
import medikus.rs.model.Visit.ReasonEnum;
import medikus.rs.model.Visit.TypeEnum;

@QuarkusTest
@Transactional
public class VisitEndpointTest {
	@Inject
	EntityManager entityManager;

	@BeforeEach
	public void cleanTestData()
	{
		
		entityManager.createNativeQuery("delete from visit where visit.patient in (select id from patient where ssn like 'TestVisitUser%')")
		.executeUpdate();
		entityManager.createNativeQuery("delete from patient where ssn like 'TestVisitUser%'")
		.executeUpdate();

		
	}
	@Test
	@DisplayName("Creating test visit for existing test user...")
	public void testCreateVisitAllData() {
		RegisterPatientRequest request = new RegisterPatientRequest();
		Patient patientData = new Patient();
		patientData.setBirthdate(LocalDate.now().minusYears(30));
		patientData.setName("TestVisitUser1");
		patientData.setSurname("TestVisitUser1");
		patientData.setSsn("TestVisitUser1");
		request.setPatientData(patientData);
		given().when().body(request).contentType("application/json").put("/patient").then()
				.statusCode(Status.OK.getStatusCode());
		RegisterVisitRequest vRequest = new RegisterVisitRequest();
		Visit visitData = new Visit();
		visitData.setAppointment(LocalDate.now().plusDays(1));
		visitData.setHistory("TestVisit1");
		visitData.setReason(ReasonEnum.FIRST);
		visitData.setType(TypeEnum.OFFICE);
		vRequest.setVisitData(visitData);
		given().when().body(vRequest).contentType("application/json").put("/visit/"+patientData.getSsn()+"/").then()
		.statusCode(Status.OK.getStatusCode());
	}
	@Test
	@DisplayName("Creating test visit for non existing test user...")
	public void testCreateVisitAllDataNonExisting() {
		RegisterPatientRequest request = new RegisterPatientRequest();
		Patient patientData = new Patient();
		patientData.setBirthdate(LocalDate.now().minusYears(30));
		patientData.setName("TestVisitUser2");
		patientData.setSurname("TestVisitUser2");
		patientData.setSsn("TestVisitUser2");
		request.setPatientData(patientData);
		RegisterVisitRequest vRequest = new RegisterVisitRequest();
		Visit visitData = new Visit();
		visitData.setAppointment(LocalDate.now().plusDays(1));
		visitData.setHistory("TestVisit2");
		visitData.setReason(ReasonEnum.FIRST);
		visitData.setType(TypeEnum.OFFICE);
		vRequest.setVisitData(visitData);
		given().when().body(vRequest).contentType("application/json").put("/visit/"+patientData.getSsn()+"/").then()
		.statusCode(Status.NOT_FOUND.getStatusCode());
	}
	@Test
	@DisplayName("Creating test visit without reason...")
	public void testCreateVisitWithoutReason() {
		RegisterPatientRequest request = new RegisterPatientRequest();
		Patient patientData = new Patient();
		patientData.setBirthdate(LocalDate.now().minusYears(30));
		patientData.setName("TestVisitUser3");
		patientData.setSurname("TestVisitUser3");
		patientData.setSsn("TestVisitUser3");
		request.setPatientData(patientData);
		given().when().body(request).contentType("application/json").put("/patient").then()
				.statusCode(Status.OK.getStatusCode());
		RegisterVisitRequest vRequest = new RegisterVisitRequest();
		Visit visitData = new Visit();
		visitData.setAppointment(LocalDate.now().plusDays(1));
		visitData.setHistory("TestVisit3");
		visitData.setType(TypeEnum.OFFICE);
		vRequest.setVisitData(visitData);
		given().when().body(vRequest).contentType("application/json").put("/visit/"+patientData.getSsn()+"/").then()
		.statusCode(Status.BAD_REQUEST.getStatusCode());
	}

}
