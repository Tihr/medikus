package medikus.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;

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

@QuarkusTest
@Transactional

public class PatientEndpointTest {
	@Inject
	EntityManager entityManager;

	@BeforeEach
	public void cleanTestData() {
		entityManager.createNativeQuery("delete from patient where ssn like 'TestUser%'").executeUpdate();
	}

	@Test
	@DisplayName("Creating test user...")
	public void testCreatePatientAllData() {
		RegisterPatientRequest request = new RegisterPatientRequest();
		Patient patientData = new Patient();
		patientData.setBirthdate(LocalDate.now().minusYears(30));
		patientData.setName("TestUser1");
		patientData.setSurname("TestUser1");
		patientData.setSsn("TestUser1");
		request.setPatientData(patientData);
		given().when().body(request).contentType("application/json").put("/patient").then()
				.statusCode(Status.OK.getStatusCode());

	}

//    public static class QuarkusDataSourceProvider implements DataSourceProvider {
//        @Override
//        public DataSourceInfo getDatasourceInfo(final ExtensionContext extensionContext) {
//            // Quarkus Dev Services rewrite the Dev Service datasource in the configuration
//            Config config = ConfigProvider.getConfig();
//            String url = config.getValue("quarkus.datasource.jdbc.url", String.class);
//            String username = config.getValue("quarkus.datasource.username", String.class);
//            String password = config.getValue("quarkus.datasource.password", String.class);
//            return DataSourceInfo.config(url, username, password);
//        }
//    }
	@Test
	@DisplayName("Creating test user without birthdate...")
	public void testCreatePatientWithoutBirthdate() {
		RegisterPatientRequest request = new RegisterPatientRequest();
		Patient patientData = new Patient();
		patientData.setName("TestUser2");
		patientData.setSurname("TestUser2");
		patientData.setSsn("TestUser2");
		request.setPatientData(patientData);

	}

	@Test
	@DisplayName("Creating test user without ssn...")
	public void testCreatePatientWithoutSSN() {
		RegisterPatientRequest request = new RegisterPatientRequest();
		Patient patientData = new Patient();
		patientData.setName("TestUser3");
		patientData.setSurname("TestUser3");
		patientData.setBirthdate(LocalDate.now().minusYears(30));
		request.setPatientData(patientData);

	}

	@Test
	@DisplayName("Creating duplicate test user...")
	public void testCreatePatientDuplicate() {
		RegisterPatientRequest request = new RegisterPatientRequest();
		Patient patientData = new Patient();
		patientData.setBirthdate(LocalDate.now().minusYears(30));
		patientData.setName("TestUser4");
		patientData.setSurname("TestUser4");
		patientData.setSsn("TestUser4");
		request.setPatientData(patientData);
		given().when().body(request).contentType("application/json").put("/patient").then()
				.statusCode(Status.OK.getStatusCode());
		given().when().body(request).contentType("application/json").put("/patient").then()
				.statusCode(Status.CONFLICT.getStatusCode());

	}

	@Test
	@DisplayName("Retrieving existing test user...")
	public void testretrieveUserExisting() {
		RegisterPatientRequest request = new RegisterPatientRequest();
		Patient patientData = new Patient();
		patientData.setBirthdate(LocalDate.now().minusYears(30));
		patientData.setName("TestUser5");
		patientData.setSurname("TestUser5");
		patientData.setSsn("TestUser5");
		request.setPatientData(patientData);
		given().when().body(request).contentType("application/json").put("/patient").then()
				.statusCode(Status.OK.getStatusCode());
		given().when().get("/patient?ssn=" + patientData.getSsn()).then().statusCode(Status.OK.getStatusCode())
				.body(containsString("patientData"), containsString("SUCCESS"), containsString("true"));

	}

	@Test
	@DisplayName("Retrieving non existing test user...")
	public void testretrieveUserNonExisting() {
		RegisterPatientRequest request = new RegisterPatientRequest();
		Patient patientData = new Patient();
		patientData.setBirthdate(LocalDate.now().minusYears(30));
		patientData.setName("TestUser6");
		patientData.setSurname("TestUser6");
		patientData.setSsn("TestUser6");
		request.setPatientData(patientData);
		given().when().get("/patient?ssn=" + patientData.getSsn()).then().statusCode(Status.NOT_FOUND.getStatusCode())
				.body(not(containsString("SUCCESS")), not(containsString("true")));
	}
}
