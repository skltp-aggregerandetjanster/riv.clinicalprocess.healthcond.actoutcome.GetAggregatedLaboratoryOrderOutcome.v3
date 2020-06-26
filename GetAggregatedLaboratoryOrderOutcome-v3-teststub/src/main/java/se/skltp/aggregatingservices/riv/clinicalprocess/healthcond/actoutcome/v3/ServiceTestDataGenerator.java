package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.actoutcome.v3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.stereotype.Service;
import riv.clinicalprocess.healthcond.actoutcome.enums.v3.ResultCodeEnum;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcomeresponder.v3.GetLaboratoryOrderOutcomeResponseType;
import riv.clinicalprocess.healthcond.actoutcome.getlaboratoryorderoutcomeresponder.v3.GetLaboratoryOrderOutcomeType;
import riv.clinicalprocess.healthcond.actoutcome.v3.HealthcareProfessionalType;
import riv.clinicalprocess.healthcond.actoutcome.v3.LaboratoryOrderOutcomeBodyType;
import riv.clinicalprocess.healthcond.actoutcome.v3.LaboratoryOrderOutcomeType;
import riv.clinicalprocess.healthcond.actoutcome.v3.OrderType;
import riv.clinicalprocess.healthcond.actoutcome.v3.OrgUnitType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PatientSummaryHeaderType;
import riv.clinicalprocess.healthcond.actoutcome.v3.PersonIdType;
import riv.clinicalprocess.healthcond.actoutcome.v3.ResultType;
import se.skltp.aggregatingservices.data.TestDataGenerator;

@Log4j2
@Service
public class ServiceTestDataGenerator extends TestDataGenerator {
	private static final DateFormat DF = new SimpleDateFormat("YYYYMMDDhhmmss");

	@Override
	public String getPatientId(MessageContentsList messageContentsList) {
		GetLaboratoryOrderOutcomeType request = (GetLaboratoryOrderOutcomeType) messageContentsList.get(1);
		return request.getPatientId().getId();
	}

	@Override
	public Object createResponse(Object... responseItems) {
		log.info("Creating a response with {} items", responseItems.length);
		GetLaboratoryOrderOutcomeResponseType response = new GetLaboratoryOrderOutcomeResponseType();
		for (int i = 0; i < responseItems.length; i++) {
			response.getLaboratoryOrderOutcome().add((LaboratoryOrderOutcomeType)responseItems[i]);
		}

		ResultType result = new ResultType();
		result.setResultCode(ResultCodeEnum.INFO);
		result.setLogId(UUID.randomUUID().toString());
		result.setMessage("Ett meddelande till användaren");
		response.setResult(result);
		log.info("response.toString:" + response.toString());

		return response;
	}

	@Override
	public Object createResponseItem(String logicalAddress, String registeredResidentId, String businessObjectId, String time) {
		log.debug("Created ResponseItem for logical-address {}, registeredResidentId {} and businessObjectId {}",
				new Object[]{logicalAddress, registeredResidentId, businessObjectId});

		LaboratoryOrderOutcomeType labOrderOutcome = new LaboratoryOrderOutcomeType();

		PatientSummaryHeaderType header = new PatientSummaryHeaderType();
		header.setDocumentId(UUID.randomUUID().toString());
		header.setSourceSystemHSAId(logicalAddress);
		header.setDocumentTime(DF.format(new Date()));

		PersonIdType personIdType = new PersonIdType();
		personIdType.setId(registeredResidentId);
		personIdType.setType("1.2.752.129.2.1.3.1");
		header.setPatientId(personIdType);

		HealthcareProfessionalType hp = new HealthcareProfessionalType();
		hp.setAuthorTime(DF.format(new Date()));
		hp.setHealthcareProfessionalHSAId(logicalAddress);

		OrgUnitType orgUnitType = new OrgUnitType();
		orgUnitType.setOrgUnitHSAId(logicalAddress);
		orgUnitType.setOrgUnitName("Organisation 1");
		hp.setHealthcareProfessionalOrgUnit(orgUnitType);
		header.setAccountableHealthcareProfessional(hp);

		header.setApprovedForPatient(true);

		labOrderOutcome.setLaboratoryOrderOutcomeHeader(header);
		//Header end

		//Body start
		LaboratoryOrderOutcomeBodyType body = new LaboratoryOrderOutcomeBodyType();
		body.setResultType("DEF");
		body.setRegistrationTime(DF.format(new Date()));
		body.setDiscipline("Klinisk kemi");

		OrderType order = new OrderType();
		order.setOrderId(UUID.randomUUID().toString());
		body.setOrder(order);

		labOrderOutcome.setLaboratoryOrderOutcomeBody(body);
		//Body end

		return labOrderOutcome;
	}

	public Object createRequest(String patientId, String sourceSystemHSAId){
		GetLaboratoryOrderOutcomeType outcomeType = new GetLaboratoryOrderOutcomeType();

		PersonIdType personIdType = new PersonIdType();
		personIdType.setId(patientId);
		personIdType.setType("1.2.3");
		outcomeType.setPatientId(personIdType);
		outcomeType.setSourceSystemHSAId(sourceSystemHSAId);

		return outcomeType;
	}
}
