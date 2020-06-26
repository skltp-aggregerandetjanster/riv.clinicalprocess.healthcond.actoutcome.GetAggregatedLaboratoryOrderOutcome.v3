package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.v3;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import riv.clinicalprocess.healthcond.actoutcome.enums.v3.ResultCodeEnum;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcomeresponder.v3.GetLaboratoryOrderOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcomeresponder.v3.GetLaboratoryOrderOutcomeType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ResultType;
import se.skltp.aggregatingservices.AgServiceFactoryBase;

@Log4j2
public class GLOOAgpServiceFactoryImpl extends
    AgServiceFactoryBase<GetLaboratoryOrderOutcomeType, GetLaboratoryOrderOutcomeResponseType> {

  @Override
  public String getPatientId(GetLaboratoryOrderOutcomeType queryObject) {
    return queryObject.getPatientId().getId();
  }

  @Override
  public String getSourceSystemHsaId(GetLaboratoryOrderOutcomeType queryObject) {
    return queryObject.getSourceSystemHSAId();
  }

  @Override
  public GetLaboratoryOrderOutcomeResponseType aggregateResponse(
      List<GetLaboratoryOrderOutcomeResponseType> aggregatedResponseList) {

    GetLaboratoryOrderOutcomeResponseType aggregatedResponse = new GetLaboratoryOrderOutcomeResponseType();

    for (Object object : aggregatedResponseList) {
      GetLaboratoryOrderOutcomeResponseType response = (GetLaboratoryOrderOutcomeResponseType) object;
      aggregatedResponse.getLaboratoryOrderOutcome().addAll(response.getLaboratoryOrderOutcome());
    }

    aggregatedResponse.setResult(new ResultType());
    aggregatedResponse.getResult().setResultCode(ResultCodeEnum.INFO);
    aggregatedResponse.getResult().setLogId("NA");

    log.info("Returning {} aggregated laboratory order outcome v3", aggregatedResponse.getLaboratoryOrderOutcome().size());

    return aggregatedResponse;
  }
}

