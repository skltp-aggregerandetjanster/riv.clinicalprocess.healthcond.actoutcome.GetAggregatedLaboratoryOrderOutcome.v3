package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.v3;

import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcomeresponder.v3.GetLaboratoryOrderOutcomeResponseType;
import se.skltp.aggregatingservices.api.AgpServiceFactory;
import se.skltp.aggregatingservices.tests.CreateAggregatedResponseTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class GLOOCreateAggregatedResponseTest extends CreateAggregatedResponseTest {

  private static GLOO3AgpServiceConfiguration configuration = new GLOO3AgpServiceConfiguration();
  private static AgpServiceFactory<GetLaboratoryOrderOutcomeResponseType> agpServiceFactory = new GLOO3AgpServiceFactoryImpl();
  private static ServiceTestDataGenerator testDataGenerator = new ServiceTestDataGenerator();

  public GLOOCreateAggregatedResponseTest() {
    super(testDataGenerator, agpServiceFactory, configuration);
  }

  @Override
  public int getResponseSize(Object response) {
    GetLaboratoryOrderOutcomeResponseType responseType = (GetLaboratoryOrderOutcomeResponseType) response;
    return responseType.getLaboratoryOrderOutcome().size();
  }
}