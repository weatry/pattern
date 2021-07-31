package com.github.budwing.pattern.sequence.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.github.budwing.pattern.sequence.commons.util.DBConnection;
import com.github.budwing.pattern.sequence.commons.util.UUID;
import com.github.budwing.pattern.sequence.service.SequenceService;
import org.apache.log4j.Logger;

public class SequenceServiceImpl implements SequenceService {
	private static final Logger logger = Logger
			.getLogger(SequenceServiceImpl.class);
	
	private Map<String,Integer> seqCache = new HashMap<String, Integer>();
	private Map<String,Integer> reminderCache = new HashMap<String, Integer>();
	private int step = 10;

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public Map<String, String> query(String companyUuid, String sequenceId, Integer length) {

		Map<String, String> result = new HashMap<String, String>();
		
		if (companyUuid == null || companyUuid.length() == 0) {
			result.put("state", "failure");
			result.put("msg", "companyUuid can't be null");
			return result;
		}
		if (sequenceId == null || sequenceId.length() == 0) {
			result.put("state", "failure");
			result.put("msg", "sequenceId can't be null");
			return result;
		}
		
		Integer seq = seqCache.get(companyUuid+sequenceId);
		Integer reminder = reminderCache.get(companyUuid+sequenceId);
		if (seq == null || reminder==null || reminder<=0) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBConnection.getConnection();
				pstmt = conn
						.prepareStatement("select * from system_sequence where company_uuid=? and sequence_identification=?");
				pstmt.setString(1, companyUuid);
				pstmt.setString(2, sequenceId);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					String seqUUID = rs.getString("sequence_uuid");
					seq = rs.getInt("sequence_num")+step;
					
					pstmt.close();
					pstmt = conn
							.prepareStatement("update system_sequence set sequence_num=? where sequence_uuid=?");
					pstmt.setInt(1, seq);
					pstmt.setString(2, seqUUID);

					pstmt.executeUpdate();
				} else {
					seq = step+1;
					
					pstmt = conn
							.prepareStatement("insert into system_sequence values(?,?,?,?,?,?,?)");
					pstmt.setString(1, UUID.getUuid());
					pstmt.setString(2, sequenceId);
					pstmt.setString(3, companyUuid);
					pstmt.setInt(4, seq);
					pstmt.setString(5, "");
					pstmt.setInt(6, 0);
					pstmt.setInt(7, 1);

					pstmt.executeUpdate();
				}
				reminder = step;
				seqCache.put(companyUuid+sequenceId, seq);
				reminderCache.put(companyUuid+sequenceId, reminder);
			} catch (Exception e) {
				logger.error(e);
			} finally {
				DBConnection.closeConnection(conn, pstmt, rs);
			}
		}
		
		StringBuilder sb = new StringBuilder(String.valueOf(seq - reminder));
		int seqLength = sb.length();
		if (length != null && sb.length() < length) {
			for (int i = 0; i < length - seqLength; i++) {
				sb.insert(0, "0");
			}
		}
		reminderCache.put(companyUuid+sequenceId, reminder-1);
		result.put("state", "success");
		result.put("sequence", sb.toString());

		return result;
	}

}