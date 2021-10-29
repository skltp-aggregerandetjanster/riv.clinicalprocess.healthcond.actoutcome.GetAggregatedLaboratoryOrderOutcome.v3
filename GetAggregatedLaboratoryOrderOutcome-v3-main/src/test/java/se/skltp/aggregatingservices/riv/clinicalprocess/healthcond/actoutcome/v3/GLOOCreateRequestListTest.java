package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.v3;

import org.junit.jupiter.api.BeforeAll;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcomeresponder.v3.GetLaboratoryOrderOutcomeResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateFindContentTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class GLOOCreateRequestListTest extends CreateFindContentTest {

  private static GLOO3AgpServiceConfiguration configuration = new GLOO3AgpServiceConfiguration();
  private static AgpServiceFactory<GetLaboratoryOrderOutcomeResponseType> agpServiceFactory = new GLOO3AgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();


  public GLOOCreateRequestListTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }

  @BeforeAll
  public static void before() {
    configuration = new GLOO3AgpServiceConfiguration();
    agpServiceFactory = new GLOO3AgpServiceFactoryImpl();
    agpServiceFactory.setAgpServiceConfiguration(configuration);
  }
}