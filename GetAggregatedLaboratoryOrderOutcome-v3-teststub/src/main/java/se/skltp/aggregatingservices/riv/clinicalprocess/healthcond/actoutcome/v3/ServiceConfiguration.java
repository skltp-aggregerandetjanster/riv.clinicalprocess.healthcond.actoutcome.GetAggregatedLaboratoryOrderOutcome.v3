package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.v3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcome.v3.rivtabp21.GetLaboratoryOrderOutcomeResponderInterface;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcome.v3.rivtabp21.GetLaboratoryOrderOutcomeResponderService;
import se.skltp.aggregatingservices.config.TestProducerConfiguration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="getaggregatedlaboratoryorderoutcome.v3.teststub")
public class ServiceConfiguration extends TestProducerConfiguration {

  public static final String SCHEMA_PATH = "/schemas/clinicalprocess-healthcond-actoutcome/interactions/GetLaboratoryOrderOutcomeInteraction/GetLaboratoryOrderOutcomeInteraction_3.1_RIVTABP21.wsdl";

  public ServiceConfiguration() {
    setProducerAddress("http://localhost:8083/vp");
    setServiceClass(GetLaboratoryOrderOutcomeResponderInterface.class.getName());
    setServiceNamespace("urn:riv:clinicalprocess:healthcond:actoutcome:GetLaboratoryOrderOutcomeResponder:3");
    setPortName(GetLaboratoryOrderOutcomeResponderService.GetLaboratoryOrderOutcomeResponderPort.toString());
    setWsdlPath(SCHEMA_PATH);
    setTestDataGeneratorClass(ServiceTestDataGenerator.class.getName());
    setServiceTimeout(27000);
  }

}
