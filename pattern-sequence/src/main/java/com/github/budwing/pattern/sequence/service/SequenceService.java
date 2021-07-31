package com.github.budwing.pattern.sequence.service;

import java.util.Map;


public interface SequenceService {

	public Map<String, String> query(String companyUuid, String sequenceNum, Integer length);

}