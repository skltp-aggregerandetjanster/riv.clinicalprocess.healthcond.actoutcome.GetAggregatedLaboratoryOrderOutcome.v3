package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.v3;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcomeresponder.v3.GetLaboratoryOrderOutcomeResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateFindContentTest;


@RunWith(SpringJUnit4ClassRunner.class)
public class GLOOCreateFindContentTest extends CreateFindContentTest {

  private static GLOO3AgpServiceConfiguration configuration = new GLOO3AgpServiceConfiguration();
  private static AgpServiceFactory<GetLaboratoryOrderOutcomeResponseType> agpServiceFactory = new GLOO3AgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();

  public GLOOCreateFindContentTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }

  @BeforeClass
  public static void before() {
    configuration = new GLOO3AgpServiceConfiguration();
    agpServiceFactory = new GLOO3AgpServiceFactoryImpl();
    agpServiceFactory.setAgpServiceConfiguration(configuration);
  }


}
