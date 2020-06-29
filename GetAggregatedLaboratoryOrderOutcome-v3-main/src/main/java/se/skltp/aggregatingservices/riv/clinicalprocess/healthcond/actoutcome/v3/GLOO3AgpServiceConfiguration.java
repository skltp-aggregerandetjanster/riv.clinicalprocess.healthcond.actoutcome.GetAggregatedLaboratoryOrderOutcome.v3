package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.v3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcome.v3.rivtabp21.GetLaboratoryOrderOutcomeResponderInterface;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcome.v3.rivtabp21.GetLaboratoryOrderOutcomeResponderService;

@Configuration()
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "getaggregatedlaboratoryorderoutcome.v3")
public class GLOO3AgpServiceConfiguration extends se.skltp.aggregatingservices.configuration.AgpServiceConfiguration {

public static final String SCHEMA_PATH = "/schemas/clinicalprocess-healthcond-actoutcome/interactions/GetLaboratoryOrderOutcomeInteraction/GetLaboratoryOrderOutcomeInteraction_3.1_RIVTABP21.wsdl";

  public GLOO3AgpServiceConfiguration() {

    setServiceName("GetAggregatedLaboratoryOrderOutcome-v3");
    setTargetNamespace("urn:riv:clinicalprocess:healthcond:actoutcome:GetLaboratoryOrderOutcome:3:rivtabp21");

    // Set inbound defaults
    setInboundServiceURL("http://0.0.0.0:9007/GetAggregatedLaboratoryOrderOutcome/service/v3");
    setInboundServiceWsdl(SCHEMA_PATH);
    setInboundServiceClass(GetLaboratoryOrderOutcomeResponderInterface.class.getName());
    setInboundPortName(GetLaboratoryOrderOutcomeResponderService.GetLaboratoryOrderOutcomeResponderPort.toString());

    // Set outbound defaults
    setOutboundServiceWsdl(SCHEMA_PATH);
    setOutboundServiceClass(getInboundServiceClass());
    setOutboundPortName(getInboundPortName());

    // FindContent
    setEiServiceDomain("riv:clinicalprocess:healthcond:actoutcome");
    setEiCategorization("und-kkm-ure");

    // TAK
    setTakContract("urn:riv:clinicalprocess:healthcond:actoutcome:GetLaboratoryOrderOutcomeResponder:3");

    // Set service factory
    setServiceFactoryClass(GLOO3AgpServiceFactoryImpl.class.getName());
    }


}
