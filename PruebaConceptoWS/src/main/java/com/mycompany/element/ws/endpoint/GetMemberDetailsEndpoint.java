package com.mycompany.element.ws.endpoint;


import com.mycompany.element.ws.message.MemberDetailsRequest;
import com.mycompany.element.ws.message.MemberDetailsResponse;
import com.mycompany.element.ws.service.MemberManager;
import com.mycompany.element.ws.types.MemberDetail;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;



public class GetMemberDetailsEndpoint extends
		AbstractMarshallingPayloadEndpoint {

	private MemberManager memberManager;

	protected Object invokeInternal(Object requestObject) throws Exception {
		MemberDetailsRequest request = (MemberDetailsRequest) requestObject;
		MemberDetail memberDetail = memberManager.getMemberDetails(request
				.getId());
		MemberDetailsResponse response = new MemberDetailsResponse(memberDetail);
		return response;

	}

	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}
	
	
}
