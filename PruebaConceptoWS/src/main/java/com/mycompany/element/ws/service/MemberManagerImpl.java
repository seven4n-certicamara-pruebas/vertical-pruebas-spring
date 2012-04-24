package com.mycompany.element.ws.service;

import com.mycompany.element.ws.types.MemberDetail;

public class MemberManagerImpl implements MemberManager {

	public MemberDetail getMemberDetails(String id) {
		MemberDetail memberDetail = new MemberDetail("John Doe","111-111-1111","New York","NY");
		return memberDetail;
	}

}
